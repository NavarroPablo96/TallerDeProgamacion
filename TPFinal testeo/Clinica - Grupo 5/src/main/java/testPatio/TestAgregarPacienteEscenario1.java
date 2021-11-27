package testPatio;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Paciente;
import modelo.Patio;

public class TestAgregarPacienteEscenario1 {

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
	public void casoDePruebaEscenario1() {
		Paciente p=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
		Patio.getInstance().AgregaPaciente(p);
		
		assertTrue("El paciente no fue agregado correctamente",Patio.getInstance().listaPacientes().containsKey(p.getDni()));
	}

}
