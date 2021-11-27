package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Clinica;
import modelo.Paciente;

public class ModPacienteDomTestEscenario1 {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	
	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setPacientes(pacientes);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
	}

	@Test
	public void test() {
		try {
			Clinica.getInstance().modPacienteDom("55555", "Colon 1");
			fail("Esto no se deberia ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, PacienteNoEncontradoExcepcion");
		}
		
	}

}
