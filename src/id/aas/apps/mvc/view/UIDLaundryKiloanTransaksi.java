/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.view;

import id.aas.apps.mvc.controller.transaksiKiloanController;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aas Suhendar
 */
public class UIDLaundryKiloanTransaksi extends javax.swing.JFrame {

    private transaksiKiloanController kiloanController;
    private DefaultTableModel tableModel;
    double harga = 0;
    double totalTagihan = 0;
    double jumKiloan = 0;
    int kode_laundry = 0;

    /**
     * Creates new form UIDLaundryKiloanTransaksi
     */
    public UIDLaundryKiloanTransaksi() {
        initComponents();
        kiloanController = transaksiKiloanController.getObject();
        tableModel = new DefaultTableModel();
        this.setSize(620, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        showNamaPelanggan();
        setHarga();
        setKodeLaundry();
        kondisiAwal();
    }

    public transaksiKiloanController getKiloanController() {
        return kiloanController;
    }

    public void setKiloanController(transaksiKiloanController kiloanController) {
        this.kiloanController = kiloanController;
    }

    public void kondisiAwal() {
//        jComboBoxNama.setSelectedIndex(-1);
    }

    public void reset() {
        jtxtKode_Laundry.setText("");
        jtxtKode_Pelanggan.setText("");
        jtxtJumlahBayar.setText("");
        jtxtJumlahKiloan.setText("");
        jtxtJumlahTagihan.setText("");
        jtxtKembalian.setText("");
        jtxtTotalbayar.setText("");
        jComboBoxNama.setSelectedIndex(-1);
        jComboBoxPembayaran.setSelectedIndex(-1);
        jComboBoxPewangi.setSelectedIndex(-1);
        this.setKodeLaundry();
        jComboBoxNama.requestFocus();
    }

    public void showNamaPelanggan() {
        jComboBoxNama.removeAllItems();
        ArrayList<Object[]> data = null;
        try {
            data = kiloanController.getNamaPelanggan();

            for (int i = 0; i < data.size(); i++) {
                Object[] obj = data.get(i);
                for (Object obj1 : obj) {
                    jComboBoxNama.addItem(obj1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setKodeLaundry() {
        try {
            int kd_laundry = kiloanController.getKodeLaundry();
            kode_laundry = kd_laundry + 1;
            System.out.println("Kode : " + kode_laundry);
            jtxtKode_Laundry.setText(String.valueOf(kode_laundry));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setHarga() {
        try {
            harga = kiloanController.getHargaSatuan();
            System.out.println("Harga : " + harga);
            totalTagihan = jumKiloan * harga;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

        panel1 = new id.aas.apps.mvc.usuDesign.Panel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelAlpha1 = new id.aas.apps.mvc.usuDesign.PanelAlpha();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxNama = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateTglTerima = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jDateTglSelesai = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxPewangi = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxPembayaran = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtKode_Laundry = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtKode_Pelanggan = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtJumlahBayar = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtJumlahKiloan = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtJumlahTagihan = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtTotalbayar = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtKembalian = new id.aas.apps.mvc.usuDesign.TextBox();
        jbtnSimpan = new id.aas.apps.mvc.usuDesign.Button();
        jbtnMenuUtama = new id.aas.apps.mvc.usuDesign.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel7.setText("Roemah Cemerlang Laundry");
        panel1.add(jLabel7);
        jLabel7.setBounds(240, 50, 293, 29);

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel6.setText("Aplikasi Pencatatan Laundry");
        panel1.add(jLabel6);
        jLabel6.setBounds(310, 30, 221, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/laundry1111.png"))); // NOI18N
        panel1.add(jLabel1);
        jLabel1.setBounds(530, 10, 80, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/aktivitas.png"))); // NOI18N
        jLabel2.setText("Transaksi Kiloan");
        panel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 220, 110);

        panelAlpha1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Form Transaksi Kiloan Laundry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        panelAlpha1.setForeground(new java.awt.Color(255, 255, 255));
        panelAlpha1.setLayout(null);

        jLabel4.setText("Nama");
        panelAlpha1.add(jLabel4);
        jLabel4.setBounds(20, 50, 100, 21);

        jComboBoxNama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-", " " }));
        jComboBoxNama.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNamaItemStateChanged(evt);
            }
        });
        jComboBoxNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNamaActionPerformed(evt);
            }
        });
        panelAlpha1.add(jComboBoxNama);
        jComboBoxNama.setBounds(130, 50, 138, 20);

        jLabel3.setText("Kode Pelanggan");
        panelAlpha1.add(jLabel3);
        jLabel3.setBounds(20, 90, 100, 14);

        jLabel9.setText("Kode Laundry");
        panelAlpha1.add(jLabel9);
        jLabel9.setBounds(20, 120, 100, 14);

        jLabel10.setText("Tanggal Terima");
        panelAlpha1.add(jLabel10);
        jLabel10.setBounds(20, 150, 100, 14);
        panelAlpha1.add(jDateTglTerima);
        jDateTglTerima.setBounds(130, 150, 138, 20);

        jLabel11.setText("Tanggal Selesai");
        panelAlpha1.add(jLabel11);
        jLabel11.setBounds(20, 180, 100, 14);
        panelAlpha1.add(jDateTglSelesai);
        jDateTglSelesai.setBounds(130, 180, 138, 20);

        jLabel12.setText("Jenis Pewangi");
        panelAlpha1.add(jLabel12);
        jLabel12.setBounds(20, 210, 110, 14);

        jComboBoxPewangi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-", "Lily", "Orange" }));
        jComboBoxPewangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPewangiActionPerformed(evt);
            }
        });
        panelAlpha1.add(jComboBoxPewangi);
        jComboBoxPewangi.setBounds(130, 210, 138, 20);

        jLabel13.setText("Jumlah Kiloan");
        panelAlpha1.add(jLabel13);
        jLabel13.setBounds(290, 50, 80, 14);

        jLabel15.setText("Total Tagihan");
        panelAlpha1.add(jLabel15);
        jLabel15.setBounds(290, 90, 80, 14);

        jLabel17.setText("Keterangan  Pembayaran");
        panelAlpha1.add(jLabel17);
        jLabel17.setBounds(290, 120, 140, 14);

        jComboBoxPembayaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-", "Lunas", "Cash Bon" }));
        panelAlpha1.add(jComboBoxPembayaran);
        jComboBoxPembayaran.setBounds(440, 120, 110, 20);

        jLabel16.setText("Total Bayar");
        panelAlpha1.add(jLabel16);
        jLabel16.setBounds(290, 160, 80, 14);

        jLabel5.setText("Kembalian");
        panelAlpha1.add(jLabel5);
        jLabel5.setBounds(290, 200, 80, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Jumlah Bayar");
        panelAlpha1.add(jLabel8);
        jLabel8.setBounds(290, 240, 110, 17);

        jtxtKode_Laundry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtKode_LaundryActionPerformed(evt);
            }
        });
        panelAlpha1.add(jtxtKode_Laundry);
        jtxtKode_Laundry.setBounds(130, 114, 140, 30);
        panelAlpha1.add(jtxtKode_Pelanggan);
        jtxtKode_Pelanggan.setBounds(130, 80, 140, 30);
        panelAlpha1.add(jtxtJumlahBayar);
        jtxtJumlahBayar.setBounds(400, 230, 160, 50);

