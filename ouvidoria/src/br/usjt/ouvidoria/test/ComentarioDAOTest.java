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

import br.usjt.ouvidoria.dao.ComentarioDAO;
import br.usjt.ouvidoria.model.Area;
import br.usjt.ouvidoria.model.Comentario;
import br.usjt.ouvidoria.model.Status;
import br.usjt.ouvidoria.model.Sugestao;
import br.usjt.ouvidoria.model.TipoUsuario;
import br.usjt.ouvidoria.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class ComentarioDAOTest {

	@Autowired
	ComentarioDAO comentarioDAO;
	
	@Transactional
	@Test
	public void salvarTest() {
		Comentario comentario = new Comentario();
		Usuario usuario = new Usuario();
		Area area = new Area();
		Sugestao sugestao = new Sugestao();
		
		area.setId(1L);
		area.setDescricao("Area 1");
		
		usuario.setArea(area);
		usuario.setCelular("11 966256725");
		usuario.setEmail("fstanchese@gmail.com");
		usuario.setLogin("fstanchese");
		usuario.setNome("Fernando F Stanchese");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);		
		usuario.setId(1L);
		
		sugestao.setArea(area);
		sugestao.setDataMural(new Date());
		sugestao.setDataSugestao(new Date());
		sugestao.setDescricao("descricao");
		sugestao.setStatus(Status.ABERTO);
		sugestao.setUsuario(usuario);
		sugestao.setId(1L);
		
		comentario.setDataComentario(new Date());
		comentario.setDescricao("descricao");
		comentario.setSugestao(sugestao);
		comentario.setUsuario(usuario);
		
		Comentario comentarioSalvo = comentarioDAO.salvar(comentario);	
		Assert.assertNotNull(comentarioSalvo);
	}
	
	@Transactional
	@Test
	public void excluirTest() {
		Comentario comentario = new Comentario();
		Usuario usuario = new Usuario();
		Area area = new Area();
		Sugestao sugestao = new Sugestao();
		
		area.setId(1L);
		area.setDescricao("Area 1");
		
		usuario.setArea(area);
		usuario.setCelular("11 966256725");
		usuario.setEmail("fstanchese@gmail.com");
		usuario.setLogin("fstanchese");
		usuario.setNome("Fernando F Stanchese");
		usuario.setSenha("123456");
		usuario.setTipoUsuario(TipoUsuario.SUPERVISOR);		
		usuario.setId(1L);
		
		sugestao.setArea(area);
		sugestao.setDataMural(new Date());
		sugestao.setDataSugestao(new Date());
		sugestao.setDescricao("descricao");
		sugestao.setStatus(Status.ABERTO);
		sugestao.setUsuario(usuario);
		sugestao.setId(1L);
		
		Comentario comentarioSalvo = comentarioDAO.salvar(comentario);	
		Long id = comentarioSalvo.getId();
		
		comentarioDAO.excluir(comentarioSalvo);
		
		Comentario comentarioExcluido = comentarioDAO.buscaPorId(id);
		
		Assert.assertNull(comentarioExcluido);
		
	}
}
