/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DDRecibo;
import Logica.LDRecibo;
import Logica.LFactura;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tecnico
 */
public class frmReciboDet extends javax.swing.JDialog {

    DefaultTableModel miModelo;

    /**
     * Creates new form frmReciboDet
     */
    public frmReciboDet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        BuscarDFactura();
        Edita(false);
        
        imagenesBtn();
    }
    
     public void imagenesBtn() {

        ImageIcon mifactura = new ImageIcon("src/Imagen/reporte-de-recibo.png");
        Icon iconof = new ImageIcon(mifactura.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        btnExportar.setIcon(iconof);

    }

    public void BuscarDFactura() {

        DefaultTableModel miModelo;
        LFactura lf = new LFactura();
        miModelo = lf.MostrarAlmacen();
        tblRecibo.setModel(miModelo);

    }

    private void Edita(boolean txt) {
        txtEntrega.setEditable(txt);
        txtid.setEditable(txt);
        txtRecibe.setEditable(txt);
        txtFecha.setEditable(txt);
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
        txtFecha = new javax.swing.JTextField();
        txtEntrega = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecibo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtRecibe = new javax.swing.JTextField();
        btnExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Fecha");

        jLabel3.setText("Entrega");

        jLabel4.setText("Recibe");

        tblRecibo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descriccion", "Cantidad", "U/Medida", "P/Unitario", "Linea", "Total"
            }
        ));
        tblRecibo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblReciboMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecibo);

        jLabel5.setText("TOTAL:");

        btnExportar.setText("Exportar recibo");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEntrega))
                                    .addComponent(txtRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(418, 418, 418))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnExportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRecibe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tblReciboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReciboMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReciboMousePressed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:

        JFileChooser seleccionar = new JFileChooser();

        int opcion = seleccionar.showSaveDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            String ruta = seleccionar.getSelectedFile().getAbsolutePath();

            String nombrereporte = ruta + txtid.getText() + ".xlsx";

            String nombrehoja = "Detalle Recibo " + txtRecibe.getText();

            XSSFWorkbook libroInventario = new XSSFWorkbook();
            XSSFSheet hojaInventario = libroInventario.createSheet(nombrehoja);

            String[] titulos = new String[]{"Codigo", "Descriccion", "Cantidad", "U/Medida", "P/Unitario", "Linea", "Total"};

            Font fontcabecera = libroInventario.createFont();
            fontcabecera.setBold(true);

            CellStyle cabecera = libroInventario.createCellStyle();//se usa para dar estilos a las celsadas de excel en el documento de reporte

            cabecera.setBorderBottom(BorderStyle.THIN);
            cabecera.setBorderLeft(BorderStyle.THIN);
            cabecera.setBorderRight(BorderStyle.THIN);
            cabecera.setBorderTop(BorderStyle.THIN);
            cabecera.setFillForegroundColor(IndexedColors.BLUE.getIndex());
            cabecera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cabecera.setFont(fontcabecera);

            CellStyle contenido2 = libroInventario.createCellStyle();//se usa para dar estilos a las celsadas de excel en el documento de reporte
            contenido2.setBorderBottom(BorderStyle.THIN);
            contenido2.setBorderLeft(BorderStyle.THIN);
            contenido2.setBorderRight(BorderStyle.THIN);
            contenido2.setBorderTop(BorderStyle.THIN);
            contenido2.setAlignment(HorizontalAlignment.CENTER);

