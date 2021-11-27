package testPacienteFactory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import factory.PacienteFactory;
import modelo.Paciente;



public class GetPacienteTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPacienteNinio() {
		Paciente nuevo=null;
		nuevo=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
		assertTrue("El Nombre del Paciente creado no es correcto",nuevo.getNombre().equals("Juan Perez"));
		assertTrue("El Dni del Paciente creado no es correcto",nuevo.getDni().equals("12324324")); 
		assertTrue("El domicilio del Paciente creado no es correcto",nuevo.getDomicilio().equals("Calle1")); 
		assertTrue("La ciudad del Paciente creado no es correcta",nuevo.getCiudad().equals("CABA")); 
		assertTrue("El telefono del Paciente creado no es correcto",nuevo.getTelefono().equals("01112349873")); 
		assertTrue("Paciente creado no es un Ninio",nuevo.getClass().getName().equals("modelo.Ninio")); 
	}
	
	@Test
	public void testGetPacienteJoven() {
		Paciente nuevo=null;
		nuevo=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Joven");
		assertTrue("El Nombre del Paciente creado no es correcto",nuevo.getNombre().equals("Juan Perez"));
		assertTrue("El Dni del Paciente creado no es correcto",nuevo.getDni().equals("12324324")); 
		assertTrue("El domicilio del Paciente creado no es correcto",nuevo.getDomicilio().equals("Calle1")); 
		assertTrue("La ciudad del Paciente creado no es correcta",nuevo.getCiudad().equals("CABA")); 
		assertTrue("El telefono del Paciente creado no es correcto",nuevo.getTelefono().equals("01112349873")); 
		assertTrue("Paciente creado no es un Ninio",nuevo.getClass().getName().equals("modelo.Joven")); 
	}

	@Test
	public void testGetPacienteMayor() {
		Paciente nuevo=null;
		nuevo=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Mayor");
		assertTrue("El Nombre del Paciente creado no es correcto",nuevo.getNombre().equals("Juan Perez"));
		assertTrue("El Dni del Paciente creado no es correcto",nuevo.getDni().equals("12324324")); 
		assertTrue("El domicilio del Paciente creado no es correcto",nuevo.getDomicilio().equals("Calle1")); 
		assertTrue("La ciudad del Paciente creado no es correcta",nuevo.getCiudad().equals("CABA")); 
		assertTrue("El telefono del Paciente creado no es correcto",nuevo.getTelefono().equals("01112349873")); 
		assertTrue("Paciente creado no es un Ninio",nuevo.getClass().getName().equals("modelo.Mayor")); 
	}	
	
	@Test
	public void testGetPacienteCadenaVacias() {
		try {
			PacienteFactory.getPaciente("","","","","","","Mayor");
			fail("No se lanzo ninguna excepción, se debería haber lanzado alguna excepcion que informe que los parametros estan incompletos");
		}catch(Exception e) {
			System.out.println("Se lanzo una excepción como se esperaba");
		} 
	}
	
	@Test
	public void testGetPacienteParametrosNull() {
		try {
			PacienteFactory.getPaciente(null,null,null,null,null,null,"Mayor");
			fail("No se lanzo ninguna excepción, se debería haber lanzado alguna excepcion que informe que los parametros son nulos");
		}catch(Exception e) {
			System.out.println("Se lanzo una excepción como se esperaba");
		} 
	}
	
	@Test
	public void testGetPacienteNumerosNegativo() { // Que deberían ser positivos como dni o numero de telefono
		try {
			PacienteFactory.getPaciente("Juan","Perez","-489","Calle1","CABA","-4987995","Mayor");
			fail("No se lanzo ninguna excepción, se debería haber lanzado alguna excepcion que informe que los parametros son incorrectos");
		}catch(Exception e) {
			System.out.println("Se lanzo una excepción como se esperaba");
		} 
	}
	
	@Test
	public void testGetPacienteCaracteresDiferetesDeNumeros() { // Cuando en lugar de un numero se ingresa una letra o un caracter diferente de numero
		try {
			PacienteFactory.getPaciente("Juan","Perez","dni=12324324","Calle1","CABA","tel=01112349873","Mayor");
			fail("No se lanzo ninguna excepción, se debería haber lanzado alguna excepcion que informe que el formato de los parametros son incorrectos");
		}catch(Exception e) {
			System.out.println("Se lanzo una excepción como se esperaba");
		} 
	}
}
