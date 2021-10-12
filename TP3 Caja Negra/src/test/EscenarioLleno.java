package test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;

public class EscenarioLleno
{
private Sistema sistema;
	
	
	public EscenarioLleno() {
		sistema = new Sistema();
	}
	
	public void setUp(){
		
		Alumno alumn1 = new Alumno("Jose","Alvarado3444","Jose@gmail.com");
		Alumno alumn2 = new Alumno("Marcos","Luro22","Marcos@gmail.com");
		
		try
		{
			sistema.agregarAlumno(alumn1);
			sistema.agregarAlumno(alumn2);
		} catch (ClaveYaExistenteException | DatoInvalidoException e)
		{
			e.printStackTrace();
		}
	}
	
	public void tearDown() {
		IndiceDoble<Alumno> ListaAlumnos = new IndiceDoble<Alumno>();
		sistema.setAlumnos(ListaAlumnos);
	}
}
