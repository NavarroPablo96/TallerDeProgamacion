package testClinica;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MedicoNoEncontradoException;
import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import factory.MedicoFactory;
import interf.IMedico;
import modelo.Clinica;

public class removerMedicoTestE2
{	
	Clinica clinica;
	
	@Before
	public void setUp() {
		clinica = clinica.getInstance();
	
		try
		{
			clinica.agregarMedico(MedicoFactory.getMedico("Jorge", "Reynoso", "46543218", "domicilio1", "Mar del Plata",
					"223-5523487", 5000, "clinico", null, "residente"));
		} catch (NoHayEspecialidadException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoHayEspecialidadException");
		} catch (NoHayContratacionException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoHayContratacionException");
		} catch (NoExistePosgradoException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoHayPostgradoException");
		} catch (NoExisteContratacionException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoExisteContratacionException ");
		} catch (NoExisteEspecialidadException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoExisteEspecialidadException");

		} catch (MismoDniExcepcion e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar MismoDniExcepcion");
		}
		
		
		try
		{
			clinica.agregarMedico(MedicoFactory.getMedico("Marisa", "Gutierrez", "1465278", "domicilio2", "Mar del Plata",
					"223-64521324", 10000, "cirujano", "doctor", "plantel permanente"));
		} catch (NoHayEspecialidadException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoHayEspecialidadException");
		} catch (NoHayContratacionException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoHayContratacionException");
		} catch (NoExistePosgradoException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoHayPostgradoException");
		} catch (NoExisteContratacionException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoExisteContratacionException ");
		} catch (NoExisteEspecialidadException e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar NoExisteEspecialidadException");

		} catch (MismoDniExcepcion e)
		{
			e.printStackTrace();
			fail("No tiene que lanzar MismoDniExcepcion");
		}
	}
	
	@After
	public void tearDown() {
		HashMap<String, IMedico> medicos_vacio = new HashMap<String, IMedico>();
		clinica.setMedicos(medicos_vacio);		
	}
	
	/**
	 * Se testea que se pueda quitar un medico con dni valido que este en la coleccion.
	 */
	@Test
	public void test_pacienteValidoEnSala(){
		try
		{
			clinica.removerMedico("46543218");
			//Verifico que se haya realmente removido de la coleccion
			assertFalse(clinica.getMedicos().containsKey("46543218"));
			
		} catch (MedicoNoEncontradoException e)
		{	
			fail("No debe lanzar MedicoNoEncontradoExcepcion");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Testea que arroje MedicoNoEncontradoExcepcion al querer quitar
	 * un medico con dni valido pero que no se encuentra entre los medicos.
	 */
	@Test
	public void test_dniValidoNoEnSala() {
		try
		{
			clinica.removerMedico("46543219");
			fail("No deberia quitar un dni invalido");
		} catch (MedicoNoEncontradoException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testea que arroje MedicoNoEncontradoExcepcion al querer quitar
	 * un medico con dni fuera de rango en una coleccion con medicos.
	 */
	@Test
	public void test_dniFueraDeRango() {
		try
		{
			clinica.removerMedico("46543219345");
			fail("No deberia quitar un dni invalido");
		} catch (MedicoNoEncontradoException e)
		{
			e.printStackTrace();
		}
	}
}

