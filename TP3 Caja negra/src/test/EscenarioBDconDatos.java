package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.IndiceDoble;
import modelo.Sistema;

public class EscenarioBDconDatos {
	private Sistema SistemaPGA;
	private IndiceDoble<Alumno> ColectAlumnos;
	private IndiceDoble<Asignatura> ColectAsignatura;
	
	
	EscenarioBDconDatos(){
		this.ColectAlumnos = new IndiceDoble<Alumno>();
		this.ColectAsignatura = new IndiceDoble<Asignatura>();

		Alumno alum1 = new Alumno("Alberto", "JUnin 2345", "alberto@gmail.com");
	    Alumno alum2 = new Alumno("Roberto", "Suipacha 767", "roberto@gmail.com");
	    Alumno nuevo = new Alumno("Jose","Maipu 4567", "Jose@hotmail.com");
	    
	    Asignatura Asig1 = new Asignatura("Análisis mátematico A");
	    Asignatura Asig2 = new Asignatura("Análisis mátematico B");

	    this.SistemaPGA = new Sistema();
	    //Inicializo con coleccion vacia
	    this.SistemaPGA.setAlumnos(this.ColectAlumnos);
	    this.SistemaPGA.setPlanDeEstudio(this.ColectAsignatura);

	    try
	    {
	    	//Aqui se implementa el escenario y el test
	        this.SistemaPGA.agregarAlumno(alum1);
	        this.SistemaPGA.agregarAlumno(alum2);
	        this.SistemaPGA.agregarAlumno(nuevo);
	        //Agregar asignatura
	        this.SistemaPGA.agregarAsignatura(Asig2);
	        this.SistemaPGA.agregarAsignatura(Asig1);
	    } catch (ClaveYaExistenteException ex) {
	    	Logger.getLogger(TestPrimerIntento.class.getName()).log(Level.SEVERE, null,ex);
	    } catch (DatoInvalidoException ex) {
	    	Logger.getLogger(TestPrimerIntento.class.getName()).log(Level.SEVERE, null,ex);
	    }
	    //this.TestColectAlumnos = this.SistemaPGA.getAlumnos();
	    //this.TestColectAsignatura= this.SistemaPGA.getPlanDeEstudio();
	    //Aqui se testea el resultado final
	    //System.out.println(this.TestColectAlumnos.contieneValor(nuevo));
		
	}

	public Sistema getSistemaPGA() {
		return this.SistemaPGA;
	}
	
	public IndiceDoble<Alumno> getColectAlumnos() {
		return ColectAlumnos;
	}

	public IndiceDoble<Asignatura> getColectAsignatura() {
		return ColectAsignatura;
	}
	
}
