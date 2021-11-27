package testGUI;

import controlador.Controlador;
import vista.Interfaz;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuiTestEnabledDisabled
{
    Robot robot;
    Controlador controlador;
    Interfaz ventana;

    public GuiTestEnabledDisabled()
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
    }

    @After
    public void tearDown() throws Exception
    {
        this.ventana.setVisible(false);
    }

    @Test
    public void testVacios()
    {
    	//obtengo las referencias a los componentes necesarios
    	JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
    	//verifico los resultados
    	Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }

    //Pruebas de un solo componente ingresado:
    
    @Test
    public void testSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }

    
    @Test
    public void testSoloApellido()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    @Test
    public void testSoloDni()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("32132132", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }

    @Test
    public void testSoloDomicilio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    @Test
    public void testSoloTelefono()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("2234878788", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    @Test
    public void testSoloCiudad()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField ciudad = (JTextField) TestUtils.getComponentForName(ventana, "jtCiudadPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    
    //Pruebas que van agregando un componente a la vez:
    
    @Test
    public void testNombreApellido()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    @Test
    public void testNombreApellidoDni()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("36363636", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    @Test
    public void testNombreApellidoDniDomicilio()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("36363636", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    
    @Test
    public void testNombreApellidoDniDomicilioTelefono()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(ventana, "jtNombrePaciente");
        JTextField apellido = (JTextField) TestUtils.getComponentForName(ventana, "jtApellidoPaciente");
        JTextField dni = (JTextField) TestUtils.getComponentForName(ventana, "jtDniPaciente");
        JTextField domicilio = (JTextField) TestUtils.getComponentForName(ventana, "jtDomicilioPaciente");
        JTextField telefono = (JTextField) TestUtils.getComponentForName(ventana, "jtTelefonoPaciente");
        JButton agregar = (JButton) TestUtils.getComponentForName(ventana, "btnAgregarPaciente");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Seba", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(apellido, robot);
        TestUtils.tipeaTexto("Lalalala", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(dni, robot);
        TestUtils.tipeaTexto("36363636", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("65656565", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de registro deberia estar deshablitado", agregar.isEnabled());
    }
    
    
    @Test
    public void testNombreApellidoDniDomicilioTelefonoCiudad()
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
        TestUtils.tipeaTexto("36363636", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(domicilio, robot);
        TestUtils.tipeaTexto("Colon 1", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(telefono, robot);
        TestUtils.tipeaTexto("65656565", robot);
        robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(ciudad, robot);
        TestUtils.tipeaTexto("Mar del Plata", robot);
        robot.delay(TestUtils.getDelay());
        //verifico los resultados
        Assert.assertTrue("El boton de registro deberia estar hablitado", agregar.isEnabled());
    }
    
    
//    
//    
//    //-----------------
//
//    @Test
//    public void testRegSoloContrasena()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField contra =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(contra, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//    @Test
//    public void testRegSoloConfirma()
//    {
//        robot.delay(TestUtils.getDelay());
//        JTextField confirma =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(confirma, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//    @Test
//    public void testRegTresLlenos()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
//        JTextField confirma =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
//        JTextField contra =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
//
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(nombre, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        TestUtils.clickComponent(contra, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        TestUtils.clickComponent(confirma, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertTrue("El boton de registro deberia estar hablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//    @Test
//    public void testRegSinConfirma()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
//        JTextField contra =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(nombre, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        TestUtils.clickComponent(contra, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//    @Test
//    public void testRegSinContrasena()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
//        JTextField confirma =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//
//        //lleno los JTextField
//        TestUtils.clickComponent(nombre, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        TestUtils.clickComponent(confirma, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//
//    @Test
//    public void testRegSinNombre()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField contra =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
//        JTextField confirma =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(contra, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        TestUtils.clickComponent(confirma, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//
//    @Test
//    public void testLogSoloNombre()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(nombre, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//    @Test
//    public void testLogSoloContra()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField contrasena =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(contrasena, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
//    }
//
//    @Test
//    public void testLogLleno()
//    {
//        robot.delay(TestUtils.getDelay());
//        //obtengo las referencias a los componentes necesarios
//        JTextField contrasena =
//            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
//        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
//        JButton aceptarReg = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
//        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
//        //lleno los JTextField
//        TestUtils.clickComponent(nombre, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        TestUtils.clickComponent(contrasena, robot);
//        TestUtils.tipeaTexto("hola", robot);
//        //verifico los resultados
//        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarReg.isEnabled());
//        Assert.assertTrue("El boton de login deberia estar hablitado", aceptarLog.isEnabled());
//    }
}