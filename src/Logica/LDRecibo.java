/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DDRecibo;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LDRecibo {

    Coneccion cn = new Coneccion();
    Connection c = cn.getConection();

    /*  public DefaultTableModel BucarFactura(DDRecibo miRecibo) {

        DefaultTableModel miModulo = null;

        try {

            String Titulos[] = {"ID PRODUCTO", "DESCRIPCION", "CANTIDAD", "U/MEDIDA", "PRECIO UNITARIO", "TOTAL"};

            String dts[] = new String[6];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{call sp_mostrardetalle_factura(?)}");

            cst.setInt(1, miFacturas.getIdFactura());

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("d.ProductosId");
                dts[1] = rs.getString("p.Descripcion");
                dts[2] = rs.getString("d.Cantidad");
                dts[3] = rs.getString("p.UMedida");
                dts[4] = rs.getString("p.PUnitario");
                dts[5] = rs.getString("d.Total");

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModulo;
    }*/
    public String insertarDDRecibo(DDRecibo miRecibo) {
        String msj = null;
        try {
            CallableStatement cst = c.prepareCall("{call sp_insertar_detallederecibo(?,?,?,?,?)}");
//recibo, producto,  cant,  idlin,  tot
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
