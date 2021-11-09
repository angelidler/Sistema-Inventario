/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DLineas;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LLineas {
    
    Coneccion cn=new Coneccion();
        Connection c=cn.getConection();
        
    
    public DefaultTableModel MostLineas(DLineas MisLineas){
        
        DefaultTableModel miModulo=null;
            
        try {
            String Titulos []= {"ID","Linea"};
            
            String dtl[]=new String[2];
            
            miModulo=new DefaultTableModel(null,Titulos);
            
            CallableStatement cst=c.prepareCall("{ call sp_mostrarbuscar_lineas (?) }");
            
            cst.setString(1, MisLineas.getLineas());
           
            ResultSet rs = cst.executeQuery();
            
            while (rs.next()) {
                
                dtl[0]=rs.getString("IdLineas");
                dtl[1]=rs.getString("Nombre");
                miModulo.addRow(dtl);
            }
        } catch (Exception e) {
         e.printStackTrace();
        }
        
       return miModulo;
    }
    public  String InsartarLn(DLineas MisLineas){
      String msj=null;
        try {
            CallableStatement cst=c.prepareCall("{call sp_insertar_lineas(?)}");
         
             cst.setString(1, MisLineas.getLineas());
             cst.executeUpdate();
           
             msj="si";
            
        } catch (Exception e) {
            
             msj="error"+e;
        }
      return msj;
    }
     public  String EditarLn(DLineas MisLineas){
      String msj=null;
        try {
            CallableStatement cst=c.prepareCall("{call sp_editar_lineas (?,?)}");
            cst.setInt(1, MisLineas.getId());
            cst.setString(2, MisLineas.getLineas());
           
           cst.executeUpdate();
            msj="si";
            
        } catch (Exception e) {
            
             msj="error"+e;
        }
      return msj;
    }
     public  String EliminarLn(DLineas MisLineas){
      String msj=null;
        try {
            CallableStatement cst=c.prepareCall("{call sp_eliminar_lineas (?)}");
            cst.setInt(1, MisLineas.getId());
            cst.executeUpdate();
            msj="si";
        } catch (Exception e) {
            
            msj="error"+e;
        }
      return msj;
    }
    
}
