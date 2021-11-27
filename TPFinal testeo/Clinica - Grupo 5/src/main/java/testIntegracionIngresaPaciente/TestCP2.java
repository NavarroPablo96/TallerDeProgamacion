package testIntegracionIngresaPaciente;

import static org.junit.Assert.*;

import java.util.Queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Patio;
import modelo.Sala_privada;

public class TestCP2 {
		private Paciente ninio,pMayor;
	@Before
	public void setUp() throws Exception {
		//Escenario 2, Sala privada con un Paciente
		this.ninio= PacienteFactory.getPaciente("Juan", "Perez", "12341234", "Calle1", "CABA", "12345687", "Ninio");
		Sala_privada.getInstace().AgregaPaciente(this.ninio);
	}

	@After
	public void tearDown() throws Exception {
		Sala_privada.getInstace().AgregaPaciente(null);
		try {
			Patio.getInstance().QuitaPaciente(this.ninio.getDni());
			Patio.getInstance().QuitaPaciente(this.pMayor.getDni());
		}catch(Exception e) {
			//alguno va a arrojar excepcion
		}
	}

	@Test
	public void test() {
		this.pMayor = PacienteFactory.getPaciente("Juana", "Pera", "123234388", "Calle8", "Mar Del Plata", "12123412687", "Mayor");
		Clinica.getInstance().ingresaPaciente(this.pMayor);
		
		Queue<Paciente> Cola = Clinica.getInstance().getColaDeEspera();
		assertTrue("El paciente mayor no fue agregado a la cola",Cola.contains(this.pMayor));
		Paciente enSalaPrivada=Sala_privada.getInstace().devuelvePaciente();
		assertTrue("El paciente mayor no fue agregado a la Sala Privada",enSalaPrivada.getDni().equals(this.pMayor.getDni()));
		assertTrue("El ninio no fue desplazado al patio",Patio.getInstance().listaPacientes().containsKey(this.ninio.getDni()));
	}
	
	
}
