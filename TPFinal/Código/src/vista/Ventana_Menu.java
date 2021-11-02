package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero
 * Clase que extiende de la clase JFrame e implementa la interfaz IVista. Representa a la ventana del menú
 *
 */
public class Ventana_Menu extends JFrame implements IVistaMenu{
	private JPanel panelCentral;
	private JPanel panelIzq;
	private JPanel panelCentralizado;
	private JPanel panelMedico;
	private JPanel panelPacientes;
	private JPanel panelFacturacion;
	private JButton btnMedicos;
	private JButton btnPacientes;
	private JButton btnFacturacion;
	private JPanel panelMenu;
	private JLabel lblMenu;
	
	
	/**
	 * Constructor sin parámtros para setear la ventana menú
	 */
	public Ventana_Menu() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 600, 400);
		panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelIzq = new JPanel();
		panelCentral.add(panelIzq);
		
		panelCentralizado = new JPanel();
		panelCentral.add(panelCentralizado);
		panelCentralizado.setLayout(new GridLayout(3, 0, 0, 0));
		
		panelMedico = new JPanel();
		FlowLayout fl_panelMedico = (FlowLayout) panelMedico.getLayout();
		fl_panelMedico.setVgap(30);
		panelCentralizado.add(panelMedico);
		
		btnMedicos = new JButton("Medicos");
		this.btnMedicos.setActionCommand("Medico");
		panelMedico.add(btnMedicos);
		
		panelPacientes = new JPanel();
		FlowLayout fl_panelPacientes = (FlowLayout) panelPacientes.getLayout();
		fl_panelPacientes.setVgap(30);
		panelCentralizado.add(panelPacientes);
		
		btnPacientes = new JButton("Pacientes");
		this.btnPacientes.setActionCommand("Paciente");
		panelPacientes.add(btnPacientes);
		
		panelFacturacion = new JPanel();
		FlowLayout fl_panelFacturacion = (FlowLayout) panelFacturacion.getLayout();
		fl_panelFacturacion.setVgap(30);
		panelCentralizado.add(panelFacturacion);
		
		btnFacturacion = new JButton("Facturacion");
		this.btnFacturacion.setActionCommand("Facturacion");
		panelFacturacion.add(btnFacturacion);
		
		panelMenu = new JPanel();
		getContentPane().add(panelMenu, BorderLayout.NORTH);
		
		lblMenu = new JLabel("Menu principal");
		panelMenu.add(lblMenu);
		setVisible(true);
	}
	/**
	 * Método con un parámetro que agrega un action listener a los botones de Ambulancia, Asociados y Facturación<br>
	 * @param listener ActionListener que representa al listener que se le asignará a los distintos botones.
	 */
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnMedicos.addActionListener(listener);
		this.btnPacientes.addActionListener(listener);
		this.btnFacturacion.addActionListener(listener);
		
	}
	
	/**
	 * Método sin parámetro que se encargá de setear el Visible en false para que no se vea la pantalla al cerrar la ventana
	 */
	public void cerrar() {
		setVisible(false);
		dispose();
	}

}
