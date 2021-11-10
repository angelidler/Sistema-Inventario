/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

/**
 *
 * @author Tecnico
 */
public class LPrincipal {

    String hora;
    String fecha;

    public String damehora() {

        boolean dime = true;
        while (dime == true) {
            Timer time = new Timer(1000, new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    Calendar cal = new GregorianCalendar();
                    int hh, mm, ss, dia, mes, an;
                    hh = cal.get(Calendar.HOUR_OF_DAY);
                    ss = cal.get(Calendar.SECOND);
                    mm = cal.get(Calendar.MINUTE);

                    dia = cal.get(Calendar.DAY_OF_MONTH);
                    mes = cal.get(Calendar.MONTH);
                    an = cal.get(Calendar.YEAR);

                    hora = hh + ":" + mm + ":" + ss;
                    fecha = dia + "/" + (+mes + 1) + "/" + an;

                    System.out.println(hora);
                    System.out.println(fecha);
                    
                }

            });
            return hora+fecha;
        }
            return hora+fecha;
    }

    public static void main(String[] args) {
        LPrincipal p = new LPrincipal();
        p.damehora();

    }
}
