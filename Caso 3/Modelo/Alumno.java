package Modelo;

import java.util.ArrayList;

public class Alumno
{
	private String nombreyapellido;
	private int legajo;
	private ArrayList<Materia> materias;
	
	public Alumno(String nombreyapellido, int legajo)
	{
		this.nombreyapellido = nombreyapellido;
		this.legajo = legajo;
		this.materias = new ArrayList<Materia>();
	}

	public String getNombreyapellido()
	{
		return nombreyapellido;
	}

	public int getLegajo()
	{
		return legajo;
	}

	public ArrayList<Materia> getMaterias()
	{
		return materias;
	}
	
}
