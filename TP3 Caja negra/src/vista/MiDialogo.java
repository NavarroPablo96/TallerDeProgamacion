// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import javax.swing.ListSelectionModel;
import excepciones.NoEncontradoException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
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

public abstract class MiDialogo extends JDialog implements ActionListener, ListSelectionListener
{
    protected Receptor receptor;
    protected JTextField texto;
    protected JButton aceptar;
    protected JTable tabla;
    protected JScrollPane scroll;
    protected JPanel busqueda;
    protected JPanel resultado;
    public static final Dimension JTEXTFIEDL_DIMEN;
    protected JTable fuente;
    
    public MiDialogo(final JFrame owner, final Receptor receptor, final JTable fuente) {
        super(owner, true);
        this.fuente = fuente;
        this.setSize(750, 500);
        this.setDefaultCloseOperation(2);
        this.receptor = receptor;
        final Container contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(this.resultado = new JPanel(), "Center");
        contenedor.add(this.busqueda = new JPanel(new FlowLayout()), "North");
        this.texto = new JTextField();
        this.aceptar = new JButton("Aceptar");
        this.busqueda.add(this.texto);
        this.busqueda.add(this.aceptar);
        this.texto.setPreferredSize(MiDialogo.JTEXTFIEDL_DIMEN);
        this.aceptar.addActionListener(this);
    }
    
    public abstract void agregaResultadosTabla(final Iterator p0);
    
    public abstract int getComandoAccion();
    
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
    }
}