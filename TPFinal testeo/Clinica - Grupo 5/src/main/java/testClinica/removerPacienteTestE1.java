package testClinica;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Clinica;

public class removerPacienteTestE1
{
	private Clinica clinica; 
	
	
	/**
	 * Sala pacientes vacia.
	 */
	@Before
	public void setUp() {
		clinica = Clinica.getInstance();
	}
	
	@After
	public void tearDown() {
		
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni valido de una coleccion vacia.
	 */
	@Test
	public void  test_dnivalido() {
		try
		{
			clinica.removerPaciente("465543218");
			fail("No deberia quitar si la coleccion esta vacia.");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
		
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni fuera de rango de una coleccion vacia.
	 */
	@Test
	public void test_dniFueraDeRango() {
		try
		{
			clinica.removerPaciente("45234235235");
			fail("No deberia quitar si la sala estaba vacia.");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
}


