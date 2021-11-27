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

public class ModPacienteNomyApeTestEscenario2 {
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");

	@Before
	public void setUp() throws Exception {
		pacientes.put(p.getDni(), p);
		Clinica.getInstance().setPacientes(pacientes);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
	}

	@Test
	public void casoDePruebaConEsePacienteE2Test() {
		try {
			Clinica.getInstance().modPacienteNomyApe(p.getDni(), "lol", "lel");
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se deberia ejecutar.");
		}
		assertFalse("Fallo: El paciente deberia tener su nombre modificado.", Clinica.getInstance().getPacientes().get(p.getDni()).getNombre().equals("lol"));
		assertFalse("Fallo: El paciente deberia tener su apellido modificado.", Clinica.getInstance().getPacientes().get(p.getDni()).getApellido().equals("lel"));
	}
	
	@Test
	public void casoDePruebaSinEsePacienteE2Test() {
		Paciente p2 = PacienteFactory.getPaciente("Jorge", "Rial", "22222222", "Constitucion 101", "Mar del plata", "34", "Joven");
		
		try {
			Clinica.getInstance().modPacienteNomyApe(p2.getDni(), "lil", "lul");
			fail("Esto no se deberia ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, PacienteNoEncontradoException");
		}
	}

}
