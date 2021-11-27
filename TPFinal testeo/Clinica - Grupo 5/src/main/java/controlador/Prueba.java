package controlador;

import excepciones.*;
import factory.MedicoFactory;
import factory.PacienteFactory;
import interf.IMedico;
import modelo.*;
import persistencia.CargaYDescarga;
import vista.Interfaz;

import java.util.GregorianCalendar;

public class Prueba {



	public static void main(String[] args) {

		Clinica unaClinica = Clinica.getInstance();
		unaClinica.setNombre("CLINICA BERAZATEGUI");
		CargaYDescarga persistencia = new CargaYDescarga();
		persistencia.leerDatos();

		Interfaz ventana = new Interfaz();
		Controlador controlador = new Controlador(ventana);
		
		ventana.setVisible(true);

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

		/*unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");*/

		try {
			unaClinica.ingresaPaciente(unaClinica.consultarPaciente("2"));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
		}

		/*unaClinica.muestraPacPatio();
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");*/

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
		unaClinica.atenderPaciente();
		unaClinica.atenderPaciente();
		unaClinica.atenderPaciente();
		unaClinica.atenderPaciente();
		unaClinica.muestraPacPatio();
		System.out.println("///////////////");
		unaClinica.muestraPacSalaPriv();
		System.out.println("///////////////");
		unaClinica.muestraPacientesAtencion();
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
		unaClinica.agregaPrestacion(new Prestacion(m1, 3),paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());
		unaClinica.agregaPrestacion(new Prestacion(h1, 20),paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());
		unaClinica.agregaPrestacion(new Prestacion(h3, 5),paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());
		unaClinica.agregaPrestacion(new Prestacion(m2, 7),paciente1.getNombre(),paciente1.getApellido(),paciente1.getDni());

		unaClinica.agregaPrestacion(new Prestacion(h1, 4),paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(new Prestacion(m1, 3),paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(new Prestacion(m1, 3),paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(new Prestacion(h2, 3),paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());
		unaClinica.agregaPrestacion(new Prestacion(h1, 20),paciente2.getNombre(),paciente2.getApellido(),paciente2.getDni());

		unaClinica.agregaPrestacion(new Prestacion(m2, 7),paciente3.getNombre(),paciente3.getApellido(),paciente3.getDni());
		unaClinica.agregaPrestacion(new Prestacion(m1, 10),paciente3.getNombre(),paciente3.getApellido(),paciente3.getDni());
		unaClinica.agregaPrestacion(new Prestacion(m1, 3),paciente3.getNombre(),paciente3.getApellido(),paciente3.getDni());


		GregorianCalendar fecha1 = new GregorianCalendar(2021, 6, 20);
		GregorianCalendar fecha2 = new GregorianCalendar(2021, 7, 10);
		GregorianCalendar fecha3 = new GregorianCalendar(2021, 7, 23);

		GregorianCalendar fecha4 = new GregorianCalendar(2021, 6, 24);
		GregorianCalendar fecha5 = new GregorianCalendar(2021, 8, 18);
		GregorianCalendar fechaf = new GregorianCalendar(2021, 10, 10);
		GregorianCalendar fechai = new GregorianCalendar(1994, 8, 18);

//--------------------------------------------------------------------------------------------------------------------------------------------




//------------------------------------------------FACTURA Y DA DE ALTA AL PACIENTE--------------------------------------------------------------------------------------------
		try {
			System.out.println(unaClinica.darAltaYFacturar(paciente1, fecha1));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}

		try {
			String factura =unaClinica.darAltaYFacturar(paciente2, fecha2);
			System.out.println(factura);
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}

		try {
			String factura =unaClinica.darAltaYFacturar(paciente3, fecha3);
			System.out.println(factura);
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}


		try {//Tira la excpecion ya que el paciente1 no esta mas en la clinica
			System.out.println(unaClinica.darAltaYFacturar(paciente1, fecha1));
		} catch (PacienteNoEncontradoExcepcion e) {
			System.out.println(e.getMessage());
			System.out.println("PACIENTE INVALIDO: " + e.getPaciente());
		}
//--------------------------------------------------------------------------------------------------------------------------------------------


//-----------------------------------------------------------REPORTA ACTIVIDAD DEL MEDICO(en un rango de fechas)---------------------------------------------------------------------------------
		unaClinica.reporteActividadMedica(m1, fechai, fechaf);
		unaClinica.muestraPacientesAtencion();
	}
		
	}
