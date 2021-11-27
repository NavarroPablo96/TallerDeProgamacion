package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MismoDniExcepcion;
import factory.PacienteFactory;
import modelo.*;

public class AltaPacienteTestEscenario1 {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();

	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setPacientes(this.pacientes);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
	}

	@Test
	public void test() {
		Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");
		
		try {
			Clinica.getInstance().altaPaciente(p);
		} catch (MismoDniExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		
		assertTrue("Fallo: no se agrego al Paciente", Clinica.getInstance().getPacientes().containsKey(p.getDni()));
	}

}
