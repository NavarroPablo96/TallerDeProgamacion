package caso3;

public class Materia
{
	private String nombre, estado;
	private byte nota;
	
	public Materia(String nombre, String estado, byte nota)
	{
		this.nombre = nombre;
		this.estado = estado;
		this.nota = nota;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public byte getNota()
	{
		return nota;
	}

	public void setNota(byte nota)
	{
		this.nota = nota;
	}

	@Override
	public String toString()
	{
		return "Materia [nombre=" + nombre + ", estado=" + estado + ", nota=" + nota + "]";
	}
		
}
