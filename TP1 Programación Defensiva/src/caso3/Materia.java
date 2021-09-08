package caso3;

/**
 * @author Grupo 6
 *Representa una materia institucional.
 *<b>inv:<\b> <br>
 *nombre != null && !nombre.equals("")
 *nombre.equals("Historia") || nombre.equals("Matemática") || nombre.equals("Fisica") || nombre.equals("Literatura")
 *estado != null && !estado.equals("")
 *estado.equals("A cursar") || estado.equals("Cursada") || estado.equals("Aprobada"): "Estado inválido"
 *nota>0 && nota<=10
 */
public class Materia
{
	private String nombre, estado;
	private byte nota;
	
	/**
	 * Crea una nueva materia.
	 * @param nombre: Nombre de la materia.
	 * @param estado: Estado actual de la materia.
	 * @param nota: Nota de la materia.
	 */
	public Materia(String nombre, String estado, byte nota)
	{
		this.nombre = nombre;
		this.estado = estado;
		this.nota = nota;
		
		verificarInvariante();
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
		
		verificarInvariante();
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
		
		verificarInvariante();
	}

	public byte getNota()
	{
		return nota;
	}

	public void setNota(byte nota)
	{
		this.nota = nota;
		
		verificarInvariante();
	}
	
	private void verificarInvariante(){
		assert nombre != null && !nombre.equals(""): "Ingrese datos validos de nombre de materia";
		assert nombre.equals("Historia") || nombre.equals("Matemática") || nombre.equals("Fisica") || nombre.equals("Literatura") : "Materias inválidas"; 
		assert estado != null && !estado.equals(""): "Ingrese datos validos de estado";
		assert estado.equals("A cursar") || estado.equals("Cursada") || estado.equals("Aprobada"): "Estado inválido";
		assert nota>0 && nota<=10: "Nota fuera de rango";
	}

	@Override
	public String toString()
	{
		return "Materia [nombre=" + nombre + ", estado=" + estado + ", nota=" + nota + "]";
	}
		
}
