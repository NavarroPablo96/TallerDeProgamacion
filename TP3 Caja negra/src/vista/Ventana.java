// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import modelo.Persona;
import excepciones.DatoInvalidoException;
import excepciones.ClaveYaExistenteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.util.Iterator;
import excepciones.DiaInvalidoException;
import modelo.Dia;
import modelo.Cursada;
import modelo.Profesor;
import excepciones.NoEncontradoException;
import modelo.Asignatura;
import modelo.Alumno;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFrame;

public class Ventana extends JFrame implements ListSelectionListener
{
    private Receptor receptor;
    private int accionAceptar;
    private static final int NUEVO = 0;
    private static final int MODIFICAR = 1;
    private JButton jButtonAceptarAlumno;
    private JButton jButtonAceptarAsignatura;
    private JButton jButtonAceptarCursada;
    private JButton jButtonAceptarProfesor;
    private JButton jButtonAgradecimientos;
    private JButton jButtonAgregarAlumnoCursada;
    private JButton jButtonAgregarCompetencia;
    private JButton jButtonAgregarCorrelativa;
    private JButton jButtonAgregarHistoria;
    private JButton jButtonAgregarProfesorCursada;
    private JButton jButtonBuscarAlumno;
    private JButton jButtonBuscarAsignatura;
    private JButton jButtonBuscarCursada;
    private JButton jButtonBuscarProfesor;
    private JButton jButtonCambiarAsignaturaCursada;
    private JButton jButtonCancelarAlumno;
    private JButton jButtonCancelarAsignatura;
    private JButton jButtonCancelarCursada;
    private JButton jButtonCancelarProfesor;
    private JButton jButtonEliminarAlumno;
    private JButton jButtonEliminarAlumnoCursada;
    private JButton jButtonEliminarAsignatura;
    private JButton jButtonEliminarCompetencia;
    private JButton jButtonEliminarCorrelativa;
    private JButton jButtonEliminarCursada;
    private JButton jButtonEliminarHistoria;
    private JButton jButtonEliminarProfesor;
    private JButton jButtonEliminarProfesorCursada;
    private JButton jButtonModificarAlumno;
    private JButton jButtonModificarAsignatura;
    private JButton jButtonModificarCursada;
    private JButton jButtonModificarProfesor;
    private JButton jButtonNuevoAlumno;
    private JButton jButtonNuevoAsignatura;
    private JButton jButtonNuevoCursada;
    private JButton jButtonNuevoProfesor;
    private JComboBox<String> jComboBoxDia;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanelAlumno;
    private JPanel jPanelAsignatura;
    private JPanel jPanelBuscarAlumno;
    private JPanel jPanelBuscarAsignatura;
    private JPanel jPanelBuscarCursada;
    private JPanel jPanelBuscarProfesor;
    private JPanel jPanelBusquedaProfesor;
    private JPanel jPanelCursada;
    private JPanel jPanelProfesor;
    private JPanel jPanelResultadosAlumno;
    private JPanel jPanelResultadosAsignatura;
    private JPanel jPanelResultadosCursada;
    private JPanel jPanelResultadosProfesor;
    private JPanel jPanelTableBusquedaAlumno;
    private JScrollPane jScrollPane10;
    private JScrollPane jScrollPane11;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private JScrollPane jScrollPaneBusquedaAlumno;
    private JScrollPane jScrollPaneBusquedaProfesor;
    private JScrollPane jScrollPaneCompetencias;
    private JScrollPane jScrollPaneHistoria;
    private JTabbedPane jTabbedPane;
    private JTable jTableAlumnoAlumno;
    private JTable jTableAlumnosCursada;
    private JTable jTableAsignaturaAsignatura;
    private JTable jTableCompetencia;
    private JTable jTableCorrelativas;
    private JTable jTableCursadaCursada;
    private JTable jTableHistoria;
    private JTable jTableProfesorProfesor;
    private JTable jTableProfesoresCursada;
    private JTextField jTextFieldBuscarAlumno;
    private JTextField jTextFieldBuscarAsignatura;
    private JTextField jTextFieldBuscarCursada;
    private JTextField jTextFieldBuscarProfesor;
    private JTextField jTextFieldDomicilioAlumno;
    private JTextField jTextFieldDomicilioProfesor;
    private JTextField jTextFieldFinCursada;
    private JTextField jTextFieldIDAsignaturaCursada;
    private JTextField jTextFieldIdentificadorAsignatura;
    private JTextField jTextFieldIdentificadorCursada;
    private JTextField jTextFieldInicioCursada;
    private JTextField jTextFieldLegajoAlumno;
    private JTextField jTextFieldLegajoProfesor;
    private JTextField jTextFieldMailAlumno;
    private JTextField jTextFieldMailProfesor;
    private JTextField jTextFieldNombreAlumno;
    private JTextField jTextFieldNombreAsignatura;
    private JTextField jTextFieldNombreAsignaturaCursada;
    private JTextField jTextFieldNombreProfesor;
    private JTextField jTextFieldPeriodoCursada;
    private JTextField jTextFieldTelefonoProfesor;
    
