package br.usjt.ouvidoria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ouvidoira.exception.ServiceException;
import br.usjt.ouvidoria.dao.UsuarioDAO;
import br.usjt.ouvidoria.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Transactional
	public Usuario salvar(Usuario usuario) throws ServiceException {
		Usuario usuarioExiste = buscaLogin(usuario.getLogin());
		if (usuarioExiste.getId() != null) {
			throw new ServiceException("Usuario Já Cadastrado");
		}
		return usuarioDAO.salvar(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}
	
	public Usuario buscaLoginUsuario(Usuario usuario) {
		return usuarioDAO.buscaLoginUsuario(usuario);
	}	
	
	public Usuario buscaLogin(String login) {
		return usuarioDAO.buscaLogin(login);
	}
}
