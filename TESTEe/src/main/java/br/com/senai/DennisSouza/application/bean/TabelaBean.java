package br.com.senai.DennisSouza.application.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.DennisSouza.jpa.ejbbean.ComandosBean;
import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Pedido;
import br.com.rafaelcosta.application.model.Produto;
import br.com.senai.DennisSouza.application.model.Despesas;


@SuppressWarnings("serial") //tira anuncios de advert�ncia
@Named("tabela")
@SessionScoped //tempo de vida da p�gina, o "session" mant�m os dados enquanto o navegador estiver aberto
public class TabelaBean implements Serializable{
	//Criando uma Lista com todos os objetos
	private List<Despesas> despesas = new ArrayList<>();
	
	//Vari�veis que ir� receber as informa��es do formul�rio e ir� enviar para a classe "Despesas"
	private String user;
	private String senha;
	
	String data1;
	String desc1;
	Double Valor1;
	String produtos;
	Boolean a = false; 
	
	private Despesas despesas1;
	
	@EJB
	private ComandosBean comandosBean;
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Double getValor1() {
		return Valor1;
	}

	public void setValor1(Double valor1) {
		Valor1 = valor1;
	}
	
	public String getProdutos() {
		return produtos;
	}

	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}
	
	
	

	public void gravarBanco(Despesas d) {
		comandosBean.inserir(d);
		
	}
	
	public void ExcluirBanco(Despesas d) {
		comandosBean.excluir(d);
		
	}
	public void EditarBanco(Despesas d) {
		comandosBean.atualizar(d);
		
	}
	
	

	
	
	
	public String inserir(String data,String desc,Double Valor) {
		
		Despesas d = new Despesas(data,desc,Valor);
		d.setEdit(true);
		a =true;
		despesas.add(d);
		data1 = null;
		desc1 = null;
		Valor1= null;
		
		gravarBanco(d);
		
		return null;

	}
	
	public String excluir(Despesas despesa) {
		//removendo o objeto da lista 
		despesas.remove(despesa);
		ExcluirBanco(despesa);
		return null;
	}
	
	public String editar(Despesas despesa) {
		despesa.setEdit(true); 
		EditarBanco(despesa);
		return null;
	}
	
	public String gravar (Despesas despesa) {
		despesa.setEdit(false);
		if(despesa.getId()==null) {
			comandosBean.inserir(despesa);
		}else {
			comandosBean.atualizar(despesa);
		}
		return null;
	}
	
	public List<Despesas> getDespesas() {
		return despesas;
	}
	
	public Despesas getDespesas1() {
		if(despesas1==null) {
			despesas1 = new Despesas();
		}
		return despesas1;
	}

	public Boolean getA() {
		return a;
	}

	public void setA(Boolean a) {
		this.a = a;
	}

	public String doLogin() {
		
		if("DENNIS".equals(user) && "admin".equals(senha)) {
			return "despesas";	
		}
		return null;
	}
	
	
	
	private List<br.com.senai.DennisSouza.application.model.Produto> produtoss;
	
	@EJB
	private ProdutoBean produtoBean; 
	
	@PostConstruct
	public void init() {
		
		
		produtoss = produtoBean.listar();
	}
	private Integer[] selectedProdutosIds;
	
	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	
	
	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}

	public List<br.com.senai.DennisSouza.application.model.Produto> getProdutoss() {
		return produtoss;
	}
private	double valortotal;

	
	public double getValortotal() {
	return valortotal;
}

public void setValortotal(double valorTotal2) {
	this.valortotal = valorTotal2;
}


public String cadastrarPedido() throws Exception {
	pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds);
	//redireciona pra tela de dados
	return "pedidos?faces-redirect=true";
}
	
	
}
