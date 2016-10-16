package br.usjt.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ouvidoria.dao.ComentarioDAO;
import br.usjt.ouvidoria.model.Comentario;

@Service
public class ComentarioService {

	@Autowired
	ComentarioDAO dao;

	@Transactional
	public void salvar(Comentario comentario){
		dao.salvar(comentario);
	}
	
	@Transactional
	public void excluir(Comentario comentario) {
		dao.excluir(comentario);
	}
	
	public Comentario buscarArea(Long id) {
		return dao.buscaPorId(id);
	}
	
}