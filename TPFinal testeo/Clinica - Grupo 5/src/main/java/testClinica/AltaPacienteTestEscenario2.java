package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MismoDniExcepcion;
import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;

public class AltaPacienteTestEscenario2 {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();

	@Before
	public void setUp() throws Exception {
		Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");
		
		this.pacientes.put(p.getDni(), p);
		Clinica.getInstance().setPacientes(this.pacientes);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
	}

	@Test
	public void casoDePruebaSinEsePacienteE2Test() {
		Paciente p2 = null;
		p2 = PacienteFactory.getPaciente("Marta", "Lopez", "22222222", "Constitucion 100", "Mar del plata", "34", "Joven");
		
		try {
			Clinica.getInstance().altaPaciente(p2);
		} catch (MismoDniExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		
		assertTrue("Fallo: no se agrego al Paciente", Clinica.getInstance().getPacientes().containsKey(p2.getDni()));
	}
	
	@Test
	public void casoDePruebaConEsePacienteE2Test() {
		Paciente p = null;
		p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");
		
		try {
			Clinica.getInstance().altaPaciente(p);
			fail("Esto no se deberia ejecutar");
		} catch (MismoDniExcepcion e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, MismoDniException");
		}
	}

}
