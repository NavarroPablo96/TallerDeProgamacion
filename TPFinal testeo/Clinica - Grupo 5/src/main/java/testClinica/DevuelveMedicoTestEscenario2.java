package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MedicoNoEncontradoException;
import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import excepciones.PacienteNoEncontradoExcepcion;
import factory.MedicoFactory;
import interf.IMedico;
import modelo.Clinica;
import modelo.Paciente;

public class DevuelveMedicoTestEscenario2 {
	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	IMedico m = null;
	

	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setMedicos(medicos);
		
		try {
			this.m = MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA", "011-12349873", 5000, "pediatra", null, "RESIDENTE");
		} catch (NoHayEspecialidadException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoHayContratacionException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoExistePosgradoException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoExisteContratacionException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoExisteEspecialidadException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		}
		
		try {
			Clinica.getInstance().agregarMedico(m);
		} catch (MismoDniExcepcion e) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setMedicos(new HashMap<String, IMedico>());
	}

	@Test
	public void casoDePruebaConEseMedicoE2Test() {
		IMedico m2 = null;
		try {
			m2 = Clinica.getInstance().devuelveMedico(m.getDni());
		} catch (MedicoNoEncontradoException e) {
			fail("Esto no se deberia ejecutar");
		}
		
		assertTrue("Fallo: no se devolvio bien al medico.", m2.getDni().equals(this.m.getDni()));
	}
	
	@Test
	public void casoDePruebaSinEseMedicoE2Test() {
		IMedico m2 = null;
		try {
			m2 = Clinica.getInstance().devuelveMedico(m.getDni() + "5");
			fail("Esto no se deberia ejecutar");
		} catch (MedicoNoEncontradoException e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, MedicoNoEncontradoException");
		}
		assertTrue("Fallo: el medico no estaba en la coleccion de medicos.", (m2 == null));
	}

}
