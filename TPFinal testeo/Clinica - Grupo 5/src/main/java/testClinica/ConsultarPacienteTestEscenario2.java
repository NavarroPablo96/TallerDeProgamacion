package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;

public class ConsultarPacienteTestEscenario2 {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");

	@Before
	public void setUp() throws Exception {
		
		this.pacientes.put(this.p.getDni(), this.p);
		Clinica.getInstance().setPacientes(this.pacientes);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
	}

	@Test
	public void casoDePruebaConEsePacienteE2Test() {
		Paciente p2 = null;
		try {
			p2 = Clinica.getInstance().consultarPaciente(this.p.getDni());
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		assertTrue("Fallo: no se agrego al Paciente", Clinica.getInstance().getPacientes().containsKey(p2.getDni()));
	}
	
	@Test
	public void casoDePruebaSinEsePacienteE2Test() {
		Paciente p2 = null;
		try {
			p2 = Clinica.getInstance().consultarPaciente(this.p.getDni() + "5");
			fail("Esto no se deberia ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, PacienteNoEncontradoExcepcion");
		}
		assertTrue("Fallo: no se agrego al Paciente", Clinica.getInstance().getPacientes().containsKey(p.getDni()));
	}

}
