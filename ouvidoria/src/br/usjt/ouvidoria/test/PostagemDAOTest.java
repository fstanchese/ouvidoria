package br.usjt.ouvidoria.test;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.usjt.ouvidoria.dao.AreaDAO;
import br.usjt.ouvidoria.dao.PostagemDAO;
import br.usjt.ouvidoria.dao.UsuarioDAO;
import br.usjt.ouvidoria.model.Area;
import br.usjt.ouvidoria.model.Status;
import br.usjt.ouvidoria.model.Postagem;
import br.usjt.ouvidoria.model.TipoUsuario;
import br.usjt.ouvidoria.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class PostagemDAOTest {

	@Autowired
	AreaDAO areaDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	PostagemDAO sugestaoDAO;

	@Transactional
	@Test
	public void salvarTest() {
		Postagem sugestao = new Postagem();
		Usuario usuario = new Usuario();
		Area area = new Area();
		
		area.setDescricao("Area 1");
		Area areaSalvo = areaDAO.salvar(area);	
	
		usuario.setArea(area);
		usuario.setCelular("11 111111111");
		usuario.setEmail("teste@teste");
		usuario.setLogin("teste");
		usuario.setNome("teste");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);
		
		Usuario usuarioSalvo = usuarioDAO.salvar(usuario);	
		
		sugestao.setArea(areaSalvo);
		sugestao.setDataSugestao(new Date());
		sugestao.setDescricao("descricao");
		sugestao.setStatus(Status.ABERTO);
		sugestao.setUsuario(usuarioSalvo);
		
		Postagem sugestaoSalvo = sugestaoDAO.salvar(sugestao);	
		Assert.assertNotNull(sugestaoSalvo);
	}
	
	@Transactional
	@Test
	public void excluirTest() {
		Postagem sugestao = new Postagem();
		Usuario usuario = new Usuario();
		Area area = new Area();
		
		area.setDescricao("Area 1");
		Area areaSalvo = areaDAO.salvar(area);	
	
		usuario.setArea(area);
		usuario.setCelular("11 111111111");
		usuario.setEmail("teste@teste");
		usuario.setLogin("teste");
		usuario.setNome("teste");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);
		
		Usuario usuarioSalvo = usuarioDAO.salvar(usuario);	
		
		sugestao.setArea(areaSalvo);
		sugestao.setDataSugestao(new Date());
		sugestao.setDescricao("descricao");
		sugestao.setStatus(Status.ABERTO);
		sugestao.setUsuario(usuarioSalvo);
		
		Postagem sugestaoSalvo = sugestaoDAO.salvar(sugestao);	
		Long id = sugestaoSalvo.getId();
		
		sugestaoDAO.excluir(sugestaoSalvo);
		
		Postagem sugestaoExcluido = sugestaoDAO.buscaPorId(id);
		
		Assert.assertNull(sugestaoExcluido);
		
	}
}
