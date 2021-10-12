package test;

import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;

public class EscenarioVacio
{
	private Sistema sistema;
	
	
	public Sistema getSistema() {
		return sistema;
	}

	public EscenarioVacio() {
		sistema = new Sistema();
	}
	
	public void setUp() {
		IndiceDoble<Alumno> ListaAlumnos = new IndiceDoble<Alumno>();
		sistema.setAlumnos(ListaAlumnos);
	}
	
	public void tearDown() {
		IndiceDoble<Alumno> ListaAlumnos = new IndiceDoble<Alumno>();
		sistema.setAlumnos(ListaAlumnos);
	}
}
