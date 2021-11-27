package testPatio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Paciente;
import modelo.Patio;

public class MuestraPacienteTestEscenario2 {
	Paciente paciente=PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
	
	@Before
	public void setUp() throws Exception {
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
		Patio.getInstance().muestraPacientes();
		System.out.println("Deber�a haberse mostrado el paciente:"+paciente.toString());
	}

}
