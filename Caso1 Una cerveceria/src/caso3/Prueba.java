package caso3;


public class Prueba
{
	
	public static void main(String[] args)
	{			
		//Simula que se esta ingresando por una vista el legajo de un alumno.
		UI.getInstance().pedirCertificado(345);
		
		//Dada una materia que haya cursado un alumno muestra el estado.
		UI.getInstance().mostrarEstado("Materia");
	}

}
