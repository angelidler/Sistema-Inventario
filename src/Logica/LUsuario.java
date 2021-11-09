/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DUsuarios;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LUsuario {

    Coneccion cn = new Coneccion();
    Connection c = cn.getConection();

    ;
        
    
    public DefaultTableModel MostUsuario(DUsuarios MisUsuario) {

        DefaultTableModel miModulo = null;

        try {
            String Titulos[] = {"ID", "Nombre", "Usuario", "Clave", "Perfil"};

            String dts[] = new String[5];

            miModulo = new DefaultTableModel(null, Titulos);
            CallableStatement cst = c.prepareCall("{ call sp_mostrarbuscar_usuarios(?)}");
            cst.setString(1, MisUsuario.getUsuario());
            ResultSet rs = cst.executeQuery();

            while (rs.next()) {

                dts[0] = rs.getString("IdUsuarios");
                dts[1] = rs.getString("Nombre");
                dts[2] = rs.getString("Usuario");
                dts[3] = rs.getString("Clave");
                dts[4] = rs.getString("Perfil");

                miModulo.addRow(dts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miModulo;
    }

    public String InsartarUs(DUsuarios misUsuarios) {
        String msj = null;
        try {
            CallableStatement cst = c.prepareCall("{call sp_insertar_usuarios(?,?,?,?)}");
            cst.setString(1, misUsuarios.getNombreUs());
            cst.setString(2, misUsuarios.getUsuario());
            cst.setString(3, misUsuarios.getClaveUs());
            cst.setString(4, misUsuarios.getPerfil());
            cst.executeUpdate();
            msj = "si";
        } catch (Exception e) {

            msj = "error" + e;
        }
        return msj;
    }

    public String EditarUs(DUsuarios misUsuarios) {
        String msj = null;
        try {
            CallableStatement cst = c.prepareCall("{call sp_editar_usuarios (?,?,?,?,?)}");
            cst.setInt(1, misUsuarios.getIdUsuario());
            cst.setString(2, misUsuarios.getNombreUs());
            cst.setString(3, misUsuarios.getUsuario());
            cst.setString(4, misUsuarios.getClaveUs());
            cst.setString(5, misUsuarios.getPerfil());
            cst.executeUpdate();
            msj = "si";
        } catch (Exception e) {

            msj = "error" + e;
        }
        return msj;
    }

    public String EliminarUs(DUsuarios misUsuarios) {
        String msj = null;
        try {
            CallableStatement cst = c.prepareCall("{call sp_eliminar_usuarios(?)}");
            cst.setInt(1, misUsuarios.getIdUsuario());
            cst.executeUpdate();
            msj = "si";
        } catch (Exception e) {

            msj = "error" + e;
        }
        return msj;
    }
}
