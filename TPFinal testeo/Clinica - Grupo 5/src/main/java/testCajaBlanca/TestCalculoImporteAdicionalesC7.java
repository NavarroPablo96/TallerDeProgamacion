package testClinica;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class TestCalculoImporteAdicionalesC7 {

	@Before
	public void setUp() throws Exception {
		Paciente paciente = PacienteFactory.getPaciente("El","Maestruli","46521535","Jerusalen 4525","Mar del Plata","54875515","Mayor");
		IMedico medico1 = MedicoFactory.getMedico("Armando", "Paredes", "4851235", "Arenales 5123", "MAr del Plata","4851351" , 2500, "Cirujano", "Magister", "Plantel Permanente");
		IMedico medico2 = MedicoFactory.getMedico("Rodrigo", "Palacios", "8462135", "Aroz 523", "MAr del Plata","83134542" , 1500, "Pediatra", "Doctor", "Residente");
	
		Prestacion p1 = new Prestacion(medico1,2);
		Prestacion p2 = new Prestacion(medico2,1);
		
		ArrayList<Prestacion> prestaciones = new ArrayList<Prestacion>();
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		
		prestaciones.add(p1);
		prestaciones.add(p2);
		
		GregorianCalendar fechaMock = mock(GregorianCalendar.class);		
		
		when(fechaMock.get(Calendar.DATE)).thenReturn(0);
				
		Factura factura = new Factura(fechaMock, paciente, prestaciones);
		
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
	public void testC2() {
		int numeroDeFactura = 1;
		
		GregorianCalendar fechaDeSolicitud = new GregorianCalendar();
		fechaDeSolicitud.set(1970, 0, 1); //el Date del mock es por defecto (1/1/1970) por lo tanto esta fecha de solicitud debe estar situada dentro de los 10 dias posteriores
		
		ArrayList<Double> listaDeInsumos = new ArrayList<Double>();
		listaDeInsumos.add(2.0);
		listaDeInsumos.add(3.5);
		
		Clinica.getInstance().calculoImporteAdicionales(1, fechaDeSolicitud, listaDeInsumos);
		
		
		
	}

}
