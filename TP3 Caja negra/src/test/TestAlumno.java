package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.NoEncontradoException;
import modelo.Alumno;
import modelo.Asignatura;
import modelo.IndiceDoble;
import modelo.Sistema;



public class TestAlumno {
	private EscenarioBDconDatos BD;
	private Sistema SPGA;
	private IndiceDoble<Alumno> TestColectAlumnos;
	private IndiceDoble<Asignatura> TestColectAsignatura;
	@Before
	public void setUp(){
		this.BD= new EscenarioBDconDatos();
		this.SPGA=this.BD.getSistemaPGA();
		
	}

	@Test
	public void testAgregaHistoria() {
		//Pre: La asignatura forma parte del sistema.
		//Post: El alumno tiene una asignatura aprobada más.
		
		//fail("Not yet implemented");
		this.TestColectAlumnos = this.BD.getColectAlumnos();
		this.TestColectAsignatura = this.BD.getColectAsignatura();
		
		Asignatura matematica=null;//= this.TestColectAsignatura.getIndice1();
		Alumno roberto=null;
		//this.TestColectAsignatura.
		//SPGA.getPlanDeEstudio().clavesPrimarias()
		
		//Iterator<Asignatura>this.TestColectAsignatura.buscarPorClaveSecundaria()
		
		Iterator<Asignatura> materias=null;
		try {
			materias = SPGA.buscarAsignatura("Análisis");
		} catch (NoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				//(Iterator<Asignatura>)this.TestColectAsignatura.elementosPorClavePrimaria();
		Iterator<Alumno> alumnos= (Iterator<Alumno>)this.TestColectAlumnos.elementosPorClavePrimaria();
		
		
		boolean encontre=false;
		while(materias.hasNext()  && !encontre) {
			matematica=materias.next();
			if(matematica.getNombre().equals("Análisis mátematico A")) {
				encontre=true;
			}			
		}
		
		encontre=false;
		while(alumnos.hasNext()  && !encontre) {
			roberto=alumnos.next();
			if(roberto.getApellidoNombre().equals("Roberto")) {
				encontre=true;
			}			
		}
		
		
		try {
			roberto.agregarHistoria(matematica);			
		}
		catch(ClaveYaExistenteException e) {
			
		}
		
		
		
		/*
		Object Clavicula = A.getClavePrimaria();
		 *  public Iterator<V> elementosPorClavePrimaria() {
        		return this.indice1.elementos();
    		}
    		 public Iterator<V> elementos() {
        return this.elementos.values().iterator();
    }
		 * */
	}

}
