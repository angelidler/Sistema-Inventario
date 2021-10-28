/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Tecnico
 */
public class FechaHora {
    
   
    public FechaHora(){
        run();
       
    } 
    
   /* public  int DameHora(){*/
     
        
      public void run(){
            time.start();
        }
 
Timer time=new Timer(1000, new ActionListener() {
             
     public void actionPerformed(ActionEvent e) {
                Calendar cal=new GregorianCalendar();
                int hh, mm, ss, dia, mes, an; 
                hh=cal.get(Calendar.HOUR);
                ss=cal.get(Calendar.SECOND);
                mm=cal.get(Calendar.MINUTE);
                 
                dia=cal.get(Calendar.DAY_OF_MONTH);
                mes=cal.get(Calendar.MONTH);
                an=cal.get(Calendar.YEAR);
                
                h=hh;
                s=ss;
                m=mm;
                
                d=dia;
                ms=mes;
                a=an;
                
                setH(h);
                setM(m);
                setS(s);
   
            }    
        });
      public static void main(String[] args) {
        FechaHora f=new FechaHora();
         
    }
      


    
   
    private int h=2,m,s,d,ms,a;

    public Timer getTime() {
        return time;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }

    public int getD() {
        return d;
    }

    public int getMs() {
        return ms;
    }

    public int getA() {
        return a;
    }

    public void setTime(Timer time) {
        this.time = time;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setS(int s) {
        this.s = s;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public void setA(int a) {
        this.a = a;
    }
}

