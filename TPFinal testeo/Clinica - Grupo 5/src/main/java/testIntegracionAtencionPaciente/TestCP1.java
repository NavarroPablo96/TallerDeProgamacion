package testIntegracionAtencionPaciente;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Patio;
import modelo.Sala_privada;

public class TestCP1 {
	Paciente pacienteEnElPatio=null;
	
	@Before
	public void setUp() throws Exception {
		Clinica.getInstance();
		Sala_privada.getInstace().AgregaPaciente(null);
		this.pacienteEnElPatio= PacienteFactory.getPaciente("Juan", "Perez", "12341234", "Calle1", "CABA", "12345687", "Ninio");
		Patio.getInstance().AgregaPaciente(this.pacienteEnElPatio);
		Clinica.getInstance().getColaDeEspera().add(this.pacienteEnElPatio);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().getColaDeEspera().clear();
		Clinica.getInstance().getAtencion().clear();
		try {
			Patio.getInstance().QuitaPaciente(this.pacienteEnElPatio.getDni());
		}catch(Exception e) {
			
		}
	}

	@Test
	public void test() {
		Clinica.getInstance().atenderPaciente();
		assertFalse("El paciente no fue removido del patio",Patio.getInstance().listaPacientes().containsKey(pacienteEnElPatio.getDni()));
		assertFalse("El paciente no fue removido de la cola de espera",Clinica.getInstance().getColaDeEspera().contains(pacienteEnElPatio));
		assertTrue("No se agrego al paciente a la lista de atendidos",Clinica.getInstance().getAtencion().containsKey(this.pacienteEnElPatio.getDni()));
	}

}
