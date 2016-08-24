package com.chicken.test.dao;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.IParametroDAO;
import com.chicken.persistencia.model.ParametroModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml"})
public class ParametroTest {
	
	@Autowired
	IParametroDAO parametroDAO;
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_AInsertarParametro() {
		ParametroModel p = new ParametroModel();
		p.setDescripcion("LALALApppp");
		p.setValor("ANDAAA");
		
		parametroDAO.guardar(p);
	}
}
