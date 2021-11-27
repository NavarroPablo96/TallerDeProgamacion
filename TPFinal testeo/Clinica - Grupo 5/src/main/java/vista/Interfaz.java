package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import excepciones.MismoDniExcepcion;
import modelo.Paciente;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

/**
 * @author JUEGOS
 *
 */
/**
 * @author JUEGOS
 *
 */
public class Interfaz extends JFrame implements KeyListener{

	private JPanel panelPrincipal;
	private JTextField textFieldNombreMedico;
	private JTextField textFieldApellidoMedico;
	private JTextField textFieldDNIMedico;
	private JTextField textFieldDomicilioMedico;
	private JTextField textFieldCiudadMedico;
	private JTextField textFieldTelefonoMedico;
	private JTextField textFieldSueldoBaseMedico;
	private JTextField textFieldNombrePaciente;
	private JTextField textFieldApellidoPaciente;
	private JTextField textFieldDNIPaciente;
	private JTextField textFieldDomicilioPaciente;
	private JTextField textFieldTelefonoPaciente;
	private JTextField textFieldCiudadPaciente;
	private JTextField textFieldDiaInicial;
	private JTextField textFieldMesInicial;
	private JTextField textFieldAnioInicial;
	private JTextField textFieldDiaFinal;
	private JTextField textFieldMesFinal;
	private JTextField textFieldAnioFinal;
	private JButton btnAgregarPaciente;
	private Controlador controlador;
	private JButton btnAgregarMedico;
	private JButton btnMostrarFacturas;
	
	
	
	
	
