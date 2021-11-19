/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DAlmacen;
import Datos.DDRecibo;
import Datos.DRecibo;
import Logica.LAlmacen;
import Logica.LDRecibo;
import Logica.LRecibo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class frmRecibos extends javax.swing.JInternalFrame {

    private DefaultTableModel miModelo;
    LDRecibo ldr = new LDRecibo();
    DDRecibo ddr = new DDRecibo();

    /**
     * Creates new form frmRecibos
     */
    public frmRecibos() {
        initComponents();

        habilita(false);

        txtTotal.setEditable(false);
        miModelo = (DefaultTableModel) tblRecibo.getModel();
        imagenesBtn();
    }

    public void imagenesBtn() {

        ImageIcon Guardar = new ImageIcon("src/Imagen/salvar.png");
        Icon iconog = new ImageIcon(Guardar.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        btnGuardar.setIcon(iconog);

        ImageIcon Nuevo = new ImageIcon("src/Imagen/archivo-nuevo.png");
        Icon iconon = new ImageIcon(Nuevo.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        btnNuevo.setIcon(iconon);

        ImageIcon Cancelar = new ImageIcon("src/Imagen/prohibicion.png");
        Icon iconoc = new ImageIcon(Cancelar.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        btnCancelar.setIcon(iconoc);

    }

    public void setDatosUs(String Entrega) {

        txtPEntrega.setText(Entrega);
    }

    public void Limpiar() {

        txtFecha.setDate(null);
        txtPersona.setText("");
        txtTotal.setText("");
        try {
            DefaultTableModel miModelo = (DefaultTableModel) tblRecibo.getModel();//Toma el model de la tabla excistente

            int fila = tblRecibo.getRowCount();//devuelve el numero de filas de una Tabla
            for (int i = 0; fila > i; i++) {

                miModelo.removeRow(0);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "no se pudo limpiar las celdas", "Infromacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void habilita(boolean txt) {

        txtFecha.setEnabled(txt);
        txtPersona.setEnabled(txt);
        txtBuscar.setEnabled(txt);

        btnGuardar.setEnabled(txt);
        btnCancelar.setEnabled(txt);
        btnNuevo.setEnabled(!txt);
    }

    private void MostrarBuscar(String id) {

        LAlmacen lam = new LAlmacen();
        DAlmacen dam = new DAlmacen();
        dam.setIdAlamcen(id);
        String Registro[] = lam.MostrarProductoRec(dam);

        if (Registro[0] != null) {
            miModelo.insertRow(0, Registro);
            tblRecibo.setModel(miModelo);
        } else {
            JOptionPane.showMessageDialog(null, "producto no existe");
        }

    }

    private boolean EstaTabla(String texto) {
        DecimalFormat ft = new DecimalFormat("####.00");
        boolean res = false;

        for (int i = 0; i < tblRecibo.getRowCount(); i++) {
            String Codigo = tblRecibo.getValueAt(i, 0).toString();
            if (Codigo.equals(texto)) {

                int cantidad = Integer.parseInt(tblRecibo.getValueAt(i, 2).toString());
                double PrecioU = Double.parseDouble(tblRecibo.getValueAt(i, 4).toString());

                int totalcantidad = cantidad + 1;
                tblRecibo.setValueAt(totalcantidad, i, 2);

                double precioParcia = PrecioU * totalcantidad;

                tblRecibo.setValueAt(ft.format(precioParcia).replace(",", "."), i, 7);

                res = true;
            }
        }
        sumarTotal();
        return res;
    }

    private void sumarTotal() {

        DecimalFormat ft = new DecimalFormat("####.00");
        double totalfinal = 0;
        for (int i = 0; i < tblRecibo.getRowCount(); i++) {
            double PrecioU = Double.parseDouble(tblRecibo.getValueAt(i, 7).toString());
            totalfinal = totalfinal + PrecioU;
//            txtTotal.setText(String.valueOf(totalfinal));
            txtTotal.setText(ft.format(totalfinal));

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
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPersona = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecibo = new javax.swing.JTable();
        txtPEntrega = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Fecha:");

        jLabel2.setText("Persona Recibe");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblRecibo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descriccion", "Cantidad", "U/Medida", "P/Unitario", "Id/Linea", "Linea", "Total"
            }
        ));
        tblRecibo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblReciboMousePressed(evt);
            }
        });
        tblRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblReciboKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecibo);
        if (tblRecibo.getColumnModel().getColumnCount() > 0) {
            tblRecibo.getColumnModel().getColumn(5).setMinWidth(0);
            tblRecibo.getColumnModel().getColumn(5).setPreferredWidth(0);
            tblRecibo.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        txtPEntrega.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtPersona))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(30, 30, 30)
                                .addComponent(btnGuardar)
                                .addGap(31, 31, 31)
                                .addComponent(btnCancelar)
                                .addGap(189, 189, 189)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(306, 306, 306)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 31, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        if (txtPersona.getText().equals("") || txtFecha.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Completar los Formularios deben de estar llenos", "Informacion", JOptionPane.QUESTION_MESSAGE);
            txtPersona.requestFocusInWindow();
            return;
        }

        DRecibo dr = new DRecibo();
        LRecibo lr = new LRecibo();

        dr.setPersonaRecibe(txtPersona.getText());
        dr.setPersonaEntrega(txtPEntrega.getText());
        Calendar cl;

        cl = txtFecha.getCalendar();
        int dd, mm, aa;

        dd = cl.get(Calendar.DAY_OF_WEEK);
        mm = cl.get(Calendar.MONTH);
        aa = cl.get(Calendar.YEAR) - 1900;

        dr.setFecha(new Date(aa, mm, dd));

        int id = lr.InsartarRecibo(dr);
        System.out.print(id);

        if (id > 0) {

            for (int i = 0; i < tblRecibo.getRowCount(); i++) {

                String idpro = tblRecibo.getValueAt(i, 0).toString();
                int cant = Integer.parseInt(tblRecibo.getValueAt(i, 2).toString());
                int linid = Integer.parseInt(tblRecibo.getValueAt(i, 5).toString());
                double tot = Double.parseDouble(tblRecibo.getValueAt(i, 7).toString());

                ddr.setReciboId(id);
                ddr.setProductosId(idpro);
                ddr.setCantidad(cant);
                ddr.setLineasId(linid);
                ddr.setTotal(tot);

                String msj = ldr.insertarDDRecibo(ddr);

                if (msj.equals("si")) {
                    DAlmacen da = new DAlmacen();
                    LAlmacen la = new LAlmacen();

                    da.setIdAlamcen(idpro);
                    da.setStock(cant);

                    la.disminuirProducto(da);
                }

            }
            JOptionPane.showMessageDialog(null, "El Item Se guardo exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Ah Ocurrido un Error", "Informacion", JOptionPane.ERROR_MESSAGE);
        }

        habilita(false);
        Limpiar();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        habilita(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        habilita(false);
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (txtBuscar.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Completar los Formularios deben de estar llenos", "Informacion", JOptionPane.QUESTION_MESSAGE);
            txtBuscar.requestFocusInWindow();
            return;
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            boolean b = EstaTabla(txtBuscar.getText());

            if (b == false) {
                MostrarBuscar(txtBuscar.getText());

            }

            sumarTotal();
            txtBuscar.setText("");

        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tblReciboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReciboMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReciboMousePressed

    private void tblReciboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblReciboKeyPressed
        // TODO add your handling code here:

        DecimalFormat ft = new DecimalFormat("####.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            for (int i = 0; i < tblRecibo.getRowCount(); i++) {

                int cantidad = Integer.parseInt(tblRecibo.getValueAt(i, 2).toString());
                double preciounitario = Double.parseDouble(tblRecibo.getValueAt(i, 4).toString());
                double totalParcial = cantidad * preciounitario;
                tblRecibo.setValueAt(totalParcial, i, 7);

            }
            sumarTotal();
        }
    }//GEN-LAST:event_tblReciboKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRecibo;
    private javax.swing.JTextField txtBuscar;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtPEntrega;
    private javax.swing.JTextField txtPersona;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
