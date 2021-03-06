/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DAlmacen;
import Logica.LAlmacen;
import Logica.MarcaAgua;
import java.awt.Color;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
//import java.util.Iterator;
import org.apache.poi.ss.usermodel.Font;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tecnico
 */
public class frmInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInventarioa
     */
    public frmInventario() {
        initComponents();
        imagenesBtn();
        BuscaLn("");
        MarcaAgua txt = new MarcaAgua("Codigo Producto", txtBuscar);
    }

    public void imagenesBtn() {

        ImageIcon reporte = new ImageIcon("src/Imagen/seo.png");
        Icon iconog = new ImageIcon(reporte.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        btnReporte.setIcon(iconog);

    }

    public void BuscaLn(String id) {

        DefaultTableModel miModelo;
        LAlmacen lln = new LAlmacen();
        DAlmacen dln = new DAlmacen();
        dln.setIdAlamcen(id);
        miModelo = lln.BuscarAlamacen(dln);
        tblInvetario.setModel(miModelo);

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
        jScrollPane4 = new javax.swing.JScrollPane();
        tblInvetario = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario"));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        tblInvetario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "STOCK", "U/MEDIDA", "PRECIO/U", "TOTAL", "NOMBRE"
            }
        ));
        jScrollPane4.setViewportView(tblInvetario);

        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporte))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnReporte)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:

        BuscaLn(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:

        JFileChooser seleccionar = new JFileChooser();

        int opcion = seleccionar.showSaveDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            String ruta = seleccionar.getSelectedFile().getAbsolutePath();

            String nombrereporte = ruta + ".xlsx";

            String nombrehoja = "Inventario";

            XSSFWorkbook libroInventario = new XSSFWorkbook();
            XSSFSheet hojaInventario = libroInventario.createSheet(nombrehoja);

            String[] titulos = new String[]{"CODIGO", "DESCRIPCION", "STOCK", "U/MEDIDA", "PRECIO/U", "TOTAL", "NOMBRE"};

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

            for (int i = 0; i < tblInvetario.getRowCount(); i++) { //getRowCount devuelve el numero de filas

                XSSFRow contenido = hojaInventario.createRow(filacontenido);
                filacontenido++;
                for (int j = 0; j < tblInvetario.getColumnCount(); j++) {// getColumnCount devuelve el numero de columnas

                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(tblInvetario.getValueAt(i, j).toString());

                    celda.setCellStyle(contenido2);

                }
            }

            //            for (int i = 0; i < tblInvetario.getRowCount(); i++) {
            //                hojaInventario.autoSizeColumn(i);
            //
            //            }
            hojaInventario.autoSizeColumn(0);
            hojaInventario.autoSizeColumn(1);
            hojaInventario.autoSizeColumn(2);
            hojaInventario.autoSizeColumn(3);
            hojaInventario.autoSizeColumn(4);
            hojaInventario.autoSizeColumn(5);
            hojaInventario.autoSizeColumn(6);

            try (OutputStream archivo = new FileOutputStream(nombrereporte)) {

                libroInventario.write(archivo);

                JOptionPane.showMessageDialog(null, "Reporte se Descargo correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {

                JOptionPane.showMessageDialog(null, "No se pudo Descargar", "Informacion", JOptionPane.ERROR_MESSAGE);

                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblInvetario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
