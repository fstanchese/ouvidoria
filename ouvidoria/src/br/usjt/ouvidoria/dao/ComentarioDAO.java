package br.usjt.ouvidoria.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ouvidoria.model.Comentario;

@Repository
public class ComentarioDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public Comentario salvar(Comentario comentario) {
		return em.merge(comentario);
	}

	public void excluir(Comentario comentario) {
		em.remove(comentario);
	}

	public Comentario buscaPorId(Long id) {
		return em.find(Comentario.class, id);
	}
}
