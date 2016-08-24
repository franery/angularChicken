package com.chicken.test.dao;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.IDepositoDAO;
import com.chicken.persistencia.model.DepositoModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml"})
public class DepositoTest {
	
	@Autowired
	IDepositoDAO depositoDAO;
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_InsertarYBuscarDeposito() {
		DepositoModel p = new DepositoModel();
		p.setNombre("Deposito2");
		p.setStockHuevos(1);
		p.setStockMaximo(1);
		
		depositoDAO.guardar(p);
		
		DepositoModel p2 = depositoDAO.get(p.getId());
		
		Assert.assertTrue(p2.getNombre().equals(p.getNombre()));
		Assert.assertTrue(p2.getStockHuevos() == p.getStockHuevos());
		Assert.assertTrue(p2.getStockMaximo() == p.getStockMaximo());
		Assert.assertTrue(p2.getId() == p.getId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_BorrarDeposito() {
		DepositoModel p = new DepositoModel();
		p.setNombre("Deposito3");
		p.setStockHuevos(1);
		p.setStockMaximo(999);
		
		depositoDAO.guardar(p);
		
		depositoDAO.borrar(p.getId());
		
		DepositoModel p2 = depositoDAO.get(p.getId());
		
		Assert.assertTrue(p2 == null);
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_ModificarDeposito() {
		DepositoModel p = new DepositoModel();
		p.setNombre("Deposito1");
		p.setStockHuevos(1);
		p.setStockMaximo(1);
		
		depositoDAO.guardar(p);
		DepositoModel p2 = depositoDAO.get(p.getId());
		Assert.assertTrue(p2.getNombre().equals(p.getNombre()));
		
		p.setNombre("NombreNuevo");
		
		depositoDAO.modificar(p);
		
		DepositoModel p3 = depositoDAO.get(p.getId());
		
		Assert.assertTrue(!p2.getNombre().equals(p3.getNombre()));
	}
}