    public Ventana(final Receptor receptor) {
        this.accionAceptar = 0;
        this.initComponents();
        this.receptor = receptor;
        this.setResizable(false);
        this.setTitle("Programa de Gestion de asignaturas");
        this.setVisible(true);
        this.cancelarAlumno();
        this.cancelarProfesor();
        this.cancelarAsignatura();
        this.cancelarCursada();
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                super.windowClosing(e);
                Ventana.this.receptor.guardar();
                Ventana.this.dispose();
            }
        });
        this.jTableAlumnoAlumno.getSelectionModel().addListSelectionListener(this);
        this.jTableProfesorProfesor.getSelectionModel().addListSelectionListener(this);
        this.jTableCursadaCursada.getSelectionModel().addListSelectionListener(this);
        this.jTableAsignaturaAsignatura.getSelectionModel().addListSelectionListener(this);
        this.jTableAlumnoAlumno.setSelectionMode(0);
        this.jTableAlumnoAlumno.setRowSelectionAllowed(true);
        this.jTableHistoria.setSelectionMode(0);
        this.jTableHistoria.setRowSelectionAllowed(true);
        this.jTableProfesorProfesor.setSelectionMode(0);
        this.jTableProfesorProfesor.setRowSelectionAllowed(true);
        this.jTableCompetencia.setSelectionMode(0);
        this.jTableCompetencia.setRowSelectionAllowed(true);
        this.jTableAsignaturaAsignatura.setSelectionMode(0);
        this.jTableAsignaturaAsignatura.setRowSelectionAllowed(true);
        this.jTableCorrelativas.setSelectionMode(0);
        this.jTableCorrelativas.setRowSelectionAllowed(true);
        this.jTableCursadaCursada.setSelectionMode(0);
        this.jTableCursadaCursada.setRowSelectionAllowed(true);
        this.jTableAlumnosCursada.setSelectionMode(0);
        this.jTableAlumnosCursada.setRowSelectionAllowed(true);
        this.jTableProfesoresCursada.setSelectionMode(0);
        this.jTableProfesoresCursada.setRowSelectionAllowed(true);
    }
    
    @Override
    public void valueChanged(final ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            if (this.jPanelAlumno.isShowing()) {
                ((DefaultTableModel)this.jTableHistoria.getModel()).setRowCount(0);
                try {
                    final Alumno elemento = (Alumno)this.receptor.buscar(this.jTableAlumnoAlumno.getValueAt(this.jTableAlumnoAlumno.getSelectedRow(), 0), 0);
                    this.jTextFieldLegajoAlumno.setText(elemento.getLegajo());
                    this.jTextFieldNombreAlumno.setText(elemento.getApellidoNombre());
                    this.jTextFieldDomicilioAlumno.setText(elemento.getDomicilio());
                    this.jTextFieldMailAlumno.setText(elemento.getMail());
                    final Iterator<Asignatura> asignaturas = elemento.historiaAcademica();
                    final DefaultTableModel model = (DefaultTableModel)this.jTableHistoria.getModel();
                    while (asignaturas.hasNext()) {
                        final Asignatura aux = asignaturas.next();
                        model.addRow(new Object[] { aux.getIdentificacion(), aux.getNombre() });
                    }
                }
                catch (NoEncontradoException ex) {}
            }
            else if (this.jPanelProfesor.isShowing()) {
                try {
                    ((DefaultTableModel)this.jTableCompetencia.getModel()).setRowCount(0);
                    final Profesor elemento2 = (Profesor)this.receptor.buscar(this.jTableProfesorProfesor.getValueAt(this.jTableProfesorProfesor.getSelectedRow(), 0), 1);
                    this.jTextFieldLegajoProfesor.setText(elemento2.getLegajo());
                    this.jTextFieldNombreProfesor.setText(elemento2.getApellidoNombre());
                    this.jTextFieldDomicilioProfesor.setText(elemento2.getDomicilio());
                    this.jTextFieldMailProfesor.setText(elemento2.getMail());
                    this.jTextFieldTelefonoProfesor.setText(elemento2.getTelefono());
                    final Iterator<Asignatura> asignaturas = elemento2.competencias();
                    final DefaultTableModel model = (DefaultTableModel)this.jTableCompetencia.getModel();
                    while (asignaturas.hasNext()) {
                        final Asignatura aux = asignaturas.next();
                        model.addRow(new Object[] { aux.getIdentificacion(), aux.getNombre() });
                    }
                }
                catch (NoEncontradoException ex2) {}
            }
            else if (this.jPanelAsignatura.isShowing()) {
                try {
                    ((DefaultTableModel)this.jTableCorrelativas.getModel()).setRowCount(0);
                    final Asignatura elemento3 = (Asignatura)this.receptor.buscar(this.jTableAsignaturaAsignatura.getValueAt(this.jTableAsignaturaAsignatura.getSelectedRow(), 0), 2);
                    this.jTextFieldIdentificadorAsignatura.setText(elemento3.getIdentificacion());
                    this.jTextFieldNombreAsignatura.setText(elemento3.getNombre());
                    final Iterator<Asignatura> asignaturas = elemento3.precorrelativas();
                    final DefaultTableModel model = (DefaultTableModel)this.jTableCorrelativas.getModel();
                    while (asignaturas.hasNext()) {
                        final Asignatura aux = asignaturas.next();
                        model.addRow(new Object[] { aux.getIdentificacion(), aux.getNombre() });
                    }
                }
                catch (NoEncontradoException ex3) {}
            }
            else if (this.jPanelCursada.isShowing()) {
                try {
                    ((DefaultTableModel)this.jTableProfesoresCursada.getModel()).setRowCount(0);
                    ((DefaultTableModel)this.jTableAlumnosCursada.getModel()).setRowCount(0);
                    final Cursada elemento4 = (Cursada)this.receptor.buscar(this.jTableCursadaCursada.getValueAt(this.jTableCursadaCursada.getSelectedRow(), 0), 3);
                    this.jTextFieldIdentificadorCursada.setText(elemento4.getIdentificacion());
                    this.jTextFieldPeriodoCursada.setText(elemento4.getPeriodo());
                    this.jComboBoxDia.setSelectedIndex(Dia.parseInt(elemento4.getDia()));
                    this.jTextFieldInicioCursada.setText(elemento4.getHoraInicio());
                    this.jTextFieldFinCursada.setText(elemento4.getHoraFinalizacion());
                    final Asignatura asig = elemento4.getAsignatura();
                    this.jTextFieldIDAsignaturaCursada.setText(asig.getIdentificacion());
                    this.jTextFieldNombreAsignaturaCursada.setText(asig.getNombre());
                    final Iterator<Profesor> profesores = elemento4.profesores();
                    final DefaultTableModel modelprof = (DefaultTableModel)this.jTableProfesoresCursada.getModel();
                    while (profesores.hasNext()) {
                        final Profesor prof = profesores.next();
                        modelprof.addRow(new Object[] { prof.getLegajo(), prof.getApellidoNombre(), prof.getDomicilio(), prof.getMail(), prof.getTelefono() });
                    }
                    final Iterator<Alumno> alumnos = elemento4.alumnos();
                    final DefaultTableModel modelalu = (DefaultTableModel)this.jTableAlumnosCursada.getModel();
                    while (alumnos.hasNext()) {
                        final Alumno alu = alumnos.next();
                        modelalu.addRow(new Object[] { alu.getLegajo(), alu.getApellidoNombre(), alu.getDomicilio(), alu.getMail() });
                    }
                }
                catch (NoEncontradoException ex4) {}
                catch (DiaInvalidoException ex5) {}
            }
        }
    }
    
    private void initComponents() {
        this.jTabbedPane = new JTabbedPane();
        this.jPanelAlumno = new JPanel();
        this.jPanelBuscarAlumno = new JPanel();
        this.jButtonBuscarAlumno = new JButton();
        this.jTextFieldBuscarAlumno = new JTextField();
        this.jPanelTableBusquedaAlumno = new JPanel();
        this.jScrollPaneBusquedaAlumno = new JScrollPane();
        this.jTableAlumnoAlumno = new JTable();
        this.jPanelResultadosAlumno = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jTextFieldLegajoAlumno = new JTextField();
        this.jTextFieldNombreAlumno = new JTextField();
        this.jTextFieldDomicilioAlumno = new JTextField();
        this.jTextFieldMailAlumno = new JTextField();
        this.jScrollPaneHistoria = new JScrollPane();
        this.jTableHistoria = new JTable();
        this.jButtonNuevoAlumno = new JButton();
        this.jButtonEliminarAlumno = new JButton();
        this.jButtonAgregarHistoria = new JButton();
        this.jButtonAceptarAlumno = new JButton();
        this.jButtonCancelarAlumno = new JButton();
        this.jButtonModificarAlumno = new JButton();
        this.jButtonEliminarHistoria = new JButton();
        this.jPanelProfesor = new JPanel();
        this.jPanelResultadosProfesor = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jTextFieldLegajoProfesor = new JTextField();
        this.jTextFieldNombreProfesor = new JTextField();
        this.jTextFieldDomicilioProfesor = new JTextField();
        this.jTextFieldMailProfesor = new JTextField();
        this.jTextFieldTelefonoProfesor = new JTextField();
        this.jScrollPaneCompetencias = new JScrollPane();
        this.jTableCompetencia = new JTable();
        this.jButtonNuevoProfesor = new JButton();
        this.jButtonEliminarProfesor = new JButton();
        this.jButtonAgregarCompetencia = new JButton();
        this.jButtonAceptarProfesor = new JButton();
        this.jButtonCancelarProfesor = new JButton();
        this.jButtonModificarProfesor = new JButton();
        this.jButtonEliminarCompetencia = new JButton();
        this.jPanelBusquedaProfesor = new JPanel();
        this.jScrollPaneBusquedaProfesor = new JScrollPane();
        this.jTableProfesorProfesor = new JTable();
        this.jPanelBuscarProfesor = new JPanel();
        this.jButtonBuscarProfesor = new JButton();
        this.jTextFieldBuscarProfesor = new JTextField();
        this.jPanelAsignatura = new JPanel();
        this.jPanelBuscarAsignatura = new JPanel();
        this.jButtonBuscarAsignatura = new JButton();
        this.jTextFieldBuscarAsignatura = new JTextField();
        this.jPanelResultadosAsignatura = new JPanel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jTextFieldIdentificadorAsignatura = new JTextField();
        this.jTextFieldNombreAsignatura = new JTextField();
        this.jScrollPane7 = new JScrollPane();
        this.jTableCorrelativas = new JTable();
        this.jButtonNuevoAsignatura = new JButton();
        this.jButtonEliminarAsignatura = new JButton();
        this.jButtonAgregarCorrelativa = new JButton();
        this.jButtonAceptarAsignatura = new JButton();
        this.jButtonCancelarAsignatura = new JButton();
        this.jButtonModificarAsignatura = new JButton();
        this.jButtonEliminarCorrelativa = new JButton();
        this.jPanel3 = new JPanel();
        this.jScrollPane8 = new JScrollPane();
        this.jTableAsignaturaAsignatura = new JTable();
        this.jPanelCursada = new JPanel();
        this.jPanelBuscarCursada = new JPanel();
        this.jButtonBuscarCursada = new JButton();
        this.jTextFieldBuscarCursada = new JTextField();
        this.jPanel4 = new JPanel();
        this.jScrollPane9 = new JScrollPane();
        this.jTableCursadaCursada = new JTable();
        this.jPanelResultadosCursada = new JPanel();
        this.jLabel14 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.jLabel23 = new JLabel();
        this.jTextFieldIdentificadorCursada = new JTextField();
        this.jTextFieldIDAsignaturaCursada = new JTextField();
        this.jTextFieldNombreAsignaturaCursada = new JTextField();
        this.jTextFieldPeriodoCursada = new JTextField();
        this.jTextFieldInicioCursada = new JTextField();
        this.jTextFieldFinCursada = new JTextField();
        this.jComboBoxDia = new JComboBox<String>();
        this.jScrollPane10 = new JScrollPane();
        this.jTableProfesoresCursada = new JTable();
        this.jButtonNuevoCursada = new JButton();
        this.jButtonEliminarCursada = new JButton();
        this.jButtonAgregarProfesorCursada = new JButton();
        this.jButtonAceptarCursada = new JButton();
        this.jButtonCancelarCursada = new JButton();
        this.jButtonModificarCursada = new JButton();
        this.jScrollPane11 = new JScrollPane();
        this.jTableAlumnosCursada = new JTable();
        this.jButtonAgregarAlumnoCursada = new JButton();
        this.jButtonCambiarAsignaturaCursada = new JButton();
        this.jButtonEliminarProfesorCursada = new JButton();
        this.jButtonEliminarAlumnoCursada = new JButton();
        this.jButtonAgradecimientos = new JButton();
        this.setDefaultCloseOperation(3);
        this.jPanelAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jPanelBuscarAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jButtonBuscarAlumno.setText("Buscar");
        this.jButtonBuscarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonBuscarAlumnoActionPerformed(evt);
            }
        });
        final GroupLayout jPanelBuscarAlumnoLayout = new GroupLayout(this.jPanelBuscarAlumno);
        this.jPanelBuscarAlumno.setLayout(jPanelBuscarAlumnoLayout);
        jPanelBuscarAlumnoLayout.setHorizontalGroup(jPanelBuscarAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarAlumnoLayout.createSequentialGroup().addComponent(this.jTextFieldBuscarAlumno, -1, 307, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonBuscarAlumno, -2, 96, -2)));
        jPanelBuscarAlumnoLayout.setVerticalGroup(jPanelBuscarAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldBuscarAlumno, -2, -1, -2).addComponent(this.jButtonBuscarAlumno)));
        this.jPanelTableBusquedaAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jTableAlumnoAlumno.setModel(new TableModelAlumno());
        this.jScrollPaneBusquedaAlumno.setViewportView(this.jTableAlumnoAlumno);
        final GroupLayout jPanelTableBusquedaAlumnoLayout = new GroupLayout(this.jPanelTableBusquedaAlumno);
        this.jPanelTableBusquedaAlumno.setLayout(jPanelTableBusquedaAlumnoLayout);
        jPanelTableBusquedaAlumnoLayout.setHorizontalGroup(jPanelTableBusquedaAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPaneBusquedaAlumno, -2, 0, 32767));
        jPanelTableBusquedaAlumnoLayout.setVerticalGroup(jPanelTableBusquedaAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPaneBusquedaAlumno, -1, 497, 32767));
        this.jPanelResultadosAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setText("Legajo");
        this.jLabel3.setText("Apellido y Nombre");
        this.jLabel4.setText("Domicilio");
        this.jLabel5.setText("Mail");
        this.jLabel6.setText("Historia:");
        this.jTextFieldLegajoAlumno.setEditable(false);
        this.jTextFieldLegajoAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldNombreAlumno.setEditable(false);
        this.jTextFieldNombreAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldDomicilioAlumno.setEditable(false);
        this.jTextFieldDomicilioAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldMailAlumno.setEditable(false);
        this.jTextFieldMailAlumno.setBorder(BorderFactory.createEtchedBorder());
        this.jTableHistoria.setModel(new TableModelAsignatura());
        this.jScrollPaneHistoria.setViewportView(this.jTableHistoria);
        this.jButtonNuevoAlumno.setText("Nuevo");
        this.jButtonNuevoAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonNuevoAlumnoActionPerformed(evt);
            }
        });
        this.jButtonEliminarAlumno.setText("Eliminar");
        this.jButtonEliminarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarAlumnoActionPerformed(evt);
            }
        });
        this.jButtonAgregarHistoria.setText("Agregar...");
        this.jButtonAgregarHistoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAgregarHistoriaActionPerformed(evt);
            }
        });
        this.jButtonAceptarAlumno.setText("Aceptar");
        this.jButtonAceptarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAceptarAlumnoActionPerformed(evt);
            }
        });
        this.jButtonCancelarAlumno.setText("Cancelar");
        this.jButtonCancelarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonCancelarAlumnoActionPerformed(evt);
            }
        });
        this.jButtonModificarAlumno.setText("Modificar");
        this.jButtonModificarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonModificarAlumnoActionPerformed(evt);
            }
        });
        this.jButtonEliminarHistoria.setText("Eliminar...");
        this.jButtonEliminarHistoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarHistoriaActionPerformed(evt);
            }
        });
        final GroupLayout jPanelResultadosAlumnoLayout = new GroupLayout(this.jPanelResultadosAlumno);
        this.jPanelResultadosAlumno.setLayout(jPanelResultadosAlumnoLayout);
        jPanelResultadosAlumnoLayout.setHorizontalGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAlumnoLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPaneHistoria).addGroup(jPanelResultadosAlumnoLayout.createSequentialGroup().addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel3, -1, -1, 32767).addComponent(this.jLabel1).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextFieldMailAlumno, -1, 484, 32767).addComponent(this.jTextFieldLegajoAlumno, GroupLayout.Alignment.TRAILING).addComponent(this.jTextFieldNombreAlumno, GroupLayout.Alignment.TRAILING).addComponent(this.jTextFieldDomicilioAlumno).addGroup(GroupLayout.Alignment.TRAILING, jPanelResultadosAlumnoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButtonAgregarHistoria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonEliminarHistoria).addGap(5, 5, 5)))).addGroup(jPanelResultadosAlumnoLayout.createSequentialGroup().addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAlumnoLayout.createSequentialGroup().addComponent(this.jButtonAceptarAlumno).addGap(18, 18, 18).addComponent(this.jButtonCancelarAlumno)).addGroup(jPanelResultadosAlumnoLayout.createSequentialGroup().addComponent(this.jButtonNuevoAlumno).addGap(18, 18, 18).addComponent(this.jButtonEliminarAlumno).addGap(18, 18, 18).addComponent(this.jButtonModificarAlumno))).addGap(0, 0, 32767))).addContainerGap()));
        jPanelResultadosAlumnoLayout.setVerticalGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAlumnoLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButtonNuevoAlumno).addComponent(this.jButtonEliminarAlumno).addComponent(this.jButtonModificarAlumno)).addGap(18, 18, 18).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextFieldLegajoAlumno, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTextFieldNombreAlumno, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTextFieldDomicilioAlumno, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTextFieldMailAlumno, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jButtonAgregarHistoria).addComponent(this.jButtonEliminarHistoria)).addGap(5, 5, 5).addComponent(this.jScrollPaneHistoria, -1, 306, 32767).addGap(18, 18, 18).addGroup(jPanelResultadosAlumnoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButtonAceptarAlumno).addComponent(this.jButtonCancelarAlumno)).addContainerGap()));
        final GroupLayout jPanelAlumnoLayout = new GroupLayout(this.jPanelAlumno);
        this.jPanelAlumno.setLayout(jPanelAlumnoLayout);
        jPanelAlumnoLayout.setHorizontalGroup(jPanelAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelAlumnoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanelResultadosAlumno, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelTableBusquedaAlumno, -1, -1, 32767).addComponent(this.jPanelBuscarAlumno, -1, -1, 32767)).addContainerGap()));
        jPanelAlumnoLayout.setVerticalGroup(jPanelAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelAlumnoLayout.createSequentialGroup().addContainerGap().addGroup(jPanelAlumnoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelResultadosAlumno, -1, -1, 32767).addGroup(jPanelAlumnoLayout.createSequentialGroup().addComponent(this.jPanelBuscarAlumno, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanelTableBusquedaAlumno, -1, -1, 32767))).addContainerGap()));
        this.jTabbedPane.addTab("Alumno", this.jPanelAlumno);
        this.jPanelResultadosProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel2.setText("Legajo");
        this.jLabel7.setText("Apellido y Nombre");
        this.jLabel8.setText("Domicilio");
        this.jLabel9.setText("Mail");
        this.jLabel10.setText("Competencias:");
        this.jLabel11.setText("Telefono");
        this.jTextFieldLegajoProfesor.setEditable(false);
        this.jTextFieldLegajoProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldNombreProfesor.setEditable(false);
        this.jTextFieldNombreProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldDomicilioProfesor.setEditable(false);
        this.jTextFieldDomicilioProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldMailProfesor.setEditable(false);
        this.jTextFieldMailProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldTelefonoProfesor.setEditable(false);
        this.jTextFieldTelefonoProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jTableCompetencia.setModel(new TableModelAsignatura());
        this.jScrollPaneCompetencias.setViewportView(this.jTableCompetencia);
        this.jButtonNuevoProfesor.setText("Nuevo");
        this.jButtonNuevoProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonNuevoProfesorActionPerformed(evt);
            }
        });
        this.jButtonEliminarProfesor.setText("Eliminar");
        this.jButtonEliminarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarProfesorActionPerformed(evt);
            }
        });
        this.jButtonAgregarCompetencia.setText("Agregar...");
        this.jButtonAgregarCompetencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAgregarCompetenciaActionPerformed(evt);
            }
        });
        this.jButtonAceptarProfesor.setText("Aceptar");
        this.jButtonAceptarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAceptarProfesorActionPerformed(evt);
            }
        });
        this.jButtonCancelarProfesor.setText("Cancelar");
        this.jButtonCancelarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonCancelarProfesorActionPerformed(evt);
            }
        });
        this.jButtonModificarProfesor.setText("Modificar");
        this.jButtonModificarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonModificarProfesorActionPerformed(evt);
            }
        });
        this.jButtonEliminarCompetencia.setText("Eliminar...");
        this.jButtonEliminarCompetencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarCompetenciaActionPerformed(evt);
            }
        });
        final GroupLayout jPanelResultadosProfesorLayout = new GroupLayout(this.jPanelResultadosProfesor);
        this.jPanelResultadosProfesor.setLayout(jPanelResultadosProfesorLayout);
        jPanelResultadosProfesorLayout.setHorizontalGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addComponent(this.jButtonAceptarProfesor).addGap(18, 18, 18).addComponent(this.jButtonCancelarProfesor)).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addComponent(this.jButtonNuevoProfesor).addGap(18, 18, 18).addComponent(this.jButtonEliminarProfesor).addGap(18, 18, 18).addComponent(this.jButtonModificarProfesor))).addGap(0, 0, 32767)).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addComponent(this.jLabel2).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextFieldMailProfesor).addComponent(this.jTextFieldLegajoProfesor, GroupLayout.Alignment.TRAILING).addComponent(this.jTextFieldNombreProfesor, GroupLayout.Alignment.TRAILING).addComponent(this.jTextFieldDomicilioProfesor).addComponent(this.jTextFieldTelefonoProfesor))).addComponent(this.jScrollPaneCompetencias, -1, 582, 32767).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addComponent(this.jLabel10, -1, -1, 32767).addGap(186, 186, 186).addComponent(this.jButtonAgregarCompetencia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonEliminarCompetencia))).addContainerGap()));
        jPanelResultadosProfesorLayout.setVerticalGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosProfesorLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButtonNuevoProfesor).addComponent(this.jButtonEliminarProfesor).addComponent(this.jButtonModificarProfesor)).addGap(18, 18, 18).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextFieldLegajoProfesor, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jTextFieldNombreProfesor, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jTextFieldDomicilioProfesor, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jTextFieldMailProfesor, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.jTextFieldTelefonoProfesor, -2, -1, -2)).addGap(38, 38, 38).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jButtonEliminarCompetencia).addComponent(this.jButtonAgregarCompetencia, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.jScrollPaneCompetencias, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelResultadosProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButtonCancelarProfesor).addComponent(this.jButtonAceptarProfesor)).addContainerGap()));
        this.jPanelBusquedaProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jTableProfesorProfesor.setModel(new TableModelProfesor());
        this.jScrollPaneBusquedaProfesor.setViewportView(this.jTableProfesorProfesor);
        final GroupLayout jPanelBusquedaProfesorLayout = new GroupLayout(this.jPanelBusquedaProfesor);
        this.jPanelBusquedaProfesor.setLayout(jPanelBusquedaProfesorLayout);
        jPanelBusquedaProfesorLayout.setHorizontalGroup(jPanelBusquedaProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPaneBusquedaProfesor, -2, 0, 32767));
        jPanelBusquedaProfesorLayout.setVerticalGroup(jPanelBusquedaProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPaneBusquedaProfesor, -1, 509, 32767));
        this.jPanelBuscarProfesor.setBorder(BorderFactory.createEtchedBorder());
        this.jButtonBuscarProfesor.setText("Buscar");
        this.jButtonBuscarProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonBuscarProfesorActionPerformed(evt);
            }
        });
        final GroupLayout jPanelBuscarProfesorLayout = new GroupLayout(this.jPanelBuscarProfesor);
        this.jPanelBuscarProfesor.setLayout(jPanelBuscarProfesorLayout);
        jPanelBuscarProfesorLayout.setHorizontalGroup(jPanelBuscarProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarProfesorLayout.createSequentialGroup().addComponent(this.jTextFieldBuscarProfesor, -1, 301, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonBuscarProfesor, -2, 96, -2)));
        jPanelBuscarProfesorLayout.setVerticalGroup(jPanelBuscarProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarProfesorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldBuscarProfesor, -2, -1, -2).addComponent(this.jButtonBuscarProfesor)));
        final GroupLayout jPanelProfesorLayout = new GroupLayout(this.jPanelProfesor);
        this.jPanelProfesor.setLayout(jPanelProfesorLayout);
        jPanelProfesorLayout.setHorizontalGroup(jPanelProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1069, 32767).addGroup(jPanelProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelProfesorLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jPanelResultadosProfesor, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanelProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelBusquedaProfesor, -1, -1, 32767).addComponent(this.jPanelBuscarProfesor, -1, -1, 32767)).addGap(14, 14, 14))));
        jPanelProfesorLayout.setVerticalGroup(jPanelProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 566, 32767).addGroup(jPanelProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelProfesorLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanelProfesorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelProfesorLayout.createSequentialGroup().addComponent(this.jPanelBuscarProfesor, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanelBusquedaProfesor, -1, -1, 32767)).addComponent(this.jPanelResultadosProfesor, -1, -1, 32767)).addGap(8, 8, 8))));
        this.jTabbedPane.addTab("Profesor", this.jPanelProfesor);
        this.jPanelBuscarAsignatura.setBorder(BorderFactory.createEtchedBorder());
        this.jButtonBuscarAsignatura.setText("Buscar");
        this.jButtonBuscarAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonBuscarAsignaturaActionPerformed(evt);
            }
        });
        final GroupLayout jPanelBuscarAsignaturaLayout = new GroupLayout(this.jPanelBuscarAsignatura);
        this.jPanelBuscarAsignatura.setLayout(jPanelBuscarAsignaturaLayout);
        jPanelBuscarAsignaturaLayout.setHorizontalGroup(jPanelBuscarAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarAsignaturaLayout.createSequentialGroup().addComponent(this.jTextFieldBuscarAsignatura, -1, 305, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonBuscarAsignatura, -2, 96, -2)));
        jPanelBuscarAsignaturaLayout.setVerticalGroup(jPanelBuscarAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldBuscarAsignatura, -2, -1, -2).addComponent(this.jButtonBuscarAsignatura)));
        this.jPanelResultadosAsignatura.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel12.setText("Identificador");
        this.jLabel13.setText("Nombre");
        this.jLabel16.setText("Correlatividades:");
        this.jTextFieldIdentificadorAsignatura.setEditable(false);
        this.jTextFieldIdentificadorAsignatura.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldNombreAsignatura.setEditable(false);
        this.jTextFieldNombreAsignatura.setBorder(BorderFactory.createEtchedBorder());
        this.jTableCorrelativas.setModel(new TableModelAsignatura());
        this.jScrollPane7.setViewportView(this.jTableCorrelativas);
        this.jButtonNuevoAsignatura.setText("Nuevo");
        this.jButtonNuevoAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonNuevoAsignaturaActionPerformed(evt);
            }
        });
        this.jButtonEliminarAsignatura.setText("Eliminar");
        this.jButtonEliminarAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarAsignaturaActionPerformed(evt);
            }
        });
        this.jButtonAgregarCorrelativa.setText("Agregar...");
        this.jButtonAgregarCorrelativa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAgregarCorrelativaActionPerformed(evt);
            }
        });
        this.jButtonAceptarAsignatura.setText("Aceptar");
        this.jButtonAceptarAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAceptarAsignaturaActionPerformed(evt);
            }
        });
        this.jButtonCancelarAsignatura.setText("Cancelar");
        this.jButtonCancelarAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonCancelarAsignaturaActionPerformed(evt);
            }
        });
        this.jButtonModificarAsignatura.setText("Modificar");
        this.jButtonModificarAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonModificarAsignaturaActionPerformed(evt);
            }
        });
        this.jButtonEliminarCorrelativa.setText("Eliminar...");
        this.jButtonEliminarCorrelativa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarCorrelativaActionPerformed(evt);
            }
        });
        final GroupLayout jPanelResultadosAsignaturaLayout = new GroupLayout(this.jPanelResultadosAsignatura);
        this.jPanelResultadosAsignatura.setLayout(jPanelResultadosAsignaturaLayout);
        jPanelResultadosAsignaturaLayout.setHorizontalGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextFieldIdentificadorAsignatura, GroupLayout.Alignment.TRAILING).addComponent(this.jTextFieldNombreAsignatura, GroupLayout.Alignment.TRAILING))).addComponent(this.jScrollPane7, -1, 582, 32767).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addComponent(this.jLabel16, -1, -1, 32767).addGap(152, 152, 152).addComponent(this.jButtonAgregarCorrelativa).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonEliminarCorrelativa)).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addComponent(this.jButtonNuevoAsignatura).addGap(18, 18, 18).addComponent(this.jButtonEliminarAsignatura).addGap(18, 18, 18).addComponent(this.jButtonModificarAsignatura)).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addComponent(this.jButtonAceptarAsignatura).addGap(18, 18, 18).addComponent(this.jButtonCancelarAsignatura))).addGap(0, 0, 32767))).addContainerGap()));
        jPanelResultadosAsignaturaLayout.setVerticalGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosAsignaturaLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButtonNuevoAsignatura).addComponent(this.jButtonEliminarAsignatura).addComponent(this.jButtonModificarAsignatura)).addGap(18, 18, 18).addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jTextFieldIdentificadorAsignatura, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.jTextFieldNombreAsignatura, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jButtonAgregarCorrelativa).addComponent(this.jButtonEliminarCorrelativa)).addGap(18, 18, 18).addComponent(this.jScrollPane7, -2, 0, 32767).addGap(18, 18, 18).addGroup(jPanelResultadosAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButtonCancelarAsignatura).addComponent(this.jButtonAceptarAsignatura)).addContainerGap()));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jTableAsignaturaAsignatura.setModel(new TableModelAsignatura());
        this.jScrollPane8.setViewportView(this.jTableAsignaturaAsignatura);
        final GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane8, -2, 0, 32767));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane8, -1, 501, 32767));
        final GroupLayout jPanelAsignaturaLayout = new GroupLayout(this.jPanelAsignatura);
        this.jPanelAsignatura.setLayout(jPanelAsignaturaLayout);
        jPanelAsignaturaLayout.setHorizontalGroup(jPanelAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelAsignaturaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanelResultadosAsignatura, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanelAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanelBuscarAsignatura, -1, -1, 32767)).addContainerGap()));
        jPanelAsignaturaLayout.setVerticalGroup(jPanelAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelAsignaturaLayout.createSequentialGroup().addContainerGap().addGroup(jPanelAsignaturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelResultadosAsignatura, -1, -1, 32767).addGroup(jPanelAsignaturaLayout.createSequentialGroup().addComponent(this.jPanelBuscarAsignatura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -1, -1, 32767))).addContainerGap()));
        this.jTabbedPane.addTab("Asignatura", this.jPanelAsignatura);
        this.jPanelBuscarCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jButtonBuscarCursada.setText("Buscar");
        this.jButtonBuscarCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonBuscarCursadaActionPerformed(evt);
            }
        });
        final GroupLayout jPanelBuscarCursadaLayout = new GroupLayout(this.jPanelBuscarCursada);
        this.jPanelBuscarCursada.setLayout(jPanelBuscarCursadaLayout);
        jPanelBuscarCursadaLayout.setHorizontalGroup(jPanelBuscarCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarCursadaLayout.createSequentialGroup().addComponent(this.jTextFieldBuscarCursada, -1, 305, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonBuscarCursada, -2, 96, -2)));
        jPanelBuscarCursadaLayout.setVerticalGroup(jPanelBuscarCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBuscarCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldBuscarCursada, -2, -1, -2).addComponent(this.jButtonBuscarCursada)));
        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
        this.jTableCursadaCursada.setModel(new TableModelCursada());
        this.jScrollPane9.setViewportView(this.jTableCursadaCursada);
        final GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane9, -2, 0, 32767));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane9, -1, 501, 32767));
        this.jPanelResultadosCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel14.setText("Identificador");
        this.jLabel17.setText("Profesores");
        this.jLabel18.setText("Periodo");
        this.jLabel19.setText("Asignatura");
        this.jLabel20.setText("Dia");
        this.jLabel21.setText("Hora Inicio");
        this.jLabel22.setText("Hora Finalizacion");
        this.jLabel23.setText("Alumnos");
        this.jTextFieldIdentificadorCursada.setEditable(false);
        this.jTextFieldIdentificadorCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldIDAsignaturaCursada.setEditable(false);
        this.jTextFieldIDAsignaturaCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldNombreAsignaturaCursada.setEditable(false);
        this.jTextFieldNombreAsignaturaCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldPeriodoCursada.setEditable(false);
        this.jTextFieldPeriodoCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldInicioCursada.setEditable(false);
        this.jTextFieldInicioCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jTextFieldFinCursada.setEditable(false);
        this.jTextFieldFinCursada.setBorder(BorderFactory.createEtchedBorder());
        this.jComboBoxDia.setModel(new DefaultComboBoxModel<String>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        this.jTableProfesoresCursada.setModel(new TableModelProfesor());
        this.jScrollPane10.setViewportView(this.jTableProfesoresCursada);
        this.jButtonNuevoCursada.setText("Nuevo");
        this.jButtonNuevoCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonNuevoCursadaActionPerformed(evt);
            }
        });
        this.jButtonEliminarCursada.setText("Eliminar");
        this.jButtonEliminarCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarCursadaActionPerformed(evt);
            }
        });
        this.jButtonAgregarProfesorCursada.setText("Agregar...");
        this.jButtonAgregarProfesorCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAgregarProfesorCursadaActionPerformed(evt);
            }
        });
        this.jButtonAceptarCursada.setText("Aceptar");
        this.jButtonAceptarCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAceptarCursadaActionPerformed(evt);
            }
        });
        this.jButtonCancelarCursada.setText("Cancelar");
        this.jButtonCancelarCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonCancelarCursadaActionPerformed(evt);
            }
        });
        this.jButtonModificarCursada.setText("Modificar");
        this.jButtonModificarCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonModificarCursadaActionPerformed(evt);
            }
        });
        this.jTableAlumnosCursada.setModel(new TableModelAlumno());
        this.jScrollPane11.setViewportView(this.jTableAlumnosCursada);
        this.jButtonAgregarAlumnoCursada.setText("Agregar...");
        this.jButtonAgregarAlumnoCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAgregarAlumnoCursadaActionPerformed(evt);
            }
        });
        this.jButtonCambiarAsignaturaCursada.setText("Asignatura...");
        this.jButtonCambiarAsignaturaCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonCambiarAsignaturaCursadaActionPerformed(evt);
            }
        });
        this.jButtonEliminarProfesorCursada.setText("Eliminar...");
        this.jButtonEliminarProfesorCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarProfesorCursadaActionPerformed(evt);
            }
        });
        this.jButtonEliminarAlumnoCursada.setText("Eliminar...");
        this.jButtonEliminarAlumnoCursada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonEliminarAlumnoCursadaActionPerformed(evt);
            }
        });
        final GroupLayout jPanelResultadosCursadaLayout = new GroupLayout(this.jPanelResultadosCursada);
        this.jPanelResultadosCursada.setLayout(jPanelResultadosCursadaLayout);
        jPanelResultadosCursadaLayout.setHorizontalGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane10, -1, 582, 32767).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel19).addComponent(this.jLabel18)).addGap(17, 17, 17).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextFieldIdentificadorCursada).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addComponent(this.jTextFieldPeriodoCursada, -2, 58, -2).addGap(3, 3, 3).addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jComboBoxDia, -2, -1, -2).addGap(14, 14, 14).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldInicioCursada, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButtonAgregarProfesorCursada).addGap(18, 18, 18).addComponent(this.jButtonEliminarProfesorCursada)).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addComponent(this.jLabel22).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldFinCursada)))).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addComponent(this.jTextFieldIDAsignaturaCursada).addGap(18, 18, 18).addComponent(this.jTextFieldNombreAsignaturaCursada, -2, 300, -2).addGap(18, 18, 18).addComponent(this.jButtonCambiarAsignaturaCursada)))).addComponent(this.jScrollPane11, -1, 582, 32767).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addComponent(this.jLabel23, -1, -1, 32767).addGap(237, 237, 237).addComponent(this.jButtonAgregarAlumnoCursada).addGap(18, 18, 18).addComponent(this.jButtonEliminarAlumnoCursada)).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addComponent(this.jButtonAceptarCursada).addGap(18, 18, 18).addComponent(this.jButtonCancelarCursada)).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addComponent(this.jButtonNuevoCursada).addGap(18, 18, 18).addComponent(this.jButtonEliminarCursada).addGap(18, 18, 18).addComponent(this.jButtonModificarCursada)).addComponent(this.jLabel17, -2, 61, -2)).addGap(0, 0, 32767))).addContainerGap()));
        jPanelResultadosCursadaLayout.setVerticalGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelResultadosCursadaLayout.createSequentialGroup().addContainerGap().addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButtonNuevoCursada).addComponent(this.jButtonEliminarCursada).addComponent(this.jButtonModificarCursada)).addGap(18, 18, 18).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.jTextFieldIdentificadorCursada, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.jTextFieldNombreAsignaturaCursada, -2, -1, -2).addComponent(this.jTextFieldIDAsignaturaCursada, -2, -1, -2).addComponent(this.jButtonCambiarAsignaturaCursada)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldPeriodoCursada, -2, -1, -2).addComponent(this.jLabel18).addComponent(this.jTextFieldFinCursada, -2, -1, -2).addComponent(this.jLabel22).addComponent(this.jTextFieldInicioCursada, -2, -1, -2).addComponent(this.jLabel21).addComponent(this.jLabel20).addComponent(this.jComboBoxDia, -2, -1, -2)).addGap(42, 42, 42).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.jButtonAgregarProfesorCursada).addComponent(this.jButtonEliminarProfesorCursada)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane10, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel23).addComponent(this.jButtonAgregarAlumnoCursada).addComponent(this.jButtonEliminarAlumnoCursada)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane11, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelResultadosCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButtonCancelarCursada).addComponent(this.jButtonAceptarCursada)).addContainerGap()));
        final GroupLayout jPanelCursadaLayout = new GroupLayout(this.jPanelCursada);
        this.jPanelCursada.setLayout(jPanelCursadaLayout);
        jPanelCursadaLayout.setHorizontalGroup(jPanelCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCursadaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanelResultadosCursada, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanelCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanelBuscarCursada, -1, -1, 32767)).addContainerGap()));
        jPanelCursadaLayout.setVerticalGroup(jPanelCursadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanelCursadaLayout.createSequentialGroup().addContainerGap().addGroup(jPanelCursadaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanelResultadosCursada, -1, -1, 32767).addGroup(jPanelCursadaLayout.createSequentialGroup().addComponent(this.jPanelBuscarCursada, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -1, -1, 32767))).addContainerGap()));
        this.jTabbedPane.addTab("Cursada", this.jPanelCursada);
        this.jButtonAgradecimientos.setFont(new Font("Tahoma", 0, 8));
        this.jButtonAgradecimientos.setText("Agradecimientos");
        this.jButtonAgradecimientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                Ventana.this.jButtonAgradecimientosActionPerformed(evt);
            }
        });
        final GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButtonAgradecimientos)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jButtonAgradecimientos, -2, 8, -2).addGap(18, 18, 18).addComponent(this.jTabbedPane).addContainerGap()));
        this.pack();
    }
    
    private void jButtonBuscarAlumnoActionPerformed(final ActionEvent evt) {
        try {
            final Iterator<Alumno> alumnos = (Iterator<Alumno>)this.receptor.ubicar(this.jTextFieldBuscarAlumno.getText(), 0);
            final DefaultTableModel model = (DefaultTableModel)this.jTableAlumnoAlumno.getModel();
            model.setRowCount(0);
            while (alumnos.hasNext()) {
                final Alumno aux = alumnos.next();
                model.addRow(new Object[] { aux.getLegajo(), aux.getApellidoNombre(), aux.getDomicilio(), aux.getMail() });
            }
        }
        catch (NoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " Por favor vuelva a ingresarlo");
        }
    }
    
    private void jButtonNuevoAlumnoActionPerformed(final ActionEvent evt) {
        this.accionAceptar = 0;
        ((DefaultTableModel)this.jTableAlumnoAlumno.getModel()).setRowCount(0);
        ((DefaultTableModel)this.jTableHistoria.getModel()).setRowCount(0);
        this.jButtonBuscarAlumno.setEnabled(false);
        this.jTextFieldBuscarAlumno.setText("");
        this.jTextFieldBuscarAlumno.setEditable(false);
        this.jButtonNuevoAlumno.setEnabled(false);
        this.jButtonEliminarAlumno.setEnabled(false);
        this.jButtonModificarAlumno.setEnabled(false);
        this.jButtonCancelarAlumno.setEnabled(true);
        this.jButtonAceptarAlumno.setEnabled(true);
        this.jTextFieldLegajoAlumno.setText("");
        this.jTextFieldNombreAlumno.setEditable(true);
        this.jTextFieldNombreAlumno.setText("");
        this.jTextFieldDomicilioAlumno.setEditable(true);
        this.jTextFieldDomicilioAlumno.setText("");
        this.jTextFieldMailAlumno.setEditable(true);
        this.jTextFieldMailAlumno.setText("");
    }
    
    private void jButtonAgregarHistoriaActionPerformed(final ActionEvent evt) {
        new DialogAsignatura(this, this.receptor, this.jTableHistoria, new TableModelAsignatura());
    }
    
    private void jButtonModificarAlumnoActionPerformed(final ActionEvent evt) {
        if (!this.jTextFieldLegajoAlumno.getText().equals("")) {
            this.accionAceptar = 1;
            this.jButtonBuscarAlumno.setEnabled(false);
            this.jTextFieldBuscarAlumno.setText("");
            this.jTextFieldBuscarAlumno.setEditable(false);
            this.jButtonNuevoAlumno.setEnabled(false);
            this.jButtonEliminarAlumno.setEnabled(false);
            this.jButtonModificarAlumno.setEnabled(false);
            this.jButtonCancelarAlumno.setEnabled(true);
            this.jButtonAceptarAlumno.setEnabled(true);
            this.jTextFieldNombreAlumno.setEditable(true);
            this.jTextFieldDomicilioAlumno.setEditable(true);
            this.jTextFieldMailAlumno.setEditable(true);
            this.jButtonAgregarHistoria.setEnabled(true);
            this.jButtonEliminarHistoria.setEnabled(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para poder modificarlo");
        }
    }
    
    private void jButtonEliminarAlumnoActionPerformed(final ActionEvent evt) {
        if (!this.jTextFieldLegajoAlumno.getText().equals("")) {
            try {
                if (JOptionPane.showConfirmDialog(this, "\u00c2¿Esta usted seguro que desea eliminar?", "Eliminar Alumno", 0) == 0) {
                    this.receptor.baja(this.jTextFieldLegajoAlumno.getText(), 0);
                    ((DefaultTableModel)this.jTableAlumnoAlumno.getModel()).setRowCount(0);
                    this.cancelarAlumno();
                }
            }
            catch (NoEncontradoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            JOptionPane.showMessageDialog(this, "Alumno eliminado exitosamente.");
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para poder eliminarlo");
        }
    }
    
    private void jButtonCancelarAlumnoActionPerformed(final ActionEvent evt) {
        this.cancelarAlumno();
    }
    
    private void jButtonAceptarAlumnoActionPerformed(final ActionEvent evt) {
        final Alumno provisorio = new Alumno(this.jTextFieldNombreAlumno.getText(), this.jTextFieldDomicilioAlumno.getText(), this.jTextFieldMailAlumno.getText());
        try {
            if (this.accionAceptar == 0) {
                this.receptor.alta(provisorio, 0);
            }
            else if (this.accionAceptar == 1) {
                provisorio.setLegajo(this.jTextFieldLegajoAlumno.getText());
                final ArrayList<Asignatura> agregar = new ArrayList<Asignatura>();
                final ArrayList<Asignatura> eliminar = new ArrayList<Asignatura>();
                this.modificarHistoria(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 0, eliminar.iterator(), agregar.iterator());
            }
            else {
                JOptionPane.showMessageDialog(this, "La operaci\u00c3³n deseada no existe.");
            }
            this.cancelarAlumno();
            JOptionPane.showMessageDialog(this, "Operaci\u00c3³n realizada exitosamente.");
        }
        catch (NoEncontradoException | ClaveYaExistenteException | DatoInvalidoException ex) {
            //final Exception ex;
            final Exception e = ex;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void jButtonBuscarProfesorActionPerformed(final ActionEvent evt) {
        try {
            final Iterator<Profesor> profesores = (Iterator<Profesor>)this.receptor.ubicar(this.jTextFieldBuscarProfesor.getText(), 1);
            final DefaultTableModel model = (DefaultTableModel)this.jTableProfesorProfesor.getModel();
            model.setRowCount(0);
            while (profesores.hasNext()) {
                final Profesor aux = profesores.next();
                model.addRow(new Object[] { aux.getLegajo(), aux.getApellidoNombre(), aux.getDomicilio(), aux.getMail(), aux.getTelefono() });
            }
        }
        catch (NoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " Por favor vuelva a ingresarlo");
        }
    }
    
    private void jButtonNuevoProfesorActionPerformed(final ActionEvent evt) {
        this.accionAceptar = 0;
        ((DefaultTableModel)this.jTableProfesorProfesor.getModel()).setRowCount(0);
        ((DefaultTableModel)this.jTableCompetencia.getModel()).setRowCount(0);
        this.jTextFieldLegajoProfesor.setText("");
        this.jTextFieldNombreProfesor.setText("");
        this.jTextFieldNombreProfesor.setEditable(true);
        this.jTextFieldDomicilioProfesor.setText("");
        this.jTextFieldDomicilioProfesor.setEditable(true);
        this.jTextFieldMailProfesor.setText("");
        this.jTextFieldMailProfesor.setEditable(true);
        this.jTextFieldTelefonoProfesor.setText("");
        this.jTextFieldTelefonoProfesor.setEditable(true);
        this.jTextFieldBuscarProfesor.setText("");
        this.jTextFieldBuscarProfesor.setEditable(false);
        this.jButtonBuscarProfesor.setEnabled(false);
        this.jButtonNuevoProfesor.setEnabled(false);
        this.jButtonEliminarProfesor.setEnabled(false);
        this.jButtonModificarProfesor.setEnabled(false);
        this.jButtonAgregarCompetencia.setEnabled(true);
        this.jButtonEliminarCompetencia.setEnabled(true);
        this.jButtonCancelarProfesor.setEnabled(true);
        this.jButtonAceptarProfesor.setEnabled(true);
    }
    
    private void jButtonEliminarProfesorActionPerformed(final ActionEvent evt) {
        try {
            if (!this.jTextFieldLegajoProfesor.getText().equals("")) {
                if (JOptionPane.showConfirmDialog(this, "\u00c2¿Esta usted seguro que desea eliminar?", "Eliminar Profesor", 0) == 0) {
                    this.receptor.baja(this.jTextFieldLegajoProfesor.getText(), 1);
                    ((DefaultTableModel)this.jTableProfesorProfesor.getModel()).setRowCount(0);
                    this.cancelarProfesor();
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Seleccione un profesor para poder eliminarlo");
            }
        }
        catch (NoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        JOptionPane.showMessageDialog(this, "Profesor eliminado exitosamente.");
    }
    
    private void jButtonAgregarCompetenciaActionPerformed(final ActionEvent evt) {
        new DialogAsignatura(this, this.receptor, this.jTableCompetencia, new TableModelAsignatura());
    }
    
    private void jButtonAceptarProfesorActionPerformed(final ActionEvent evt) {
        final Profesor provisorio = new Profesor(this.jTextFieldNombreProfesor.getText(), this.jTextFieldDomicilioProfesor.getText(), this.jTextFieldMailProfesor.getText(), this.jTextFieldTelefonoProfesor.getText());
        try {
            if (this.accionAceptar == 0) {
                this.receptor.alta(provisorio, 1);
                this.jTextFieldLegajoProfesor.setText(provisorio.getLegajo());
                final ArrayList<Asignatura> agregar = new ArrayList<Asignatura>();
                final ArrayList<Asignatura> eliminar = new ArrayList<Asignatura>();
                this.modificarCompetencia(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 1, eliminar.iterator(), agregar.iterator());
            }
            else if (this.accionAceptar == 1) {
                provisorio.setLegajo(this.jTextFieldLegajoProfesor.getText());
                final ArrayList<Asignatura> agregar = new ArrayList<Asignatura>();
                final ArrayList<Asignatura> eliminar = new ArrayList<Asignatura>();
                this.modificarCompetencia(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 1, eliminar.iterator(), agregar.iterator());
            }
            else {
                JOptionPane.showMessageDialog(this, "La operaci\u00c3³n deseada no existe.");
            }
            this.cancelarProfesor();
            JOptionPane.showMessageDialog(this, "Operaci\u00c3³n realizada exitosamente.");
        }
        catch (NoEncontradoException | ClaveYaExistenteException | DatoInvalidoException ex) {
            //final Exception ex;
            final Exception e = ex;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void jButtonCancelarProfesorActionPerformed(final ActionEvent evt) {
        this.cancelarProfesor();
    }
    
    private void jButtonModificarProfesorActionPerformed(final ActionEvent evt) {
        if (!this.jTextFieldLegajoProfesor.getText().equals("")) {
            this.accionAceptar = 1;
            ((DefaultTableModel)this.jTableProfesorProfesor.getModel()).setRowCount(0);
            this.jTextFieldNombreProfesor.setEditable(true);
            this.jTextFieldDomicilioProfesor.setEditable(true);
            this.jTextFieldMailProfesor.setEditable(true);
            this.jTextFieldTelefonoProfesor.setEditable(true);
            this.jButtonEliminarProfesor.setEnabled(false);
            this.jButtonNuevoProfesor.setEnabled(false);
            this.jButtonModificarProfesor.setEnabled(false);
            this.jButtonAgregarCompetencia.setEnabled(true);
            this.jButtonEliminarCompetencia.setEnabled(true);
            this.jButtonAceptarProfesor.setEnabled(true);
            this.jButtonCancelarProfesor.setEnabled(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor para poder modificarlo");
        }
    }
    
    private void jButtonBuscarAsignaturaActionPerformed(final ActionEvent evt) {
        try {
            final Iterator<Asignatura> asignaturas = (Iterator<Asignatura>)this.receptor.ubicar(this.jTextFieldBuscarAsignatura.getText(), 2);
            final DefaultTableModel model = (DefaultTableModel)this.jTableAsignaturaAsignatura.getModel();
            model.setRowCount(0);
            while (asignaturas.hasNext()) {
                final Asignatura aux = asignaturas.next();
                model.addRow(new Object[] { aux.getIdentificacion(), aux.getNombre() });
            }
        }
        catch (NoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " Por favor vuelva a ingresarlo");
        }
    }
    
    private void jButtonNuevoAsignaturaActionPerformed(final ActionEvent evt) {
        this.accionAceptar = 0;
        ((DefaultTableModel)this.jTableAsignaturaAsignatura.getModel()).setRowCount(0);
        ((DefaultTableModel)this.jTableCorrelativas.getModel()).setRowCount(0);
        this.jTextFieldIdentificadorAsignatura.setText("");
        this.jTextFieldNombreAsignatura.setText("");
        this.jTextFieldNombreAsignatura.setEditable(true);
        this.jButtonEliminarAsignatura.setEnabled(false);
        this.jButtonModificarAsignatura.setEnabled(false);
        this.jButtonNuevoAsignatura.setEnabled(false);
        this.jButtonAgregarCorrelativa.setEnabled(true);
        this.jButtonEliminarCorrelativa.setEnabled(true);
        this.jButtonAceptarAsignatura.setEnabled(true);
        this.jButtonCancelarAsignatura.setEnabled(true);
        this.jTextFieldBuscarAsignatura.setText("");
        this.jTextFieldBuscarAsignatura.setEditable(false);
        this.jButtonBuscarAsignatura.setEnabled(false);
    }
    
    private void jButtonEliminarAsignaturaActionPerformed(final ActionEvent evt) {
        try {
            if (!this.jTextFieldIdentificadorAsignatura.getText().equals("")) {
                if (JOptionPane.showConfirmDialog(this, "\u00c2¿Esta usted seguro que desea eliminar?", "Eliminar Asignatura", 0) == 0) {
                    this.receptor.baja(this.jTextFieldIdentificadorAsignatura.getText(), 2);
                    ((DefaultTableModel)this.jTableAsignaturaAsignatura.getModel()).setRowCount(0);
                    this.cancelarAsignatura();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Seleccione una asignatura para poder eliminarla");
                }
            }
        }
        catch (NoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        JOptionPane.showMessageDialog(this, "Asignatura eliminada exitosamente.");
    }
    
    private void jButtonAgregarCorrelativaActionPerformed(final ActionEvent evt) {
        new DialogAsignatura(this, this.receptor, this.jTableCorrelativas, new TableModelAsignatura());
    }
    
    private void jButtonAceptarAsignaturaActionPerformed(final ActionEvent evt) {
        final Asignatura provisorio = new Asignatura(this.jTextFieldNombreAsignatura.getText());
        try {
            final ArrayList<Asignatura> agregar = new ArrayList<Asignatura>();
            final ArrayList<Asignatura> eliminar = new ArrayList<Asignatura>();
            if (this.accionAceptar == 0) {
                this.receptor.alta(provisorio, 2);
                this.jTextFieldIdentificadorAsignatura.setText(provisorio.getIdentificacion());
                this.modificarCorrelativa(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 2, eliminar.iterator(), agregar.iterator());
            }
            else if (this.accionAceptar == 1) {
                provisorio.setIdentificacion(this.jTextFieldIdentificadorAsignatura.getText());
                this.modificarCorrelativa(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 2, eliminar.iterator(), agregar.iterator());
            }
            else {
                JOptionPane.showMessageDialog(this, "La operaci\u00c3³n deseada no existe.");
            }
            this.cancelarAsignatura();
            JOptionPane.showMessageDialog(this, "Operaci\u00c3³n realizada exitosamente.");
        }
        catch (NoEncontradoException | ClaveYaExistenteException | DatoInvalidoException ex2) {
            final Exception ex;
            final Exception e = ex2;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void jButtonCancelarAsignaturaActionPerformed(final ActionEvent evt) {
        this.cancelarAsignatura();
    }
    
    private void jButtonModificarAsignaturaActionPerformed(final ActionEvent evt) {
        if (!this.jTextFieldIdentificadorAsignatura.getText().equals("")) {
            this.accionAceptar = 1;
            this.jTextFieldNombreAsignatura.setEditable(true);
            this.jButtonEliminarAsignatura.setEnabled(false);
            this.jButtonNuevoAsignatura.setEnabled(false);
            this.jButtonModificarAsignatura.setEnabled(false);
            this.jButtonAgregarCorrelativa.setEnabled(true);
            this.jButtonEliminarCorrelativa.setEnabled(true);
            this.jButtonAceptarAsignatura.setEnabled(true);
            this.jButtonCancelarAsignatura.setEnabled(true);
            ((DefaultTableModel)this.jTableAsignaturaAsignatura.getModel()).setRowCount(0);
            this.jTextFieldBuscarAsignatura.setText("");
            this.jTextFieldBuscarAsignatura.setEditable(false);
            this.jButtonBuscarAsignatura.setEnabled(false);
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione una asignatura para poder modificarla");
        }
    }
    
    private void jButtonBuscarCursadaActionPerformed(final ActionEvent evt) {
        try {
            final Iterator<Cursada> cursadas = (Iterator<Cursada>)this.receptor.ubicar(this.jTextFieldBuscarCursada.getText(), 3);
            final DefaultTableModel model = (DefaultTableModel)this.jTableCursadaCursada.getModel();
            model.setRowCount(0);
            while (cursadas.hasNext()) {
                final Cursada aux = cursadas.next();
                model.addRow(new Object[] { aux.getIdentificacion(), aux.getAsignatura().getIdentificacion(), aux.getAsignatura().getNombre(), aux.getPeriodo(), aux.getDia(), aux.getHoraInicio(), aux.getHoraFinalizacion() });
            }
        }
        catch (NoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + " Por favor vuelva a ingresarlo");
        }
    }
    
    private void jButtonNuevoCursadaActionPerformed(final ActionEvent evt) {
        this.accionAceptar = 0;
        this.jTextFieldIdentificadorCursada.setText("");
        this.jTextFieldIDAsignaturaCursada.setText("");
        this.jButtonCambiarAsignaturaCursada.setEnabled(true);
        this.jTextFieldNombreAsignaturaCursada.setText("");
        this.jComboBoxDia.setEnabled(true);
        this.jTextFieldPeriodoCursada.setText("");
        this.jTextFieldPeriodoCursada.setEditable(true);
        this.jTextFieldInicioCursada.setText("");
        this.jTextFieldInicioCursada.setEditable(true);
        this.jTextFieldFinCursada.setText("");
        this.jTextFieldFinCursada.setEditable(true);
        ((DefaultTableModel)this.jTableCursadaCursada.getModel()).setRowCount(0);
        ((DefaultTableModel)this.jTableAlumnosCursada.getModel()).setRowCount(0);
        ((DefaultTableModel)this.jTableProfesoresCursada.getModel()).setRowCount(0);
        this.jTextFieldBuscarCursada.setText("");
        this.jTextFieldBuscarCursada.setEditable(false);
        this.jButtonBuscarCursada.setEnabled(false);
        this.jButtonEliminarCursada.setEnabled(false);
        this.jButtonModificarCursada.setEnabled(false);
        this.jButtonNuevoAlumno.setEnabled(false);
        this.jButtonAgregarAlumnoCursada.setEnabled(true);
        this.jButtonEliminarAlumnoCursada.setEnabled(true);
        this.jButtonAgregarProfesorCursada.setEnabled(true);
        this.jButtonEliminarProfesorCursada.setEnabled(true);
        this.jButtonCancelarCursada.setEnabled(true);
        this.jButtonAceptarCursada.setEnabled(true);
    }
    
    private void jButtonEliminarCursadaActionPerformed(final ActionEvent evt) {
        if (!this.jTextFieldIdentificadorCursada.getText().equals("")) {
            try {
                if (JOptionPane.showConfirmDialog(this, "\u00c2¿Esta usted seguro que desea eliminar?", "Eliminar Cursada", 0) == 0) {
                    this.receptor.baja(this.receptor.buscar(this.jTextFieldIdentificadorCursada.getText(), 3), 3);
                    ((DefaultTableModel)this.jTableCursadaCursada.getModel()).setRowCount(0);
                    this.cancelarCursada();
                }
            }
            catch (NoEncontradoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione una cursada para poder eliminarla");
        }
        JOptionPane.showMessageDialog(this, "Cursada eliminada exitosamente.");
    }
    
    private void jButtonAgregarProfesorCursadaActionPerformed(final ActionEvent evt) {
        new DialogProfesor(this, this.receptor, this.jTableProfesoresCursada, new TableModelProfesor());
    }
    
    private void jButtonAceptarCursadaActionPerformed(final ActionEvent evt) {
        try {
            final Cursada provisorio = new Cursada((Asignatura)this.receptor.buscar(this.jTextFieldIDAsignaturaCursada.getText(), 2), this.jTextFieldPeriodoCursada.getText(), Dia.parseDia(this.jComboBoxDia.getItemAt(this.jComboBoxDia.getSelectedIndex())), this.jTextFieldInicioCursada.getText(), this.jTextFieldFinCursada.getText());
            final ArrayList<Persona> agregar = new ArrayList<Persona>();
            final ArrayList<Persona> eliminar = new ArrayList<Persona>();
            if (this.accionAceptar == 0) {
                this.receptor.alta(provisorio, 3);
                this.jTextFieldIdentificadorCursada.setText(provisorio.getIdentificacion());
                this.modificarCursada(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 3, eliminar.iterator(), agregar.iterator());
            }
            else if (this.accionAceptar == 1) {
                provisorio.setIdentificacion(this.jTextFieldIdentificadorCursada.getText());
                this.modificarCursada(provisorio, eliminar, agregar);
                this.receptor.modificacion(provisorio, 3, eliminar.iterator(), agregar.iterator());
            }
            else {
                JOptionPane.showMessageDialog(this, "La operaci\u00c3³n deseada no existe.");
            }
            this.cancelarCursada();
            JOptionPane.showMessageDialog(this, "Operaci\u00c3³n realizada exitosamente.");
        }
        catch (DatoInvalidoException | NoEncontradoException | ClaveYaExistenteException | DiaInvalidoException ex) {
            //final Exception ex;
            final Exception e = ex;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void jButtonCancelarCursadaActionPerformed(final ActionEvent evt) {
        this.cancelarCursada();
    }
    
    private void jButtonModificarCursadaActionPerformed(final ActionEvent evt) {
        if (!this.jTextFieldIdentificadorCursada.getText().equals("")) {
            this.accionAceptar = 1;
            ((DefaultTableModel)this.jTableCursadaCursada.getModel()).setRowCount(0);
            this.jComboBoxDia.setEnabled(true);
            this.jTextFieldPeriodoCursada.setEditable(true);
            this.jTextFieldInicioCursada.setEditable(true);
            this.jTextFieldFinCursada.setEditable(true);
            this.jButtonAgregarAlumnoCursada.setEnabled(true);
            this.jButtonEliminarAlumnoCursada.setEnabled(true);
            this.jButtonAgregarProfesorCursada.setEnabled(true);
            this.jButtonEliminarProfesorCursada.setEnabled(true);
            this.jButtonCambiarAsignaturaCursada.setEnabled(true);
            this.jButtonCancelarCursada.setEnabled(true);
            this.jButtonAceptarCursada.setEnabled(true);
            this.jButtonEliminarCursada.setEnabled(false);
            this.jButtonNuevoCursada.setEnabled(false);
            this.jButtonModificarCursada.setEnabled(false);
            this.jTextFieldBuscarCursada.setText("");
            this.jTextFieldBuscarCursada.setEditable(false);
            this.jButtonBuscarCursada.setEnabled(false);
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione una cursada para poder modificarla");
        }
    }
    
    private void jButtonAgregarAlumnoCursadaActionPerformed(final ActionEvent evt) {
        new DialogAlumno(this, this.receptor, this.jTableAlumnosCursada, new TableModelAlumno());
    }
    
    private void jButtonCambiarAsignaturaCursadaActionPerformed(final ActionEvent evt) {
        new DialogAsignaturaCursada(this, this.receptor, this.jTextFieldIDAsignaturaCursada, this.jTextFieldNombreAsignaturaCursada);
    }
    
    private void jButtonEliminarHistoriaActionPerformed(final ActionEvent evt) {
        if (this.jTableHistoria.getSelectedRow() != -1) {
            final TableModelAsignatura aux = (TableModelAsignatura)this.jTableHistoria.getModel();
            aux.removeRow(this.jTableHistoria.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione una asignatura para poder eliminarla de la historia");
        }
    }
    
    private void jButtonEliminarCompetenciaActionPerformed(final ActionEvent evt) {
        if (this.jTableCompetencia.getSelectedRow() != -1) {
            final TableModelAsignatura aux = (TableModelAsignatura)this.jTableCompetencia.getModel();
            aux.removeRow(this.jTableCompetencia.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione una asignatura para poder eliminarla de la competencia");
        }
    }
    
    private void jButtonEliminarCorrelativaActionPerformed(final ActionEvent evt) {
        if (this.jTableCorrelativas.getSelectedRow() != -1) {
            final TableModelAsignatura aux = (TableModelAsignatura)this.jTableCorrelativas.getModel();
            aux.removeRow(this.jTableCorrelativas.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione una asignatura para poder eliminarla de las correlativas");
        }
    }
    
    private void jButtonEliminarProfesorCursadaActionPerformed(final ActionEvent evt) {
        if (this.jTableProfesoresCursada.getSelectedRow() != -1) {
            final TableModelProfesor aux = (TableModelProfesor)this.jTableProfesoresCursada.getModel();
            aux.removeRow(this.jTableProfesoresCursada.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor para poder eliminarlo de la cursada");
        }
    }
    
    private void jButtonEliminarAlumnoCursadaActionPerformed(final ActionEvent evt) {
        if (this.jTableAlumnosCursada.getSelectedRow() != -1) {
            final TableModelAlumno aux = (TableModelAlumno)this.jTableAlumnosCursada.getModel();
            aux.removeRow(this.jTableAlumnosCursada.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno para poder eliminarlo de la cursada");
        }
    }
    
    private void jButtonAgradecimientosActionPerformed(final ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Gracias DarioFF");
    }
    
    private void cancelarAlumno() {
        this.jTextFieldLegajoAlumno.setText("");
        this.jTextFieldNombreAlumno.setText("");
        this.jTextFieldNombreAlumno.setEditable(false);
        this.jTextFieldDomicilioAlumno.setText("");
        this.jTextFieldDomicilioAlumno.setEditable(false);
        this.jTextFieldMailAlumno.setText("");
        this.jTextFieldMailAlumno.setEditable(false);
        this.jTextFieldBuscarAlumno.setText("");
        this.jTextFieldBuscarAlumno.setEditable(true);
        this.jButtonBuscarAlumno.setEnabled(true);
        ((DefaultTableModel)this.jTableHistoria.getModel()).setRowCount(0);
        this.jButtonEliminarAlumno.setEnabled(true);
        this.jButtonModificarAlumno.setEnabled(true);
        this.jButtonNuevoAlumno.setEnabled(true);
        this.jButtonAgregarHistoria.setEnabled(false);
        this.jButtonEliminarHistoria.setEnabled(false);
        this.jButtonAceptarAlumno.setEnabled(false);
        this.jButtonCancelarAlumno.setEnabled(false);
    }
    
    private void cancelarProfesor() {
        this.jTextFieldLegajoProfesor.setText("");
        this.jTextFieldNombreProfesor.setText("");
        this.jTextFieldNombreProfesor.setEditable(false);
        this.jTextFieldDomicilioProfesor.setText("");
        this.jTextFieldDomicilioProfesor.setEditable(false);
        this.jTextFieldMailProfesor.setText("");
        this.jTextFieldMailProfesor.setEditable(false);
        this.jTextFieldTelefonoProfesor.setText("");
        this.jTextFieldTelefonoProfesor.setEditable(false);
        this.jTextFieldBuscarProfesor.setText("");
        this.jTextFieldBuscarProfesor.setEditable(true);
        this.jButtonBuscarProfesor.setEnabled(true);
        ((DefaultTableModel)this.jTableCompetencia.getModel()).setRowCount(0);
        this.jButtonEliminarProfesor.setEnabled(true);
        this.jButtonModificarProfesor.setEnabled(true);
        this.jButtonNuevoProfesor.setEnabled(true);
        this.jButtonEliminarCompetencia.setEnabled(false);
        this.jButtonAgregarCompetencia.setEnabled(false);
        this.jButtonAceptarProfesor.setEnabled(false);
        this.jButtonCancelarProfesor.setEnabled(false);
    }
    
    private void cancelarAsignatura() {
        this.jTextFieldIdentificadorAsignatura.setText("");
        this.jTextFieldNombreAsignatura.setText("");
        this.jTextFieldNombreAsignatura.setEditable(false);
        this.jTextFieldBuscarAsignatura.setText("");
        this.jTextFieldBuscarAsignatura.setEditable(true);
        this.jButtonBuscarAsignatura.setEnabled(true);
        ((DefaultTableModel)this.jTableCorrelativas.getModel()).setRowCount(0);
        this.jButtonEliminarAsignatura.setEnabled(true);
        this.jButtonModificarAsignatura.setEnabled(true);
        this.jButtonNuevoAsignatura.setEnabled(true);
        this.jButtonAgregarCorrelativa.setEnabled(false);
        this.jButtonEliminarCorrelativa.setEnabled(false);
        this.jButtonCancelarAsignatura.setEnabled(false);
        this.jButtonAceptarAsignatura.setEnabled(false);
    }
    
    private void cancelarCursada() {
        ((DefaultTableModel)this.jTableAlumnosCursada.getModel()).setRowCount(0);
        ((DefaultTableModel)this.jTableProfesoresCursada.getModel()).setRowCount(0);
        this.jTextFieldIdentificadorCursada.setText("");
        this.jTextFieldIDAsignaturaCursada.setText("");
        this.jTextFieldNombreAsignaturaCursada.setText("");
        this.jTextFieldPeriodoCursada.setText("");
        this.jTextFieldPeriodoCursada.setEditable(false);
        this.jTextFieldInicioCursada.setText("");
        this.jTextFieldInicioCursada.setEditable(false);
        this.jTextFieldFinCursada.setText("");
        this.jTextFieldFinCursada.setEditable(false);
        this.jComboBoxDia.setEnabled(false);
        this.jTextFieldBuscarCursada.setText("");
        this.jTextFieldBuscarCursada.setEditable(true);
        this.jButtonBuscarCursada.setEnabled(true);
        this.jButtonEliminarCursada.setEnabled(true);
        this.jButtonModificarCursada.setEnabled(true);
        this.jButtonNuevoCursada.setEnabled(true);
        this.jButtonAgregarAlumnoCursada.setEnabled(false);
        this.jButtonEliminarAlumnoCursada.setEnabled(false);
        this.jButtonCambiarAsignaturaCursada.setEnabled(false);
        this.jButtonAgregarProfesorCursada.setEnabled(false);
        this.jButtonEliminarProfesorCursada.setEnabled(false);
        this.jButtonAceptarCursada.setEnabled(false);
        this.jButtonCancelarCursada.setEnabled(false);
    }
    
    private void modificarHistoria(final Alumno provisorio, final ArrayList<Asignatura> eliminar, final ArrayList<Asignatura> agregar) throws NoEncontradoException, ClaveYaExistenteException {
        final int n = this.jTableHistoria.getModel().getRowCount();
        final Alumno viejo = (Alumno)this.receptor.buscar(provisorio.getLegajo(), 0);
        for (int i = 0; i < n; ++i) {
            provisorio.agregarHistoria((Asignatura)this.receptor.buscar(this.jTableHistoria.getValueAt(i, 0), 2));
        }
        Iterator<Asignatura> asignaturasViejas = viejo.historiaAcademica();
        while (asignaturasViejas.hasNext()) {
            final Asignatura auxiliar = asignaturasViejas.next();
            if (!provisorio.asignaturaAprobada(auxiliar)) {
                eliminar.add(auxiliar);
            }
        }
        asignaturasViejas = provisorio.historiaAcademica();
        while (asignaturasViejas.hasNext()) {
            final Asignatura auxiliar = asignaturasViejas.next();
            if (!viejo.asignaturaAprobada(auxiliar)) {
                agregar.add(auxiliar);
            }
        }
    }
    
    private void modificarCompetencia(final Profesor provisorio, final ArrayList<Asignatura> eliminar, final ArrayList<Asignatura> agregar) throws NoEncontradoException, ClaveYaExistenteException {
        final int n = this.jTableCompetencia.getModel().getRowCount();
        final Profesor viejo = (Profesor)this.receptor.buscar(provisorio.getLegajo(), 1);
        for (int i = 0; i < n; ++i) {
            provisorio.agregarCompetencia((Asignatura)this.receptor.buscar(this.jTableCompetencia.getValueAt(i, 0), 2));
        }
        Iterator<Asignatura> asignaturasViejas = viejo.competencias();
        while (asignaturasViejas.hasNext()) {
            final Asignatura auxiliar = asignaturasViejas.next();
            if (!provisorio.habilitadoParaAsignatura(auxiliar)) {
                eliminar.add(auxiliar);
            }
        }
        asignaturasViejas = provisorio.competencias();
        while (asignaturasViejas.hasNext()) {
            final Asignatura auxiliar = asignaturasViejas.next();
            if (!viejo.habilitadoParaAsignatura(auxiliar)) {
                agregar.add(auxiliar);
            }
        }
    }
    
    private void modificarCorrelativa(final Asignatura provisorio, final ArrayList<Asignatura> eliminar, final ArrayList<Asignatura> agregar) throws NoEncontradoException, ClaveYaExistenteException, DatoInvalidoException {
        final int n = this.jTableCorrelativas.getModel().getRowCount();
        final Asignatura viejo = (Asignatura)this.receptor.buscar(provisorio.getIdentificacion(), 2);
        for (int i = 0; i < n; ++i) {
            provisorio.agregarCorrelativa((Asignatura)this.receptor.buscar(this.jTableCorrelativas.getValueAt(i, 0), 2));
        }
        Iterator<Asignatura> asignaturasViejas = viejo.precorrelativas();
        while (asignaturasViejas.hasNext()) {
            final Asignatura auxiliar = asignaturasViejas.next();
            if (!provisorio.tienePrecorrelativa(auxiliar)) {
                eliminar.add(auxiliar);
            }
        }
        asignaturasViejas = provisorio.precorrelativas();
        while (asignaturasViejas.hasNext()) {
            final Asignatura auxiliar = asignaturasViejas.next();
            if (!viejo.tienePrecorrelativa(auxiliar)) {
                agregar.add(auxiliar);
            }
        }
    }
    
    private void modificarCursada(final Cursada provisorio, final ArrayList<Persona> eliminar, final ArrayList<Persona> agregar) throws NoEncontradoException, ClaveYaExistenteException, DatoInvalidoException {
        int n = this.jTableAlumnosCursada.getModel().getRowCount();
        final Cursada viejo = (Cursada)this.receptor.buscar(provisorio.getIdentificacion(), 3);
        for (int i = 0; i < n; ++i) {
            provisorio.altaAlumno((Alumno)this.receptor.buscar(this.jTableAlumnosCursada.getValueAt(i, 0), 0));
        }
        Iterator<Alumno> alumnoViejas = viejo.alumnos();
        while (alumnoViejas.hasNext()) {
            final Alumno auxiliar = alumnoViejas.next();
            if (!provisorio.tieneAlumno(auxiliar)) {
                eliminar.add(auxiliar);
            }
        }
        alumnoViejas = provisorio.alumnos();
        while (alumnoViejas.hasNext()) {
            final Alumno auxiliar = alumnoViejas.next();
            if (!viejo.tieneAlumno(auxiliar)) {
                agregar.add(auxiliar);
            }
        }
        n = this.jTableProfesoresCursada.getModel().getRowCount();
        for (int i = 0; i < n; ++i) {
            provisorio.altaProfesor((Profesor)this.receptor.buscar(this.jTableProfesoresCursada.getValueAt(i, 0), 1));
        }
        Iterator<Profesor> profesorViejas = viejo.profesores();
        while (profesorViejas.hasNext()) {
            final Profesor auxiliar2 = profesorViejas.next();
            if (!provisorio.tieneProfesor(auxiliar2)) {
                eliminar.add(auxiliar2);
            }
        }
        profesorViejas = provisorio.profesores();
        while (profesorViejas.hasNext()) {
            final Profesor auxiliar2 = profesorViejas.next();
            if (!viejo.tieneProfesor(auxiliar2)) {
                agregar.add(auxiliar2);
            }
        }
    }
}
