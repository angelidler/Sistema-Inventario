/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DAlmacen;
import Datos.DDFacturas;
import Datos.DFactura;
import Datos.DLineas;
import Logica.LAlmacen;
import Logica.LDFactura;
import Logica.LFactura;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.sql.Date;

import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tecnico
 */
public class frmFacturas extends javax.swing.JInternalFrame {

    private DefaultTableModel miModelo;
    private static int idLina = 0;

    /**
     * Creates new form frmFacturas
     */
    public frmFacturas() {
        initComponents();

        txtTotal.setEditable(false);
        txtid.setEnabled(false);
// ----------------- Codigo de tabla para dar tamaño y ejecucion ---------------
        miModelo = (DefaultTableModel) tblFactura.getModel();

        tblFactura.getColumn("Codigo").setWidth(18);
        tblFactura.getColumn("Codigo").setPreferredWidth(18);

        tblFactura.getColumn("Descriccion").setWidth(190);
        tblFactura.getColumn("Descriccion").setPreferredWidth(190);

        tblFactura.getColumn("Cantidad").setWidth(35);
        tblFactura.getColumn("Cantidad").setPreferredWidth(35);

        tblFactura.getColumn("U/Medida").setWidth(40);
        tblFactura.getColumn("U/Medida").setPreferredWidth(40);

        tblFactura.getColumn("P/Unitario").setWidth(40);
        tblFactura.getColumn("P/Unitario").setPreferredWidth(40);

        tblFactura.getColumn("Total").setWidth(30);
        tblFactura.getColumn("Total").setPreferredWidth(30);

// ----------------- Codigo de tabla para dar tamaño y ejecucion ---------------
        habilitar(true);
        Limpiar();

    }

    public static void setlineas(String id, String Lineas) {
        idLina = Integer.parseInt(id);
        idLineas.setText(id);
        txtLinea.setText(Lineas);

    }

    public static void setProveedor(String id, String Proveedor) {

        idProveedores.setText(id);
        txtProveedor.setText(Proveedor);

    }

