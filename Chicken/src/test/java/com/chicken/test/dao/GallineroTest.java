package com.chicken.test.dao;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chicken.base.enumeradores.EPerfil;
import com.chicken.persistencia.dao.IGallineroDAO;
import com.chicken.persistencia.dao.IUsuarioDAO;
import com.chicken.persistencia.model.GallineroModel;
import com.chicken.persistencia.model.UsuarioModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml"})
public class GallineroTest {
	
	@Autowired
	IGallineroDAO gallineroDAO;
	
	@Autowired 
	IUsuarioDAO usuarioDAO;
	
	private UsuarioModel crearUsuario() {
		UsuarioModel u = new UsuarioModel();
		u.setApellido("dd");
		u.setContrasenia("cc");
		u.setNombre("NN");
		u.setNombreUsuario("NU");
		u.setPerfil(EPerfil.ADMINISTRADOR);
		return u;
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_InsertarYBuscarGallinero() {
		
		UsuarioModel u = crearUsuario();
		usuarioDAO.guardar(u);
		
		GallineroModel p = new GallineroModel();
		p.setNombre("Gallinero2");
		p.setStockGallinas(50);
		p.setUsuario(usuarioDAO.get(u.getId()));
	
		gallineroDAO.guardar(p);
		
		GallineroModel p2 = gallineroDAO.get(p.getId());
		
		Assert.assertTrue(p2.getNombre().equals(p.getNombre()));
		Assert.assertTrue(p2.getId() == p.getId());
		Assert.assertTrue(p2.getStockGallinas() == p.getStockGallinas());
		Assert.assertTrue(p2.getUsuario().getId() == p.getUsuario().getId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_BorrarGallinero() {
		UsuarioModel u = crearUsuario();
		usuarioDAO.guardar(u);
		
		GallineroModel p = new GallineroModel();
		p.setNombre("Gallinero2");
		p.setStockGallinas(50);
		p.setUsuario(usuarioDAO.get(u.getId()));
	
		gallineroDAO.guardar(p);
		
		gallineroDAO.borrar(p.getId());
		
		GallineroModel p2 = gallineroDAO.get(p.getId());
		
		Assert.assertTrue(p2 == null);
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_ModificarGallinero() {
		UsuarioModel u = crearUsuario();
		usuarioDAO.guardar(u);
		
		GallineroModel p = new GallineroModel();
		p.setNombre("Gallinero2");
		p.setStockGallinas(50);
		p.setUsuario(usuarioDAO.get(u.getId()));
		
		gallineroDAO.guardar(p);
		
		GallineroModel p2 = gallineroDAO.get(p.getId());
		Assert.assertTrue(p2.getNombre().equals(p.getNombre()));
		
		p.setNombre("NombreNuevo");
		
		gallineroDAO.modificar(p);
		
		GallineroModel p3 = gallineroDAO.get(p.getId());
		
		Assert.assertTrue(!p2.getNombre().equals(p3.getNombre()));
	}
}
