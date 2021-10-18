package prueba;

import java.util.HashMap;

import decorators.IMedico;
import modelo.Clinica;
import modelo.Compartida;
import modelo.ConsultaMedica;
import modelo.Habitacion;
import modelo.Internacion;
import modelo.Joven;
import modelo.Mayor;
import modelo.MedicoFactory;
import modelo.Ni�o;
import modelo.Paciente;
import modelo.Prestacion;
import modelo.Privada;
import modelo.TerapiaIntensiva;
import persistencia.PersistenciaGeneral;

public class Main
{ 	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	//Creo pacientes
	
//	HashMap<Long, Paciente> pacientes = new HashMap<Long, Paciente>();
//	HashMap<Long,IMedico> medicos = new HashMap<Long,IMedico>();	
//	
//	Paciente paciente1 = new Joven("39231888", "Seba", "A", "Luro900", "mdp", "459-4312");
//	Paciente paciente2 = new Mayor("23455123", "Ima", "V", "Balcarce560", "balcarce", "3234-2323");
////	
//////	//Creo medicos
//	IMedico Medico1 = MedicoFactory.getMedico("Pediatria","Residente","Magister", "11234532", "Pepe", "Pepe", "San Luis 1234", "Batan", "5551234", 2345);
//	IMedico Medico2 = MedicoFactory.getMedico("Cirugia","Residente","Magister", "88234532", "Lolo", "Lolo", "San Juan 8234", "Miramar", "8881234", 8888);
//////	
////	//Prestacion-Consultas medicas
//	ConsultaMedica consulta1= new ConsultaMedica(1,Medico1);
//	ConsultaMedica consulta2= new ConsultaMedica(1,Medico2);
//	
////	//Prestacion-Internacion
//	Habitacion h1 = new Privada("55");
//	Habitacion h2 = new Compartida("10");
//	Habitacion h3 = new TerapiaIntensiva("12");
//	Internacion internacion1 = new Internacion(7, h1);
//	Internacion internacion2 = new Internacion(6, h2);
//	Internacion internacion3 = new Internacion(6, h3);
////	
////	//Se agrega las prestaciones al los pacientes a una estructura 
//	HashMap<String, Prestacion> prestaciones1 = new HashMap<String, Prestacion>();
//	HashMap<String, Prestacion> prestaciones2 = new HashMap<String, Prestacion>();
// 	
//	prestaciones1.put(internacion1.getHabitacion().getNumeroHabitacion(), internacion1);
//	prestaciones2.put(internacion2.getHabitacion().getNumeroHabitacion(), internacion2);
//	prestaciones2.put(internacion2.getHabitacion().getNumeroHabitacion(), internacion3);
//	prestaciones1.put(consulta1.getMedico().getNombre(), consulta1);
//	prestaciones2.put(consulta2.getMedico().getNombre(), consulta2);
//	
//	medicos.put(Medico1.getNroMatricula(), Medico1);
//	medicos.put(Medico2.getNroMatricula(), Medico2);
////	
////	//Se agregan las prestaciones a los pacientes
//	paciente1.agregarPrestaciones(prestaciones1);
//	paciente2.agregarPrestaciones(prestaciones2);
//	
//	pacientes.put(paciente1.getNroHistoria(),paciente1);
//	pacientes.put(paciente2.getNroHistoria(),paciente2);
//		
//	Clinica.getInstance().Ingreso(paciente1);
//	Clinica.getInstance().Ingreso(paciente2);
//		
//	Clinica.getInstance().Atencion();
//	Clinica.getInstance().Atencion();
////	
////	//Se guarda en un archivo el registro de los pacientes
//	PersistenciaGeneral.guardaInformacionPacientes(pacientes);
////	
////	//Se guarda en un archivo la informacion de los medicos
//	PersistenciaGeneral.guardaInformacionMedicos(medicos);
	
	//Se recupera la informacion de los pacientes
	HashMap<Long, Paciente> pacientes_des = new HashMap<Long, Paciente>();
	
	pacientes_des = PersistenciaGeneral.recuperaInformacionPacientes();
	
	Paciente paciente_act = null;
	
	for(Paciente i: pacientes_des.values()) {
		paciente_act= i;
		System.out.println("Datos personales \n"+ i.toString()+ "\n"+ i.historicoPracticas());
	}
	
//	
//	//Se setea para que al recuperar siguiente numero conserve su valor statico.(resuelto)
	Paciente.setsiguientenumero(paciente_act.getNroHistoria());
//	
//	//Creo un nuevo paciente para verificar si el siguientenumero es correcto
	Paciente paciente3 = new Joven("37892345", "Pedro", "A", "Luro920", "mdp", "459-4312");
	Paciente paciente4 = new Ni�o("20892345", "Marcos", "Apel", "Const92", "mdp", "459-4312");
	
	System.out.println("El numero de historia es: " + paciente4.getNroHistoria());
//	
//	//Se recupera la informacion de los medicos
	HashMap<Long,IMedico> medicos_des = new HashMap<Long,IMedico>();
	
	medicos_des = PersistenciaGeneral.recuperaInformacionMedicos();
	
	for(IMedico i: medicos_des.values()) {
		System.out.println("\nDatos personales del medico \n"+ i.toString()+"\n Consultas:\n");
		for(ConsultaMedica j: i.getConsultas()) {
			System.out.println(j.toString());
		}
	}  	
  }
}
