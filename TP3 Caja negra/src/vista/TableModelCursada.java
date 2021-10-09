// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import modelo.Cursada;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class TableModelCursada extends DefaultTableModel
{
    public TableModelCursada() {
        super(new Object[] { "Identificacion", "ID Asignatura", "Nombre Asignatura", "Periodo", "Dia", "Hora Inicio", "Hora Finalizacion" }, 0);
    }
    
    @Override
    public boolean isCellEditable(final int row, final int column) {
        return false;
    }
    
    public void agregarFilas(final Iterator cursadas) {
        this.setRowCount(0);
        while (cursadas.hasNext()) {
            final Cursada aux = (Cursada)cursadas.next();
            this.addRow(new Object[] { aux.getIdentificacion(), aux.getAsignatura().getIdentificacion(), aux.getAsignatura().getNombre(), aux.getPeriodo(), aux.getDia(), aux.getHoraInicio(), aux.getHoraFinalizacion() });
        }
    }
}