    public void Limpiar() {

        txtEntrar.setText("");
        txtFecha.setDate(null);
        txtLinea.setText("");
        txtProveedor.setText("");
        txtTotal.setText("");
        idLineas.setText("");
        idProveedores.setText("");

        try {
            DefaultTableModel miModelo = (DefaultTableModel) tblFactura.getModel();//Toma el model de la tabla excistente

            int fila = tblFactura.getRowCount();//devuelve el numero de filas de una Tabla
            for (int i = 0; fila > i; i++) {

                miModelo.removeRow(0);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "no se pudo limpiar las celdas", "Infromacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void habilitar(boolean txt) {

        txtEntrar.setEnabled(!txt);
        txtLinea.setEnabled(!txt);
        txtProveedor.setEnabled(!txt);
        txtFecha.setEnabled(!txt);

        btnGuardar.setEnabled(!txt);
        btnCancelar.setEnabled(!txt);
        btnLinea.setEnabled(!txt);
        btnProveedor.setEnabled(!txt);
        btnNuevo.setEnabled(txt);

    }

    public void alGuardar(boolean txt) {

        txtEntrar.setEnabled(!txt);
        txtFecha.setEnabled(!txt);

        btnGuardar.setEnabled(!txt);
        btnCancelar.setEnabled(!txt);
        btnLinea.setEnabled(!txt);
        btnProveedor.setEnabled(!txt);
        btnNuevo.setEnabled(txt);

    }

    private boolean EstaTabla(String texto) {
        DecimalFormat ft = new DecimalFormat("####.00");
        boolean res = false;

        for (int i = 0; i < tblFactura.getRowCount(); i++) {
            String Codigo = tblFactura.getValueAt(i, 0).toString();
            if (Codigo.equals(texto)) {

                int cantidad = Integer.parseInt(tblFactura.getValueAt(i, 2).toString());
                double PrecioU = Double.parseDouble(tblFactura.getValueAt(i, 4).toString());

                int totalcantidad = cantidad + 1;
                tblFactura.setValueAt(totalcantidad, i, 2);

                double precioParcia = PrecioU * totalcantidad;
                
                tblFactura.setValueAt(ft.format(precioParcia).replace(",", "."), i, 5);
                

                res = true;
            }

        }
        sumarTotal();
        return res;

    }

    private void sumarTotal() {

        DecimalFormat ft = new DecimalFormat("####.00");
        double totalfinal = 0;
        for (int i = 0; i < tblFactura.getRowCount(); i++) {
            double PrecioU = Double.parseDouble(tblFactura.getValueAt(i, 5).toString());
            totalfinal = totalfinal + PrecioU;
            txtTotal.setText(ft.format(totalfinal));

        }
    }

    private void MostrarBuscar(String id) {

        LAlmacen lam = new LAlmacen();
        DAlmacen dam = new DAlmacen();
        dam.setIdAlamcen(id);
        String Registro[] = lam.MostrarAlamcen(dam);

        if (Registro[0] != null) {
            miModelo.insertRow(0, Registro);
            tblFactura.setModel(miModelo);
        } else {
            Registro[0] = txtEntrar.getText();
            Registro[1] = "";
            Registro[2] = "1";
            Registro[3] = "";
            Registro[4] = "0.00";
            Registro[5] = "0.00";
            miModelo.insertRow(0, Registro);
            tblFactura.setModel(miModelo);

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();
        idLineas = new javax.swing.JLabel();
        idProveedores = new javax.swing.JLabel();
        txtEntrar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Facturas");
        setPreferredSize(new java.awt.Dimension(740, 530));

        jLabel1.setText("ID");

        jLabel2.setText("Linea");

        jLabel3.setText("Proveedor");

        jLabel4.setText("Fecha");

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descriccion", "Cantidad", "U/Medida", "P/Unitario", "Total"
            }
        ));
        tblFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFacturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnLinea.setText("...");
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnProveedor.setText("...");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        idLineas.setText("jLabel5");

        idProveedores.setText("jLabel6");

        txtEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntrarKeyPressed(evt);
            }
        });

        jLabel5.setText("TOTAL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtLinea)
                                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProveedor)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(idProveedores)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(idLineas)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnLinea)
                        .addComponent(idLineas)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor)
                    .addComponent(idProveedores))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(440, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar(false);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        // TODO add your handling code here:

        frmBuscarLinea mi = new frmBuscarLinea(new JFrame(), true);
        mi.setLocationRelativeTo(null);
        mi.setVisible(true);

        /* DLineas dl=new DLineas();
        txtLinea.setText(dl.getLineas());*/
    }//GEN-LAST:event_btnLineaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:

        frmBuscarProveedor mi = new frmBuscarProveedor(new JFrame(), true);
        mi.setLocationRelativeTo(null);
        mi.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String msj;
        if (txtLinea.getText().equals("") || txtProveedor.getText().equals("") || txtFecha.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Completar los Formularios deben de estar llenos", "Informacion", JOptionPane.QUESTION_MESSAGE);
            txtLinea.requestFocusInWindow();
            return;
        }
        if (txtid.getText().equals("")) {
            DFactura df = new DFactura();
            LFactura lf = new LFactura();

            df.setIdLinea(Integer.parseInt(idLineas.getText()));
            df.setIdProveedor(Integer.parseInt(idProveedores.getText()));

            Calendar cl;

            cl = txtFecha.getCalendar();
            int dd, mm, aa;

            dd = cl.get(Calendar.DAY_OF_WEEK);
            mm = cl.get(Calendar.MONTH);
            aa = cl.get(Calendar.YEAR) - 1900;

            df.setFecha(new Date(aa, mm, dd));

            int id = lf.InsartarFc(df);
            System.out.print(id);

            if (id > 0) {

                int fila = tblFactura.getRowCount();
                for (int i = 0; i < fila; i++) {

                    String idprod = tblFactura.getValueAt(i, 0).toString();
                    String descripcion = tblFactura.getValueAt(i, 1).toString();
                    int cantidad = Integer.parseInt(tblFactura.getValueAt(i, 2).toString());
                    String unidad = tblFactura.getValueAt(i, 3).toString();
                    double preciou = Double.parseDouble(tblFactura.getValueAt(i, 4).toString());
                    double total = Double.parseDouble(tblFactura.getValueAt(i, 5).toString());

                    DDFacturas ddf = new DDFacturas();
                    LDFactura ldf = new LDFactura();
                    ddf.setProductosid(idprod);
                    ddf.setIdDetFactura(id);
                    ddf.setCantidad(cantidad);
                    ddf.setTotal(total);

                    String mensaje = ldf.insertarDDFactura(ddf);
                    System.out.print(mensaje);
                    if (mensaje.equals("si")) {

                        DAlmacen da = new DAlmacen();
                        LAlmacen la = new LAlmacen();

                        da.setIdAlamcen(idprod);
                        da.setDescripcion(descripcion);
                        da.setStock(cantidad);
                        da.setUMedida(unidad);
                        da.setPrecioU(preciou);
                        da.setIdLinea(idLina);

                        la.InsertarProducto(da);
                        //JOptionPane.showMessageDialog(null, "entro en el bucle", "informacion", JOptionPane.PROPERTIES);
                    }

                }
                JOptionPane.showMessageDialog(null, "El Item Se guardo exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Ah Ocurrido un Error", "Informacion", JOptionPane.ERROR_MESSAGE);
            }
            Limpiar();
            alGuardar(true);
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntrarKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            boolean b = EstaTabla(txtEntrar.getText());

            if (b == false) {

                MostrarBuscar(txtEntrar.getText());
            }
            sumarTotal();
            txtEntrar.setText("");

        }
    }//GEN-LAST:event_txtEntrarKeyPressed

    private void tblFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFacturaKeyPressed
        // TODO add your handling code here: allar el error 

        DecimalFormat ft = new DecimalFormat("####.00");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            for (int i = 0; i < tblFactura.getRowCount(); i++) {

                int cantidad = Integer.parseInt(tblFactura.getValueAt(i, 2).toString());
                double preciounitario = Double.parseDouble(tblFactura.getValueAt(i, 4).toString());
                double totalParcial = cantidad * preciounitario;

//                tblFactura.setValueAt(totalParcial, i, 5);
                tblFactura.setValueAt(ft.format(totalParcial), i, 5);

            }
            sumarTotal();
        }
    }//GEN-LAST:event_tblFacturaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProveedor;
    private static javax.swing.JLabel idLineas;
    private static javax.swing.JLabel idProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtEntrar;
    private com.toedter.calendar.JDateChooser txtFecha;
    private static javax.swing.JTextField txtLinea;
    private static javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

}
