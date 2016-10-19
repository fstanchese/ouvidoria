package br.usjt.ouvidoria.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ouvidoria.model.Postagem;

@Repository
public class PostagemDAO {

	@PersistenceContext
	EntityManager em;
	
	public Postagem salvar(Postagem sugestao) {
		return em.merge(sugestao);
	}

	public void excluir(Postagem sugestao) {
		em.remove(sugestao);
	}

	public Postagem buscaPorId(Long id) {
		return em.find(Postagem.class, id);
	}

}
