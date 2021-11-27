package testPatio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.PacienteNoEncontradoExcepcion;
import factory.PacienteFactory;
import modelo.Paciente;
import modelo.Patio;

public class QuitaPacienteTestEscenario2 {
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
	public void CasoDePruebaSinEsePacienteE2Test() {
		Paciente diferente = PacienteFactory.getPaciente("Juana","Pera","12324325","Calle2","CABAL","01112349874","Joven");
		
		try {
			Patio.getInstance().QuitaPaciente(diferente.getDni());
			fail("Esto no se debería ejecutar");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("Se lanzo la excepcion que se esparaba PacienteNoEncontradoExcepcion");
		}
	}
	
	@Test
	public void CasoDePruebaConEsePacienteE2Test() {
		
		try {
			Patio.getInstance().QuitaPaciente(this.paciente.getDni());
			System.out.println("Se Quito el paciente correctamente");
		} catch (PacienteNoEncontradoExcepcion e) {
			fail("Esto no se debería ejecutar");
		}
	}
}
