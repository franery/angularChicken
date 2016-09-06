package ar.com.escuelita.chicken.test.dao;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.persistencia.dao.IGallineroDAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml"})
public class GallineroTest {
	
	@Autowired
	IGallineroDAO gallineroDAO;
	
	@Autowired 
	IUsuarioDAO usuarioDAO;
	
	private UsuarioModel crearUsuario() {
		UsuarioModel u = new UsuarioModel();
		u.setApellido("dd");
		u.setContrasenia("cc");
		u.setNombre("Productor");
		u.setNombreUsuario("Productor");
		u.setPerfil(EnumPerfil.PRODUCTOR);
		return u;
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_InsertarYBuscarGallinero() throws Exception {
		
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
	public void test_BorrarGallinero() throws Exception  {
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
	public void test_ModificarGallinero() throws Exception {
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
