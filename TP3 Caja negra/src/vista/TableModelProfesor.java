// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import modelo.Profesor;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class TableModelProfesor extends DefaultTableModel
{
    public TableModelProfesor() {
        super(new Object[] { "Legajo", "Apellido y Nombre", "Domicilio", "Mail", "Telefono" }, 0);
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
    
    public void agregarFilas(final Iterator profesores) {
        this.setRowCount(0);
        while (profesores.hasNext()) {
            final Profesor aux = (Profesor)profesores.next();
            this.addRow(new Object[] { aux.getLegajo(), aux.getApellidoNombre(), aux.getDomicilio(), aux.getMail(), aux.getTelefono() });
        }
    }
}