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
public class DDFacturas {

    private int idDetFactura, IdFactura, Cantidad;
    private String Productosid;
    private double total;

    public DDFacturas() {

    }

    public DDFacturas(int idDetFactura, int IdFactura, int Cantidad, String Productosid, double total) {
        this.idDetFactura = idDetFactura;
        this.IdFactura = IdFactura;
        this.Cantidad = Cantidad;
        this.Productosid = Productosid;
        this.total = total;
    }

    public void setIdDetFactura(int idDetFactura) {
        this.idDetFactura = idDetFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setProductosid(String Productosid) {
        this.Productosid = Productosid;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdDetFactura() {
        return idDetFactura;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getProductosid() {
        return Productosid;
    }

    public double getTotal() {
        return total;
    }

}
