package testIntegracionAtencionPaciente;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import modelo.Patio;
import modelo.Sala_privada;

public class TestCP3 {

	@Before
	public void setUp() throws Exception {
		Patio.getInstance();
		Sala_privada.getInstace();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Clinica.getInstance().atenderPaciente();
	}

}
