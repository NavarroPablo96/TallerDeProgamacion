package testSala_Privada;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Sala_privada;


public class QuitaPacienteTestE2
{
	private Sala_privada sala_privada; 
	
	
	/**
	 * Sala sin paciente.
	 */
	@Before
	public void setUpE2() {
		sala_privada = Sala_privada.getInstace();	
	}
	
	@After
	public void tearDown() {
		
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni valido en una sala sin pacientes.
	 */
	@Test
	public void  test_dnivalido() {
		try
		{
			sala_privada.QuitaPaciente("40124923");
			fail("No deberia quitar si la sala estaba vacia.");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni vacio en una sala sin pacientes.
	 */
	@Test
	public void test_dnivacio() {
		try
		{
			sala_privada.QuitaPaciente("");
			fail("No deberia quitar si la sala estaba vacia.");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni fuera de rango en una sala sin pacientes.
	 */
	@Test
	public void test_dniFueraDeRango() {
		try
		{
			sala_privada.QuitaPaciente("401234321");
			fail("No deberia quitar si la sala estaba vacia.");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
}
