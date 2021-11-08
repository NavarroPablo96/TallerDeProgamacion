package factory;

import decorator.DDoctor;
import decorator.DMagister;
import decorator.DPermanente;
import decorator.DResidente;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import modelo.Cirujano;
import modelo.Clinico;
import interf.IMedico;
import modelo.Pediatra;

/**
 * @author Agustin <br>
 *         Clase que permite crear un medico a partir de sus parametros de
 *         construccion, especialidad, contratacion y posgrado.
 */
public class MedicoFactory
{

	/**
	 * Metodo que devuelve un medico de la clase IMedico.<br>
	 * <br>
	 * Pre: </b> El dni, telefono y sueldoBase deben ser numeros enteros mayores a
	 * cero. <br>
	 * 
	 * @param nombre       Nombre del medico a crear.
	 * @param apellido     Apellido del medico a crear.
	 * @param dni          Dni del medico a crear.
	 * @param domicilio    Domicilio del medico a crear.
	 * @param ciudad       Ciudad del medico a crear.
	 * @param telefono     Telefono del medico a crear.
	 * @param sueldoBase   Honorario basico del medico a crear.
	 * @param especialidad Especialidad del medico a crear.
	 * @param posgrado     Posgrado del medico a crear.
	 * @param contratacion Contratacion del medico a crear.
	 * @return Un medico de clase IMedico.
	 * @throws NoHayEspecialidadException    Excepcion lanzada en caso de que
	 *                                       "especialidad" sea null
	 * @throws NoHayContratacionException    Excepcion lanzada en caso de que
	 *                                       "contratacion" sea null
	 * @throws NoExistePosgradoException     Excepcion lanzada en caso de que el
	 *                                       posgrado pasado por parametro no exista
	 * @throws NoExisteContratacionException Excepcion lanzada en caso de que el
	 *                                       posgrado pasado por parametro no exista
	 * @throws NoExisteEspecialidadException Excepcion lanzada en caso de que el
	 *                                       posgrado pasado por parametro no exista
	 */
	public static IMedico getMedico(String nombre, String apellido, String dni, String domicilio, String ciudad,
			String telefono, double sueldoBase, String especialidad, String posgrado, String contratacion)
			throws NoHayEspecialidadException, NoHayContratacionException, NoExistePosgradoException,
			NoExisteContratacionException, NoExisteEspecialidadException
	{
		IMedico encapsulado1 = null;
		IMedico encapsulado2 = null;
		IMedico respuesta = null;

		if (especialidad == null) // excepcion -> no tiene especialidad
			throw new NoHayEspecialidadException("El medico debe tener una especialidad");

		if (especialidad.equalsIgnoreCase("CLINICO"))
			encapsulado1 = new Clinico(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
		else if (especialidad.equalsIgnoreCase("CIRUJANO"))
			encapsulado1 = new Cirujano(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
		else if (especialidad.equalsIgnoreCase("PEDIATRA"))
			encapsulado1 = new Pediatra(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);

		if (encapsulado1 != null) // la especialidad es v�lida
		{
			if (posgrado != null)
			{
				if (posgrado.equalsIgnoreCase("DOCTOR"))
					encapsulado2 = new DDoctor(encapsulado1);
				else if (posgrado.equalsIgnoreCase("MAGISTER"))
					encapsulado2 = new DMagister(encapsulado1);

				else // excepcion -> no existe el posgrado
					throw new NoExistePosgradoException("El posgrado no es valido", posgrado);
			}
			if (encapsulado2 != null) // tiene posgrado
			{
				if (contratacion == null) // excepcion -> no hay contratacion
					throw new NoHayContratacionException("El medico debe tener una contratacion");

				else if (contratacion.equalsIgnoreCase("RESIDENTE"))
					respuesta = new DResidente(encapsulado2);
				else if (contratacion.equalsIgnoreCase("PLANTEL PERMANENTE"))
					respuesta = new DPermanente(encapsulado2);
				else // excepcion -> no existe el tipo de contratacion
					throw new NoExisteContratacionException("El tipo de contratacion no es valido", contratacion);

			} else // no tiene un posgrado
			{
				if (contratacion == null) // excepcion -> no hay contratacion
					throw new NoHayContratacionException("El medico debe tener una contratacion");

				else if (contratacion.equalsIgnoreCase("RESIDENTE"))
					respuesta = new DResidente(encapsulado1);
				else if (contratacion.equalsIgnoreCase("PLANTEL PERMANENTE"))
					respuesta = new DPermanente(encapsulado1);
				else // excepcion -> no existe el tipo de contratacion
					throw new NoExisteContratacionException("El tipo de contratacion no es valido", contratacion);

			}
		} else // excepcion -> la especialidad no existe
			throw new NoExisteEspecialidadException("La especialidad no es valida", especialidad);

		return respuesta;
	}
}
