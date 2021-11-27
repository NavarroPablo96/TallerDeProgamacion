package testCajaBlanca;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Clinica;
import modelo.Factura;

public class TestCalculoImporteAdionalesC1 {

	@Before
	public void setUp() throws Exception {
		
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		Clinica.getInstance().setFacturas(facturas);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		
		ArrayList<Double> insumos = new ArrayList<Double>();
		GregorianCalendar fechaSolicitud = new GregorianCalendar();
		
		fechaSolicitud.set(2021, 1, 1);
		
		Clinica.getInstance().calculoImporteAdicionales(1, fechaSolicitud, insumos);
	}

}
