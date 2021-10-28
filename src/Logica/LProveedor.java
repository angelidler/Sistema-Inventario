/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DProveedor;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LProveedor {
    Coneccion c=new Coneccion();
    Connection cn=c.getConection();
    
    
  
     public DefaultTableModel MostProveedor(DProveedor miProveedor){
        
        DefaultTableModel miModulo=null;
            
        try {
            String Titulos []= {"id","Nombre","Telefono","Domicilio"};
            
            String dtl[]=new String[4];
            
            miModulo=new DefaultTableModel(null,Titulos);
            
            CallableStatement cst=cn.prepareCall("{ call sp_buscar_Prv (?) }");
            
            cst.setString(1, miProveedor.getNombre());
           
            ResultSet rs = cst.executeQuery();
            
            while (rs.next()) {
                
                dtl[0]=rs.getString("idProveedor");
                dtl[1]=rs.getString("Nombre");
                dtl[2]=rs.getString("Telefono");
                dtl[3]=rs.getString("domicilio");
                miModulo.addRow(dtl);
            }
        } catch (Exception e) {
         e.printStackTrace();
        }
        
       return miModulo;
    }
     
   
    public String InsertarPrv(DProveedor miProveedor){
        
        String msj=null;
        try {
            
            CallableStatement cst=cn.prepareCall("{call sp_insertar_Prv(?,?,?)}");
            
            cst.setString(1, miProveedor.getNombre());
            cst.setString(2, miProveedor.getTelefono());
            cst.setString(3, miProveedor.getDomicilio());
            
            cst.executeUpdate();
            
        } catch (Exception e) {
            
            msj="no"+e;
        }
        
        
        return msj="si";
    }
    public String EditarPrv(DProveedor miProveedor){
        
        String msj="";
        try {
            
            CallableStatement cst=cn.prepareCall("{call sp_editar_Prv (?,?,?,?)}");
            
            cst.setInt(1, miProveedor.getId());
            cst.setString(2, miProveedor.getNombre());
            cst.setString(3, miProveedor.getTelefono());
            cst.setString(4, miProveedor.getDomicilio());
            
            cst.executeUpdate();
            
            
        } catch (Exception e) {
            
            msj="no"+e;
        }
        return msj="si";
        
    }
    
    public String EliminarPrv(DProveedor miProveedor){
        String msj=null;
        
        try {
            CallableStatement cst=cn.prepareCall("{call sp_eliminar_Prv (?)}");
            
            cst.setInt(1, miProveedor.getId());
            
            cst.executeUpdate();
        } catch (Exception e) {
            
            msj="no"+e;
            
        }
        
        return msj="si";
    }
}

