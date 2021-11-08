package factory;

import modelo.Joven;
import modelo.Mayor;
import modelo.Ninio;
import modelo.Paciente;

public class PacienteFactory
{
	/**
	 * Metodo que genera un paciente con los datos pasados por parametro<br>
	 * <br>
	 * Pre: </b> el string rangoEtario solo puede ser "NINIO", "JOVEN" o "MAYOR"
	 * <br>
	 * 
	 * @param nombre      Nombre del paciente a crear.
	 * @param apellido    Apellido del paciente a crear.
	 * @param dni         Dni del paciente a crear.
	 * @param domicilio   Domicilio del paciente a crear.
	 * @param ciudad      Ciudad del paciente a crear.
	 * @param telefono    Telefono del paciente a crear.
	 * @param rangoEtario Rango etario del paciente a crear.
	 * @return Un paciente de la clase Paciente
	 */
	public static Paciente getPaciente(String nombre, String apellido, String dni, String domicilio, String ciudad,
			String telefono, String rangoEtario)
	{
		Paciente respuesta = null;

		if (rangoEtario.equalsIgnoreCase("NINIO"))
			respuesta = new Ninio(nombre, apellido, dni, domicilio, ciudad, telefono);
		if (rangoEtario.equalsIgnoreCase("JOVEN"))
			respuesta = new Joven(nombre, apellido, dni, domicilio, ciudad, telefono);
		if (rangoEtario.equalsIgnoreCase("MAYOR"))
			respuesta = new Mayor(nombre, apellido, dni, domicilio, ciudad, telefono);

		return respuesta;
	}
}
