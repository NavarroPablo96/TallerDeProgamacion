package testClinica;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;

public class DarAltaYFacturarTestEscenario1 {
	HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
	
	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setAtencion(this.atencion);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setAtencion(new HashMap<String, Paciente>());
	}

	@Test
	public void test() {
		Paciente p = PacienteFactory.getPaciente("Marta", "Lopez", "11111111", "Constitucion 100", "Mar del plata", "34", "Joven");
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(1990, 11, 5);
		try {
			Clinica.getInstance().darAltaYFacturar(p, fecha1);
			fail("Esto no se deberia ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, PacienteNoEncontradoException");
		}
	}

}
