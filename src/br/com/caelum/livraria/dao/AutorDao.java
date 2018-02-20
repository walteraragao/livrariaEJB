package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	/*@Inject
	private Banco banco;*/
	
	//anotação para o EJB administrar o JPA.
	@PersistenceContext
	private EntityManager manager;
	

	public void salva(Autor autor) {
		//banco.save(autor);
		manager.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		//return banco.listaAutores();
		
		 return manager.createQuery("select a from Autor a", Autor.class)
		            .getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		/*Autor autor = this.banco.buscaPelaId(autorId);
		return autor;*/
		
		 Autor autor = this.manager.find(Autor.class, autorId);
		 return autor;
	}
	
}