        jtxtJumlahKiloan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtJumlahKiloanKeyTyped(evt);
            }
        });
        panelAlpha1.add(jtxtJumlahKiloan);
        jtxtJumlahKiloan.setBounds(370, 44, 190, 30);
        panelAlpha1.add(jtxtJumlahTagihan);
        jtxtJumlahTagihan.setBounds(370, 80, 190, 30);

        jtxtTotalbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTotalbayarKeyTyped(evt);
            }
        });
        panelAlpha1.add(jtxtTotalbayar);
        jtxtTotalbayar.setBounds(370, 150, 190, 30);
        panelAlpha1.add(jtxtKembalian);
        jtxtKembalian.setBounds(370, 190, 190, 30);

        jbtnSimpan.setForeground(new java.awt.Color(0, 0, 0));
        jbtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/save_all.png"))); // NOI18N
        jbtnSimpan.setText("Simpan");
        jbtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSimpanActionPerformed(evt);
            }
        });
        panelAlpha1.add(jbtnSimpan);
        jbtnSimpan.setBounds(440, 290, 120, 40);

        panel1.add(panelAlpha1);
        panelAlpha1.setBounds(10, 150, 590, 350);

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
        jbtnMenuUtama.setBounds(460, 110, 130, 30);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNamaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNamaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int kodePelanggan = 0;
            try {
                String nama = jComboBoxNama.getSelectedItem().toString();
                kodePelanggan = kiloanController.getKodePelanggan(nama);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(kodePelanggan);
            jtxtKode_Pelanggan.setText(String.valueOf(kodePelanggan));
        }
    }//GEN-LAST:event_jComboBoxNamaItemStateChanged

    private void jComboBoxNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNamaActionPerformed

    private void jComboBoxPewangiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPewangiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPewangiActionPerformed

    private void jtxtKode_LaundryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtKode_LaundryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtKode_LaundryActionPerformed

    private void jtxtJumlahKiloanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtJumlahKiloanKeyTyped
        // TODO add your handling code here:
        try {
            jumKiloan = Double.parseDouble(jtxtJumlahKiloan.getText().toString());
            if (jumKiloan <= 0) {
                JOptionPane.showMessageDialog(null, "Jumlah Kiloan tidak boleh minus atau nol", "Warning", JOptionPane.INFORMATION_MESSAGE);
                jtxtJumlahKiloan.setText("");
                jtxtJumlahTagihan.setText("");
            } else {
                totalTagihan = jumKiloan * harga;
                jtxtJumlahTagihan.setText(String.valueOf(totalTagihan));
                jtxtJumlahBayar.setText(String.valueOf(totalTagihan));
                System.out.println("total tagihan :" + totalTagihan);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jtxtJumlahKiloanKeyTyped

    private void jtxtTotalbayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTotalbayarKeyTyped
        // TODO add your handling code here:
        try {
            double bayar = Double.parseDouble(jtxtTotalbayar.getText().toString());
            double kembalian = bayar - totalTagihan;
            jtxtKembalian.setText(String.valueOf(kembalian));
            System.out.println("Kembalian : " + kembalian);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jtxtTotalbayarKeyTyped

    private void jbtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            boolean validasi = false;
            String kodeTransaksi = "";
            String kodePelanggan = jtxtKode_Pelanggan.getText();
            String kd_laundry = jtxtKode_Laundry.getText();
            String jenisLayanan = "";
            java.sql.Date tglTerima = new java.sql.Date(jDateTglTerima.getDate().getTime());
            java.sql.Date tglSelesai = new java.sql.Date(jDateTglSelesai.getDate().getTime());
            String pewangi = jComboBoxPewangi.getSelectedItem().toString();
            String jumlahKiloan = jtxtJumlahKiloan.getText();
            String jenisPakaian = "";
            double jumlahSatuan = 0;
            String hargaSatuan = String.valueOf(harga);
            totalTagihan = Double.valueOf(jumlahKiloan) * harga;
            String tagihan = String.valueOf(totalTagihan);
            jtxtJumlahTagihan.setText(tagihan);
            String keteranganL = "";
            String keteranganT = jComboBoxPembayaran.getSelectedItem().toString();
            String btnStatus = jbtnSimpan.getText();

            System.out.println("tgl terima :" + tglTerima);
            System.out.println("tgl selesai :" + tglSelesai);

            if (kodePelanggan.isEmpty() || kd_laundry.isEmpty() || pewangi.equals("-Pilih-") || jumlahKiloan.isEmpty() || keteranganT.equals("-Pilih-")) {
                JOptionPane.showMessageDialog(null, "Terdapat Field Kosong, harap mengisi semua field", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                validasi = kiloanController.simpanTransaksi(kd_laundry, jenisLayanan,
                        pewangi, jumlahKiloan, jumlahSatuan, jenisPakaian, hargaSatuan,
                        tagihan, keteranganL, kodePelanggan, kd_laundry, tglTerima,
                        tglSelesai, tagihan, keteranganT);
                if (validasi == true) {
                    JOptionPane.showMessageDialog(null, "Data Transaksi Laundry Kiloan Berhasil Disimpan", "Simpan Transaksi", JOptionPane.INFORMATION_MESSAGE);
                    kiloanController.cetakStruk();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Transaksi Laundry Kiloan Gagal Disimpan", "Simpan Transaksi", JOptionPane.INFORMATION_MESSAGE);
                }
                reset();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtnSimpanActionPerformed

    private void jbtnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMenuUtamaActionPerformed
        // TODO add your handling code here:
        new UIDmenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnMenuUtamaActionPerformed

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
            java.util.logging.Logger.getLogger(UIDLaundryKiloanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIDLaundryKiloanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIDLaundryKiloanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIDLaundryKiloanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIDLaundryKiloanTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxNama;
    private javax.swing.JComboBox jComboBoxPembayaran;
    private javax.swing.JComboBox jComboBoxPewangi;
    private com.toedter.calendar.JDateChooser jDateTglSelesai;
    private com.toedter.calendar.JDateChooser jDateTglTerima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private id.aas.apps.mvc.usuDesign.Button jbtnMenuUtama;
    private id.aas.apps.mvc.usuDesign.Button jbtnSimpan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtJumlahBayar;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtJumlahKiloan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtJumlahTagihan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtKembalian;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtKode_Laundry;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtKode_Pelanggan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtTotalbayar;
    private id.aas.apps.mvc.usuDesign.Panel panel1;
    private id.aas.apps.mvc.usuDesign.PanelAlpha panelAlpha1;
    // End of variables declaration//GEN-END:variables
}