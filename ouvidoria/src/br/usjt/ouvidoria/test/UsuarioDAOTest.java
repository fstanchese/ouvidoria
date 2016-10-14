package br.usjt.ouvidoria.test;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
	
	@Transactional
	@Test
	public void salvarTest() {
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
		
		Usuario usuarioSalvo = usuarioDAO.salvar(usuario);	
		Assert.assertNotNull(usuarioSalvo);
	}
	
	@Transactional
	@Test
	public void excluirTest() {
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
		
		Usuario usuarioSalvo = usuarioDAO.salvar(usuario);		
		Long id = usuarioSalvo.getId();
		
		usuarioDAO.excluir(usuarioSalvo);
		
		Usuario usuarioExcluido = usuarioDAO.buscaPorId(id);
		
		Assert.assertNull(usuarioExcluido);
		
	}
}
