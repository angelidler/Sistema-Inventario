/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DDRecibo;
import Datos.DRecibo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LDRecibo {

    Coneccion cn = new Coneccion();
    Connection c = cn.getConection();

      public DefaultTableModel BucarDRecibo(DDRecibo miRecibo) {

        DefaultTableModel miModulo = null;

        try {

            String Titulos[] = {"ID PRODUCTO", "DESCRIPCION", "CANTIDAD", "U/MEDIDA", "PRECIO UNITARIO","LINEAS", "TOTAL"};

            String dts[] = new String[7];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{call sp_mostrardetalle_recibos(?)}");

            cst.setInt(1, miRecibo.getReciboId());

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("d.ProductosId");
                dts[1] = rs.getString("p.Descripcion");
                dts[2] = rs.getString("d.Cantidad");
                dts[3] = rs.getString("p.UMedida");
                dts[4] = rs.getString("p.PUnitario");
                dts[5] = rs.getString("l.Nombre");
                dts[6] = rs.getString("d.Total");

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModulo;
    }
      
       public DefaultTableModel MostrarRecibos() {

        DefaultTableModel miModulo = null;

        try {

            String Titulos[] = {"ID ",  "FECHA", "ENTREGA","RECIBE"};

            String dts[] = new String[4];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{call sp_mostrardetallerecibos()}");
            
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("IdRecibo");
                dts[1] = rs.getString("FechaSalida");
                dts[2] = rs.getString("EntregaPersn");
                dts[3] = rs.getString("RecibePersn");
                

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

        return miModulo;
    } 
      
      
    public String insertarDDRecibo(DDRecibo miRecibo) {
        String msj = null;
        try {
            CallableStatement cst = c.prepareCall("{call sp_insertar_detallederecibo(?,?,?,?,?)}");
//          recibo, producto,  cant,  idlin,  tot
//            cst.setInt(1, miRecibo.getIdDetalleRecibo());
            cst.setInt(1, miRecibo.getReciboId());
            cst.setString(2, miRecibo.getProductosId());
            cst.setInt(3, miRecibo.getCantidad());
            cst.setInt(4, miRecibo.getLineasId());
            cst.setDouble(5, miRecibo.getTotal());
            cst.executeUpdate();

            msj = "si";

        } catch (Exception e) {

            msj = "error" + e;
        }
        return msj;
    }

}
