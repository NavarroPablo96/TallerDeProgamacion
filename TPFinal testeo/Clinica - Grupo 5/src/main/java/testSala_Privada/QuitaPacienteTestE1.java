package testSala_Privada;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Joven;
import modelo.Paciente;
import modelo.Sala_privada;

public class QuitaPacienteTestE1
{
	private Sala_privada sala_privada; 
	
	@Before
	public void setUp() {
		sala_privada = Sala_privada.getInstace();
		
		Paciente paciente = new Joven("Carlos", "Menem", "34", "Calle1", "Mard", "1234");
		sala_privada.AgregaPaciente(paciente);
	}
	
	@After
	public void tearDown() {

	}
	
	/**
	 * Se testea que se pueda quitar un paciente con dni valido de la sala.
	 */
	@Test
	public void test_pacienteValidoEnSala(){
		try
		{
			sala_privada.QuitaPaciente(sala_privada.devuelvePaciente().getDni());
		} catch (PacienteNoEncontradoExcepcion e)
		{	
			fail("No debe lanzar PacienteNoEncontradoExcepcion");
			e.printStackTrace();
		}
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni vacio en una sala con pacientes.
	 */
	@Test
	public void test_dnivacio() {
		try
		{
			sala_privada.QuitaPaciente("");
			fail("No deberia quitar un dni invalido");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni fuera de rango en una sala con pacientes.
	 */
	@Test
	public void test_dniFueraDeRango() {
		try
		{
			sala_privada.QuitaPaciente("401234321");
			fail("No deberia quitar un dni invalido");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
}
