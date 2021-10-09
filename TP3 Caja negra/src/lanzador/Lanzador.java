// 
// Decompiled by Procyon v0.5.36
// 

package lanzador;

import modelo.Sistema;
import vista.Ventana;
import vista.Receptor;
import persistencia.SerializadorXML;

public class Lanzador
{
    public static void main(final String[] args) {
        final Sistema modelo = SerializadorXML.cargar();
        final Receptor receptor = new Receptor(modelo);
		final Ventana vista = new Ventana(receptor);
    }
}