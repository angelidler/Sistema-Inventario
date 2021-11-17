/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DRecibo;
import Presentacion.frmLogin;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class LPrincipal {

    public static void main(String[] args) {
        frmLogin lg=new frmLogin();
        
        lg.setVisible(true);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lg.setLocationRelativeTo(null);

    }
}
