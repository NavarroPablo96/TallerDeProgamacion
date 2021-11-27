package testIntegracionAtencionPaciente;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Sala_privada;

public class TestCP2 {
	Paciente pacienteEnEnSalaPrivada;
	
	@Before
	public void setUp() throws Exception {
		this.pacienteEnEnSalaPrivada = PacienteFactory.getPaciente("Roberto", "Petinato", "54652135", "arandanos12", "MArPla", "876313", "Mayor");
		
		Clinica.getInstance().getColaDeEspera().add(this.pacienteEnEnSalaPrivada);
		Sala_privada.getInstace().AgregaPaciente(this.pacienteEnEnSalaPrivada);
		
		
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().getColaDeEspera().clear();		
		Clinica.getInstance().getAtencion().clear();
		
	}
	

	@Test
	public void test() {
		Clinica.getInstance().atenderPaciente();
		Paciente enSalaPosTest=Sala_privada.getInstace().devuelvePaciente();
		assertFalse("El paciente no fue removido de la Sala privada",enSalaPosTest!=null  && enSalaPosTest.getDni().equals(this.pacienteEnEnSalaPrivada.getDni()));
		assertFalse("El paciente no fue removido de la cola de espera",Clinica.getInstance().getColaDeEspera().contains(pacienteEnEnSalaPrivada));
		assertTrue("No se agrego al paciente a la lista de atendidos",Clinica.getInstance().getAtencion().containsKey(this.pacienteEnEnSalaPrivada.getDni()));
	}

}
