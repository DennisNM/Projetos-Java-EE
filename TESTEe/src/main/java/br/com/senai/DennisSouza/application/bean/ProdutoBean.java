package br.com.senai.DennisSouza.application.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class ProdutoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<br.com.senai.DennisSouza.application.model.Produto> listar() {
		return em.createQuery("SELECT p FROM Produto p", br.com.senai.DennisSouza.application.model.Produto.class).getResultList();
	}
	
	
}
