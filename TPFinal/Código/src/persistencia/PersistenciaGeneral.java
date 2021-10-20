package persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeSet;
import decorators.IMedico;
import modelo.Factura;
import modelo.Paciente;



/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebastián Agüero.<br>
 *Clase representa la persistencia General.
 */
public class PersistenciaGeneral {
	
	
	/**
	 * Método que permite recuperar la información del archivo "Pacientes.dat".<br>
	 * <b>Pre: </b> El archivo con ese nombre debe existir.<br>
	 * <b>Post: </b> Se retorna un HashMap de Pacientes, con los datos del archivo.
	 * */
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
	/**
	 * Método que permite guardar la información de los Pacientes en el archivo "Pacientes.dat".<br>
	 * <b>Pre: </b> El archivo con ese nombre debe existir. El parametro debe ser distinto de null.<br>
	 * <b>Post: </b> Se guardo la información de los pacientes en el archivo.
	 * @param pacientes: HashMap de Pacientes a almacenar en el archivo.
	 * */
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
	/**
	 * Método que permite recuperar la información del archivo "Medicos.dat".<br>
	 * <b>Pre: </b> El archivo con ese nombre debe existir.<br>
	 * <b>Post: </b> Se retorna un HashMap de IMedico, con los datos del archivo.
	 * */
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
	/**
	 * Método que permite guardar la información de los medicos en el archivo "Medicos.dat".<br>
	 * <b>Pre: </b> El archivo con ese nombre debe existir. El parametro debe ser distinto de null.<br>
	 * <b>Post: </b> Se guardo la información de los medicos en el archivo.
	 * @param medicos: HashMap de IMedico a almacenar en el archivo.
	 * */
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
	/**
	 * Método que permite recuperar la información del archivo "Facturas.dat".<br>
	 * <b>Pre: </b> El archivo con ese nombre debe existir.<br>
	 * <b>Post: </b> Se retorna un TreeSet de Facturas, con los datos del archivo.
	 * */
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
		
	/**
	 * Método que permite guardar la información de las Facturas en el archivo "Facturas.dat".<br>
	 * <b>Pre: </b> El archivo con ese nombre debe existir. El parametro debe ser distinto de null.<br>
	 * <b>Post: </b> Se guardo la información de las Facturas en el archivo.
	 * @param facturas: TreeSet de Factura a almacenar en el archivo.
	 * */
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
