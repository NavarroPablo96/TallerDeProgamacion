package testSala_Privada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Joven;
import modelo.Paciente;
import modelo.Sala_privada;

public class AgregarPacienteTest
{
	private Sala_privada sala_privada;
	
	
	/**
	 * Escenario vacio. No hay paciente en la sala 
	 */
	@Before
	public void setUpE1() {
		sala_privada = Sala_privada.getInstace();
	}
	
	@After
	public void tearDown() {
		try
		{
			sala_privada.QuitaPaciente(sala_privada.devuelvePaciente().getDni());
		} catch (PacienteNoEncontradoExcepcion e)
		{
			fail("No debe ingresar aqui, dni valido y en sala");
			e.printStackTrace();
		}
	}
	
	/**
	 * Se testea que se pueda agregar un paciente a la sala_privada vacia.
	 */
	@Test
	public void test_AgregarPacienteJE2() {
		Paciente paciente = new Joven("Carlos", "Menem", "34", "Calle1", "Mard", "1234");
		
		sala_privada.AgregaPaciente(paciente);
		
		assertEquals("Deberia tener el mismo nombre", paciente.getNombre(), sala_privada.devuelvePaciente().getNombre());
		assertEquals("Deberia tener el mismo Apellido", paciente.getApellido(), sala_privada.devuelvePaciente().getApellido());
		assertEquals("Deberia tener el mismo dni", paciente.getDni(), sala_privada.devuelvePaciente().getDni());
		assertEquals("Deberia tener el mismo domicilio", paciente.getDomicilio(), sala_privada.devuelvePaciente().getDomicilio());
		assertEquals("Deberia tener el mismo ciudad", paciente.getCiudad(), sala_privada.devuelvePaciente().getCiudad());
		assertEquals("Deberia tener el mismo telefono", paciente.getTelefono(), sala_privada.devuelvePaciente().getTelefono());
	}
	
	/**
	 * Se testea que no se pueda agregar un paciente a la salaprivada si ya hay uno. 
	 */
	@Test
	public void test_AgregarPacienteJE1() {
		Paciente paciente = new Joven("Lucas", "Menem", "344554", "Calle1", "Mard", "1234");
		
		sala_privada.AgregaPaciente(paciente);
		
		//Si tiene el mismo dni se ingreso a la sala, y no debe hacerlo
		assertNotSame(sala_privada.devuelvePaciente().getDni(), paciente.getDni());
		 
	}
	
}
