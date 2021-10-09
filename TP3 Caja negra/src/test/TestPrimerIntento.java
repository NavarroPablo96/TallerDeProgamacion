package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.*;
import excepciones.*;

import java.util.logging.Level;
import java.util.logging.Logger;

class TestPrimerIntento {
/*
 * cosigna:
 * proyecto PGA en base a los javadoc y la SRS
 * construir los test 
 * métodos de la capa "modelo" 
 * agregar, buscar, eliminar y modificar 
 * Alumnos  y Profesores,
 * 
 * todos los otros métodos están probados. 
 * 
 * 
 * */
	@Before
	public void setUp() throws Exception {
		IndiceDoble<Alumno> ColectAlumnos = new IndiceDoble<Alumno>();
		IndiceDoble<Alumno> TestColectAlumnos;

		Alumno alum1 = new Alumno("Alberto", "JUnin 2345", "alberto@gmail.com");
	    Alumno alum2 = new Alumno("Roberto", "Suipacha 767", "roberto@gmail.com");
	    Alumno nuevo = new Alumno("Jose","Maipu 4567", "Jose@hotmail.com");

	    Sistema SistemaPGA = new Sistema();
	    SistemaPGA.setAlumnos(ColectAlumnos); //Inicializo con coleccion vacia

	    try
	    {
	    	//Aqui se implementa el escenario y el test
	        SistemaPGA.agregarAlumno(alum1);
	        SistemaPGA.agregarAlumno(alum2);
	        SistemaPGA.agregarAlumno(nuevo);
	    } catch (ClaveYaExistenteException ex) {
	    	Logger.getLogger(TestPrimerIntento.class.getName()).log(Level.SEVERE, null,ex);
	    } catch (DatoInvalidoException ex) {
	    	Logger.getLogger(TestPrimerIntento.class.getName()).log(Level.SEVERE, null,ex);
	    }
	    TestColectAlumnos = SistemaPGA.getAlumnos();
	    //Aqui se testea el resultado final
	    System.out.println(TestColectAlumnos.contieneValor(nuevo));

	   
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("HOLA JUAN CARLOS");
	}

}
