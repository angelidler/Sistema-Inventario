/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.FechaHora;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Tecnico
 */
public class MCPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MCPrincipal
     */
    public MCPrincipal() {
        initComponents();

        time.start();

        imagenesBtn();
        imagenesItem();
        imagenMenu();
    }

    public void imagenesBtn() {

        ImageIcon mifactura = new ImageIcon("src/Imagen/factura.png");
        Icon iconof = new ImageIcon(mifactura.getImage().getScaledInstance(52, 60, Image.SCALE_DEFAULT));
        btnFactura.setIcon(iconof);

        ImageIcon miRecibo = new ImageIcon("src/Imagen/recibo.png");
        Icon iconor = new ImageIcon(miRecibo.getImage().getScaledInstance(52, 60, Image.SCALE_DEFAULT));
        btnRecibos.setIcon(iconor);

        ImageIcon miAlmacen = new ImageIcon("src/Imagen/almacen.png");
        Icon iconoa = new ImageIcon(miAlmacen.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT));
        btnAlamcen.setIcon(iconoa);

    }

    public void imagenesItem() {

        ImageIcon miusuario = new ImageIcon("src/Imagen/usuario.png");
        Icon iconou = new ImageIcon(miusuario.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        ItemUsuario.setIcon(iconou);

        ImageIcon milinea = new ImageIcon("src/Imagen/las-compras-en-linea.png");
        Icon iconol = new ImageIcon(milinea.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        itemLinea.setIcon(iconol);

        ImageIcon miInfo = new ImageIcon("src/Imagen/expediente.png");
        Icon iconoi = new ImageIcon(miInfo.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        ItemIformacion.setIcon(iconoi);

        ImageIcon miProv = new ImageIcon("src/Imagen/proveedor.png");
        Icon iconop = new ImageIcon(miProv.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        itemProveedor.setIcon(iconop);

        ImageIcon miBD = new ImageIcon("src/Imagen/bases-de-datos.png");
        Icon iconobd = new ImageIcon(miBD.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        ItemRespaldar.setIcon(iconobd);

        ImageIcon mirf = new ImageIcon("src/Imagen/reporte-de-factura.png");
        Icon iconorf = new ImageIcon(mirf.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        itemFactura.setIcon(iconorf);

        ImageIcon miRecibo = new ImageIcon("src/Imagen/reporte-de-recibo.png");
        Icon iconors = new ImageIcon(miRecibo.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        itemRecibo.setIcon(iconors);

        ImageIcon miReporte = new ImageIcon("src/Imagen/listas-de-verificacion.png");
        Icon iconorp = new ImageIcon(miReporte.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        itemReporte.setIcon(iconorp);
        
        ImageIcon misalir = new ImageIcon("src/Imagen/cerrar-sesion.png");
        Icon iconosl = new ImageIcon(misalir.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        itemSalir.setIcon(iconosl);


    }

    public void imagenMenu() {

        ImageIcon menubd = new ImageIcon("src/Imagen/transferencia-de-datos.png");
        Icon iconobd = new ImageIcon(menubd.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        MenuBD.setIcon(iconobd);

        ImageIcon menuconsulta = new ImageIcon("src/Imagen/seo.png");
        Icon iconoc = new ImageIcon(menuconsulta.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        menuConsulta.setIcon(iconoc);

        ImageIcon menuherramienta = new ImageIcon("src/Imagen/transferencia-de-datos.png");
        Icon iconohr = new ImageIcon(menuherramienta.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        menuHerramienta.setIcon(iconohr);

//        ImageIcon menusesion = new ImageIcon("src/Imagen/transferencia-de-datos.png");
//        Icon iconoss = new ImageIcon(menusesion.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
//        MenuBD.setIcon(iconoss);

    }

    Timer time = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Calendar calendario = new GregorianCalendar();

            int ss, mm, hh, dd, ms, an;

            ss = calendario.get(Calendar.SECOND);
            mm = calendario.get(Calendar.MINUTE);
            hh = calendario.get(Calendar.HOUR_OF_DAY);

            dd = calendario.get(Calendar.DAY_OF_MONTH);
            ms = calendario.get(Calendar.MONTH);
            an = calendario.get(Calendar.YEAR);

            lbhora.setText(hh + ":" + mm + ":" + ss);
            lbfecha.setText(dd + "/" + (ms + 1) + "/" + an);
        }

    });

    public void setDatos(String usuario, String Perfil) {

        lbUsuario.setText(usuario);

        if (Perfil.equals("Usuario")) {
            ItemUsuario.setVisible(false);
            ItemIformacion.setVisible(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnFactura = new javax.swing.JButton();
        btnRecibos = new javax.swing.JButton();
        btnAlamcen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        dpnEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConsulta = new javax.swing.JMenu();
        itemReporte = new javax.swing.JMenuItem();
        itemFactura = new javax.swing.JMenuItem();
        itemRecibo = new javax.swing.JMenuItem();
        MenuBD = new javax.swing.JMenu();
        ItemRespaldar = new javax.swing.JMenuItem();
        menuHerramienta = new javax.swing.JMenu();
        ItemUsuario = new javax.swing.JMenuItem();
        ItemIformacion = new javax.swing.JMenuItem();
        itemLinea = new javax.swing.JMenuItem();
        itemProveedor = new javax.swing.JMenuItem();
        menuSesion = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Inventario A&M");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnFactura.setText("Facturas");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        btnRecibos.setText("Recibos");
        btnRecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibosActionPerformed(evt);
            }
        });

        btnAlamcen.setText("Alamacen");
        btnAlamcen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlamcenActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Hora");

        jLabel3.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecibos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlamcen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbhora)
                                    .addComponent(lbUsuario)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lbfecha)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlamcen, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbhora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbfecha)))
        );

        javax.swing.GroupLayout dpnEscritorioLayout = new javax.swing.GroupLayout(dpnEscritorio);
        dpnEscritorio.setLayout(dpnEscritorioLayout);
        dpnEscritorioLayout.setHorizontalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        dpnEscritorioLayout.setVerticalGroup(
            dpnEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menuConsulta.setText("Consultas");

        itemReporte.setText("Reportes");
        menuConsulta.add(itemReporte);

        itemFactura.setText("Detalle de Facturas");
        itemFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFacturaActionPerformed(evt);
            }
        });
        menuConsulta.add(itemFactura);

        itemRecibo.setText("Detalle de Recibo");
        itemRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReciboActionPerformed(evt);
            }
        });
        menuConsulta.add(itemRecibo);

        jMenuBar1.add(menuConsulta);

        MenuBD.setText("Base de Datos");

        ItemRespaldar.setText("Respadar/Restaurar");
        ItemRespaldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRespaldarActionPerformed(evt);
            }
        });
        MenuBD.add(ItemRespaldar);

        jMenuBar1.add(MenuBD);

        menuHerramienta.setText("Herramientas");

        ItemUsuario.setText("Usuarios");
        ItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemUsuarioActionPerformed(evt);
            }
        });
        menuHerramienta.add(ItemUsuario);

        ItemIformacion.setText("Informacion");
        menuHerramienta.add(ItemIformacion);

        itemLinea.setText("Lineas");
        itemLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLineaActionPerformed(evt);
            }
        });
        menuHerramienta.add(itemLinea);

        itemProveedor.setText("Proveedor");
        itemProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedorActionPerformed(evt);
            }
        });
        menuHerramienta.add(itemProveedor);

        jMenuBar1.add(menuHerramienta);

        menuSesion.setText("Usuario");

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuSesion.add(itemSalir);

        jMenuBar1.add(menuSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpnEscritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dpnEscritorio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFacturaActionPerformed
        // TODO add your handling code here:

        frmdtsFactura fdf = new frmdtsFactura();
        dpnEscritorio.add(fdf);
        fdf.show();
    }//GEN-LAST:event_itemFacturaActionPerformed

    private void ItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemUsuarioActionPerformed
        // TODO add your handling code here:

        frmUsuario us = new frmUsuario();
        dpnEscritorio.add(us);
        us.show();
    }//GEN-LAST:event_ItemUsuarioActionPerformed

    private void itemLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLineaActionPerformed
        // TODO add your handling code here:
        frmLineas ln = new frmLineas();
        dpnEscritorio.add(ln);
        ln.show();
    }//GEN-LAST:event_itemLineaActionPerformed

    private void itemProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedorActionPerformed
        // TODO add your handling code here:
        frmProveedor pv = new frmProveedor();
        dpnEscritorio.add(pv);
        pv.show();
    }//GEN-LAST:event_itemProveedorActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        // TODO add your handling code here:
        frmFacturas fct = new frmFacturas();
        dpnEscritorio.add(fct);
        fct.show();
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnAlamcenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlamcenActionPerformed
        // TODO add your handling code here:

        frmInventario fiv = new frmInventario();
        dpnEscritorio.add(fiv);
        fiv.show();
    }//GEN-LAST:event_btnAlamcenActionPerformed

    private void btnRecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibosActionPerformed
        // TODO add your handling code here:

        frmRecibos fiv = new frmRecibos();
        dpnEscritorio.add(fiv);
        fiv.setDatosUs(lbUsuario.getText());
        fiv.show();
    }//GEN-LAST:event_btnRecibosActionPerformed

    private void itemReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReciboActionPerformed
        // TODO add your handling code here:

        frmDetaRecibo fr = new frmDetaRecibo();
        dpnEscritorio.add(fr);
        fr.show();
    }//GEN-LAST:event_itemReciboActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:

        frmLogin lg = new frmLogin();
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void ItemRespaldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRespaldarActionPerformed
        // TODO add your handling code here:

        frmRespaldarRestaura fr = new frmRespaldarRestaura();
        dpnEscritorio.add(fr);
        fr.show();

    }//GEN-LAST:event_ItemRespaldarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MCPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MCPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemIformacion;
    private javax.swing.JMenuItem ItemRespaldar;
    private javax.swing.JMenuItem ItemUsuario;
    private javax.swing.JMenu MenuBD;
    private javax.swing.JButton btnAlamcen;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnRecibos;
    private javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JMenuItem itemFactura;
    private javax.swing.JMenuItem itemLinea;
    private javax.swing.JMenuItem itemProveedor;
    private javax.swing.JMenuItem itemRecibo;
    private javax.swing.JMenuItem itemReporte;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbhora;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JMenu menuHerramienta;
    private javax.swing.JMenu menuSesion;
    // End of variables declaration//GEN-END:variables

}
