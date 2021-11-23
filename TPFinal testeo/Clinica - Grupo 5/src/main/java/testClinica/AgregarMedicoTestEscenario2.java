package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import factory.MedicoFactory;
import interf.IMedico;
import modelo.Clinica;

public class AgregarMedicoTestEscenario2 {
	private HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	
	@Before
	public void setUp() throws Exception {
		IMedico nuevo=null;
		try {
			nuevo = MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA", "011-12349873", 5000, "pediatra", null, "RESIDENTE");
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
		medicos.put(nuevo.getDni(), nuevo);
		Clinica.getInstance().setMedicos(this.medicos);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CasoDePruebaIMedicoValidoE2Test() {
		IMedico nuevo=null;
		try {
			nuevo = MedicoFactory.getMedico("Carlos","Lopez","40345897","Calle2","Miramar", "4569872", 5000, "pediatra", null, "RESIDENTE");
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
			Clinica.getInstance().agregarMedico(nuevo);
		} catch (MismoDniExcepcion e) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		}
		assertTrue("Fallo: no se agrego al IMedico", Clinica.getInstance().getMedicos().containsKey(nuevo.getDni()));
	}
	
	@Test
	public void CasoDePruebaDniRepetidoE2Test() {
		IMedico nuevo=null;
		try {
			nuevo = MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA", "011-12349873", 5000, "pediatra", null, "RESIDENTE");
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
			Clinica.getInstance().agregarMedico(nuevo);
			fail("Esto no se deberia ejecutar");
		} catch (MismoDniExcepcion e) {
			System.out.println("Se lanzo la excepción que se esperaba, MismoDniExcepcion");
		}
	}

}
