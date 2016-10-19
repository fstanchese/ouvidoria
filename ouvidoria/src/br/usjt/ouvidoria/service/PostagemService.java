package br.usjt.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ouvidoria.dao.PostagemDAO;
import br.usjt.ouvidoria.model.Postagem;

@Service
public class PostagemService {

	@Autowired
	PostagemDAO dao;

	@Transactional
	public Postagem salvar(Postagem postagem){
		return dao.salvar(postagem);
	}
	
	@Transactional
	public void excluir(Postagem postagem) {
		dao.excluir(postagem);
	}
	
	public Postagem buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}
	
}
