// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import excepciones.DatoInvalidoException;

public abstract class Persona implements I_Indexable
{
    private String legajo;
    private String apellidoNombre;
    private String domicilio;
    private String mail;
    
    public Persona(final String apellidoNombre, final String domicilio, final String mail) {
        this.apellidoNombre = apellidoNombre;
        this.domicilio = domicilio;
        this.mail = mail;
    }
    
    @Override
    public Object getClavePrimaria() {
        return this.getLegajo();
    }
    
    @Override
    public Object getClaveSecundaria() {
        return this.getApellidoNombre();
    }
    
    public String getLegajo() {
        return this.legajo;
    }
    
    public String getApellidoNombre() {
        return this.apellidoNombre;
    }
    
    public void setLegajo(final String legajo) {
        this.legajo = legajo;
    }
    
    public void setApellidoNombre(final String apellidoNombre) {
        this.apellidoNombre = apellidoNombre;
    }
    
    public void setDomicilio(final String domicilio) {
        this.domicilio = domicilio;
    }
    
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setMail(final String mail) {
        this.mail = mail;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public static boolean validaMail(final String mail) {
        return mail.contains("@") && mail.charAt(mail.length() - 1) != '@' && mail.charAt(0) != '@';
    }
    
    public static boolean validaNombre(final String nombre) {
        return !nombre.equals("");
    }
    
    public static boolean validaDomicilio(final String domicilio) {
        return !domicilio.equals("");
    }
    
    public static boolean validaPersona(final Persona persona) {
        return validaMail(persona.getMail()) && validaNombre(persona.getApellidoNombre()) && validaDomicilio(persona.getDomicilio());
    }
    
    @Override
    public void modificarDatos(final I_Indexable modif) throws DatoInvalidoException {
        if (this.getClass() != modif.getClass()) {
            throw new DatoInvalidoException(modif, "Tipo de dato incompatible.");
        }
        final Persona aux = (Persona)modif;
        this.setApellidoNombre(aux.getApellidoNombre());
        this.setDomicilio(aux.getDomicilio());
        this.setMail(aux.getMail());
    }
    
    public Persona() {
    }
}