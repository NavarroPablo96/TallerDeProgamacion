// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import excepciones.DiaInvalidoException;

public enum Dia
{
    LUN, 
    MAR, 
    MIE, 
    JUE, 
    VIE, 
    SAB, 
    DOM;
    
    public static int parseInt(final Dia dia) throws DiaInvalidoException {
        int ret = 0;
        switch (dia) {
            case LUN: {
                ret = 0;
                break;
            }
            case MAR: {
                ret = 1;
                break;
            }
            case MIE: {
                ret = 2;
                break;
            }
            case JUE: {
                ret = 3;
                break;
            }
            case VIE: {
                ret = 4;
                break;
            }
            case SAB: {
                ret = 5;
                break;
            }
            case DOM: {
                ret = 6;
                break;
            }
            default: {
                throw new DiaInvalidoException(dia);
            }
        }
        return ret;
    }
    
    public static Dia parseDia(final String dia) throws DiaInvalidoException {
        Dia ret;
        if (dia.equals("Lunes")) {
            ret = Dia.LUN;
        }
        else if (dia.equals("Martes")) {
            ret = Dia.MAR;
        }
        else if (dia.equals("Miercoles")) {
            ret = Dia.MIE;
        }
        else if (dia.equals("Jueves")) {
            ret = Dia.JUE;
        }
        else if (dia.equals("Viernes")) {
            ret = Dia.VIE;
        }
        else if (dia.equals("Sabado")) {
            ret = Dia.SAB;
        }
        else {
            if (!dia.equals("Domingo")) {
                throw new DiaInvalidoException((Object)dia);
            }
            ret = Dia.DOM;
        }
        return ret;
    }
}