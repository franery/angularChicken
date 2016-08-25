package com.chicken.test.dao;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.persistencia.dao.IProveedorDAO;
import com.chicken.persistencia.model.ProveedorModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml"})
public class ProveedorTest {
	
	@Autowired
	IProveedorDAO proveedorDAO;
	
	private ProveedorModel crearProveedor(){
		ProveedorModel p = new ProveedorModel();
		p.setDireccion("CalleFalsa123");
		p.setMail("pepe@gmail.com");
		p.setNombre("Pepe");
		p.setTelefono("342423");
		return p;
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_InsertarYBuscarProveedor() {
		ProveedorModel p = crearProveedor();
		
		proveedorDAO.guardar(p);
		
		ProveedorModel p2 = proveedorDAO.get(p.getId());
		
		Assert.assertTrue(p2.getDireccion().equals(p.getDireccion()));
		Assert.assertTrue(p2.getMail().equals(p.getMail()));
		Assert.assertTrue(p2.getNombre().equals(p.getNombre()));
		Assert.assertTrue(p2.getTelefono().equals(p.getTelefono()));
		Assert.assertTrue(p2.getId() == p.getId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_BorrarProveedor() {
		ProveedorModel p = crearProveedor();
		proveedorDAO.guardar(p);
		proveedorDAO.borrar(p.getId());
		
		ProveedorModel p2 = proveedorDAO.get(p.getId());
		
		Assert.assertTrue(p2 == null);
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_ModificarProveedor() {
		ProveedorModel p = crearProveedor();
		proveedorDAO.guardar(p);
		ProveedorModel p2 = proveedorDAO.get(p.getId());
		Assert.assertTrue(p2.getNombre().equals(p.getNombre()));
		
		
		p.setNombre("NombreNueva");
		
		proveedorDAO.modificar(p);
		
		ProveedorModel p3 = proveedorDAO.get(p.getId());
		
		Assert.assertTrue(!p2.getNombre().equals(p3.getNombre()));
	}
}