//--------------------------Contenido de proveedores----------------------------------------------------  
            CellStyle cstitulo = libroInventario.createCellStyle(); //se usa para dar estilos a las celsadas de excel en el documento de reporte
            cstitulo.setBorderBottom(BorderStyle.THIN);
            cstitulo.setBorderLeft(BorderStyle.THIN);
            cstitulo.setBorderRight(BorderStyle.THIN);
            cstitulo.setBorderTop(BorderStyle.THIN);

            XSSFRow id = hojaInventario.createRow(1);// metodo que devuelve la fila de una celda de excell 
            XSSFCell idtitulo = id.createCell(0);// metodo que devuelve la columna de una celda de excell 
            XSSFCell idtexto = id.createCell(1);
            idtitulo.setCellValue("Recibo");
            idtexto.setCellValue(txtid.getText());
            idtitulo.setCellStyle(cstitulo);

            XSSFRow Linea = hojaInventario.createRow(3);// metodo que devuelve la fila de una celda de excell 
            XSSFCell LineaTitulo = Linea.createCell(0);// metodo que devuelve la columna de una celda de excell 
            XSSFCell Lineatexto = Linea.createCell(1);
            LineaTitulo.setCellValue("Persona Recibe");
            Lineatexto.setCellValue(txtRecibe.getText());
            LineaTitulo.setCellStyle(cstitulo);

            XSSFRow Proveedor = hojaInventario.createRow(5);// metodo que devuelve la fila de una celda de excell 
            XSSFCell Proveedortitulo = Proveedor.createCell(0);// metodo que devuelve la columna de una celda de excell 
            XSSFCell Proveedortexto = Proveedor.createCell(1);
            Proveedortitulo.setCellValue("Persona Entrega");
            Proveedortexto.setCellValue(txtEntrega.getText());
            Proveedortitulo.setCellStyle(cstitulo);

            XSSFRow Fecha = hojaInventario.createRow(7);// metodo que devuelve la fila de una celda de excell 
            XSSFCell Fechatitulo = Fecha.createCell(0);// metodo que devuelve la columna de una celda de excell 
            XSSFCell Fechatexto = Fecha.createCell(1);
            Fechatitulo.setCellValue("Fecha");
            Fechatexto.setCellValue(txtFecha.getText());
            Fechatitulo.setCellStyle(cstitulo);

            XSSFRow titulo = hojaInventario.createRow(9);// metodo que devuelve la fila de una celda de excell 

            for (int i = 0; i < titulos.length; i++) {
                XSSFCell celda = titulo.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(cabecera);
            }
            int filacontenido = 10;

            for (int i = 0; i < tblRecibo.getRowCount(); i++) { //getRowCount devuelve el numero de filas

                XSSFRow contenido = hojaInventario.createRow(filacontenido);//añade una fila por medio de un bucle for
                filacontenido++;
                for (int j = 0; j < tblRecibo.getColumnCount(); j++) {// getColumnCount devuelve el numero de columnas

                    XSSFCell celda = contenido.createCell(j);
                    celda.setCellValue(tblRecibo.getValueAt(i, j).toString());

                    celda.setCellStyle(contenido2);

                }
            }

            XSSFRow Total = hojaInventario.createRow(filacontenido+1);// metodo que devuelve la fila de una celda de excell 
            XSSFCell Totaltitulo = Total.createCell(5);// metodo que devuelve la columna de una celda de excell 
            XSSFCell Totaltexto = Total.createCell(6);
            Totaltitulo.setCellValue("Total");
            Totaltexto.setCellValue(txtTotal.getText());
            Totaltitulo.setCellStyle(cstitulo);

            CellRangeAddress unirceldas = new CellRangeAddress(5, 5, 1, 3);
            hojaInventario.addMergedRegion(unirceldas);//Metodo Utilizado para Unir celtas" Investigar mas este metodo

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
    }//GEN-LAST:event_btnExportarActionPerformed
    public void setDatos(String id, String Fecha, String PEntrega, String PRecibe) {

        txtFecha.setText(Fecha);
        txtid.setText(id);
        txtEntrega.setText(PEntrega);
        txtRecibe.setText(PRecibe);
        MostrarDetalleRecibo(Integer.parseInt(id));

    }

    private void MostrarDetalleRecibo(int id) {

        miModelo = (DefaultTableModel) tblRecibo.getModel();
        LDRecibo ldf = new LDRecibo();
        DDRecibo ddf = new DDRecibo();
        ddf.setReciboId(id);
        miModelo = ldf.BucarDRecibo(ddf);
        tblRecibo.setModel(miModelo);
        sumarTotal();
    }

    public void sumarTotal() {

        DecimalFormat ft = new DecimalFormat("####.00");
        double totalfinal = 0;
        for (int i = 0; i < tblRecibo.getRowCount(); i++) {
            double PrecioU = Double.parseDouble(tblRecibo.getValueAt(i, 6).toString());
            totalfinal = totalfinal + PrecioU;
            txtTotal.setText(ft.format(totalfinal));

        }
    }

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
            java.util.logging.Logger.getLogger(frmReciboDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReciboDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReciboDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReciboDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmReciboDet dialog = new frmReciboDet(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRecibo;
    private static javax.swing.JTextField txtEntrega;
    private static javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtRecibe;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

}
