package testPatio;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Paciente;
import modelo.Patio;

public class MuestraPacienteTestEscenario1 {

	@Before
	public void setUp() throws Exception {
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
		Patio.getInstance().muestraPacientes();
		System.out.println("No Debería haberse mostrado ningún paciente");
	}

}
