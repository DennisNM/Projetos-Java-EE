package br.com.rafaelcosta.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;
// tipo sessão EJB
// EJB facilita  desenvolvimento rápido
@Stateless
public class TarefaBean {
	//Responsável por gerenciar o banco de dados e persistir no banco
	@PersistenceContext
	private EntityManager em;
	// inserir
	public void inserir(Tarefa tarefa) {
		em.persist(tarefa);
	}
	// atulizar
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa);
	}
	// exlcuir do banco
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId());
		em.remove(tarefa);
	}
	// carregar a lista
	public Tarefa carregar(int id) {
		return em.find(Tarefa.class, id);
	}
}
