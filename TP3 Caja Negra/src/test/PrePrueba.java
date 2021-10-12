package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Alumno;
import modelo.IndiceDoble;
import modelo.Sistema;

public class PrePrueba {
	Sistema SistemaPGA = new Sistema();
    IndiceDoble<Alumno> ColectAlumnos;
    IndiceDoble<Alumno> TestColectAlumnos;

    public PrePrueba(){
    }
    
    @Before
    public void setUpEscenarioUno() throws Exception {
        ColectAlumnos = new IndiceDoble<Alumno>();
    }
    
    @After
    public void tearDown() throws Exception {
        TestColectAlumnos = null;
        ColectAlumnos = null;
    }
    
	@Test
	public void AgregarListaVacia() {
		Alumno alum1 = new Alumno("Alberto", "JUnit 2345", "alberto@gmail.com");
		try {
            SistemaPGA.agregarAlumno(alum1);
        }
        catch (Exception ex){
        	fail("En este caso no hay excepción");
        }
		//fail("Not yet implemented");
		TestColectAlumnos = SistemaPGA.getAlumnos();
		assertTrue("No agregó y tenía que hacerlo!", TestColectAlumnos.contieneValor(alum1));
	}

  @Test
  public void AgregarListaConUnAlumno() {
      	Alumno alum1 = new Alumno("Alberto", "JUnit 2345", "alberto@gmail.com");
      	SistemaPGA.setAlumnos(ColectAlumnos);
      	try {
          	SistemaPGA.agregarAlumno(alum1);
      	}
      	catch(Exception ex){
          	fail("En este caso no hay excepción.");
      	}
      
      	Alumno alum2 = new Alumno("Roberto", "Suipacha 2767", "roberto@gmail.com");
      	try {
          	SistemaPGA.agregarAlumno(alum2);
      	}
      	catch (Exception ex){
          	fail("En este caso no hay excepción");
      	}
      	TestColectAlumnos = SistemaPGA.getAlumnos();
      	assertTrue("No agregó y tenía que hacerlo", TestColectAlumnos.contieneValor(alum2) & TestColectAlumnos.contieneValor(alum1)); 
  	}
	
  	@Test
  	public void AgregarListaConDosAlumnos() {
  		Alumno alum1 = new Alumno("Alberto", "JUnit 2345", "alberto@gmail.com");
  		Alumno alum2 = new Alumno("Roberto", "Suipacha 2767", "roberto@gmail.com");
  		SistemaPGA.setAlumnos(ColectAlumnos);
  		try {
  			SistemaPGA.agregarAlumno(alum1);
  			SistemaPGA.agregarAlumno(alum2);
  		}
  		catch (Exception ex){
  			fail("En este caso no hay excepción");
  		}
  		Alumno alum3 = new Alumno("Jose", "Maipú 4567", "jose@hotmail.com");
  		try {
  			SistemaPGA.agregarAlumno(alum3);
  		}
  		catch (Exception ex) {
  			fail("En este caso no hay excepción");
  		}
  		TestColectAlumnos = SistemaPGA.getAlumnos();
  		boolean Salida = TestColectAlumnos.contieneValor(alum1) & TestColectAlumnos.contieneValor(alum2) & TestColectAlumnos.contieneValor(alum3);
  		assertTrue("No agregó y tenía que hacerlo!", Salida);
  	}
  
}
