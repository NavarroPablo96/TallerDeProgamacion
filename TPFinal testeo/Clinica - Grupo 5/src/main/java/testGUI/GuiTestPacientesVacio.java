package testGUI;

import controlador.Controlador;
import factory.PacienteFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JTextField;

import modelo.Clinica;
import modelo.Paciente;
import vista.Interfaz;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuiTestPacientesVacio
{
    Robot robot;
    Controlador controlador;
    Interfaz ventana;

    public GuiTestPacientesVacio()
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
    	ventana = new Interfaz();
		this.controlador = new Controlador(ventana);
		ventana.setVisible(true);
		Clinica.getInstance();
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
        Assert.assertEquals("Deberia haber 0 pacientes en la clinica", 0, Clinica.getInstance().getPacientes().size());
    }


    @Test
    public void testAgregaOk()
    {
        robot.delay(TestUtils.getDelay());
        Paciente nuevo = PacienteFactory.getPaciente("Seba", "Lalala", "12345678", "Colon 1", "Mar del plata", "1234567890", "Joven");
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
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
        //verifico los resultados
        Assert.assertEquals("Deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 1);
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
    public void testDniMenosDe8()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("1234567", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    
    @Test
    public void testDniMasDe10()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("12345678901", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    
    @Test
    public void testDniNoNumero()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("asdasdasd", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    @Test
    public void testNombreConNumero()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456789", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    @Test
    public void testApellidoConNumero()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456789", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    
    @Test
    public void testCiudadConNumero()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456789", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    
    @Test
    public void testTelefonoConLetra()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456789", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565656565a", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    
    @Test
    public void testTelefonoMenosDe9()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456789", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("6565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
    
    @Test
    public void testTelefonoMasDe16()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("123456789", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("656565656565656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(agregar, robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertEquals("No deberia haber un paciente en la clinica", Clinica.getInstance().getPacientes().size(), 0);
        robot.delay(TestUtils.getDelay());
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(TestUtils.getDelay());
    }
    
}