package testMedicoFactory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import factory.MedicoFactory;
import interf.IMedico;

public class GetMedicoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetPediatraDoctorResidente() {
		IMedico nuevo=null;
		try {
			nuevo=MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Pediatra","Doctor","Residente");
			
		}catch(Exception e) {
			fail("No se debería lanzar esta excepción");
		}
		System.out.println(nuevo.toString());
		assertTrue("No se creo doctor correctamente",nuevo.toString().contains("doctor"));
		assertTrue("No se creo Pediatra correctamente",nuevo.toString().contains("Pediatra")); 
		assertTrue("No se creo un residente correctamente",nuevo.toString().contains("residente")); 
		assertTrue("El Dni del IMedico creado no es correcto",nuevo.getDni().equals("12324324")); 
		assertTrue("El Nombre del IMedico creado no es correcto",nuevo.getNombre().equals("Rene Favaloro")); 
		assertTrue("El domicilio del IMedico creado no es correcto",nuevo.toString().contains("Calle1")); 
		assertTrue("El telefono del IMedico creado no es correcto",nuevo.toString().contains("01112349873")); 
		
	}
	
	@Test
	public void testgetClinicoSinPosgradoConPlantelPermanente() {
		IMedico nuevo=null;
		try {
			nuevo=MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Clinico",null,"Plantel Permanente");
			
		}catch(Exception e) {
			fail("No se debería lanzar esta excepción");
		} 
		System.out.println(nuevo.toString());
		assertTrue("No se creo Sin Posgrado correctamente",!nuevo.toString().contains("doctor") || !nuevo.toString().contains("magister"));
		assertTrue("No se creo Pediatra correctamente",nuevo.toString().contains("Clinico")); 
		assertTrue("No se creo un plantel permanente correctamente",nuevo.toString().contains("plantel permanente")); 
		assertTrue("El Dni del IMedico creado no es correcto",nuevo.getDni().equals("12324324")); 
		assertTrue("El Nombre del IMedico creado no es correcto",nuevo.getNombre().equals("Rene Favaloro")); 
		assertTrue("El domicilio del IMedico creado no es correcto",nuevo.toString().contains("Calle1")); 
		assertTrue("El telefono del IMedico creado no es correcto",nuevo.toString().contains("01112349873")); 
	}
	
	@Test
	public void testgetCirujanoMagisterConPlantelPermanente() {
		IMedico nuevo=null;
		try {
			nuevo=MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Cirujano","magister","Plantel Permanente");
			
		}catch(Exception e) {
			fail("No se debería lanzar esta excepción");
		} 
		System.out.println(nuevo.toString());
		assertTrue("No se creo magister correctamente",nuevo.toString().contains("magister"));
		assertTrue("No se creo Cirujano correctamente",nuevo.toString().contains("Cirujano")); 
		assertTrue("No se creo un plantel permanente correctamente",nuevo.toString().contains("plantel permanente")); 
		assertTrue("El Dni del IMedico creado no es correcto",nuevo.getDni().equals("12324324")); 
		assertTrue("El Nombre del IMedico creado no es correcto",nuevo.getNombre().equals("Rene Favaloro")); 
		assertTrue("El domicilio del IMedico creado no es correcto",nuevo.toString().contains("Calle1")); 
		assertTrue("El telefono del IMedico creado no es correcto",nuevo.toString().contains("01112349873")); 
	}
	
	@Test
	public void testgetMedicoNoHayEspecialidadException() {

		try {
			MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,null,null,"Plantel Permanente");
			fail("No se lanzo ninguna excepción, se debería haber lanzado NoHayEspecialidadException");
		} catch (NoHayContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExistePosgradoException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		}catch (NoHayEspecialidadException e) {
			System.out.println("Se lanzo la excepción que se esperaba, NoHayEspecialidadException");
		}
	}
	
	@Test
	public void testgetMedicoNoHayContratacionException() {
		try {
			MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Clinico",null,null);
			fail("No se lanzo ninguna excepción, se debería haber lanzado NoHayContratacionException");
		} catch (NoHayEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExistePosgradoException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		}catch (NoHayContratacionException e) {
			System.out.println("Se lanzo la excepción que se esperaba, NoHayContratacionException");
		}
	}
	
	@Test
	public void testgetMedicoNoExisteEspecialidadException() {
		try {
			MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Dentista",null,"Plantel Permanente");
			fail("No se lanzo ninguna excepción, se debería haber lanzado NoExisteEspecialidadException");
		} catch (NoHayEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoHayContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExistePosgradoException e) {
			fail("No se debería lanzar esta excepción");
		}catch (NoExisteEspecialidadException e) {
			System.out.println("Se lanzo la excepción que se esperaba, NoExisteEspecialidadException");
		}
	}
	
	@Test
	public void testgetMedicoNoExisteContratacionException() {
		try {
			MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Clinico",null,"Temporal");
			fail("No se lanzo ninguna excepción, se debería haber lanzado NoExisteContratacionException");
		} catch (NoHayEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoHayContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExistePosgradoException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		}catch (NoExisteContratacionException e) {
			System.out.println("Se lanzo la excepción que se esperaba, NoExisteContratacionException");
		}
	}
	
	@Test
	public void testgetMedicoNoExistePosgradoException() {
		try {
			MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA","01112349873",5000,"Clinico","aaaaaaa","Plantel Permanente");
			fail("No se lanzo ninguna excepción, se debería haber lanzado NoExistePosgradoException");
		} catch (NoHayEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoHayContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		}catch (NoExistePosgradoException e) {
			System.out.println("Se lanzo la excepción que se esperaba, NoExistePosgradoException");
		}
	}
	
	@Test
	public void testgetMedicoParametrosCadenaVacias() {
		try {
			MedicoFactory.getMedico("","","12324324","","","01112349873",5000,"Cirujano","magister","Plantel Permanente");
			fail("No se lanzo ninguna excepción, se debería haber lanzado alguna excepcion que informe que los parametros estan incompletos");
		}catch(Exception e) {
			System.out.println("Se lanzo una excepción como se esperaba");
		} 
	}
	
	@Test
	public void testgetMedicoParametrosNull() {
		try {
			MedicoFactory.getMedico(null,null,"12324324",null,null,"01112349873",5000,"Cirujano","magister","Plantel Permanente");
			fail("No se lanzo ninguna excepción, se debería haber lanzado alguna excepcion que informe que los parametros son nulos");
		}catch(Exception e) {
			System.out.println("Se lanzo una excepción como se esperaba");
		} 
	}
}
