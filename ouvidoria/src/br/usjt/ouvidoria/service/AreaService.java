package br.usjt.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ouvidoria.dao.AreaDAO;
import br.usjt.ouvidoria.model.Area;

@Service
public class AreaService {

	@Autowired
	AreaDAO dao;

	@Transactional
	public void salvar(Area area){
		dao.salvar(area);
	}
	
	@Transactional
	public void excluir(Area area) {
		dao.excluir(area);
	}
	
	public Area buscarArea(Long id) {
		return dao.buscaPorId(id);
	}
	
}
