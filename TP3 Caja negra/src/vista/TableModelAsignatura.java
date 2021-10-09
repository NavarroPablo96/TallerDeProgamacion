// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import modelo.Asignatura;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class TableModelAsignatura extends DefaultTableModel
{
    public TableModelAsignatura() {
        super(new Object[] { "Identificacion", "Nombre" }, 0);
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
    
    public void agregarFilas(final Iterator asignaturas) {
        this.setRowCount(0);
        while (asignaturas.hasNext()) {
            final Asignatura aux = (Asignatura)asignaturas.next();
            this.addRow(new Object[] { aux.getIdentificacion(), aux.getNombre() });
        }
    }
}