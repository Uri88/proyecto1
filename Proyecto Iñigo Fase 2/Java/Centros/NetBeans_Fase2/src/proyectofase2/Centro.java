/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofase2;

/**
 *
 * @author msimm
 */
public class Centro {
    private String nombre;
    private String telefono;
    private String provincia;
    private String ciudad;
    private String calle;
    private String codigopostal;
    private  String numero;

    public Centro() {
    }

    public Centro(String nombre, String telefono, String provincia, String ciudad, String codigopostal, String numero) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.codigopostal = codigopostal;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Centro{" + "nombre=" + nombre + ", telefono=" + telefono + ", provincia=" + provincia + ", ciudad=" + ciudad + ", calle=" + calle + ", codigopostal=" + codigopostal + ", numero=" + numero + '}';
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
    
}
