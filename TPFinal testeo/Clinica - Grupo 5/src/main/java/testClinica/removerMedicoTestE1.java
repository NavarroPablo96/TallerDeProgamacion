package testClinica;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MedicoNoEncontradoException;
import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Clinica;

public class removerMedicoTestE1
{
	private Clinica clinica; 
	
	
	/**
	 * Sala medicos vacia.
	 */
	@Before
	public void setUp() {
		clinica = Clinica.getInstance();
	}
	
	@After
	public void tearDown() {
		
	}
	
	/**
	 * Testea que arroje MedicoNoEncontradoExcepcion al querer quitar
	 * un medico con dni valido de una coleccion vacia.
	 */
	@Test
	public void  test_dnivalido() {
		try
		{
			clinica.removerMedico("45652168");
			fail("No deberia quitar si la sala estaba vacia.");
		} catch (MedicoNoEncontradoException e)
		{
			e.printStackTrace();
		}
	}
		
	/**
	 * Testea que arroje MedicoNoEncontradoExcepcion al querer quitar
	 * un medico con dni fuera de rango de una coleccion vacia.
	 */
	@Test
	public void test_dniFueraDeRango() {
		try
		{
			clinica.removerMedico("45234235235");
			fail("No deberia quitar si la sala estaba vacia.");
		} catch (MedicoNoEncontradoException e)
		{
			e.printStackTrace();
		}
	}
}


