package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Clinica;
import modelo.Factura;
import interf.IMedico;
import modelo.Paciente;

public class CargaYDescarga
{
	private IPersistencia persistencia = new PersistenciaBIN();
	private Clinica unaClinica = Clinica.getInstance();

	/**
	 * Metodo que escribe en archivos binarios el hashmap de pacientes junto con el
	 * hashmap de atencion
	 */
	public void guardarPacientes()
	{
		try // guarda los pacientes
		{
			persistencia.abrirOutput("Pacientes.bin");
			System.out.println("Creando/sobreescribiendo archivo escritura Pacientes.bin");
			persistencia.escribir(unaClinica.getPacientes());
			System.out.println("Lista de pacientes grabada exitosamente");
			persistencia.cerrarOutput();
			System.out.println("Archivo Pacientes.bin cerrado");
		} catch (IOException e)
		{
			System.out.println(e.getLocalizedMessage());
		}

		try // guarda los pacientes en atencion
		{
			persistencia.abrirOutput("Atencion.bin");
			System.out.println("Creando/sobreescribiendo archivo escritura Atencion.bin");
			persistencia.escribir(unaClinica.getAtencion());
			System.out.println("Lista de atencion grabada exitosamente");
			persistencia.cerrarOutput();
			System.out.println("Archivo Atencion.bin cerrado");
		} catch (IOException e)
		{
			System.out.println(e.getLocalizedMessage());
		}

	}

	/**
	 * Metodo que escribe en archivos binarios el hashmap de facturas
	 */
	public void guardarFacturas()
	{
		try
		{
			persistencia.abrirOutput("Facturas.bin");
			System.out.println("Creando/sobreescribiendo archivo escritura Facturas.bin");
			persistencia.escribir(unaClinica.getFacturas());
			System.out.println("Lista de medicos grabada exitosamente");
			persistencia.cerrarOutput();
			System.out.println("Archivo Facturas.bin cerrado");
		} catch (IOException e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Metodo que escribe en archivos binarios el hashmap de medicos
	 */
	public void guardarMedicos()
	{
		try
		{
			persistencia.abrirOutput("Medicos.bin");
			System.out.println("Creando/sobreescribiendo archivo escritura Medicos.bin");
			persistencia.escribir(unaClinica.getMedicos());
			System.out.println("Lista de medicos grabada exitosamente");
			persistencia.cerrarOutput();
			System.out.println("Archivo Medicos.bin cerrado");
		} catch (IOException e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Metodo que lee de los archivos binarios los hashmaps de pacientes, atencion, medicos y facturas
	 */
	public void leerDatos()
	{
		HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
		HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
		HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
		ArrayList<Factura> facturas = new ArrayList<Factura>();

		// --------------------LECTURA-DE-PACIENTES-----------------------------------------
		try
		{
			persistencia.abrirInput("Pacientes.bin");
			System.out.println("Archivo Pacientes.bin abierto");
			pacientes = (HashMap<String, Paciente>) persistencia.leer();
			System.out.println("Lista de pacientes recuperada");
			persistencia.cerrarInput();
			System.out.println("Archivo Pacientes.bin cerado");
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		// --------------------LECTURA-DE-MEDICOS-----------------------------------------
		try
		{
			persistencia.abrirInput("Medicos.bin");
			System.out.println("Archivo Medicos.bin abierto");
			medicos = (HashMap<String, IMedico>) persistencia.leer();
			System.out.println("Lista de medicos recuperada");
			persistencia.cerrarInput();
			System.out.println("Archivo Medicos.bin cerado");
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		// --------------------LECTURA-DE-FACTURAS-----------------------------------------
		try
		{
			persistencia.abrirInput("Facturas.bin");
			System.out.println("Archivo Facturas.bin abierto");
			facturas = (ArrayList<Factura>) persistencia.leer();
			System.out.println("Lista de facturas recuperada");
			persistencia.cerrarInput();
			System.out.println("Archivo Facturas.bin cerado");
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		// --------------------LECTURA-DE-ATENCION-----------------------------------------
		try
		{
			persistencia.abrirInput("Atencion.bin");
			System.out.println("Archivo Atencion.bin abierto");
			atencion = (HashMap<String, Paciente>) persistencia.leer();
			System.out.println("Lista de atencion recuperada");
			persistencia.cerrarInput();
			System.out.println("Archivo Atencion.bin cerado");
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		unaClinica.setMedicos(medicos);
		unaClinica.setPacientes(pacientes);
		unaClinica.setFacturas(facturas);
		unaClinica.setAtencion(atencion);

	}

}
