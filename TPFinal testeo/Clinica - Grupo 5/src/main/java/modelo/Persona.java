package modelo;

import java.io.Serializable;

public abstract class Persona implements Cloneable, Serializable
{
	private static final long serialVersionUID = 413557585;
	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private String ciudad;
	private String telefono;
	
	public Persona(String nombre, String apellido, String dni, String domicilio, String ciudad, String telefono)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.ciudad = ciudad;
		this.telefono = telefono;
	}
	
	public Persona()
	{
	}

	public String getNombre()
	{
		return nombre + " " + apellido;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public String getDomicilio()
	{
		return domicilio;
	}

	public void setDomicilio(String domicilio)
	{
		this.domicilio = domicilio;
	}

	public String getCiudad()
	{
		return ciudad;
	}

	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public String getDni()
	{
		return dni;
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
