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
import modelo.Factura;
import modelo.Paciente;
import modelo.Prestacion;

public class TestMuestraPrestacionMedicoEscenario2 {
	private ArrayList<Prestacion> auxPrestaciones=null;
	private Factura auxFactura;
	private IMedico medico;
	private Prestacion prestacion;
	
	private void creaIMedicoeYPrestacion() {
		this.medico=null;
		try {
			this.medico = MedicoFactory.getMedico("Rene", "Favaloro", "12324324", "Calle1","CABA", "011-12349873", 5000,"Clinico", null, "Plantel Permanente");
		} catch (NoHayEspecialidadException | NoHayContratacionException | NoExistePosgradoException
				| NoExisteContratacionException | NoExisteEspecialidadException e) {
			fail("No se debería lanzar esta excepción");
		}
		this.prestacion=  new Prestacion(this.medico, 2);
	}
	
	@Before
	public void setUp() throws Exception {
		//Escenario 2, la coleccion de pretaciones tiene al menos una prestación
		creaIMedicoeYPrestacion();
		this.auxPrestaciones=new ArrayList<>();
		//se agrega una prestación al arraylist
		this.auxPrestaciones.add(this.prestacion);
		
		Paciente p = PacienteFactory.getPaciente("Juan","Perez","12324324","Calle1","CABA","01112349873","Ninio");
		this.auxFactura=new Factura(new GregorianCalendar(),p);
		//se setea el arrayList de prestaciones en la factura
		this.auxFactura.setPrestaciones(this.auxPrestaciones);
		
	}

	@After
	public void tearDown() throws Exception {
		this.auxFactura=null;
		this.auxPrestaciones=null;
		this.medico=null;
		this.prestacion=null;
	}

	@Test
	public void test() {
		auxFactura.muestraPrestacionMedico(this.medico);
	}

}
