// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;
import excepciones.NoEncontradoException;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import javax.swing.event.ListSelectionEvent;
import java.util.Iterator;
import java.awt.Container;
import javax.swing.table.TableModel;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class DialogAsignaturaCursada extends JDialog implements ActionListener, ListSelectionListener
{
    protected Receptor receptor;
    protected JTextField texto;
    protected JButton aceptar;
    protected JTable tabla;
    protected JScrollPane scroll;
    protected JPanel busqueda;
    protected JPanel resultado;
    public static final Dimension JTEXTFIEDL_DIMEN;
    public static final Dimension JBUTTON_DIMEN;
    protected JTable fuente;
    protected TableModelAsignatura modeloAsignatura;
    protected JTextField id;
    protected JTextField nombre;
    
    public DialogAsignaturaCursada(final JFrame owner, final Receptor receptor, final JTextField id, final JTextField nombre) {
        super(owner, true);
        this.setTitle("Selecci\u00c3³n de asignatura");
        this.id = id;
        this.nombre = nombre;
        this.setSize(750, 500);
        this.setDefaultCloseOperation(2);
        this.receptor = receptor;
        this.busqueda = new JPanel(new FlowLayout());
        this.resultado = new JPanel();
        final Container contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(this.resultado, "Center");
        contenedor.add(this.busqueda, "North");
        this.texto = new JTextField();
        this.aceptar = new JButton("Aceptar");
        this.busqueda.add(this.texto);
        this.busqueda.add(this.aceptar);
        this.texto.setPreferredSize(MiDialogo.JTEXTFIEDL_DIMEN);
        this.aceptar.addActionListener(this);
        this.modeloAsignatura = new TableModelAsignatura();
        this.tabla = new JTable(this.modeloAsignatura);
        this.resultado.setLayout(new BorderLayout());
        this.scroll = new JScrollPane(this.tabla);
        this.tabla.setFillsViewportHeight(true);
        this.resultado.add(this.scroll);
        this.resultado.add(this.tabla.getTableHeader(), "First");
        this.resultado.add(this.tabla, "Center");
        this.setVisible(true);
    }
    
    public void agregaResultadosTabla(final Iterator alumnos) {
        this.modeloAsignatura.agregarFilas(alumnos);
    }
    
    public int getComandoAccion() {
        return 2;
    }
    
    @Override
    public void valueChanged(final ListSelectionEvent e) {
        try {
            final Asignatura elemento = (Asignatura)this.receptor.buscar(this.tabla.getValueAt(this.tabla.getSelectedRow(), 0), 2);
            this.id.setText(elemento.getIdentificacion());
            this.nombre.setText(elemento.getNombre());
        }
        catch (NoEncontradoException f) {
            JOptionPane.showMessageDialog(this, f.getMessage());
        }
        this.dispose();
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        try {
            this.agregaResultadosTabla(this.receptor.ubicar(this.texto.getText(), this.getComandoAccion()));
            this.tabla.setSelectionMode(0);
            this.tabla.setRowSelectionAllowed(true);
            final ListSelectionModel model = this.tabla.getSelectionModel();
            model.addListSelectionListener(this);
        }
        catch (NoEncontradoException f) {
            JOptionPane.showMessageDialog(this, f.getMessage());
        }
    }
    
    static {
        JTEXTFIEDL_DIMEN = new Dimension(200, 20);
        JBUTTON_DIMEN = new Dimension(100, 30);
    }
}
