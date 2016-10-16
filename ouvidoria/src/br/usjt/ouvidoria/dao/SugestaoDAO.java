package br.usjt.ouvidoria.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ouvidoria.model.Sugestao;

@Repository
public class SugestaoDAO {

	@PersistenceContext
	EntityManager em;
	
	public Sugestao salvar(Sugestao sugestao) {
		return em.merge(sugestao);
	}

	public void excluir(Sugestao sugestao) {
		em.remove(sugestao);
	}

	public Sugestao buscaPorId(Long id) {
		return em.find(Sugestao.class, id);
	}

}
