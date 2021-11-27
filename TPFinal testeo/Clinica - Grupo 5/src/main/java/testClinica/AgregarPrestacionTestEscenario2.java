package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import factory.MedicoFactory;
import interf.IMedico;
import modelo.Clinica;
import modelo.HistoriaClinica;
import modelo.Paciente;
import modelo.Prestacion;

public class AgregarPrestacionTestEscenario2 {

	@Before
	public void setUp() throws Exception {
		//Primero creamos un médico:
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
		//Ahora creaoms una prestación:
		Prestacion p = new Prestacion(nuevo, 2);
		
		Clinica.getInstance().agregaPrestacion(p, "Jorge", "Rial", "55555");
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setHistoriaClinicaHashMap(new HashMap<String, HistoriaClinica>());
//		Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
	}

	@Test
	public void casoDePruebaDniExistenteE2Test() {
		//Primero creamos un médico:
		IMedico nuevo=null;
		try {
			nuevo = MedicoFactory.getMedico("Marcelo","Tinelli","12324324","Calle1","CABA", "011-12349873", 5000, "pediatra", null, "RESIDENTE");
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
		//Ahora creaoms una prestación:
		Prestacion p = new Prestacion(nuevo, 2);
		
		Clinica.getInstance().agregaPrestacion(p, "Jorge", "Rial", "55555");
		
		//Como la documentación del método es inexistente, se testeó viendo el código y se ingresó el DNI a mano.
		assertTrue("Fallo: no se agrego la prestacion",Clinica.getInstance().getHistoriaClinicaHashMap().containsKey("55555"));
		
		assertTrue("Fallo: Hay una historia clínica con un DNI de un paciente inexistente.", Clinica.getInstance().getPacientes().containsKey("55555"));
	}

	@Test
	public void casoDePruebaDniInexistenteE2Test() {
		//Primero creamos un médico:
		IMedico nuevo=null;
		try {
			nuevo = MedicoFactory.getMedico("Marcelo","Tinelli","12324324","Calle1","CABA", "011-12349873", 5000, "pediatra", null, "RESIDENTE");
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
		//Ahora creaoms una prestación:
		Prestacion p = new Prestacion(nuevo, 2);
		
		Clinica.getInstance().agregaPrestacion(p, "Lionel", "Messi", "101010");
		
		//Como la documentación del método es inexistente, se testeó viendo el código y se ingresó el DNI a mano.
		assertTrue("Fallo: no se agrego la prestacion",Clinica.getInstance().getHistoriaClinicaHashMap().containsKey("55555"));
		assertTrue("Fallo: no se agrego la prestacion",Clinica.getInstance().getHistoriaClinicaHashMap().containsKey("101010"));
		
		assertTrue("Fallo: Hay una historia clínica con un DNI de un paciente inexistente.", Clinica.getInstance().getPacientes().containsKey("55555"));
		assertTrue("Fallo: Hay una historia clínica con un DNI de un paciente inexistente.", Clinica.getInstance().getPacientes().containsKey("101010"));
	}
	
}
