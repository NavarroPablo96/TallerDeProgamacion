package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.event.ItemEvent;
/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebastián Agüero.<br>
 *JFrame que representa la ventana de persistencia.Se extiende de JFrame e Implementa IVistaPersistencia.
 */
public class Ventana_Persistencia extends JFrame implements IVistaPersistencia{

	private JPanel contentPane;
	private JButton boton_Guardar;
	private JButton boton_Recuperar;
	private JComboBox<String> comboBox_Persistencias;
	private File archivo = null;
	
	/**
	 * Constructor sin parámetros que crea la ventana de persistencia.<br>
	 */
	public Ventana_Persistencia() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_General = new JPanel();
		contentPane.add(panel_General, BorderLayout.CENTER);
		panel_General.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_Superior = new JPanel();
		FlowLayout fl_panel_Superior = (FlowLayout) panel_Superior.getLayout();
		panel_General.add(panel_Superior);
		
		JPanel panel_comboBox = new JPanel();
		FlowLayout fl_panel_comboBox = (FlowLayout) panel_comboBox.getLayout();
		fl_panel_comboBox.setVgap(25);
		panel_Superior.add(panel_comboBox);
		
		comboBox_Persistencias = new JComboBox<String>();
	
		panel_comboBox.add(comboBox_Persistencias);
		comboBox_Persistencias.setMaximumRowCount(3);	
		comboBox_Persistencias.addItem("Pacientes");
		comboBox_Persistencias.addItem("Medicos");
		comboBox_Persistencias.addItem("Facturas");
		
		JPanel panel_Central = new JPanel();
		FlowLayout fl_panel_Central = (FlowLayout) panel_Central.getLayout();
		fl_panel_Central.setVgap(25);
		panel_General.add(panel_Central);
		
		boton_Guardar = new JButton("Guardar");
		boton_Guardar.setMargin(new Insets(5, 20, 5, 20));
		panel_Central.add(boton_Guardar);
		boton_Guardar.setActionCommand("Guardar");
		
		
		JPanel panel_Inferior = new JPanel();
		FlowLayout fl_panel_Inferior = (FlowLayout) panel_Inferior.getLayout();
		fl_panel_Inferior.setVgap(25);
		panel_General.add(panel_Inferior);
		
		this.boton_Recuperar = new JButton("Recuperar");
		boton_Recuperar.setEnabled(false);
		boton_Recuperar.setMargin(new Insets(5, 17, 5, 17));
		panel_Inferior.add(boton_Recuperar);
		boton_Recuperar.setActionCommand("Recuperar");

		habilitaBotonRecuperar();
		
		comboBox_Persistencias.addItemListener(new ItemListener() {
			//método interno del constructor, se encarga de comprobar en tiempo de ejecución 
			//si el combobox cambio de item.
			public void itemStateChanged(ItemEvent e) {
				habilitaBotonRecuperar();
			}
		});
		
		boton_Guardar.addActionListener(new ActionListener() {
			//método interno del constructor, al apretar el boton "guardar" muestra un mensaje
			//de confirmación.
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(boton_Guardar, "Se guardó el archivo");
			}
		});
		
		boton_Recuperar.addActionListener(new ActionListener() {
			//método interno del constructor, al apretar el boton "recuperar" muestra un mensaje
			//de confirmación.
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(boton_Guardar, "Se recuperó el archivo");
			}
		});
		setVisible(true);
	}
	
	
	/**
	 * Método que habilita o dehabilita el boton recuperar, en función de la existencia del archivo
	 * correspondiente en la carpeta del proyecto segun combobox<br>
	 * 
	 */
	public void habilitaBotonRecuperar(){
		archivo = new File(((String) (comboBox_Persistencias.getSelectedItem())).concat(".dat"));
		if(archivo.exists())
			boton_Recuperar.setEnabled(true);
		else 
			boton_Recuperar.setEnabled(false);	
	}
	
    /**
	 * Método que agrega un actionListener a todos los componentes.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * @param actionListener: Parámetro de tipo ActionListener 
	 * que se encarga de escuchar los eventos de la ventana.
	 */
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.boton_Guardar.addActionListener(actionListener);
		this.boton_Recuperar.addActionListener(actionListener);
		this.comboBox_Persistencias.addActionListener(actionListener);
	}
	

    /**
	 * Método que devuelve el item seleccionado del comboBox, en formato String<br>
	 * @return devuelve el nombre del item que representa el tipo de dato del archivo que se 
	 * quiere guardar o recuperar. El cual puede ser "Pacientes", "Medicos" o "Facturas"
	 */
	@Override
	public String getMesajePersistencia() {
		return (String)comboBox_Persistencias.getSelectedItem();
	}
	
	

}
