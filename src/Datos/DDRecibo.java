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
public class DDRecibo {
    
   private int IdDetalleRecibo, ReciboId,  LineasId, Cantidad ;
   private String ProductosId;
   private double Total;

    public DDRecibo() {
        
        
    }

    public DDRecibo(int IdDetalleRecibo, int ReciboId, int LineasId, int Cantidad, String ProductosId, double Total) {
        this.IdDetalleRecibo = IdDetalleRecibo;
        this.ReciboId = ReciboId;
        this.LineasId = LineasId;
        this.Cantidad = Cantidad;
        this.ProductosId = ProductosId;
        this.Total = Total;
    }

    public void setIdDetalleRecibo(int IdDetalleRecibo) {
        this.IdDetalleRecibo = IdDetalleRecibo;
    }

    public void setReciboId(int ReciboId) {
        this.ReciboId = ReciboId;
    }

    public void setLineasId(int LineasId) {
        this.LineasId = LineasId;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setProductosId(String ProductosId) {
        this.ProductosId = ProductosId;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getIdDetalleRecibo() {
        return IdDetalleRecibo;
    }

    public int getReciboId() {
        return ReciboId;
    }

    public int getLineasId() {
        return LineasId;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getProductosId() {
        return ProductosId;
    }

    public double getTotal() {
        return Total;
    }
}
