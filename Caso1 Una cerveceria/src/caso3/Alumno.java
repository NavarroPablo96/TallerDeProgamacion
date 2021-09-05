package caso3;

import java.util.ArrayList;
import java.util.Iterator;

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
		
		verificarInvariante();
	}
	
	public Materia buscaMateria(String materia) {
		Iterator<Materia> it_materia = this.materias.iterator();
		boolean encuent_mat = false;
		Materia mat_act = null;
		
		while(it_materia.hasNext() && !encuent_mat)
		{
			mat_act = it_materia.next();
			if(mat_act.getNombre().equals(materia))
				encuent_mat = true;
		}
		
		if(encuent_mat)
			return mat_act;
		return null;
	}
	
	private void verificarInvariante() {
		assert this.nombreyapellido != null && !this.nombreyapellido.equals(""): "Se debe indicar un nombre y apellido";
		assert this.legajo>=0 && this.legajo<=9999: "El legajo tiene que ser un numero de 4 digitos";
		assert this.materias != null: "Se debe informar las materias del alumno";
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
