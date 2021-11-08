package pruebaConsola;

import excepciones.MedicoNoEncontradoException;
import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import excepciones.PacienteNoEncontradoExcepcion;
import java.util.GregorianCalendar;
import modelo.Clinica;
import modelo.Compartida;
import modelo.Habitacion;
import interf.IMedico;
import factory.MedicoFactory;
import modelo.Paciente;
import factory.PacienteFactory;
import modelo.Prestacion;
import modelo.Privada;
import modelo.Terapia_Intesiva;

public class Prueba {

	public static void main(String[] args) {
		Clinica unaClinica = Clinica.getInstance();
		unaClinica.setNombre("CLINICA BERAZATEGUI");

//----------------------------------------------------------------LOTE DE PRUEBA DE MEDICOS-------------------------------------------------------------------------------			
		try {
			unaClinica.agregarMedico(MedicoFactory.getMedico("Jorge", "Reynoso", "12345678", "domicilio1", "Mar del Plata",
					"223-5523487", 5000, "clinico", null, "residente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try {
			unaClinica.agregarMedico(MedicoFactory.getMedico("Marisa", "Gutierrez", "1465278", "domicilio2", "Mar del Plata",
					"223-64521324", 10000, "cirujano", "doctor", "plantel permanente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

		try {
			unaClinica.agregarMedico(MedicoFactory.getMedico("Miguel", "Patane", "98431800", "domicilio3", "Mar del Tuyu",
					"223-45456454", 1000, "pediatra", "magister", "residente"));
			System.out.println("Medico agregado con exito");
		} catch (NoHayEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (NoHayContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExistePosgradoException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage());
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage());
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un medico con el dni " + e.getDni());
		}

//------------------------------------------------------------------------------------------------------------------------------------------------------		

//---------------------------------------------------------LOTE DE PRUEBA DE PACIENTES--------------------------------------------------------------------------------------			
		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Nahuel", "Spatera", "1", "calle 123", "Mar de Ajo", "223-1251213", "joven"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Tomas", "Barrios", "2", "calle 123", "Mar del Plata", "223-5566687", "ninio"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Diego", "Maradona", "3", "calle 123", "Villa Fiorito", "223-6546682", "mayor"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}

		try {
			unaClinica.altaPaciente(
					PacienteFactory.getPaciente("Martin", "Gomez", "4", "calle 123", "Mar de las Pampas", "1234", "mayor"));
		} catch (MismoDniExcepcion e) {
			System.out.println("Ya existe un paciente con el mismo dni");
		}
//-----------------------------------------------------------------------------------------------------------------------------------------------			

//--------------------------------------------------------VERIFICA SI ESTAN LOS PACIENTES EN EL REGISTRO DE LA CLINICA---------------------------------------------------------------------------------------			
		try {
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("1"));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
		}

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		try {
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("2"));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
		}

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		try {
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("3"));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
		}

		try {
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("4"));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
		}
//-----------------------------------------------------------------------------------------------------------------------------------------------	

//------------------------------------------------MUESTRA COMO SE VAN ACTUALIZANDO EL PATIO Y LA SALA PRIVADA-----------------------------------------------------------------------------------------------
		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		unaClinica.muestraPacientesAtencion();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		unaClinica.muestraPacientesAtencion();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		unaClinica.muestraPacientesAtencion();
		System.out.println("///////////////");

		unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");

		unaClinica.atenderPaciente();
		System.out.println("///////////////");
//-----------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------AGREGA HABITACIONES-----------------------------------------------------------------------------------------------
		Habitacion h1 = new Compartida(1000);
		Habitacion h2 = new Privada(2000);
		Habitacion h3 = new Terapia_Intesiva(5000);

//-----------------------------------------------ASIGNA MEDICOS------------------------------------------------------------------------------------------------		
		IMedico m1, m2, m3;
		m1 = null;
		m2 = null;
		m3 = null;
		try {
			m1 = unaClinica.devuelveMedico("12345678");
		} catch (MedicoNoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			m2 = unaClinica.devuelveMedico("1465278");
		} catch (MedicoNoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			m3 = unaClinica.devuelveMedico("98431800");
		} catch (MedicoNoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//-----------------------------------------------------------------------------------------------------------------------------------------------		

		Paciente paciente1 = null, paciente2 = null, paciente3 = null;

		try {
			paciente1 = unaClinica.consultarPaciente("1");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("El paciente con dni " + e.getDni() + " no esta en el hospital ");
		}
		try {
			paciente2 = unaClinica.consultarPaciente("2");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("El paciente con dni " + e.getDni() + " no esta en el hospital ");
		}
		try {
			paciente3 = unaClinica.consultarPaciente("3");
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println("El paciente con dni " + e.getDni() + " no esta en el hospital ");
		}

//----------------------------------------------------LOTE DE PRUEBA PARA FACTURAR (en la 2da parte se leen a partir de interfaces graficas)----------------------------------------------------------------------------------------		
		Prestacion p1 = new Prestacion(m1, 3);
		Prestacion p2 = new Prestacion(m2, 7);
		Prestacion p3 = new Prestacion(m3, 1);
		Prestacion p4 = new Prestacion(m3, 5);
		Prestacion p5 = new Prestacion(m1, 10);

		Prestacion p6 = new Prestacion(h1, 20);
		Prestacion p7 = new Prestacion(h2, 13);
		Prestacion p8 = new Prestacion(h2, 3);
		Prestacion p9 = new Prestacion(h3, 5);
		Prestacion p10 = new Prestacion(h1, 4);

		unaClinica.agregaPrestacion(p1,paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());
		unaClinica.agregaPrestacion(p5,paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());
		unaClinica.agregaPrestacion(p9,paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());
		unaClinica.agregaPrestacion(p2,paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());


		unaClinica.agregaPrestacion(p10,paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(p1,paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(p4,paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(p8,paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(p6,paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());

		unaClinica.agregaPrestacion(p2,paciente3.getNombre(),paciente3.getApellido(),paciente3.getDni());
		unaClinica.agregaPrestacion(p5,paciente3.getNombre(),paciente3.getApellido(),paciente3.getDni());
		unaClinica.agregaPrestacion(p1,paciente3.getNombre(),paciente3.getApellido(),paciente3.getDni());


		GregorianCalendar fecha1 = new GregorianCalendar(2021, 6, 20);
		GregorianCalendar fecha2 = new GregorianCalendar(2021, 7, 10);
		GregorianCalendar fecha3 = new GregorianCalendar(2021, 7, 23);

		GregorianCalendar fecha4 = new GregorianCalendar(2021, 6, 24);
		GregorianCalendar fecha5 = new GregorianCalendar(2021, 8, 18);

//--------------------------------------------------------------------------------------------------------------------------------------------		
		
		
		
		
//------------------------------------------------FACTURA Y DA DE ALTA AL PACIENTE--------------------------------------------------------------------------------------------		
		try {
			unaClinica.darAltaYFacturar(paciente1, fecha1);
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}

		try {
			unaClinica.darAltaYFacturar(paciente2, fecha2);
		} catch (PacienteNoEncontradoExcepcion e) {
			e.printStackTrace();
		}

		try {
			unaClinica.darAltaYFacturar(paciente3, fecha3);
		} catch (PacienteNoEncontradoExcepcion e) {
			e.printStackTrace();
		}

		
		try {//Tira la excpecion ya que el paciente1 no esta mas en la clinica
			unaClinica.darAltaYFacturar(paciente1, fecha1);
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}
//--------------------------------------------------------------------------------------------------------------------------------------------		
		
		
//-----------------------------------------------------------REPORTA ACTIVIDAD DEL MEDICO(en un rango de fechas)---------------------------------------------------------------------------------		
		unaClinica.reporteActividadMedica(m1, fecha4, fecha5);
	}

}
