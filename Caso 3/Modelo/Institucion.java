package Modelo;

import java.util.ArrayList;

public class Institucion
{	
	private static Institucion instancia_institucion = null;
	private ArrayList<Alumno> alumnos;
	
	public Institucion() {
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public static Institucion getInstance() {
		if(instancia_institucion == null)
			instancia_institucion = new Institucion();
		return instancia_institucion;
	}

	public ArrayList<Alumno> getAlumnos()
	{
		return alumnos;
	}
	
}
