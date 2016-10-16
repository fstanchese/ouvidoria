package br.usjt.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ouvidoria.dao.SugestaoDAO;
import br.usjt.ouvidoria.model.Sugestao;

@Service
public class SugestaoService {

	@Autowired
	SugestaoDAO dao;

	@Transactional
	public Sugestao salvar(Sugestao sugestao){
		return dao.salvar(sugestao);
	}
	
	@Transactional
	public void excluir(Sugestao sugestao) {
		dao.excluir(sugestao);
	}
	
	public Sugestao buscarArea(Long id) {
		return dao.buscaPorId(id);
	}
	
}
