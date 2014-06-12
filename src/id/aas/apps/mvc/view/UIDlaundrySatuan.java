/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.view;

import id.aas.apps.mvc.controller.laundrySatuanController;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aas Suhendar
 */
public class UIDlaundrySatuan extends javax.swing.JFrame {

    private laundrySatuanController lsController;
    private DefaultTableModel tableModel;

    /**
     * Creates new form UIDlaundrySatuan
     */
    public UIDlaundrySatuan() {
        initComponents();
        lsController = new laundrySatuanController();
        tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 520);
        this.setLocationRelativeTo(null);
        RunApps();
    }

    public laundrySatuanController getLSController() {
        return lsController;
    }

    public void setLSController(laundrySatuanController LSController) {
        this.lsController = LSController;
    }

    public void setTableHeader() {
        Object[] header = lsController.getHeaderTable();
        for (Object header1 : header) {
            tableModel.addColumn(header1);
        }
    }

    public void setIsiDataLSatuan() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();

        ArrayList<Object[]> data = null;
        try {
            data = lsController.getAllDataLSatuan();
            for (int i = 0; i < data.size(); i++) {
                tableModel.addRow(data.get(i));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void RunApps() {
        try {
            this.setTableHeader();
            this.setIsiDataLSatuan();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reset() {
        jtxtNamaPakaian.setText("");
        jtxtHarga.setText("");
        jbtnSimpanEdit.setText("Simpan");
        jtxtNamaPakaian.requestFocus();
    }

    public void isiField() {
        int row = jTable1.getSelectedRow();
        jtxtNamaPakaian.setText(jTable1.getValueAt(row, 1).toString());
        jtxtHarga.setText(jTable1.getValueAt(row, 2).toString());
        jbtnSimpanEdit.setText("Edit");
    }

    /**
     *
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new id.aas.apps.mvc.usuDesign.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelAlpha1 = new id.aas.apps.mvc.usuDesign.PanelAlpha();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNamaPakaian = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtHarga = new id.aas.apps.mvc.usuDesign.TextBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtnSimpanEdit = new id.aas.apps.mvc.usuDesign.Button();
        jbtnHapus = new id.aas.apps.mvc.usuDesign.Button();
        jbtnMenuUtama = new id.aas.apps.mvc.usuDesign.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/laundry1111.png"))); // NOI18N
        panel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 70, 80);

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel6.setText("Aplikasi Pencatatan Laundry");
        panel1.add(jLabel6);
        jLabel6.setBounds(100, 20, 221, 22);

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel7.setText("Roemah Cemerlang Laundry");
        panel1.add(jLabel7);
        jLabel7.setBounds(100, 40, 293, 29);

        panelAlpha1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Harga Laundry Satuan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        panelAlpha1.setForeground(new java.awt.Color(255, 255, 255));
        panelAlpha1.setLayout(null);

        jLabel2.setText("Nama Pakaian");
        panelAlpha1.add(jLabel2);
        jLabel2.setBounds(10, 30, 100, 14);

        jLabel3.setText("Harga");
        panelAlpha1.add(jLabel3);
        jLabel3.setBounds(10, 70, 70, 14);
        panelAlpha1.add(jtxtNamaPakaian);
        jtxtNamaPakaian.setBounds(110, 24, 260, 30);
        panelAlpha1.add(jtxtHarga);
        jtxtHarga.setBounds(110, 60, 260, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panelAlpha1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 170, 360, 140);

        jbtnSimpanEdit.setForeground(new java.awt.Color(0, 0, 0));
        jbtnSimpanEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/save_all.png"))); // NOI18N
        jbtnSimpanEdit.setText("Simpan");
        jbtnSimpanEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSimpanEditActionPerformed(evt);
            }
        });
        panelAlpha1.add(jbtnSimpanEdit);
        jbtnSimpanEdit.setBounds(110, 110, 130, 40);

        jbtnHapus.setForeground(new java.awt.Color(0, 0, 0));
        jbtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/gnome_edit_delete.png"))); // NOI18N
        jbtnHapus.setText("Hapus");
        jbtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHapusActionPerformed(evt);
            }
        });
        panelAlpha1.add(jbtnHapus);
        jbtnHapus.setBounds(250, 110, 120, 40);

        panel1.add(panelAlpha1);
        panelAlpha1.setBounds(20, 120, 400, 320);

        jbtnMenuUtama.setForeground(new java.awt.Color(0, 0, 0));
        jbtnMenuUtama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/home.png"))); // NOI18N
        jbtnMenuUtama.setText("Menu Utama");
        jbtnMenuUtama.setActionCommand("jbtnMenuUtama");
        jbtnMenuUtama.setFocusPainted(false);
        jbtnMenuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMenuUtamaActionPerformed(evt);
            }
        });
        panel1.add(jbtnMenuUtama);
        jbtnMenuUtama.setBounds(290, 80, 130, 30);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSimpanEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSimpanEditActionPerformed
        // TODO add your handling code here:
        try {
            boolean validasi = false;
            String nama = jtxtNamaPakaian.getText();
            String harga = jtxtHarga.getText();
            String btnStatus = jbtnSimpanEdit.getText();

            if (nama.isEmpty() || harga.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Terdapat Field Kosong, harap mengisi semua field", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (btnStatus.equalsIgnoreCase("Simpan")) {
                    String kode = null;
                    validasi = lsController.olahDataLSatuan(btnStatus, kode, nama, harga);
                } else if (btnStatus.equalsIgnoreCase("Edit")) {
                    int row = jTable1.getSelectedRow();
                    String kode = jTable1.getValueAt(row, 0).toString();
                    validasi = lsController.olahDataLSatuan(btnStatus, kode, nama, harga);
                }

                if (validasi == true) {
                    setIsiDataLSatuan();
                    if (btnStatus.equalsIgnoreCase("Simpan")) {
                        JOptionPane.showMessageDialog(null, "Data Harga Satuan Laundry Berhasil Disimpan", "Simpan Harga Satuan Laundry", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Harga Satuan Laundry Berhasil Diedit", "Simpan Harga Satuan Laundry", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    if (btnStatus.equalsIgnoreCase("Simpan")) {
                        JOptionPane.showMessageDialog(null, "Data Harga Satuan Laundry Gagal Disimpan", "Simpan Harga Satuan Laundry", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Harga Satauan Laundry Gagal Diedit", "Simpan harga Satuan Laundry", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                reset();
            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtnSimpanEditActionPerformed

    private void jbtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHapusActionPerformed
        // TODO add your handling code here:
        try {

            int row = jTable1.getSelectedRow();
            String kode = jTable1.getValueAt(row, 0).toString();
            boolean validasi = lsController.hapusDataLSatuan(kode);
            if (validasi == true) {
                setIsiDataLSatuan();
                JOptionPane.showMessageDialog(null, "Data Harga Satuan Laundry Berhasil DIhapus", "Simpan Harga Satuan Laundry", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data Harga Satuan Laundry Gagal DIhapuus", "Simpan Harga Satuan Laundy", JOptionPane.INFORMATION_MESSAGE);
            }
            reset();
        } catch (SQLException | HeadlessException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtnHapusActionPerformed

    private void jbtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMenuUtamaActionPerformed
        // TODO add your handling code here:
        new UIDmenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnMenuUtamaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            isiField();
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(UIDlaundrySatuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIDlaundrySatuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIDlaundrySatuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIDlaundrySatuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIDlaundrySatuan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private id.aas.apps.mvc.usuDesign.Button jbtnHapus;
    private id.aas.apps.mvc.usuDesign.Button jbtnMenuUtama;
    private id.aas.apps.mvc.usuDesign.Button jbtnSimpanEdit;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtHarga;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtNamaPakaian;
    private id.aas.apps.mvc.usuDesign.Panel panel1;
    private id.aas.apps.mvc.usuDesign.PanelAlpha panelAlpha1;
    // End of variables declaration//GEN-END:variables
}
