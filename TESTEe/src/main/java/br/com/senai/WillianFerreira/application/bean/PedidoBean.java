package br.com.senai.WillianFerreira.application.bean;

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
	//lista todos os pedidos
	
	
	
	public void cadastrar( Integer[] produtosIds) throws Exception {
		//linka o cliente com a tabela
		
		TabelaBean tabela = new TabelaBean();
		
		
		//grava as informações na tabela
		
		
		double valorTotal = 0;
		//adiciona o produto na tabela e soma ele
		for (Integer produtoId : produtosIds) {
			br.com.senai.WillianFerreira.application.model.Produto produto = em.find(br.com.senai.WillianFerreira.application.model.Produto.class, produtoId);
			
			valorTotal += produto.getValor();
		}
		//salva na tabela
		tabela.setValortotal(valorTotal);
	}
}

