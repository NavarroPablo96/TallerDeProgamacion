package caso3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Grupo 6
 * Representa un alumno con sus datos de indentificación.
 * <b>inv:<\b> <br>
 * nombreyapellido != null <br>
 * !nombreyapellido.equals("") <br>
 * legajo>=0 && legajo<=9999 <br>
 * materias != null
 */
public class Alumno
{
	private String nombreyapellido;
	private int legajo;
	private ArrayList<Materia> materias;
	
	/**
	 * Se inicializa los datos de identificacion de un alumno.
	 * <b>pos<\b>: Datos de identificacion inicializados.
	 */
	public Alumno(String nombreyapellido, int legajo)
	{
		this.nombreyapellido = nombreyapellido;
		this.legajo = legajo;
		this.materias = new ArrayList<Materia>();
		
		verificarInvariante();
	}
	
	/**
	 * Busca una materia del listado de materias que cursa el alumno.
	 * <b>pre<\b>:El alumno debe existir<\b>
	 * <b>pos<\b>:Devuelve la referencia de materia.
	 * @param materia: Materia institucional que cursa un alumno.
	 * @return Materia si se encuetra en el listado del alumno o null en caso contrario.
	 */
	public Materia buscaMateria(String materia) {
		Iterator<Materia> it_materia = this.materias.iterator();
		boolean encuent_mat = false;
		Materia mat_act = null;
		
		assert materia != null && !materia.equals(""): "Datos inválidos";
		
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
	
	/**
	 * Verifica que el invariante de la clase se cumpla, si algo falla lanza un AssertionError.
	 */
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
