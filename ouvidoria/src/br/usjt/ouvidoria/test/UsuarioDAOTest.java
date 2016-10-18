package br.usjt.ouvidoria.test;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.usjt.ouvidoria.dao.AreaDAO;
import br.usjt.ouvidoria.dao.UsuarioDAO;
import br.usjt.ouvidoria.model.Area;
import br.usjt.ouvidoria.model.TipoUsuario;
import br.usjt.ouvidoria.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class UsuarioDAOTest {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	AreaDAO areaDAO;
	
	@Transactional
	@Test
	public void salvarTest() {
		Usuario usuario = new Usuario();
		Area area = new Area();
		
		area.setDescricao("teste");
		
		Area areaSalvo = areaDAO.salvar(area);	
		
		usuario.setArea(areaSalvo);
		usuario.setCelular("11 111111111");
		usuario.setEmail("teste@teste.com");
		usuario.setLogin("teste");
		usuario.setNome("teste teste");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);
		
		Usuario usuarioSalvo = usuarioDAO.salvar(usuario);	
		Assert.assertNotNull(usuarioSalvo);
	}
	
	@Transactional
	@Test
	public void excluirTest() {
		Usuario usuario = new Usuario();
		Area area = new Area();
		
		area.setDescricao("teste");
		
		Area areaSalvo = areaDAO.salvar(area);	
		
		usuario.setArea(areaSalvo);
		usuario.setCelular("11 111111111");
		usuario.setEmail("teste@teste.com");
		usuario.setLogin("teste");
		usuario.setNome("teste teste");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);
		
		Usuario usuarioSalvo = usuarioDAO.salvar(usuario);		
		Long id = usuarioSalvo.getId();
		
		usuarioDAO.excluir(usuarioSalvo);
		
		Usuario usuarioExcluido = usuarioDAO.buscaPorId(id);
		
		Assert.assertNull(usuarioExcluido);
		
	}
}
