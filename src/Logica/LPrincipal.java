/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.*;
/**
 *
 * @author Tecnico
 */

public class LPrincipal {
    public static void main(String[] args) {
        Coneccion cn=new Coneccion();
        Connection c;
        c=cn.getConection();
    }
}
