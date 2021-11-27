package testClinica;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MismoDniExcepcion;
import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Clinica;
import modelo.Joven;
import modelo.Paciente;

public class removerPacienteTestE2
{	
	Clinica clinica;
	
	@Before
	public void setUp() {
		clinica = clinica.getInstance();
		
		Paciente paciente = new Joven("Carlos", "Menem", "46543218", "Calle1", "Mard", "1234");
		Paciente paciente2 = new Joven("Paola", "Menem", "41545218", "Calle2", "Mard", "123452");
		
		try
		{
			clinica.altaPaciente(paciente);
		} catch (MismoDniExcepcion e)
		{
            fail("No puede lanzar MismoDniExcepcion");  
			e.printStackTrace();
		}
		
		try
		{
			clinica.altaPaciente(paciente2);
		} catch (MismoDniExcepcion e)
		{
			fail("No puede lanzar MismoDniExcepcion");
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		HashMap<String, Paciente> pacientes_vacio = new HashMap<String, Paciente>();
		clinica.setPacientes(pacientes_vacio);		
	}
	
	/**
	 * Se testea que se pueda quitar un paciente con dni valido que este en la coleccion.
	 */
	@Test
	public void test_pacienteValidoEnSala(){
		try
		{
			clinica.removerPaciente("46543218");
			//Verifico que se haya realmente removido de la coleccion
			assertFalse(clinica.getPacientes().containsKey("46543218"));
		} catch (PacienteNoEncontradoExcepcion e)
		{	
			fail("No debe lanzar PacienteNoEncontradoExcepcion");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni valido pero que no se encuentra entre los pacientes.
	 */
	@Test
	public void test_dniValidoNoEnSala() {
		try
		{
			clinica.removerPaciente("46543219");
			fail("No deberia quitar un dni invalido");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testea que arroje PacienteNoEncontradoExcepcion al querer quitar
	 * un paciente con dni valido pero que no se encuentra entre los pacientes.
	 */
	@Test
	public void test_dniFueraDeRango() {
		try
		{
			clinica.removerPaciente("46543219345");
			fail("No deberia quitar un dni invalido");
		} catch (PacienteNoEncontradoExcepcion e)
		{
			e.printStackTrace();
		}
	}
}

