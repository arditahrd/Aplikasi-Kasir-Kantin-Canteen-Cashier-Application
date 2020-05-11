/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IF2A;

/**
 *
 * @author GameOfThrones
 */

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Data extends javax.swing.JFrame {

    /**
     * Creates new form Data
     */
    public Data() {
        initComponents();
        koneksi_db();
        tampil_data();
    }

    Connection conn;
    Statement stmt;
    DefaultTableModel model = new DefaultTableModel();
    ResultSet rs;
    public void koneksi_db(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/kasir_kantin", "root", "");
            stmt=conn.createStatement();
            
            System.out.println("Koneksi berhasil");
        }catch (Exception e){
            System.out.println("Koneksi gagal : "+e);
        }
    }
    
    public void tampil_data(){
        model.addColumn("No Beli");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        model.addColumn("Tanggal");
        
        try{
        String  query="Select * from pembelian";
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
                while(rs.next()){
                    Object [] data =new Object[] {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)};
                    model.addRow(data);
                }
            jTable1.setModel(model);
               
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        /*try{
           model.setRowCount(0);
           rs=stmt.executeQuery("select * from pembelian");
           while(rs.next()){
               Object[] data = {rs.getString("no_beli"),
                   rs.getString("nama_barang"),
                   rs.getString("jumlah"),
                   rs.getString("total"),
                   rs.getString("tanggal")};
               model.addRow(data);
            }
           jTable1.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error"+ e);
        }*/
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        B_data = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));
        setForeground(new java.awt.Color(51, 153, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Barang", "Jumlah", "Total", "Tanggal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 340));

        B_data.setText("KEMBALI");
        B_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_dataActionPerformed(evt);
            }
        });
        getContentPane().add(B_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_dataActionPerformed
        // TODO add your handling code here:
        FormUtama back = new FormUtama();
        back.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_B_dataActionPerformed

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
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_data;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}