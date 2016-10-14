package br.usjt.ouvidoria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.ouvidoria.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	public Usuario buscaLoginUsuario(Usuario usuario) {
		try {
			return (Usuario) em.createNamedQuery("Usuario.buscaUsuario").setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha()).getSingleResult();
		} catch (NoResultException nre) {
			return new Usuario();
		}
	}

	public Usuario buscaLogin(String login) {
		try {
			Query q = em.createQuery("select u from Usuario u where login=:login");
			q.setParameter("login", login);
			q.setMaxResults(1);
			return (Usuario) q.getSingleResult();
		} catch (NoResultException nre) {
			return new Usuario();
		}
	}

	public Usuario salvar(Usuario usuario) {
		return em.merge(usuario);
	}

	public void excluir(Usuario usuario) {
		em.remove(usuario);
	}

	public Usuario buscaPorId(Long id) {
		return em.find(Usuario.class, id);
	}

}
