package testPatio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.*;

public class ListaPacienteTestEscenario1 {

	@Before
	public void setUp() throws Exception {
		Patio.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		HashMap<String,Paciente>Copia = Patio.getInstance().listaPacientes();
		assertFalse("El HashMap es null y no deber�a serlo",Copia==null);
		assertTrue("El HashMap deber�a estar vacio y no lo est�",Copia.size()==0);
	}

}
