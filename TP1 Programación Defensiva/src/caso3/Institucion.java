package caso3;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.LegajoInexistenteException;

/**
 * @author Grupo 6
 *Representa una Institucion formada por alumnos.
 *<b>inv:<\b> <br>
 *alumnos != null
 */
public class Institucion
{	
	private static Institucion instancia_institucion = null;
	private ArrayList<Alumno> alumnos;
	
	/**
	 * Crea una institucion.
	 */
	public Institucion() {
		this.alumnos = new ArrayList<Alumno>();
		
		verificarInvariante();
	}
	
	/**
	 *  Obtiene una única instancia de la institucion.
	 * <b>pos:<\b> Una instancia de la institucion. 
	 * @return Una instancia de la inst o la que ya se habia creado.
	 */
	public static Institucion getInstance() {
		if(instancia_institucion == null)
			instancia_institucion = new Institucion();
		return instancia_institucion;
	}
	
	/**
	 * Se encarga de buscar un alumno por su legajo.
	 * <b>pre:</b> Se tuvo que haber pedido un certificado.
	 * <b>pos:</b> Se devuelve la referencia del alumno buscado.
	 * @param legajo: Numero entero de 4 digitos que identifica a un alumno.
	 * @return Alumno o null si no se encontró.
	 */
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
