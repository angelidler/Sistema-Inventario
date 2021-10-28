/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DFactura;
import Presentacion.frmFacturas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Tecnico
 */
public class LFactura {
    
    Coneccion cn=new Coneccion();
        Connection c=cn.getConection();
        
    public  String InsartarFc(DFactura miFactura){
      String msj=null;
      frmFacturas mi=new frmFacturas();
        try {
            CallableStatement cst=c.prepareCall("{call sp_inserter_facturas(?,?,?,?)}");
         
             cst.setInt(1, miFactura.getIdLinea());
             cst.setInt(2, miFactura.getIdProveedor());
             cst.setDate(3, miFactura.getFecha());
             cst.registerOutParameter(4, Types.INTEGER);
             cst.executeUpdate();
             int id=cst.getInt(4);
             mi.idfact(id);
             msj="si";
            
        } catch (Exception e) {
            
             msj="error"+e;
        }
      return msj;
    }
}
