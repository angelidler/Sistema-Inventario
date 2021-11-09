package Logica;





import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Coneccion {

	
	    private static final String Driver="org.gjt.mm.mysql.Driver";
	    private static final String user="root2";
	    private static final String pass="olivar2021";
	    private static final String url="jdbc:mysql://192.168.0.231:3306/dbalmacen";
	     Connection cn;
	    public Connection  getConection(){
	        
	        try {
	            cn=DriverManager.getConnection(url, user, pass);
                  //JOptionPane.showMessageDialog(null,"conectado");
	        } catch (Exception e) {
	            
	            System.out.println("error de conexio: " + e);
	        }
               return cn;
	    }

    /*CallableStatement noexiste(String _call_sp_mostrarbuscar_ususarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
