// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import modelo.Alumno;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class TableModelAlumno extends DefaultTableModel
{
    public TableModelAlumno() {
        super(new Object[] { "Legajo", "Apellido y Nombre", "Domicilio", "Mail" }, 0);
    }
    
    @Override
    public boolean isCellEditable(final int row, final int column) {
        return false;
    }
    
    public boolean contieneElemento(final String id) {
        int n;
        int i;
        for (n = this.getRowCount(), i = 0; i < n && !this.getValueAt(i, 0).equals(id); ++i) {}
        return i < n;
    }
    
    public void agregarFilas(final Iterator alumnos) {
        this.setRowCount(0);
        while (alumnos.hasNext()) {
            final Alumno aux = (Alumno)alumnos.next();
            this.addRow(new Object[] { aux.getLegajo(), aux.getApellidoNombre(), aux.getDomicilio(), aux.getMail() });
        }
    }
}