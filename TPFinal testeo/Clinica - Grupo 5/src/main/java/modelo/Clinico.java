package modelo;


/**
 * @author Agustin <br>
 *         Clase que se extiende de Medico que indica que la especialidad de
 *         este es clinico
 */

public class Clinico extends Medico
{
	private static final long serialVersionUID = 1849999455;
	public Clinico(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono, double sueldoBase)
	{
		super(nombre, apellido, dni, domicilio, ciudad, telefono, sueldoBase);
	}

	
	
	/**
	 * Metodo que devuelve un double que es el honorario basico del medico aumentado
	 * en un 5%.
	 */
	@Override
	public double getHonorarioBasico()
	{
		double sueldo =super.getHonorarioBasico();
		sueldo += sueldo * 0.05;	
		return sueldo;
	}

	@Override
	public String toString()
	{
		return "Clinico [sueldoBase=" + this.getHonorarioBasico() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", dni=" + this.getDni()
				+ ", domicilio=" + this.getDni() + ", ciudad=" + this.getCiudad() + ", telefono=" + this.getTelefono();
	}

	
	
	
}