package testModelo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;

public class ClinicaTest
{
	public Clinica clinica; 
	
	/**
	 * Escenario con las colecciones vacias de clinica. 
	 */
	@Before
	public void setUp() {
		this.clinica = Clinica.getInstance(); 
	}
	
	
	@After
	public void tearDown() {
		this.clinica = null;
	}
	
	
	
}
