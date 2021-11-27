package testPatio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import factory.PacienteFactory;
import modelo.Paciente;
import modelo.Patio;

public class QuitaPacienteTestEscenario1 {
	Paciente paciente=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
	
	@Before
	public void setUp() throws Exception {
		//Escenario 1, HashMap de Pacientes vacio
		Patio.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		for (Paciente i : Patio.getInstance().listaPacientes().values()) {
            Patio.getInstance().QuitaPaciente(i.getDni());
        }
	}

	@Test
	public void test() {
		try {
			Patio.getInstance().QuitaPaciente(paciente.getDni());
			fail("Esto no se debería ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepcion que se esparaba PacienteNoEncontradoExcepcion");
		}
	}

}
