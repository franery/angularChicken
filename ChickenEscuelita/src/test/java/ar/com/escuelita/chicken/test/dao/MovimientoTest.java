package ar.com.escuelita.chicken.test.dao;

import java.sql.Date;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.escuelita.chicken.base.enumerador.EnumPerfil;
import ar.com.escuelita.chicken.persistencia.dao.IDepositoDAO;
import ar.com.escuelita.chicken.persistencia.dao.IGallineroDAO;
import ar.com.escuelita.chicken.persistencia.dao.IMovimientoDAO;
import ar.com.escuelita.chicken.persistencia.dao.IUsuarioDAO;
import ar.com.escuelita.chicken.persistencia.modelo.DepositoModel;
import ar.com.escuelita.chicken.persistencia.modelo.GallineroModel;
import ar.com.escuelita.chicken.persistencia.modelo.MovimientoModel;
import ar.com.escuelita.chicken.persistencia.modelo.UsuarioModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-context.xml"})
public class MovimientoTest {
	
	@Autowired
	IMovimientoDAO movimientoDAO;
	
	@Autowired 
	IUsuarioDAO usuarioDAO;
	
	@Autowired 
	IDepositoDAO depositoDAO;
	
	@Autowired
	IGallineroDAO gallineroDAO;
	
	private DepositoModel crearDeposito() {
		DepositoModel d = new DepositoModel();
		d.setNombre("Deposito2");
		d.setStockHuevos(1);
		d.setStockMaximo(1);
		return d;
	}
	

	private UsuarioModel crearUsuario() {
		UsuarioModel u = new UsuarioModel();
		u.setApellido("dd");
		u.setContrasenia("cc");
		u.setNombre("NN");
		u.setNombreUsuario("NU");
		u.setPerfil(EnumPerfil.ADMINISTRADOR);
		return u;
	}
	
	private GallineroModel crearGallinero() throws Exception  {
		UsuarioModel u = crearUsuario();
		usuarioDAO.guardar(u);
		
		GallineroModel g = new GallineroModel();
		g.setNombre("Gallinero2");
		g.setStockGallinas(50);
		g.setUsuario(usuarioDAO.get(u.getId()));
		
		return g;
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_InsertarYBuscarMovimiento() throws Exception  {
		DepositoModel d = crearDeposito();
		depositoDAO.guardar(d);
		
		GallineroModel g = crearGallinero();
		gallineroDAO.guardar(g);
		
		MovimientoModel p = new MovimientoModel();
		p.setCantidad(12);
		p.setFecha(new Date(99));
		p.setDeposito(depositoDAO.get(d.getId()));
		p.setGallinero(gallineroDAO.get(g.getId()));
		
		movimientoDAO.guardar(p);
		
		MovimientoModel p2 = movimientoDAO.get(p.getId());
		
		Assert.assertTrue(p2.getCantidad() == p.getCantidad());
		Assert.assertTrue(p2.getId() == p.getId());
		Assert.assertTrue(p2.getDeposito().getId() == p.getDeposito().getId());
		Assert.assertTrue(p2.getGallinero().getId() == p.getGallinero().getId());
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_BorrarMovimiento() throws Exception {
		DepositoModel d = crearDeposito();
		depositoDAO.guardar(d);
		
		GallineroModel g = crearGallinero();
		gallineroDAO.guardar(g);
		
		MovimientoModel p = new MovimientoModel();
		p.setCantidad(12);
		p.setFecha(new Date(99));
		p.setDeposito(depositoDAO.get(d.getId()));
		p.setGallinero(gallineroDAO.get(g.getId()));
		
		movimientoDAO.guardar(p);
		
		movimientoDAO.borrar(p.getId());
		
		MovimientoModel p2 = movimientoDAO.get(p.getId());
		
		Assert.assertTrue(p2 == null);
	}
	
	@Test
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public void test_ModificarMovimiento() throws Exception {
		DepositoModel d = crearDeposito();
		depositoDAO.guardar(d);
		
		GallineroModel g = crearGallinero();
		gallineroDAO.guardar(g);
		
		MovimientoModel p = new MovimientoModel();
		p.setCantidad(12);
		p.setFecha(new Date(99));
		p.setDeposito(depositoDAO.get(d.getId()));
		p.setGallinero(gallineroDAO.get(g.getId()));
		
		movimientoDAO.guardar(p);
		
		MovimientoModel p2 = movimientoDAO.get(p.getId());
		
		Assert.assertTrue(p2.getCantidad() == p.getCantidad());
		
		p.setCantidad(50);
		
		movimientoDAO.modificar(p);
		
		MovimientoModel p3 = movimientoDAO.get(p.getId());
		
		Assert.assertTrue(p2.getCantidad() != p3.getCantidad());
	}
}
