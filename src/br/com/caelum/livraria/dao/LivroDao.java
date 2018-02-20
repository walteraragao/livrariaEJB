package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	/*
	 * @Inject private Banco banco;
	 */

	@PersistenceContext
	private EntityManager manager;

	public void salva(Livro livro) {
		// banco.save(livro);
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {
		// return banco.listaLivros();
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> buscaLivrosPeloNome(String nome) {
		TypedQuery<Livro> createQuery = this.manager.createQuery("select l from Livro l where l.titulo like :pnome", Livro.class);
		createQuery.setParameter("pnome","%"+nome+"%");
		return createQuery.getResultList();
	}

}
