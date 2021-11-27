package testPersistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import factory.MedicoFactory;
import interf.IMedico;
import modelo.Clinica;
import persistencia.CargaYDescarga;

public class CargaYDescargaTest
{
	Clinica clinica;
	
	
	@Before
	public void setUp() {
		clinica = Clinica.getInstance();
		
		File archivo = new File("Medicos.bin");
		if(archivo.exists())
			archivo.delete();
	}
	
	@After
	public void tearDown() {
		
	}
	
	
	/**
	 * Se testea que se cree el archivo medicos.bin
	 */
	@Test
	public void test_CrearArchivo() {		
		CargaYDescarga carga = new CargaYDescarga();
		
		carga.guardarMedicos();
		File archivo = new File("Medicos.bin");
		assertTrue("Fail: Se tuvo que crear el archivo Medicos.bin", archivo.exists());
	}
	
	/**
	 * Se testea persistir una coleccion vacia de medicos y luego
	 * despersistir verificando que ambas sigan siendo vacias.
	 */
	@Test
	public void test_LectoEscrituraE1() {
		CargaYDescarga carga = new CargaYDescarga();
		HashMap<String, IMedico> medicos_pers = clinica.getMedicos();
		HashMap<String, IMedico> medicos_desp;
		
		carga.guardarMedicos(); 
		carga.leerDatos();
		
		medicos_desp = clinica.getMedicos();
		
		assertEquals(medicos_pers, medicos_desp);
	}
	
	/**
	 * Se testea persistir una coleccion con medicos y luego
	 * despersistir verificando que ambas sigan teniendo los mismo medicos.
	 */
	@Test
	public void test_LectoEscrituraE2() {
		this.setUpE2();
		
		CargaYDescarga carga = new CargaYDescarga();
		HashMap<String, IMedico> medicos_desp;
		
		carga.guardarMedicos();
		//Si no guardo me pisa la coleccion cuando se despersiste 
		HashMap<String, IMedico> medicos_pers = clinica.getMedicos();
		
		carga.leerDatos(); 
		medicos_desp = clinica.getMedicos();
				
		assertEquals("Deberian tener el mismo tamaño", medicos_pers.size(), medicos_desp.size());
		
		boolean iguales = true;
		Iterator<String> it = medicos_pers.keySet().iterator();
		while(it.hasNext() && iguales) {
			if(!medicos_desp.containsKey(it.next())) {
				iguales = false;
				fail("Las colecciones son distintas");
			}	
		}
	}
	
	/**
	 * No se puede verificar que se rompa por que no arroja excepcion.
	 */
	@Test
	public void test_SinArchivo() {
	}
	
	/**
	 * Se encarga de cargar la coleccion de medicos.
	 */
	public void setUpE2() {
		
		try
		{
			clinica.agregarMedico(MedicoFactory.getMedico("Jorge", "Reynoso", "12345678", "domicilio1", "Mar del Plata",
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
	
}
