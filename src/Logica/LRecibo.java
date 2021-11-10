/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DAlmacen;
import Datos.DRecibo;
import Presentacion.frmFacturas;
import Presentacion.frmRecibos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LRecibo {

    Coneccion cn = new Coneccion();
    Connection c = cn.getConection();

    public int InsartarRecibo(DRecibo miRecibo) {
        int idres = 0;
        frmRecibos mi = new frmRecibos();
        try {
            CallableStatement cst = c.prepareCall("{call sp_insertar_recibo(?,?,?,?)}");

            cst.setString(1, miRecibo.getPersonaEntrega());
            cst.setString(2, miRecibo.getPersonaRecibe());
            cst.setDate(3, miRecibo.getFecha());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);

        } catch (Exception e) {
            e.printStackTrace();
            idres = 0;
        }

        return idres;
    }

     public String[] MostrarProdcto(DAlmacen miAlmacen) {
        String dts[] = null;

        try {
            dts = new String[6];
            CallableStatement cst = c.prepareCall("{call sp_mostrarbuscar_productos(?)}");

            cst.setString(1, miAlmacen.getIdAlamcen());

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                dts[0] = rs.getString("IdAlmacen");
                dts[1] = rs.getString("Descripcion");
                dts[2] = "1";
                dts[3] = rs.getString("UMedida");
                dts[4] = rs.getString("PUnitario");
                dts[5] = rs.getString("PUnitario");

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return dts;
    }
}
