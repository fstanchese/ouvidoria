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

import br.usjt.ouvidoria.dao.SugestaoDAO;
import br.usjt.ouvidoria.model.Area;
import br.usjt.ouvidoria.model.Status;
import br.usjt.ouvidoria.model.Sugestao;
import br.usjt.ouvidoria.model.TipoUsuario;
import br.usjt.ouvidoria.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class SugestaoDAOTest {

	@Autowired
	SugestaoDAO sugestaoDAO;
	
	@Transactional
	@Test
	public void salvarTest() {
		Sugestao sugestao = new Sugestao();
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
		usuario.setId(1L);
		
		sugestao.setArea(area);
		sugestao.setDataMural(new Date());
		sugestao.setDataSugestao(new Date());
		sugestao.setDescricao("descricao");
		sugestao.setStatus(Status.ABERTO);
		sugestao.setUsuario(usuario);
		
		Sugestao sugestaoSalvo = sugestaoDAO.salvar(sugestao);	
		Assert.assertNotNull(sugestaoSalvo);
	}
	
	@Transactional
	@Test
	public void excluirTest() {
		Sugestao sugestao = new Sugestao();
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
		usuario.setId(1L);
		
		sugestao.setArea(area);
		sugestao.setDataMural(new Date());
		sugestao.setDataSugestao(new Date());
		sugestao.setDescricao("descricao");
		sugestao.setStatus(Status.ABERTO);
		sugestao.setUsuario(usuario);
		
		Sugestao sugestaoSalvo = sugestaoDAO.salvar(sugestao);	
		Long id = sugestaoSalvo.getId();
		
		sugestaoDAO.excluir(sugestaoSalvo);
		
		Sugestao sugestaoExcluido = sugestaoDAO.buscaPorId(id);
		
		Assert.assertNull(sugestaoExcluido);
		
	}
}
