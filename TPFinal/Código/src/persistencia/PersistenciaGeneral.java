package persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import decorators.IMedico;
import modelo.Factura;
import modelo.Medico;
import modelo.Paciente;



public class PersistenciaGeneral {
	
	public static HashMap<Long,Paciente> recuperaInformacionPacientes(){
		
		IPersistencia<Serializable> persistencia = new Persistencia();
		HashMap<Long,Paciente> pacientes = null;
        try
        {
            persistencia.abrirInput("Pacientes.dat");
            pacientes=(HashMap<Long, Paciente>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return pacientes;
	}
	
	public static void guardaInformacionPacientes(HashMap<Long, Paciente> pacientes) {
		 IPersistencia<Serializable>  persistencia = new Persistencia();
		 
		try
      {
		  persistencia.abrirOutput("Pacientes.dat");
          persistencia.escribir(pacientes);
          persistencia.cerrarOutput();
      } 
      catch (IOException e)
      {
          e.printStackTrace();
      }
	}
	
	public static HashMap<Long,IMedico> recuperaInformacionMedicos(){
		
		IPersistencia<Serializable> persistencia = new Persistencia();
		HashMap<Long,IMedico> medicos = null;
        try
        {
            persistencia.abrirInput("Medicos.dat");
            medicos=(HashMap<Long,IMedico>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return medicos;
	}
	
	public static void guardaInformacionMedicos(HashMap<Long,IMedico> medicos) {
		
		IPersistencia<Serializable>  persistencia = new Persistencia(); 
		try
     {
		 persistencia.abrirOutput("Medicos.dat");
         persistencia.escribir(medicos);
         persistencia.cerrarOutput();
     } 
     catch (IOException e)
     {
         e.printStackTrace();
     }
	}
	
	public static TreeSet<Factura> recuperaInformacionFacturas(){
			
			IPersistencia<Serializable> persistencia = new Persistencia();
			TreeSet<Factura> facturas = null;
	        try
	        {
	            persistencia.abrirInput("Facturas.dat");
	            facturas=(TreeSet<Factura>) persistencia.leer();
	            persistencia.cerrarInput();
	        } catch (ClassNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        return facturas;
		}
		
	
	public static void guardaInformacionFacturas(TreeSet<Factura> facturas) {
		
		IPersistencia<Serializable>  persistencia = new Persistencia(); 
		try
     {
		 persistencia.abrirOutput("Facturas.dat");
         persistencia.escribir(facturas);
         persistencia.cerrarOutput();
     } 
     catch (IOException e)
     {
         e.printStackTrace();
     }
	}
	
	
}
