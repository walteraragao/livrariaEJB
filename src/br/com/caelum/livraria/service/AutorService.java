package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	private AutorDao dao;

	public void adiciona(Autor autor){
		dao.salva(autor);
	}

	
	public List<Autor> getListAutor(){
		return dao.todosAutores();
	}
	
}
