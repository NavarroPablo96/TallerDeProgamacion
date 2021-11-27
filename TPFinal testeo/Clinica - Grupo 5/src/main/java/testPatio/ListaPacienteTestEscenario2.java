package testPatio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Paciente;
import modelo.Patio;

public class ListaPacienteTestEscenario2 {
	Paciente paciente=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
	HashMap<String,Paciente> Original;
	@Before
	public void setUp() throws Exception {
		Original=new HashMap<String,Paciente>();
		Original.put(this.paciente.getDni(),this.paciente);
		Patio.getInstance().AgregaPaciente(this.paciente);
	}

	@After
	public void tearDown() throws Exception {
		for (Paciente i : Patio.getInstance().listaPacientes().values()) {
            Patio.getInstance().QuitaPaciente(i.getDni());
        }
	}

	@Test
	public void test() {
		HashMap<String,Paciente>Copia = Patio.getInstance().listaPacientes();
		assertFalse("El HashMap es null y no debería serlo",Copia==null);
		assertTrue("El HashMap retornado por el metodo debería tener la misma cantidad de elemento que el original antes de ejecutar",Copia.size()==this.Original.size());
	}

}
