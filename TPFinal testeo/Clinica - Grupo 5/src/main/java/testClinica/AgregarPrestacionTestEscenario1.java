package testClinica;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.*;
import factory.*;
import interf.*;
import modelo.*;

public class AgregarPrestacionTestEscenario1 {
	HashMap<String, HistoriaClinica> hc = new HashMap<String, HistoriaClinica>();

	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setHistoriaClinicaHashMap(this.hc);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setHistoriaClinicaHashMap(new HashMap<String, HistoriaClinica>());
	}

	@Test
	public void test() {
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
		Prestacion p = new Prestacion(nuevo, 2);
		
		Clinica.getInstance().agregaPrestacion(p, "Jorge", "Rial", "55555");
		
		//Como la documentación del método es inexistente, se testeó viendo el código y se ingresó el DNI a mano.
		assertTrue("Fallo: no se agrego la prestacion",Clinica.getInstance().getHistoriaClinicaHashMap().containsKey("55555"));
	}

}
