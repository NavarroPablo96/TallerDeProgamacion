package testIntegracionIngresaPaciente;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Patio;
import modelo.Sala_privada;

public class TestCP1 {

	@Before
	public void setUp() throws Exception {
		Clinica.getInstance();
		Sala_privada.getInstace();
		Patio.getInstance();
		
	}

	@After
	public void tearDown() throws Exception {
		Sala_privada.getInstace().QuitaPaciente("54652135");
	}

	@Test
	public void test() {
		Paciente p = PacienteFactory.getPaciente("Roberto", "Petinato", "54652135", "arandanos12", "MArPla", "876313", "Mayor");
		
		Clinica.getInstance().ingresaPaciente(p);
		
		Assert.assertTrue(Clinica.getInstance().getColaDeEspera().contains(p));
		Assert.assertEquals(Sala_privada.getInstace().devuelvePaciente().getDni(),p.getDni());
		
		
		
	}

}
