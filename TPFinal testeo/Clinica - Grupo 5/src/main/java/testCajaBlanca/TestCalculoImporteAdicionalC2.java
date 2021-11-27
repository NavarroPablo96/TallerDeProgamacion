package testClinica;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.MedicoFactory;
import factory.PacienteFactory;
import interf.IMedico;
import modelo.Clinica;
import modelo.Factura;
import modelo.Paciente;
import modelo.Prestacion;

public class TestCalculoImporteAdicionalC2 {

	@Before
	public void setUp() throws Exception {
		
		GregorianCalendar fecha = new GregorianCalendar();
		
		fecha.set(2021, 0, 1);
		
		Paciente paciente = PacienteFactory.getPaciente("El","Maestruli","46521535","Jerusalen 4525","Mar del Plata","54875515","Joven");
		IMedico medico1 = MedicoFactory.getMedico("Armando", "Paredes", "4851235", "Arenales 5123", "MAr del Plata","4851351" , 2500, "Cirujano", "Magister", "Plantel Permanente");
		IMedico medico2 = MedicoFactory.getMedico("Rodrigo", "Palacios", "8462135", "Aroz 523", "MAr del Plata","83134542" , 1500, "Pediatra", "Doctor", "Residente");
		GregorianCalendar fechaFactura = new GregorianCalendar();
		
		fechaFactura.set(2021, 0, 1);
		
		Prestacion p1 = new Prestacion(medico1,2);
		Prestacion p2 = new Prestacion(medico2,1);
		
		ArrayList<Prestacion> prestaciones = new ArrayList<Prestacion>();
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		prestaciones.add(p1);
		prestaciones.add(p2);
		
		Factura factura = new Factura(fechaFactura, paciente, prestaciones);
		
		facturas.add(factura);
		
		Clinica.getInstance().setFacturas(facturas);
			
	}

	@After
	public void tearDown() throws Exception {
		Factura.setCantFacturas(0);
		ArrayList<Factura>facturasVacia = new ArrayList<Factura>();
		
		Clinica.getInstance().setFacturas(facturasVacia);
	}

	@Test
	public void test() {
		GregorianCalendar fechaSolicitud = new GregorianCalendar();
		ArrayList<Double> insumos = new ArrayList<Double>();
		
		fechaSolicitud.set(2021, 8, 25);
		System.out.println(insumos.size());
		Clinica.getInstance().calculoImporteAdicionales(1 , fechaSolicitud, insumos);
	}

}
