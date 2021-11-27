package testPatio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.PacienteFactory;
import modelo.Paciente;
import modelo.Patio;

public class TestAgregarPacienteEscenario2 {
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
	public void casoDePruebaAgregaPacienteConEsePaciente() {
		if (Patio.getInstance().listaPacientes().containsKey(this.paciente.getDni())) {
			String nombre = this.paciente.getNombre();
			this.paciente.setNombre("NombreNuevo");
			Patio.getInstance().AgregaPaciente(this.paciente);
			assertFalse("Error: Se agrego un paciente que ya estaba cargado",Patio.getInstance().listaPacientes().containsKey(nombre));
        }
		assertTrue("El paciente no fue agregado correctamente",Patio.getInstance().listaPacientes().containsKey(this.paciente.getDni()));
	}
	
	@Test
	public void casoDePruebaAgregaPacienteSinEsePaciente() {
		Paciente diferente = PacienteFactory.getPaciente("Juana","Pera","12324325","Calle2","CABAL","01112349874","Joven");
		Patio.getInstance().AgregaPaciente(diferente);
		assertTrue("El paciente no fue agregado correctamente",Patio.getInstance().listaPacientes().containsKey(diferente.getDni()));
	}
	

}
