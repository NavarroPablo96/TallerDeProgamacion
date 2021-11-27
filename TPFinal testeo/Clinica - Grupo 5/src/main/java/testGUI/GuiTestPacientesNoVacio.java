package testGUI;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import factory.PacienteFactory;
import modelo.Clinica;
import modelo.Paciente;
import vista.Interfaz;

public class GuiTestPacientesNoVacio {

	Robot robot;
    Controlador controlador;
    Interfaz ventana;
    

    public GuiTestPacientesNoVacio()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        Paciente nuevo = PacienteFactory.getPaciente("Seba", "Lalala", "12345678", "Colon 1", "Mar del plata", "1234567890", "Joven");
    	ventana = new Interfaz();
		this.controlador = new Controlador(ventana);
		ventana.setVisible(true);
		Clinica.getInstance().altaPaciente(nuevo);
    }

    @After
    public void tearDown() throws Exception
    {
    	this.ventana.setVisible(false);
    	Clinica.getInstance().setPacientes(new HashMap<String, Paciente>());
    }

    @Test
    public void testCantidad()
    {
        Assert.assertEquals("Deberia haber 0 pacientes en la clinica", 1, Clinica.getInstance().getPacientes().size());
    }
    
    @Test
    public void testAgregaOk()
    {
    	robot.delay(TestUtils.getDelay());
    	int cantidad = Clinica.getInstance().getPacientes().size();
        int cantidadActual;
        Paciente nuevo = PacienteFactory.getPaciente("Ivo", "Nananana", "87654321", "Colon 2", "Mar del plataaa", "12345678901", "Ninio");
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto(nuevo.getNombre(), robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto(nuevo.getApellido(), robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto(nuevo.getDni(), robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto(nuevo.getDomicilio(), robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto(nuevo.getTelefono(), robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto(nuevo.getCiudad(), robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        cantidadActual = Clinica.getInstance().getPacientes().size();
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("Deberia haber un paciente mas que antes en la clinica.", cantidad + 1, cantidadActual);
        Assert.assertEquals("El apellido del paciente es incorrecto.", nuevo.getApellido(), Clinica.getInstance().getPacientes().get(nuevo.getDni()).getApellido());
        Assert.assertEquals("El dni del paciente es incorrecto.", nuevo.getDni(), Clinica.getInstance().getPacientes().get(nuevo.getDni()).getDni());
        Assert.assertEquals("El domicilio del paciente es incorrecto.", nuevo.getDomicilio(), Clinica.getInstance().getPacientes().get(nuevo.getDni()).getDomicilio());
        Assert.assertEquals("El telefono del paciente es incorrecto.", nuevo.getTelefono(), Clinica.getInstance().getPacientes().get(nuevo.getDni()).getTelefono());
        Assert.assertEquals("El ciudad del paciente es incorrecto.", nuevo.getCiudad(), Clinica.getInstance().getPacientes().get(nuevo.getDni()).getCiudad());
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    

    @Test
    public void testPacienteRepetido()
    {
        robot.delay(TestUtils.getDelay());
//        Paciente nuevo = PacienteFactory.getPaciente("Seba", "Lalala", "12345678", "Colon 1", "Mar del plata", "1234567890", "Joven");
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("12345678", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("1234567890", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber agregado un paciente que ya estaba registrado en la clinica", 1, Clinica.getInstance().getPacientes().size());
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
}
