// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import excepciones.NoEncontradoException;
import javax.swing.JOptionPane;
import modelo.Alumno;
import javax.swing.event.ListSelectionEvent;
import java.util.Iterator;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JFrame;

public class DialogAlumno extends MiDialogo
{
    private TableModelAlumno modeloAlumno;
    
    public DialogAlumno(final JFrame owner, final Receptor receptor, final JTable fuente, final DefaultTableModel modelo) {
        super(owner, receptor, fuente);
        this.setTitle("Selecci\u00c3³n de alumno");
        this.modeloAlumno = (TableModelAlumno)modelo;
        this.tabla = new JTable(this.modeloAlumno);
        this.resultado.setLayout(new BorderLayout());
        this.scroll = new JScrollPane(this.tabla);
        this.tabla.setFillsViewportHeight(true);
        this.resultado.add(this.scroll);
        this.resultado.add(this.tabla.getTableHeader(), "First");
        this.resultado.add(this.tabla, "Center");
        this.setVisible(true);
    }
    
    @Override
    public void agregaResultadosTabla(final Iterator alumnos) {
        this.modeloAlumno.agregarFilas(alumnos);
    }
    
    @Override
    public int getComandoAccion() {
        return 0;
    }
    
    @Override
    public void valueChanged(final ListSelectionEvent e) {
        try {
            final Alumno elemento = (Alumno)this.receptor.buscar(this.tabla.getValueAt(this.tabla.getSelectedRow(), 0), 0);
            final TableModelAlumno model = (TableModelAlumno)this.fuente.getModel();
            if (!model.contieneElemento(elemento.getLegajo())) {
                model.addRow(new Object[] { elemento.getLegajo(), elemento.getApellidoNombre(), elemento.getDomicilio(), elemento.getMail() });
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "El elemento seleccionado ya est\u00c3¡ en la lista");
            }
        }
        catch (NoEncontradoException f) {
            JOptionPane.showMessageDialog(this, f.getMessage());
            this.dispose();
        }
    }
}
