package test;

import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoEncontradoException;
import modelo.Alumno;

public class BuscaAlumnoEscenarioVacioTest {
	private EscenarioVacio escenarioVacio=new EscenarioVacio();
	
	@Before
    public void setUp() {
		//this.escenarioVacio=new EscenarioVacio();
		this.escenarioVacio.setUp();
    }

    @After
    public void tearDown() {
    	this.escenarioVacio.tearDown();
    }
    
    @Test
    public void buscarAlumno_1(){ // Busca alumno válido
    	//al ser escenario vacio, en el mejor de los casos debería arrojar NoEncuentradoException
        Alumno alumno = new Alumno("Alberto", "JUnit 2345", "alberto@gmail.com");
        Iterator <Alumno> test_alumnos=null;//=new Iterator<Alumno>();
        try
        {
        	test_alumnos = this.escenarioVacio.getSistema().buscarAlumno(alumno.getApellidoNombre());
            fail("buscarAlumno_1:No se debería ejecutar esto, se debería lanzar una excepcion.");
        }
        catch (NoEncontradoException e){//esto es lo que deberia pasar
        	System.out.printf("buscarAlumno_1:Se ha lanzado una NoEncontradoException, "+e.getMessage()+"\n");
        }
        catch(Exception e) {
        	fail("buscarAlumno_1:No se debería ejecutar esto, se debería lanzar una NoEncontradoException.");
        }
    }
    
    //public void buscarAlumno_2()
    // Este método no tiene sentido en este escenario
    
    @Test
    public void buscarAlumno_3(){// Busca alumno null
        Alumno alumno = null;
        Iterator <Alumno> test_alumnos=null;//=new Iterator<Alumno>();
        try
        {	
        	test_alumnos = this.escenarioVacio.getSistema().buscarAlumno(alumno.getApellidoNombre());
            fail("buscarAlumno_3:No se debería ejecutar esto, se debería lanzar una excepcion.");
        }
        catch(Exception e) {
        	System.out.printf("buscarAlumno_3:Se ha lanzado una Exception, "+e.getMessage()+"\n");
        }
        fail("buscarAlumno_3:No se debería ejecutar esto, se debería lanzar una excepcion.");
    }
}
