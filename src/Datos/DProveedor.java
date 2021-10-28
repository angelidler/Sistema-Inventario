/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Tecnico
 */
public class DProveedor {
    
    private int id;
    private String Nombre, Domicilio,Telefono;
     public DProveedor(){
         
     }

    public DProveedor(int id, String Nombre, String Domicilio, String Telefono) {
        this.id = id;
        this.Nombre = Nombre;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public String getTelefono() {
        return Telefono;
    }
    
}