	private JRadioButton rdbtnNinio;
	private JRadioButton rdbtnJoven;
	private JRadioButton rdbtnMayor;
	private JRadioButton rdbtnClinico;
	private JRadioButton rdbtnCirujano;
	private JRadioButton rdbtnPediatra;
	private JRadioButton rdbtnDoctor;
	private JRadioButton rdbtnMagister;
	private JRadioButton rdbtnResidente;
	private JRadioButton rdbtnPermanente;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Constructor de la vista principal
	 */
	
	
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelPacientes = new JPanel();
		tabbedPane.addTab("Pacientes", null, panelPacientes, null);
		panelPacientes.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("PACIENTES");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelPacientes.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panelPacientes.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(4, 5, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		
		JLabel lblNombrePaciente = new JLabel("Nombre");
		panel_8.add(lblNombrePaciente);
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		
		textFieldNombrePaciente = new JTextField();
		this.textFieldNombrePaciente.addKeyListener(this);
		panel_9.add(textFieldNombrePaciente);
		textFieldNombrePaciente.setColumns(10);
		this.textFieldNombrePaciente.setName("jtNombrePaciente");
		
		JPanel panel_30 = new JPanel();
		panel_7.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_7.add(panel_31);
		
		JLabel lblApellidoPaciente = new JLabel("Apellido");
		panel_31.add(lblApellidoPaciente);
		
		JPanel panel_32 = new JPanel();
		panel_7.add(panel_32);
		
		textFieldApellidoPaciente = new JTextField();
		this.textFieldApellidoPaciente.addKeyListener(this);
		panel_32.add(textFieldApellidoPaciente);
		textFieldApellidoPaciente.setColumns(10);
		this.textFieldApellidoPaciente.setName("jtApellidoPaciente");
		
		JPanel panel_33 = new JPanel();
		panel_7.add(panel_33);
		
		JLabel lblDNIPaciente = new JLabel("DNI");
		panel_33.add(lblDNIPaciente);
		
		JPanel panel_34 = new JPanel();
		panel_7.add(panel_34);
		
		textFieldDNIPaciente = new JTextField();
		this.textFieldDNIPaciente.addKeyListener(this);
		panel_34.add(textFieldDNIPaciente);
		textFieldDNIPaciente.setColumns(10);
		this.textFieldDNIPaciente.setName("jtDniPaciente");
		
		JPanel panel_35 = new JPanel();
		panel_7.add(panel_35);
		
		JPanel panel_36 = new JPanel();
		panel_7.add(panel_36);
		
		JLabel lblDomicilioPaciente = new JLabel("Domicilio");
		panel_36.add(lblDomicilioPaciente);
		
		JPanel panel_37 = new JPanel();
		panel_7.add(panel_37);
		
		textFieldDomicilioPaciente = new JTextField();
		this.textFieldDomicilioPaciente.addKeyListener(this);
		panel_37.add(textFieldDomicilioPaciente);
		textFieldDomicilioPaciente.setColumns(10);
		this.textFieldDomicilioPaciente.setName("jtDomicilioPaciente");
		
		JPanel panel_38 = new JPanel();
		panel_7.add(panel_38);
		
		JLabel lblTelefonoPaciente = new JLabel("Telefono");
		panel_38.add(lblTelefonoPaciente);
		
		JPanel panel_39 = new JPanel();
		panel_7.add(panel_39);
		
		textFieldTelefonoPaciente = new JTextField();
		this.textFieldTelefonoPaciente.addKeyListener(this);
		panel_39.add(textFieldTelefonoPaciente);
		textFieldTelefonoPaciente.setColumns(10);
		this.textFieldTelefonoPaciente.setName("jtTelefonoPaciente");

		
		JPanel panel_40 = new JPanel();
		panel_7.add(panel_40);
		
		JPanel panel_41 = new JPanel();
		panel_7.add(panel_41);
		
		JLabel lblCiudadPaciente = new JLabel("Ciudad");
		panel_41.add(lblCiudadPaciente);
		
		JPanel panel_42 = new JPanel();
		panel_7.add(panel_42);
		
		textFieldCiudadPaciente = new JTextField();
		this.textFieldCiudadPaciente.addKeyListener(this);
		panel_42.add(textFieldCiudadPaciente);
		textFieldCiudadPaciente.setColumns(10);
		this.textFieldCiudadPaciente.setName("jtCiudadPaciente");

		
		JPanel panel_43 = new JPanel();
		panel_7.add(panel_43);
		panel_43.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRangoEtario = new JLabel("Rango Etario");
		lblRangoEtario.setHorizontalAlignment(SwingConstants.CENTER);
		panel_43.add(lblRangoEtario);
		
		JPanel panel_44 = new JPanel();
		panel_7.add(panel_44);
		panel_44.setBounds(100, 100, 100, 100);
		panel_44.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnNinio = new JRadioButton("Ninio");
		rdbtnNinio.setSelected(true);
		panel_44.add(rdbtnNinio);
		this.rdbtnNinio.setName("rbNinioPaciente");

		
		rdbtnJoven = new JRadioButton("Joven");
		panel_44.add(rdbtnJoven);
		this.rdbtnJoven.setName("rbJovenPaciente");
		
		rdbtnMayor = new JRadioButton("Mayor");
		panel_44.add(rdbtnMayor);
		this.rdbtnMayor.setName("rbMayorPaciente");
		
		
		ButtonGroup rangoEtario = new ButtonGroup();
		rangoEtario.add(rdbtnNinio);
		rangoEtario.add(rdbtnJoven);
		rangoEtario.add(rdbtnMayor);
		
		
		JLabel label = new JLabel("");
		panel_44.add(label);
		
		JPanel panel_45 = new JPanel();
		panel_7.add(panel_45);
		
		JPanel panel_46 = new JPanel();
		panel_7.add(panel_46);
		
		btnAgregarPaciente = new JButton("AGREGAR");
		btnAgregarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPaciente();
			}
		});
		btnAgregarPaciente.addKeyListener(this);
		btnAgregarPaciente.setEnabled(false);
		this.btnAgregarPaciente.setName("btnAgregarPaciente");
		
		panel_46.add(btnAgregarPaciente);
		
		JPanel panel_47 = new JPanel();
		panel_7.add(panel_47);
		
		btnAgregarMedico = new JButton("AGREGAR");
		btnAgregarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarMedico();
			}
		});
		btnAgregarMedico.setEnabled(false);
		btnAgregarMedico.addKeyListener(this);
		
		
		
		JPanel panelMedicos = new JPanel();
		tabbedPane.addTab("Medicos", null, panelMedicos, null);
		panelMedicos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("MEDICOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelMedicos.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panelMedicos.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JLabel lblNombreMedico = new JLabel("Nombre");
		panel_11.add(lblNombreMedico);
		lblNombreMedico.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		textFieldNombreMedico = new JTextField();
		this.textFieldNombreMedico.addKeyListener(this);
		
		panel_10.add(textFieldNombreMedico);
		textFieldNombreMedico.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_20 = new JPanel();
		panel.add(panel_20);
		
		JLabel lblApellidoMedico = new JLabel("Apellido");
		panel_20.add(lblApellidoMedico);
		lblApellidoMedico.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_25 = new JPanel();
		panel.add(panel_25);
		
		textFieldApellidoMedico = new JTextField();
		this.textFieldApellidoMedico.addKeyListener(this);
		
		panel_25.add(textFieldApellidoMedico);
		textFieldApellidoMedico.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JLabel lblDNIMedico = new JLabel("DNI");
		panel_12.add(lblDNIMedico);
		lblDNIMedico.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		textFieldDNIMedico = new JTextField();
		this.textFieldDNIMedico.addKeyListener(this);
		
		panel_13.add(textFieldDNIMedico);
		textFieldDNIMedico.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_21 = new JPanel();
		panel.add(panel_21);
		
		JLabel lblDomicilioMedico = new JLabel("Domicilio");
		panel_21.add(lblDomicilioMedico);
		lblDomicilioMedico.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_26 = new JPanel();
		panel.add(panel_26);
		
		textFieldDomicilioMedico = new JTextField();
		this.textFieldDomicilioMedico.addKeyListener(this);
		
		panel_26.add(textFieldDomicilioMedico);
		textFieldDomicilioMedico.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		panel_14.add(lblCiudad);
		lblCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17);
		
		textFieldCiudadMedico = new JTextField();
		this.textFieldCiudadMedico.addKeyListener(this);
		panel_17.add(textFieldCiudadMedico);
		textFieldCiudadMedico.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_22 = new JPanel();
		panel.add(panel_22);
		
		JLabel lblTelefono = new JLabel("Telefono");
		panel_22.add(lblTelefono);
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_27 = new JPanel();
		panel.add(panel_27);
		
		textFieldTelefonoMedico = new JTextField();
		this.textFieldTelefonoMedico.addKeyListener(this);
		
		panel_27.add(textFieldTelefonoMedico);
		textFieldTelefonoMedico.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		
		JLabel lblSueldoBase = new JLabel("Sueldo Base");
		panel_15.add(lblSueldoBase);
		lblSueldoBase.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_18 = new JPanel();
		panel.add(panel_18);
		
		textFieldSueldoBaseMedico = new JTextField();
		this.textFieldSueldoBaseMedico.addKeyListener(this);
		
		panel_18.add(textFieldSueldoBaseMedico);
		textFieldSueldoBaseMedico.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JPanel panel_23 = new JPanel();
		panel.add(panel_23);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		panel_23.add(lblEspecialidad);
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_28 = new JPanel();
		panel.add(panel_28);
		
		rdbtnClinico = new JRadioButton("Clinico");
		rdbtnClinico.setSelected(true);
		panel_28.add(rdbtnClinico);
		
		rdbtnCirujano = new JRadioButton("Cirujano");
		panel_28.add(rdbtnCirujano);
		
		rdbtnPediatra = new JRadioButton("Pediatra");
		panel_28.add(rdbtnPediatra);
		
		
		ButtonGroup especialidad = new ButtonGroup();
		especialidad.add(rdbtnClinico);
		especialidad.add(rdbtnCirujano);
		especialidad.add(rdbtnPediatra);
		
		
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16);
		
		JLabel lblPosgrado = new JLabel("Posgrado");
		panel_16.add(lblPosgrado);
		lblPosgrado.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_19 = new JPanel();
		panel.add(panel_19);
		
		rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setSelected(true);
		panel_19.add(rdbtnDoctor);
		
		rdbtnMagister = new JRadioButton("Magister");
		panel_19.add(rdbtnMagister);
		
		
		ButtonGroup posgrado = new ButtonGroup();
		posgrado.add(rdbtnDoctor);
		posgrado.add(rdbtnMagister);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JPanel panel_24 = new JPanel();
		panel.add(panel_24);
		
		JLabel lblContratacion = new JLabel("Contratacion");
		panel_24.add(lblContratacion);
		lblContratacion.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_29 = new JPanel();
		panel.add(panel_29);
		
		rdbtnResidente = new JRadioButton("Residente");
		rdbtnResidente.setSelected(true);
		panel_29.add(rdbtnResidente);
		
		rdbtnPermanente = new JRadioButton("Permanente");
		panel_29.add(rdbtnPermanente);
		
		
		
		ButtonGroup contratacion = new ButtonGroup();
		contratacion.add(rdbtnResidente);
		contratacion.add(rdbtnPermanente);
		
		
		
		JPanel panelSur = new JPanel();
		panelMedicos.add(panelSur, BorderLayout.SOUTH);
		

		panelSur.add(btnAgregarMedico);
		
		
		JPanel panelFactura = new JPanel();
		tabbedPane.addTab("Factura", null, panelFactura, null);
		panelFactura.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("FACTURAS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelFactura.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panelFactura.add(panel_6, BorderLayout.SOUTH);
		
		JPanel panel_48 = new JPanel();
		panelFactura.add(panel_48, BorderLayout.CENTER);
		panel_48.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_49 = new JPanel();
		panel_48.add(panel_49);
		
		JPanel panel_50 = new JPanel();
		panel_48.add(panel_50);
		
		JPanel panel_51 = new JPanel();
		panel_48.add(panel_51);
		
		JPanel panel_52 = new JPanel();
		panel_48.add(panel_52);
		panel_52.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFechaInicial = new JLabel("FECHA INICIAL");
		lblFechaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaInicial.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_52.add(lblFechaInicial);
		
		JPanel panel_53 = new JPanel();
		panel_48.add(panel_53);
		
		JPanel panel_54 = new JPanel();
		panel_48.add(panel_54);
		panel_54.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFechaFinal = new JLabel("FECHA FINAL");
		lblFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFechaFinal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_54.add(lblFechaFinal, BorderLayout.CENTER);
		
		JPanel panel_55 = new JPanel();
		panel_48.add(panel_55);
		panel_55.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblDiaInicial = new JLabel("DIA");
		
		lblDiaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		panel_55.add(lblDiaInicial);
		
		JPanel panel_64 = new JPanel();
		panel_55.add(panel_64);
		
		textFieldDiaInicial = new JTextField();
		this.textFieldDiaInicial.addKeyListener(this);
		panel_64.add(textFieldDiaInicial);
		textFieldDiaInicial.setColumns(10);
		
		JLabel lblMesInicial = new JLabel("MES");
		lblMesInicial.setHorizontalAlignment(SwingConstants.CENTER);
		panel_55.add(lblMesInicial);
		
		JPanel panel_65 = new JPanel();
		panel_55.add(panel_65);
		
		textFieldMesInicial = new JTextField();
		this.textFieldMesInicial.addKeyListener(this);
		panel_65.add(textFieldMesInicial);
		textFieldMesInicial.setColumns(10);
		
		JLabel lblAnioInicial = new JLabel("A\u00D1O");
		lblAnioInicial.setHorizontalAlignment(SwingConstants.CENTER);
		panel_55.add(lblAnioInicial);
		
		JPanel panel_66 = new JPanel();
		panel_55.add(panel_66);
		
		textFieldAnioInicial = new JTextField();
		this.textFieldAnioInicial.addKeyListener(this);
		panel_66.add(textFieldAnioInicial);
		textFieldAnioInicial.setColumns(10);
		
		JPanel panel_56 = new JPanel();
		panel_48.add(panel_56);
		
		JPanel panel_57 = new JPanel();
		panel_48.add(panel_57);
		panel_57.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblDiaFinal = new JLabel("DIA");
		lblDiaFinal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_57.add(lblDiaFinal);
		
		JPanel panel_67 = new JPanel();
		panel_57.add(panel_67);
		
		textFieldDiaFinal = new JTextField();
		this.textFieldDiaFinal.addKeyListener(this);
		panel_67.add(textFieldDiaFinal);
		textFieldDiaFinal.setColumns(10);
		
		JLabel lblMesFinal = new JLabel("MES");
		lblMesFinal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_57.add(lblMesFinal);
		
		JPanel panel_69 = new JPanel();
		panel_57.add(panel_69);
		
		textFieldMesFinal = new JTextField();
		this.textFieldMesFinal.addKeyListener(this);
		panel_69.add(textFieldMesFinal);
		textFieldMesFinal.setColumns(10);
		
		JLabel lblAnioFinal = new JLabel("A\u00D1O");
		lblAnioFinal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_57.add(lblAnioFinal);
		
		JPanel panel_68 = new JPanel();
		panel_57.add(panel_68);
		
		textFieldAnioFinal = new JTextField();
		this.textFieldAnioFinal.addKeyListener(this);
		panel_68.add(textFieldAnioFinal);
		textFieldAnioFinal.setColumns(10);
		
		JPanel panel_58 = new JPanel();
		panel_48.add(panel_58);
		
		JPanel panel_59 = new JPanel();
		panel_48.add(panel_59);
		panel_59.setLayout(new BorderLayout(0, 0));
		
		btnMostrarFacturas = new JButton("Mostrar Facturas");
		
		btnMostrarFacturas.setEnabled(false);
		this.btnMostrarFacturas.addKeyListener(this);
		
		panel_59.add(btnMostrarFacturas, BorderLayout.SOUTH);
		
		
		
		btnMostrarFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFacturas();
			}
		});
		
		JPanel panel_60 = new JPanel();
		panel_48.add(panel_60);
		
		JPanel panel_61 = new JPanel();
		panel_48.add(panel_61);
		
		JPanel panel_62 = new JPanel();
		panel_48.add(panel_62);
		
		JPanel panel_63 = new JPanel();
		panel_48.add(panel_63);
	}

	
	
	/**
	 * <b>POST:<b> Informa exito o fracaso de la adicion del medico.
	 * 
	 * Metodo que valida todos los campos de entrada de la pesta�a de medicos e invoca al metodo agregarMedico del controlador.
	 */
	
	protected void agregarMedico() {
		
		String DNI, nombre, apellido, domicilio, telefono, ciudad, sueldoBase, especialidad, posgrado, contratacion;
		double sueldoBaseDouble;
		
		DNI = this.getTextFieldDNIMedico();
		nombre = this.getTextFieldNombreMedico();
		apellido = this.getTextFieldApellidoMedico();
		domicilio = this.getTextFieldDomicilioMedico();
		telefono = this.getTextFieldTelefonoMedico();
		ciudad = this.getTextFieldCiudadMedico();
		sueldoBase = this.getTextFieldSueldoBase();
		especialidad = this.getEspecialidad();
		posgrado = this.getPosgrado();
		contratacion = this.getContratacion();
		

		
		if(!this.esNumero(DNI) )
			JOptionPane.showMessageDialog(null, "ERROR. El DNI debe estar compuesto solo por numeros.");
		else if( DNI.length() <8 || DNI.length()>10)
			JOptionPane.showMessageDialog(null, "ERROR. Verifique que el DNI este escrito correctamente.");
		else if(!this.esCadenaAlfabetica(nombre)   ||  !this.esCadenaAlfabetica(apellido) || !this.esCadenaAlfabetica(ciudad) )
			JOptionPane.showMessageDialog(null, "ERROR. Asegurese que el nombre, apellido y/o ciudad contegan caracteres validos.");
		else if(!esTelefonoValido(telefono))
			JOptionPane.showMessageDialog(null, "Numero de telefono invalido. Asegurese de ingresar caracteristica del pais, prefijo, no incluir el 15. Verifique que solo contenga numeros.");
		else if(!this.esNumero(sueldoBase))
			JOptionPane.showMessageDialog(null, "El sueldo base debe estar compuesto solo por numeros.");
		else {
			
		
			sueldoBaseDouble = Double.parseDouble(sueldoBase);
		
			if(sueldoBaseDouble<0 || !this.esNumero(sueldoBase))
				JOptionPane.showMessageDialog(null, "Sueldo base ingresado erroneo.");
			else {
			
				try {
					this.controlador.agregarMedico(nombre,apellido,DNI,domicilio,ciudad,telefono,sueldoBaseDouble,especialidad,posgrado,contratacion);
					JOptionPane.showMessageDialog(null, "El medico ha sido dado de alta exitosamente.");
				} catch (MismoDniExcepcion e) {
					JOptionPane.showMessageDialog(null, "ERROR. Ya existe un medico con el DNI ingresado.");
				}
			}	
		}
	}

	
	
	
	/**
	 * <b>POST:<b> Informa exito o fracaso del alta del paciente.
	 * 
	 * Metodo que valida todos los campos de entrada de la pesta�a de pacientes e invoca al metodo altaPaciente del controlador.
	 * 
	 */
	
	protected void altaPaciente() {
		
		String DNI, nombre, apellido, domicilio, telefono, ciudad, rangoEtario;
		
		
		
		DNI = this.getTextFieldDNIPaciente();
		nombre = this.getTextFieldNombrePaciente();
		apellido = this.getTextFieldApellidoPaciente();
		domicilio = this.getTextFieldDomicilioPaciente();
		telefono = this.getTextFieldTelefonoPaciente();
		ciudad = this.getTextFieldCiudadPaciente();
		rangoEtario = this.getRangoEtario();
		
		
		if(!this.esNumero(DNI) )
			JOptionPane.showMessageDialog(null, "ERROR. El DNI debe estar compuesto solo por numeros.");
		else if( DNI.length() <8 || DNI.length()>10)
			JOptionPane.showMessageDialog(null, "ERROR. Verifique que el DNI este escrito correctamente.");
		else if(!this.esCadenaAlfabetica(nombre)   ||  !this.esCadenaAlfabetica(apellido) || !this.esCadenaAlfabetica(ciudad) )
			JOptionPane.showMessageDialog(null, "ERROR. Asegurese que el nombre, apellido y/o ciudad contegan caracteres validos.");
		else if(!esTelefonoValido(telefono))
			JOptionPane.showMessageDialog(null, "Numero de telefono invalido. Asegurese de ingresar caracteristica del pais, prefijo, no incluir el 15. Verifique que solo contenga numeros.");
		else {
			
			try {
				
				this.controlador.altaPaciente(nombre,apellido,DNI,domicilio,ciudad,telefono,rangoEtario);
				JOptionPane.showMessageDialog(null, "El paciente ha sido dado de alta exitosamente.");
			} catch (MismoDniExcepcion e) {
				JOptionPane.showMessageDialog(null, "ERROR. Ya existe un paciente con el DNI ingresado.");
			}
			
			
		}
	}

	
	
	

	
	
	protected void mostrarFacturas() {
		
		int diaInicial = Integer.parseInt(this.textFieldDiaInicial.getText());
		int mesInicial = Integer.parseInt(this.textFieldMesInicial.getText());
		int anioInicial = Integer.parseInt(this.textFieldAnioInicial.getText());
		
		int diaFinal = Integer.parseInt(this.textFieldDiaFinal.getText());
		int mesFinal = Integer.parseInt(this.textFieldMesFinal.getText());
		int anioFinal = Integer.parseInt(this.textFieldAnioFinal.getText());
		
		if(!esNumero(textFieldDiaInicial.getText()) || !esNumero(textFieldMesInicial.getText()) || !esNumero(textFieldAnioInicial.getText()) || !esNumero(this.textFieldDiaFinal.getText()) || !esNumero(this.textFieldMesFinal.getText()) || !esNumero(this.textFieldAnioFinal.getText()) )
			JOptionPane.showMessageDialog(null, "ERROR. Asegurese de que todos los dias ingresados correspondan exclusivamente a numeros.");
		if(anioInicial<1900)
			JOptionPane.showMessageDialog(null, "El A\u00D1O incial ingresado es invalido. Debe ser a partir de 1900.");
		else if(anioFinal<1900)
			JOptionPane.showMessageDialog(null, "El A\u00D1O final ingresado es invalido. Debe ser a partir de 1900.");
		else if(mesInicial<1 || mesInicial>12)
			JOptionPane.showMessageDialog(null, "El mes inicial ingresado es invalido. Debe ser un mes comprendido entre 1 y 12.");
		else if(mesFinal<1 || mesFinal>12)
			JOptionPane.showMessageDialog(null, "El mes final ingresado es invalido. Debe ser un mes comprendido entre 1 y 12.");
		else if(!esDiaValido(diaInicial,mesInicial))
			JOptionPane.showMessageDialog(null, "El dia inicial es invalido ya que el mes "+mesInicial+" no tiene el dia "+diaInicial+".");
		else if(!esDiaValido(diaFinal,mesFinal))
			JOptionPane.showMessageDialog(null, "El dia final es invalido ya que el mes "+mesFinal+" no tiene "+diaFinal+" dias.");
		else if(anioInicial>anioFinal || (anioInicial==anioFinal && mesInicial>mesFinal)  ||     (anioInicial==anioFinal && mesInicial==mesFinal && diaInicial>diaFinal) )
			JOptionPane.showMessageDialog(null, "Las fechas son incoherentes. Asegurese de que la fecha inicial no sea posterior a la fecha final.");
		else
			this.controlador.muestraFacturaRangoFechas(diaInicial,mesInicial,anioInicial,diaFinal,mesFinal,anioFinal);
		
	}

	
	
	

	
	

	
	
	
	
	
	/**
	 * 
	 * @param <b>telefono:<b> Numero de telefono ingresado por el usuario 
	 * @return Devuelve falso en caso de ser un telefono invalido y verdadero n caso de ser un telefono valido.
	 * 
	 * Metodo que valida el numero de telefono ingresado por el usuario
	 */
	
	
	private boolean esTelefonoValido(String telefono) {
		
		int n,i;
		n = telefono.length();
		
		if(n<9 || n>16 || !this.esNumero(telefono))
			return false;
		else 
			return true;
		
	}

	
	
	
	/**
	 * 
	 * @param <b>dia:<b> Dia correspondiente a una fecha ingresado por el usuario
	 * @param <b>mes:<b> Mes correspondiente a una fecha ingresado por el usuario
	 * @return Devuelve falso en caso de ser un dia invalido y verdadero en caso de ser un dia valido.
	 * 
	 * Metodo que determina si el dia  pertenece al mes pasado por parametro.
	 * 
	 */
	
	private boolean esDiaValido(int dia, int mes) {
		if((mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12 ) && (dia<1 || dia>31) )
			return false;
		else if ((mes==4 || mes==6 || mes==9 || mes==11 ) && (dia<1 || dia>30))
			return false;
		else if(mes==2 && (dia<1 || dia>29))
			return false;
		else 
			return true;
	}

	
	
	
	/**
	 * 
	 * @param <b>texto<b>: Cadena de caracteres ingresada por el usuario
	 * @return  Devuelve falso si el parametro 'texto' contiene al menos un caracter que no corresponda a una letra alfabetica o un espacio y verdadero en caso contrario.
	 * 
	 * Metodo que se encarga de validar que una cadena de texto recibida por parametro este compuesta unicamente por letras alfabeticas y espacios.
	 */
	private boolean esCadenaAlfabetica(String texto) {
		
		int n,i;
		n = texto.length(); 
		i = 0;
		while(i<n && (texto.charAt(i)>=65 && texto.charAt(i)<=90 || texto.charAt(i)>=97 && texto.charAt(i)<=122 || texto.charAt(i)<=32) ) 
			i++;
		
		return i==n;
	}
	
	
	
	/**
	 * 
	 * @param <b>texto:<b> Cadena de caracteres ingresada por el usuario
	 * @return Devuelve falso si el parametro 'texto' contiene al menos un caracter que no corresponda a un numero del 0 al 9 y verdadero en caso contrario.
	 */
	
	private boolean esNumero(String texto){
		
		int n,i;
		n = texto.length(); 
		i = 0;
		while(i<n && texto.charAt(i)>=48 && texto.charAt(i)<=57)
			i++;
		
		return i==n;
	}
	
	
	
	
	
	
	
	
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	/**
	 * Metodo que se encarga de bloquear el boton "AGREGAR" correspondiente a la pesta�a de pacientes y de forma independiente hace lo mismo con el boton "AGREGAR" de la pesta�a de medicos siempre y cuando
	 * exista al menos un campo de la pesta�a que no contengan al menos un caracter ingresado. Basicamente valida que esten todos los campos requeridos llenos.
	 */
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		String DNI, nombre, apellido, domicilio, telefono, ciudad, sueldoBase;
		

		DNI = this.getTextFieldDNIPaciente();
		nombre = this.getTextFieldNombrePaciente();
		apellido = this.getTextFieldApellidoPaciente();
		domicilio = this.getTextFieldDomicilioPaciente();
		telefono = this.getTextFieldTelefonoPaciente();
		ciudad = this.getTextFieldCiudadPaciente();
	
		boolean condicion = !DNI.equals("")  && !nombre.equals("")   && !apellido.equals("")   && !domicilio.equals("")   && !telefono.equals("")   && !ciudad.equals("")  ;

		this.btnAgregarPaciente.setEnabled(condicion);
		
		
		
		DNI = this.getTextFieldDNIMedico();
		nombre = this.getTextFieldNombreMedico();
		apellido = this.getTextFieldApellidoMedico();
		domicilio = this.getTextFieldDomicilioMedico();
		telefono = this.getTextFieldTelefonoMedico();
		ciudad = this.getTextFieldCiudadMedico();
		sueldoBase = this.getTextFieldSueldoBase();
		
		condicion = !DNI.equals("")  && !nombre.equals("")   && !apellido.equals("")   && !domicilio.equals("")   && !telefono.equals("")   && !ciudad.equals("") && !sueldoBase.equals("") ;
		
		this.btnAgregarMedico.setEnabled(condicion);

		
		
		
		
		String diaInicial,mesInicial,anioInicial,diaFinal,mesFinal,anioFinal;
		
		
		diaInicial = this.getTextFieldDiaInicial();
		mesInicial = this.getTextFieldMesInicial();
		anioInicial = this.getTextFieldAnioInicial();
		diaFinal = this.getTextFieldDiaFinal();
		mesFinal = this.getTextFieldMesFinal();
		anioFinal = this.getTextFieldAnioFinal();
		
		condicion = !diaInicial.equals("")  && !mesInicial.equals("")   && !anioInicial.equals("")   && !diaFinal.equals("")   && !mesFinal.equals("")   && !anioFinal.equals("") ;
		
		this.btnMostrarFacturas.setEnabled(condicion);
		
		
	}

	
	
	
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}
	
	
	public String getTextFieldNombrePaciente() {
		return textFieldNombrePaciente.getText();
	}

	public String getTextFieldApellidoPaciente() {
		return textFieldApellidoPaciente.getText();
	}

	public String getTextFieldDNIPaciente() {
		return textFieldDNIPaciente.getText();
	}

	public String getTextFieldDomicilioPaciente() {
		return textFieldDomicilioPaciente.getText();
	}

	public String getTextFieldTelefonoPaciente() {
		return textFieldTelefonoPaciente.getText();
	}

	public String getTextFieldCiudadPaciente() {
		return textFieldCiudadPaciente.getText();
	}


	public String getRangoEtario() {
		if (this.rdbtnNinio.isSelected())
			return "Ninio";
		else if (this.rdbtnJoven.isSelected())
			return "Joven";
		else
			return "Mayor";
	}
	
	
	public String getTextFieldNombreMedico() {
		return textFieldNombreMedico.getText();
	}

	public String getTextFieldApellidoMedico() {
		return textFieldApellidoMedico.getText();
	}

	public String getTextFieldDNIMedico() {
		return textFieldDNIMedico.getText();
	}

	public String getTextFieldDomicilioMedico() {
		return textFieldDomicilioMedico.getText();
	}

	public String getTextFieldTelefonoMedico() {
		return textFieldTelefonoMedico.getText();
	}

	public String getTextFieldCiudadMedico() {
		return textFieldCiudadMedico.getText();
	}

	
	public String getTextFieldSueldoBase() {
		return textFieldSueldoBaseMedico.getText();
	}

	
	
	
	
	public String getEspecialidad() {
		if (this.rdbtnClinico.isSelected())
			return "Clinico";
		else if (this.rdbtnCirujano.isSelected())
			return "Cirujano";
		else
			return "Pediatra";
	}
	
	
	
	public String getPosgrado() {
		if (this.rdbtnDoctor.isSelected())
			return "Doctor";
		else
			return "Magister";
	}
	
	
	
	public String getContratacion() {
		if (this.rdbtnResidente.isSelected())
			return "Residente";
		else
			return "Permanente";
	}
	
	
	
	
	
	
	
	
	
	public String getTextFieldDiaInicial() {
		return textFieldDiaInicial.getText();
	}

	public String getTextFieldMesInicial() {
		return textFieldMesInicial.getText();
	}

	public String getTextFieldAnioInicial() {
		return textFieldAnioInicial.getText();
	}

	public String getTextFieldDiaFinal() {
		return textFieldDiaFinal.getText();
	}

	public String getTextFieldMesFinal() {
		return textFieldMesFinal.getText();
	}

	public String getTextFieldAnioFinal() {
		return textFieldAnioFinal.getText();
	}

	
	
	
	
	
	
	
	
	
	

}
