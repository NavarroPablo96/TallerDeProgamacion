package testClinica;

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
import interf.IMedico;
import modelo.Clinica;
import modelo.Factura;

public class ReporteActividadMedicaTestEscenario1 {
	ArrayList<Factura> facturas = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		Clinica.getInstance().setFacturas(this.facturas);
	}

	@After
	public void tearDown() throws Exception {
		Clinica.getInstance().setFacturas(new ArrayList<>());
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
		
		//Ahora creo ambas fechas:
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(1990, 11, 5);
		GregorianCalendar fecha2 = new GregorianCalendar();
		fecha1.set(1991, 11, 5);
		
		Clinica.getInstance().reporteActividadMedica(nuevo, fecha1, fecha2);
		
	}

}
