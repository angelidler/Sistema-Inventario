/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DFactura;
import Logica.LFactura;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tecnico
 */
public class frmdtsFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmdtsFactura
     */
    public frmdtsFactura() {
        initComponents();
        MostrarDFacura();

    }

    public void MostrarDFacura() {

        DefaultTableModel miModelo;
        LFactura lf = new LFactura();
        miModelo = lf.MostrarAlmacen();
        tblDtfactura.setModel(miModelo);

    }

    public void BuscarDFactura(String id) {

        DefaultTableModel miModelo;
        DFactura df = new DFactura();
        LFactura lf = new LFactura();
        df.setId(id);
        miModelo = lf.BuscarAlamacen(df);
        tblDtfactura.setModel(miModelo);

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
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDtfactura = new javax.swing.JTable();
        txtReporte = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Factura"));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        tblDtfactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROVEEDOR", "LINEA", "FECHA"
            }
        ));
        tblDtfactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDtfacturaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDtfactura);

        txtReporte.setText("Reporte de Factura");
        txtReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReporte))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:

        if (txtBuscar.getText().equals("")) {

        MostrarDFacura();

        } else {

            BuscarDFactura(txtBuscar.getText());
            
            int aumenta = evt.getKeyCode();
            
            aumenta += aumenta;
            
            if (aumenta <= 20) {

                txtBuscar.setText("");

        }

    }

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tblDtfacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDtfacturaMousePressed
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {

            String id = tblDtfactura.getValueAt(tblDtfactura.getSelectedRow(), 0).toString();
            String Proveedor = tblDtfactura.getValueAt(tblDtfactura.getSelectedRow(), 1).toString();
            String Linea = tblDtfactura.getValueAt(tblDtfactura.getSelectedRow(), 2).toString();
            String Fecha = tblDtfactura.getValueAt(tblDtfactura.getSelectedRow(), 3).toString();

            frmdtllFactura mi = new frmdtllFactura(new JFrame(), true);
            mi.setDatos(id, Proveedor, Linea, Fecha);
            mi.setLocationRelativeTo(null);
            mi.setVisible(true);

        }

    }//GEN-LAST:event_tblDtfacturaMousePressed

    private void txtReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReporteActionPerformed
        // TODO add your handling code here:

        JFileChooser seleccionar = new JFileChooser();

        int opcion = seleccionar.showSaveDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            String ruta = seleccionar.getSelectedFile().getAbsolutePath();

            String nombrereporte = ruta + ".xlsx";

            String nombrehoja = "Facturas";

            XSSFWorkbook libroInventario = new XSSFWorkbook();
            XSSFSheet hojaInventario = libroInventario.createSheet(nombrehoja);

            String[] titulos = new String[]{"ID", "PROVEEDOR", "LINEA", "FECHA"};

            Font fontcabecera = libroInventario.createFont();
            fontcabecera.setBold(true);

            CellStyle cabecera = libroInventario.createCellStyle();

            cabecera.setBorderBottom(BorderStyle.THIN);
            cabecera.setBorderLeft(BorderStyle.THIN);
            cabecera.setBorderRight(BorderStyle.THIN);
            cabecera.setBorderTop(BorderStyle.THIN);
            cabecera.setFillForegroundColor(IndexedColors.BLUE.getIndex());
            cabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cabecera.setFont(fontcabecera);

            CellStyle contenido2 = libroInventario.createCellStyle();
            contenido2.setBorderBottom(BorderStyle.THIN);
            contenido2.setBorderLeft(BorderStyle.THIN);
            contenido2.setBorderRight(BorderStyle.THIN);
            contenido2.setBorderTop(BorderStyle.THIN);

            XSSFRow titulo = hojaInventario.createRow(0);

            for (int i = 0; i < titulos.length; i++) {
                XSSFCell celda = titulo.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(cabecera);
            }
            int filacontenido = 1;

            for (int i = 0; i < tblDtfactura.getRowCount(); i++) { //getRowCount devuelve el numero de filas

                XSSFRow contenido = hojaInventario.createRow(filacontenido);
                filacontenido++;
                for (int j = 0; j < tblDtfactura.getColumnCount(); j++) {// getColumnCount devuelve el numero de columnas

                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(tblDtfactura.getValueAt(i, j).toString());

                    celda.setCellStyle(contenido2);

                }
            }

            
            
            hojaInventario.autoSizeColumn(0);
            hojaInventario.autoSizeColumn(1);
            hojaInventario.autoSizeColumn(2);
            hojaInventario.autoSizeColumn(3);

            try (OutputStream archivo = new FileOutputStream(nombrereporte)) {

                libroInventario.write(archivo);

                JOptionPane.showMessageDialog(null, "Reporte se Descargo correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {

                JOptionPane.showMessageDialog(null, "No se pudo Descargar", "Informacion", JOptionPane.ERROR_MESSAGE);

                e.printStackTrace();
            }
            
        }


    }//GEN-LAST:event_txtReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDtfactura;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JButton txtReporte;
    // End of variables declaration//GEN-END:variables
}
