package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import modelo.Alumno;

public class AgregarAlumnoEscenarioVacioTest {
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
    /**
     * Verificar que cuando un alumno es nulo debe generar un error
     */
	@Test
    public void agregarAlumno_3(){
		
        Alumno alumno = null;
        try
        {
        	this.escenarioVacio.getSistema().agregarAlumno(alumno);
            //fail("No tiene que pasar sin generar un error.");
            fail("agregarAlumno_3:No se debería ejecutar esto, se debería lanzar una excepcion.");
        }
        catch (DatoInvalidoException e){ 
        	System.out.printf("agregarAlumno_3:Se ha lanzado una excepción,"+e.getMessage()+"\n");
        	fail("agregarAlumno_3:Deberia haber arrojado una excepcion de tipo NullPointerException");
        }
        catch (ClaveYaExistenteException e){
        	System.out.printf("agregarAlumno_3:Se ha lanzado una excepción, "+e.getMessage()+"\n");
        	fail("agregarAlumno_3:Deberia haber arrojado una excepcion de tipo NullPointerException");
        }
        catch (NullPointerException e){
        	//esto es lo que deberia pasar
        	System.out.printf("agregarAlumno_3:Se ha lanzado una NullPointerException\n");
        }
    }
	
	@Test
	public void agregarAlumno_4_1(){//{nulo,nulo,nulo}
        Alumno alumno = new Alumno(null,null,null);
        try
        {
        	//this.escenarioVacio.getSistema().
        	this.escenarioVacio.getSistema().agregarAlumno(alumno);
            fail("agregarAlumno_4_1:No se debería ejecutar esto, se debería lanzar una excepcion.");
        }
        catch (DatoInvalidoException e){ //esto es lo que deberia pasar
        	System.out.printf("agregarAlumno_4_1:Se ha lanzado una excepción, de tipo dato invalido, "+e.getMessage()+"\n");
        }
        catch (ClaveYaExistenteException e){
        	System.out.printf("agregarAlumno_4_1:Se ha lanzado una excepción, de tipo alumno ya existente, "+e.getMessage()+"\n");
        	fail("agregarAlumno_4_1:Deberia haber arrojado una excepcion de tipo DatoInvalidoException");
        }
        catch (NullPointerException e){
        	System.out.printf("agregarAlumno_4_1:Se ha lanzado una Null Pointer excepción\n");
        	fail("agregarAlumno_4_1:Deberia haber arrojado una excepcion de tipo DatoInvalidoException");
        }
	}
	
	@Test
	public void agregarAlumno_4_2(){//{nulo,nulo,""}
        Alumno alumno = new Alumno(null,null,"");
        try
        {
        	//this.escenarioVacio.getSistema().
        	this.escenarioVacio.getSistema().agregarAlumno(alumno);
            fail("agregarAlumno_4_2:No se debería ejecutar esto, se debería lanzar una excepcion.");
        }
        catch (DatoInvalidoException e){
        	System.out.printf("agregarAlumno_4_2:Se ha lanzado una excepción, de tipo dato invalido, "+e.getMessage()+"\n");
        }
        catch (ClaveYaExistenteException e){
        	System.out.printf("agregarAlumno_4_2:Se ha lanzado una excepción, de tipo alumno ya existente, "+e.getMessage()+"\n");
        	fail("agregarAlumno_4_2:Deberia haber arrojado una excepcion de tipo DatoInvalidoException");
        }
        catch (NullPointerException e){
        	System.out.printf("agregarAlumno_4_2:Se ha lanzado una Null Pointer excepción\n");
        	fail("agregarAlumno_4_2:Deberia haber arrojado una excepcion de tipo DatoInvalidoException");
        }
	}
}
