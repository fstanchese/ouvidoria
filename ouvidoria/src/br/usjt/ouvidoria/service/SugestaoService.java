package br.usjt.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ouvidoria.dao.PostagemDAO;
import br.usjt.ouvidoria.model.Postagem;

@Service
public class SugestaoService {

	@Autowired
	PostagemDAO dao;

	@Transactional
	public Postagem salvar(Postagem sugestao){
		return dao.salvar(sugestao);
	}
	
	@Transactional
	public void excluir(Postagem sugestao) {
		dao.excluir(sugestao);
	}
	
	public Postagem buscarArea(Long id) {
		return dao.buscaPorId(id);
	}
	
}
