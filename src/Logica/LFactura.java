/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DAlmacen;
import Datos.DFactura;
import Presentacion.frmFacturas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LFactura {

    Coneccion cn = new Coneccion();
    Connection c = cn.getConection();

    public DefaultTableModel MostrarAlmacen() {

        DefaultTableModel miModulo = null;

        try {

            String Titulos[] = {"ID", "PROVEEDOR", "LINEA", "FECHA"};

            String dts[] = new String[4];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{call sp_mostrar_facturas()}");
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("f.IdFacturas");
                dts[1] = rs.getString("p.NombreRS");
                dts[2] = rs.getString("l.Nombre");
                dts[3] = rs.getString("f.FechaEntrada");

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModulo;
    }
public DefaultTableModel BuscarAlamacen(DFactura miFactura) {

        DefaultTableModel miModulo = null;

        try {

            String Titulos[] = {"ID", "PROVEEDOR", "LINEA", "FECHA"};

            String dts[] = new String[4];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{call sp_mostrarbuscar_facturas(?)}");
            
            cst.setInt(1, Integer.parseInt(miFactura.getId()));
            
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("f.IdFacturas");
                dts[1] = rs.getString("p.NombreRS");
                dts[2] = rs.getString("l.Nombre");
                dts[3] = rs.getString("f.FechaEntrada");

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModulo;
    }
    public int InsartarFc(DFactura miFactura) {
        int idres = 0;
        frmFacturas mi = new frmFacturas();
        try {
            CallableStatement cst = c.prepareCall("{call sp_insertar_factura(?,?,?,?)}");

            cst.setInt(1, miFactura.getIdLinea());
            cst.setInt(2, miFactura.getIdProveedor());
            cst.setDate(3, miFactura.getFecha());
            cst.registerOutParameter(4, Types.INTEGER);
            cst.executeUpdate();
            idres = cst.getInt(4);

        } catch (Exception e) {
            
            e.printStackTrace();
            idres = 0;
            
        }

        return idres;
    }
}
