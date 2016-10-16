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
import br.usjt.ouvidoria.model.Area;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/spring-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class AreaDAOTest {

	@Autowired
	AreaDAO areaDAO;
	
	@Transactional
	@Test
	public void salvarTest() {
		Area area = new Area();
		
		area.setDescricao("Area 1");
		
		Area areaSalvo = areaDAO.salvar(area);	
		Assert.assertNotNull(areaSalvo);
	}
	
	@Transactional
	@Test
	public void excluirTest() {
		Area area = new Area();
		
		area.setDescricao("Area 1");
		
		Area areaSalvo = areaDAO.salvar(area);	
		Long id = areaSalvo.getId();
		
		areaDAO.excluir(areaSalvo);
		
		Area areaExcluido = areaDAO.buscaPorId(id);
		
		Assert.assertNull(areaExcluido);
		
	}
}
