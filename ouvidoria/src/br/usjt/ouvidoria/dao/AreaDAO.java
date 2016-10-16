package br.usjt.ouvidoria.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.ouvidoria.model.Area;

@Repository
public class AreaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public Area salvar(Area area) {
		return em.merge(area);
	}

	public void excluir(Area area) {
		em.remove(area);
	}

	public Area buscaPorId(Long id) {
		return em.find(Area.class, id);
	}
}
