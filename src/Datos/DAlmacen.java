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
public class DAlmacen {
    private String idAlamcen;
            
    private int idLinea, stock;
    private String Descripcion, UMedida;
    public DAlmacen(){
        
    }
     public DAlmacen(String idAlamcen, int idLinea, int stock, String Descripcion, String UMedida, double PrecioU) {
        this.idAlamcen = idAlamcen;
        this.idLinea = idLinea;
        this.stock = stock;
        this.Descripcion = Descripcion;
        this.UMedida = UMedida;
        this.PrecioU = PrecioU;
    }

    public void setIdAlamcen(String idAlamcen) {
        this.idAlamcen = idAlamcen;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setUMedida(String UMedida) {
        this.UMedida = UMedida;
    }

    public void setPrecioU(double PrecioU) {
        this.PrecioU = PrecioU;
    }

    public String getIdAlamcen() {
        return idAlamcen;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getUMedida() {
        return UMedida;
    }

    public double getPrecioU() {
        return PrecioU;
    }
    private double PrecioU;

   
}
