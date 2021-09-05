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
		
		verificarInvariante();
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
	
	assert legajo>=0 && legajo<=9999: "El legajo tiene que ser un numero de 4 digitos";
	
	//Busco el alumno segun el legajo
		while(it_alumno.hasNext() && !existe_legajo) {
			alumno_act = it_alumno.next();
			if(alumno_act.getLegajo() == legajo) existe_legajo = true;
		}
		if(existe_legajo)
			return alumno_act;
	    return null;
	}
	
	private void verificarInvariante() {
		assert alumnos != null: "Alumnos sin inicializar";
	}

	public ArrayList<Alumno> getAlumnos()
	{
		return alumnos;
	}
	
}
