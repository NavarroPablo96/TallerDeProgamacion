package testFactura;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import factory.MedicoFactory;
import factory.PacienteFactory;
import interf.IMedico;
import modelo.*;

public class TestMuestraPrestracionMedicoEscenario1 {
	private ArrayList<Prestacion> auxPrestaciones=null;
	private Factura auxFactura;
	
	@Before
	public void setUp() throws Exception {
		//Escenario 1, la coleccion de pretaciones está vacia
		this.auxPrestaciones=new ArrayList<>();
		Paciente p = PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
		this.auxFactura=new Factura(new GregorianCalendar(),p);
		this.auxFactura.setPrestaciones(this.auxPrestaciones);
	}

	@After
	public void tearDown() throws Exception {
		this.auxFactura=null;
		this.auxPrestaciones=null;
	}

	@Test
	public void TestMuestraPrestacionSinPrestaciones() {
		IMedico medico=null;
		try {
			medico = MedicoFactory.getMedico("Rene", "Favaloro", "12324324", "Calle1","CABA", "011-12349873", 5000,"Clinico", null, "Plantel Permanente");
		} catch (NoHayEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoHayContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExistePosgradoException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteContratacionException e) {
			fail("No se debería lanzar esta excepción");
		} catch (NoExisteEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		}
		double totalFactura= auxFactura.muestraPrestacionMedico(medico);
		assertTrue("El costo total de la factura debería ser 0, dado que no teiene prestaciones",totalFactura==0);
	}

}
