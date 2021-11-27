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

public class TestCP4 {
		private Paciente mayor,pMayor;
	@Before
	public void setUp() throws Exception {
		//Escenario 2, Sala privada con un Paciente
		this.mayor= PacienteFactory.getPaciente("Juan", "Perez", "12341234", "Calle1", "CABA", "12345687", "Mayor");
		Sala_privada.getInstace().AgregaPaciente(this.mayor);
	}

	@After
	public void tearDown() throws Exception {
		Sala_privada.getInstace().AgregaPaciente(null);
		try {
			Patio.getInstance().QuitaPaciente(this.mayor.getDni());
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
		assertTrue("El paciente mayor que estaba en la sala privada fue desplazado al patio",enSalaPrivada.getDni().equals(this.mayor.getDni()));
		assertTrue("El paciente mayor que deseaba ingresar no fue agregado al patio",Patio.getInstance().listaPacientes().containsKey(this.pMayor.getDni()));
	}
	
	
}
