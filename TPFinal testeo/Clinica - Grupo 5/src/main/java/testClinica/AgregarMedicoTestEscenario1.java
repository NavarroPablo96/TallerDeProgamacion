package testClinica;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import factory.*;
import factory.MedicoFactory;
import interf.*;
import modelo.*;




public class AgregarMedicoTestEscenario1 {
	private HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	
	@Before
	public void setUp() throws Exception {
		
		//Escenario 1 hashMap de medicos est� vacio
		Clinica.getInstance().setMedicos(this.medicos);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
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
		} catch (MismoDniExcepcion e) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		}
		
		assertTrue("Fallo: no se agrego al IMedico", Clinica.getInstance().getMedicos().containsKey(nuevo.getDni()));
		
	}

}
