package testClinica;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Patio;

public class AtenderPacienteTestEscenario2 {
	Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");


	@Before
	public void setUp() throws Exception {
		Patio.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			Patio.getInstance().QuitaPaciente(p.getDni());
			fail("Esto no se deberia ejecutar");
			Clinica.getInstance().getAtencion().put(p.getDni(), p);
		} catch (PacienteNoEncontradoExcepcion e) {
			e.printStackTrace();
		}
		assertFalse("Fallo: El paciente no deberia estar en atencion ya que no estaba antes en espera.", Clinica.getInstance().getAtencion().containsKey(p.getDni()));
	}

}
