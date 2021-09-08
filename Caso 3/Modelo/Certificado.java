package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.LegajoInexistenteException;

public class Certificado
{
	private String nombreyapellido;
	private int legajo;
	private ArrayList<Materia> materias;
	private String condicion;
	
	/**
	 * Genera un certificado base, sin datos.
	 */
	public Certificado()
	{
		this.nombreyapellido = "";
		this.condicion = "";
		this.legajo =-1;
		this.materias = null;
	}

	public String pedirCertificado(Integer Legajo) throws LegajoInexistenteException {
		Iterator<Alumno> it_alumno = Institucion.getInstance().getAlumnos().iterator();
		boolean encuentra_leg = false;
		Alumno alumno_act = null;
		
		//Busco el alumno segun el legajo
		while(it_alumno.hasNext() && !encuentra_leg) {
			alumno_act = it_alumno.next();
			if(alumno_act.getLegajo() == Legajo) encuentra_leg = true;
		}
				
		if(encuentra_leg) {
			this.nombreyapellido = alumno_act.getNombreyapellido();
			this.legajo = alumno_act.getLegajo();
			this.materias = alumno_act.getMaterias();
		}
		else
			throw new LegajoInexistenteException("El legajo no existe!");
		
		return armaCertificado(); 	
	}
	
	
	private String armaCertificado() {
		byte cont = 0;
		StringBuilder st = new StringBuilder();
		
		st.append(this.toString());
		
		for(Materia materia: this.materias) {
			st.append(materia.toString());
			if(materia.getEstado().contentEquals("a cursar"))
				cont++;
		}
		if(cont >= 2)
			this.condicion = "Regular";
		else
			this.condicion = "Irregular";
		
		st.append(this.condicion);
		
		return st.toString();
	}
	
	@Override
	public String toString()
	{
		return "--------Certificado de alumno--------"
				+ "Nombre y Apellido = " + nombreyapellido + ", Legajo=" + legajo;
	}

	public String traerApellidoyNombre() {
		return "hola";
	}
	
	public String traerEstado(String Materia) {
		return "hola";
	}
	
	public String traerNota(String Materia) {
		return "hola";
	}
	
	public String traerCondición() {
		return "hola";
	}
}
