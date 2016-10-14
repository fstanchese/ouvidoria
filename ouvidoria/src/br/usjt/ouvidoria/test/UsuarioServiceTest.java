package br.usjt.ouvidoria.test;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.usjt.ouvidoira.exception.ServiceException;
import br.usjt.ouvidoria.dao.UsuarioDAO;
import br.usjt.ouvidoria.model.Area;
import br.usjt.ouvidoria.model.TipoUsuario;
import br.usjt.ouvidoria.model.Usuario;
import br.usjt.ouvidoria.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired 
	UsuarioDAO usuarioDAO;
	
	@Transactional
	@Test(expected=ServiceException.class)
	public void naoDeveSalvarTest() throws ServiceException {
		Usuario usuario = new Usuario();
		Area area = new Area();
		
		area.setId(1L);
		area.setDescricao("Area 1");
		
		usuario.setArea(area);
		usuario.setCelular("11 966256725");
		usuario.setEmail("fstanchese@gmail.com");
		usuario.setLogin("fstanchese");
		usuario.setNome("Fernando F Stanchese");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);
		
		usuarioDAO.salvar(usuario);
		
		usuarioService.salvar(usuario);
	}
	
	@Transactional
	@Test
	public void deveSalvarTest() throws ServiceException {
		Usuario usuario = new Usuario();
		Area area = new Area();
		
		area.setId(1L);
		area.setDescricao("Area 1");
		
		usuario.setArea(area);
		usuario.setCelular("11 966256725");
		usuario.setEmail("fstanchese@ig.com");
		usuario.setLogin("stanchese");
		usuario.setNome("Fernando F Stanchese");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);		
		
		Usuario usuarioSalvo = usuarioService.salvar(usuario);
		
		Assert.assertNotNull(usuarioSalvo);
	}
}
