package testClinica;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.MedicoNoEncontradoException;
import excepciones.PacienteNoEncontradoExcepcion;
import interf.IMedico;
import modelo.Clinica;
import modelo.Paciente;

public class DevuelveMedicoTestEscenario1 {
	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	
	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setMedicos(this.medicos);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setMedicos(new HashMap<String, IMedico>());
	}

	@Test
	public void test() {
		IMedico m = null;
		try {
			m = Clinica.getInstance().devuelveMedico("55555");
			fail("Esto no se debería ejecutar.");
		} catch (MedicoNoEncontradoException e) {
			System.out.println("Se lanzo la excepci�n que se esperaba, MedicoNoEncontradoException");
		}
	}

}
