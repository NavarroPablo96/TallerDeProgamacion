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
import excepciones.PacienteNoEncontradoExcepcion;
import factory.MedicoFactory;
import factory.PacienteFactory;
import interf.IMedico;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Patio;
import modelo.Prestacion;

public class AtenderPacienteTestEscenario1 { //Se realizará con una persona en el Patio.
	Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");

	@Before
	public void setUp() throws Exception {
		Patio.getInstance().AgregaPaciente(p);
	}

	@After
	public void tearDown() throws Exception {
		for (Paciente i : Patio.getInstance().listaPacientes().values()) {
			Patio.getInstance().QuitaPaciente(i.getDni());
		}
	}

	@Test
	public void casoDePruebaAtencionVaciaE1Test() {
		escenario3();
		try {
			Patio.getInstance().QuitaPaciente(p.getDni());
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		Clinica.getInstance().getAtencion().put(p.getDni(), p);
		
		assertTrue("Fallo: El paciente no se agrego al HashMap atencion.", Clinica.getInstance().getAtencion().get(p.getDni()).getDni().equals(p.getDni()));
	}
	
	@Test
	public void casoDePruebaAtencionConAlgunPacienteE1Test() {
		escenario4();
		
		try {
			Patio.getInstance().QuitaPaciente(p.getDni());
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		Clinica.getInstance().getAtencion().put(p.getDni(), p);
		
		assertTrue("Fallo: El paciente no se agrego al HashMap atencion.", Clinica.getInstance().getAtencion().get(p.getDni()).getDni().equals(p.getDni()));
	}
	
	@Test
	public void casoDePruebaYaConteniaEsePacienteE1Test() {
		escenario4();
		Clinica.getInstance().getAtencion().put(p.getDni(), p);
		
		try {
			Patio.getInstance().QuitaPaciente(p.getDni());
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		if (Clinica.getInstance().getAtencion().containsKey(p.getDni())) {
			fail("No debería agregar a atención un paciente que ya estaba agregado.");
		}
		else {
			Clinica.getInstance().getAtencion().put(p.getDni(), p);
		}
		
		assertTrue("Fallo: El paciente no se agrego al HashMap atencion.", Clinica.getInstance().getAtencion().get(p.getDni()).getDni().equals(p.getDni()));
	}
	
	public void escenario3() { //La colección de atención está vacía
		HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
		
		Clinica.getInstance().setAtencion(atencion);
	}
	
	public void escenario4() { //La colección de atención tiene al menos un paciente
		HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();

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
		Prestacion prestacion = new Prestacion(nuevo, 2);
		
		Paciente p2 = PacienteFactory.getPaciente("Jorge", "Rial", "22222222", "Constitucion 101", "Mar del plata", "34", "Joven");
		
		Clinica.getInstance().agregaPrestacion(prestacion, p2.getNombre(), p2.getApellido(), p2.getDni());
		
		atencion.put(p2.getDni(), p2);
		Clinica.getInstance().setAtencion(atencion);
	}

}
