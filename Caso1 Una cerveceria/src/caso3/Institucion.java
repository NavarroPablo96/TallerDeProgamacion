package caso3;

import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.LegajoInexistenteException;

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
	
	public Alumno buscaAlumno(Integer legajo){
	Iterator<Alumno> it_alumno = this.getAlumnos().iterator();
	boolean existe_legajo = false;
	Alumno alumno_act = null;
	
	//Busco el alumno segun el legajo
		while(it_alumno.hasNext() && !existe_legajo) {
			alumno_act = it_alumno.next();
			if(alumno_act.getLegajo() == legajo) existe_legajo = true;
		}
		if(existe_legajo)
			return alumno_act;
	    return null;
	}

	public ArrayList<Alumno> getAlumnos()
	{
		return alumnos;
	}
	
}
