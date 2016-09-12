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
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml"})
public class UsuarioTest {
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_InsertarYBuscarUsuario() throws Exception {
		UsuarioModel u = new UsuarioModel();
		u.setApellido("dd");
		u.setContrasenia("cc");
		u.setNombre("Admin");
		u.setNombreUsuario("Admin");
		
		usuarioDAO.guardar(u);
		
		UsuarioModel u2 = usuarioDAO.get(u.getId());
		
		Assert.assertTrue(u2.getNombre().equals(u.getNombre()));
		Assert.assertTrue(u2.getApellido().equals(u.getApellido()));
		Assert.assertTrue(u2.getContrasenia().equals(u.getContrasenia()));
		Assert.assertTrue(u2.getNombreUsuario().equals(u.getNombreUsuario()));
		Assert.assertTrue(u2.getId() == u.getId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_BorrarUsuario() throws Exception {
		UsuarioModel u = new UsuarioModel();
		u.setApellido("dd");
		u.setContrasenia("cc");
		u.setNombre("Productor");
		u.setNombreUsuario("Productor");
		
		usuarioDAO.guardar(u);
		
		usuarioDAO.borrar(u.getId());
		
		UsuarioModel p2 = usuarioDAO.get(u.getId());
		
		Assert.assertTrue(p2.isBorrado());
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_ModificarUsuario() throws Exception {
		UsuarioModel u = new UsuarioModel();
		u.setApellido("dd");
		u.setContrasenia("cc");
		u.setNombre("Contable");
		u.setNombreUsuario("Contable");
		
		usuarioDAO.guardar(u);
		UsuarioModel u2 = usuarioDAO.get(u.getId());
		Assert.assertTrue(u2.getNombre().equals(u.getNombre()));
		
		u.setNombre("ContableNuevo");
		
		usuarioDAO.modificar(u);
		
		UsuarioModel u3 = usuarioDAO.get(u.getId());
		
		Assert.assertTrue(!u2.getNombre().equals(u3.getNombre()));
	}
}
