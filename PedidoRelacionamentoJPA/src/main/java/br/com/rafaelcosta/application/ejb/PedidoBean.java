package br.com.rafaelcosta.application.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Pagamento;
import br.com.rafaelcosta.application.model.Pagamento.TipoPagamento;
import br.com.rafaelcosta.application.model.Pedido;
import br.com.rafaelcosta.application.model.Produto;


@Stateless
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
//carregar todos os pedidos	
	public List<Pedido> listar() {
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	// recebe o id e  tipo de pagamento e transforma em enum
	public void pagar(Integer pedidoId, String tipo) {
		//link
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId);
		//guarda o tipo de pagamento
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagto(tipoPagamento);
		em.persist(pagamento);
		//por estar linkado ocm aquela variavel setar no objeto atuliza lá tbm
		pedido.setPagamento(pagamento);
	}
	
	public void excluir(Integer pedidoId) {
		Pedido pedido = em.find(Pedido.class, pedidoId);
		em.remove(pedido);
	}
	
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception {
		Cliente cliente = em.find(Cliente.class, clienteId);
		
		Pedido pedido = new Pedido();
		pedido.setData(new Date());
		pedido.setCliente(cliente);
		em.persist(pedido);
		//somar valores de produtos
		double valorTotal = 0;
		for (Integer produtoId : produtosIds) {
			Produto produto = em.find(Produto.class, produtoId);
			pedido.getProdutos().add(produto);
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal);
	}
}

