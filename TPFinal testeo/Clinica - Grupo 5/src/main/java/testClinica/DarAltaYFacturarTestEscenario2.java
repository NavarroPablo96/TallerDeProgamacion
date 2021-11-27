package testClinica;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import excepciones.PacienteNoEncontradoExcepcion;
import factory.MedicoFactory;
import factory.PacienteFactory;
import interf.IMedico;
import modelo.Clinica;
import modelo.HistoriaClinica;
import modelo.Paciente;
import modelo.Prestacion;

public class DarAltaYFacturarTestEscenario2 {
	HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
	Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");
	
	
	@Before
	public void setUp() throws Exception {
		//Primero creamos un médico:
		IMedico nuevo=null;
		try {
			nuevo = MedicoFactory.getMedico("Rene","Favaloro","12324324","Calle1","CABA", "011-12349873", 5000, "pediatra", null, "RESIDENTE");
		} catch (NoHayEspecialidadException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoHayContratacionException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoExistePosgradoException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoExisteContratacionException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		} catch (NoExisteEspecialidadException e1) {
			fail("Esto no se deberia ejecutar");
			//e1.printStackTrace();
		}
		//Ahora creaoms una prestación:
		Prestacion prestacion = new Prestacion(nuevo, 2);
		
		Clinica.getInstance().agregaPrestacion(prestacion, this.p.getNombre(), this.p.getApellido(), this.p.getDni());
		
		this.atencion.put(this.p.getDni(), this.p);
		Clinica.getInstance().setAtencion(this.atencion);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setAtencion(new HashMap<String, Paciente>());
	}

	@Test
	public void casoDePruebaConEsePacienteE2Test() {
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(1990, 11, 5);
		try {
			Clinica.getInstance().darAltaYFacturar(this.p, fecha1);
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se deberia ejecutar");
		}
		assertFalse("Fallo: El paciente ya no deberia estar en el HashMap de atencion.", Clinica.getInstance().getAtencion().containsKey(this.p));
	}
	
	@Test
	public void casoDePruebaSinEsePacienteE2Test() {
		Paciente p2 = PacienteFactory.getPaciente("Jorge", "Rial", "22222222", "Constitucion 101", "Mar del plata", "34", "Joven");
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(1990, 11, 5);
		try {
			Clinica.getInstance().darAltaYFacturar(p2, fecha1);
			fail("Esto no se deberia ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, PacienteNoEncontradoException");
		}
	}

}
