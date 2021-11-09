/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DAlmacen;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LAlmacen {

    Coneccion cn = new Coneccion();
    Connection c = cn.getConection();

    public DefaultTableModel BuscarAlamacen(DAlmacen miAlmacen) {

        DefaultTableModel miModulo = null;

        try {

            String Titulos[] = {"CODIGO", "DESCRIPCION", "STOCK", "U/MEDIDA", "PRECIO/U", "TOTAL", "LINEA"};

            String dts[] = new String[7];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{call sp_mostrar_inventario(?)}");

            cst.setString(1, miAlmacen.getIdAlamcen());

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("a.IdAlmacen");
                dts[1] = rs.getString("a.Descripcion");
                dts[2] = rs.getString("a.Stock");
                dts[3] = rs.getString("a.UMedida");;
                dts[4] = rs.getString("a.PUnitario");
                dts[5] = rs.getString("Total");
                dts[6] = rs.getString("l.Nombre");
                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return miModulo;
    }

    public String[] MostrarAlamcen(DAlmacen miAlmacen) {
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
    
     public  String InsertarProducto(DAlmacen miProducto){
      String msj=null;
        try {
            CallableStatement cst=c.prepareCall("{call sp_insertar_productos(?,?,?,?,?,?)}");
         
             cst.setString(1, miProducto.getIdAlamcen());
             cst.setInt(2, miProducto.getIdLinea());
             cst.setString(3, miProducto.getDescripcion());
             cst.setInt(4, miProducto.getStock());
             cst.setDouble(5, miProducto.getPrecioU());
             cst.setString(6, miProducto.getUMedida());
             
             
             
             cst.executeUpdate();
           
             msj="si";
            
        } catch (Exception e) {
            
             msj="error"+e;
        }
      return msj;
    }
}
