package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Clinica;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana_Persistencia extends JFrame implements IVistaPersistencia{

	private JPanel contentPane;
	private JButton boton_Guardar;
	private JButton boton_Recuperar;
	private JComboBox<String> comboBox_Persistencias;
	private File archivo = null;

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
		
		//Cositas que estoy agregando. Funciona para el primero. Chequea si existe la lista o no para el primero del comboBox
//		archivo = new File(((String) (comboBox_Persistencias.getSelectedItem())).concat(".dat"));
//		if(archivo.exists())
//			boton_Recuperar.setEnabled(true);
		habilitaBotonRecuperar();
		
		comboBox_Persistencias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				habilitaBotonRecuperar();
			}
		});
		
		boton_Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(boton_Guardar, "Se guardó el archivo");
			}
		});
		
		boton_Recuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(boton_Guardar, "Se recuperó el archivo");
			}
		});
		
		setVisible(true);
		
	}
	
	
	public void habilitaBotonRecuperar(){
		archivo = new File(((String) (comboBox_Persistencias.getSelectedItem())).concat(".dat"));
		if(archivo.exists())
			boton_Recuperar.setEnabled(true);
		else 
			boton_Recuperar.setEnabled(false);	
	}
	
	
	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
//		this.actionListener = actionListener;
		this.boton_Guardar.addActionListener(actionListener);
		this.boton_Recuperar.addActionListener(actionListener);
		this.comboBox_Persistencias.addActionListener(actionListener);
	}
	


	@Override
	public String getMesajePersistencia() {
		return (String)comboBox_Persistencias.getSelectedItem();
	}
	
	

}
