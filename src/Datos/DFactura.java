/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Tecnico
 */
public class DFactura {
    
    private int id, idLinea,idProveedor;
    private Date Fecha;
 public DFactura(){
    
    }
    public DFactura(int id, int idLinea, int idProveedor, Date Fecha) {
        this.id = id;
        this.idLinea = idLinea;
        this.idProveedor = idProveedor;
        this.Fecha = Fecha;
    }
    
    public int getId() {
        return id;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
   
}
