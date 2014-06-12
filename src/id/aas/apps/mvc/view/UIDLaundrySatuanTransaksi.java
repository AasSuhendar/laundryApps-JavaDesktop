/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.view;

import id.aas.apps.mvc.controller.transaksiSatuanController;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aas Suhendar
 */
public class UIDLaundrySatuanTransaksi extends javax.swing.JFrame {

    private transaksiSatuanController satuanController;
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModelSatuan;
    double harga = 0;
    double totalTagihan = 0;
    double jumSatuan = 0;
    int kode_laundry = 0;
    String namaPakaian = "";

    /**
     * Creates new form UIDLaundrySatuanTransaksi
     */
    public UIDLaundrySatuanTransaksi() {
        initComponents();
        satuanController = new transaksiSatuanController();
        tableModel = new DefaultTableModel();
        tableModelSatuan = new DefaultTableModel();
        jTableSatuanLaundry.setModel(tableModelSatuan);
        tableModel.setColumnIdentifiers(new String[]{"Kode Pakaian", "Nama Pakaian", "Satuan", "Harga", "Total"});
        this.setSize(850, 670);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        runApps();
    }

    public transaksiSatuanController getSatuanController() {
        return satuanController;
    }

    public void setSatuanController(transaksiSatuanController satuanController) {
        this.satuanController = satuanController;
    }

    public void kondisiAwal() {
//        jComboBoxNama.setSelectedIndex(-1);
    }

    public void showNamaPelanggan() {
        jComboBoxNama.removeAllItems();
        ArrayList<Object[]> data = null;
        try {
            data = satuanController.getNamaPelanggan();
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
            int kd_laundry = satuanController.getKodeLaundry();
            kode_laundry = kd_laundry + 1;
            System.out.println("Kode : " + kode_laundry);
            jtxtKodeLaundry.setText(String.valueOf(kode_laundry));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setIsiDataTableSatuan() {
        tableModelSatuan.getDataVector().removeAllElements();
        tableModelSatuan.fireTableDataChanged();
        ArrayList<Object[]> data;
        try {
            data = satuanController.getAllSatuanLaundry();
            for (int i = 0; i < data.size(); i++) {
                tableModelSatuan.addRow(data.get(i));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setHeaderTableSatuan() {
        Object[] headerTable = satuanController.getTableHeaderSatuanLaundry();
        for (Object headerTable1 : headerTable) {
            tableModelSatuan.addColumn(headerTable1);
        }
    }

    public void setHeaderTableTransaksiSatuan() {
        Object[] headerTable = satuanController.getTableHeaderTransaksiSatuan();
        for (Object headerTable1 : headerTable) {
            tableModel.addColumn(headerTable1);
        }
    }

    public void runApps() {
        try {
            this.setHeaderTableSatuan();
            this.setHeaderTableTransaksiSatuan();
            this.setIsiDataTableSatuan();
            this.showNamaPelanggan();
            this.setKodeLaundry();
            this.kondisiAwal();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reset() {
        jtxtJumlahBayar.setText("");
        jtxtJumlahSatuan.setText("");
        jtxtKembalian.setText("");
        jtxtKodeLaundry.setText("");
        jtxtKodePelanggan.setText("");
        jtxtTotalTagihan.setText("");
        jtxtTotalbayar.setText("");
        jComboBoxNama.setSelectedIndex(-1);
        jComboBoxPembayaran.setSelectedIndex(-1);
        jComboBoxPewangi.setSelectedIndex(-1);
        setKodeLaundry();
        jComboBoxNama.requestFocus();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelAlpha1 = new id.aas.apps.mvc.usuDesign.PanelAlpha();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxPewangi = new javax.swing.JComboBox();
        jDateTglSelesai = new com.toedter.calendar.JDateChooser();
        jDateTglTerima = new com.toedter.calendar.JDateChooser();
        jComboBoxNama = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxPembayaran = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtKodePelanggan = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtKodeLaundry = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtJumlahSatuan = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtTotalTagihan = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtTotalbayar = new id.aas.apps.mvc.usuDesign.TextBox();
        jtxtKembalian = new id.aas.apps.mvc.usuDesign.TextBox();
        jLabel8 = new javax.swing.JLabel();
        jtxtJumlahBayar = new id.aas.apps.mvc.usuDesign.TextBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSatuanLaundry = new javax.swing.JTable();
        jbtnTambahkan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFormSatuan = new javax.swing.JTable();
        jbtnSimpan = new id.aas.apps.mvc.usuDesign.Button();
        jbtnMenuUtama = new id.aas.apps.mvc.usuDesign.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/aktivitas.png"))); // NOI18N
        jLabel2.setText("Transaksi Satuan");
        panel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 220, 110);

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel6.setText("Aplikasi Pencatatan Laundry");
        panel1.add(jLabel6);
        jLabel6.setBounds(500, 30, 221, 22);

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel7.setText("Roemah Cemerlang Laundry");
        panel1.add(jLabel7);
        jLabel7.setBounds(430, 50, 293, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/laundry1111.png"))); // NOI18N
        panel1.add(jLabel1);
        jLabel1.setBounds(720, 10, 80, 90);

        panelAlpha1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Form Transaksi Satuan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        panelAlpha1.setForeground(new java.awt.Color(255, 255, 255));
        panelAlpha1.setLayout(null);

        jLabel4.setText("Nama");
        panelAlpha1.add(jLabel4);
        jLabel4.setBounds(20, 20, 100, 21);

        jLabel3.setText("Kode Pelanggan");
        panelAlpha1.add(jLabel3);
        jLabel3.setBounds(20, 60, 100, 14);

        jLabel9.setText("Kode Laundry");
        panelAlpha1.add(jLabel9);
        jLabel9.setBounds(20, 100, 110, 14);

        jLabel10.setText("Tanggal Terima");
        panelAlpha1.add(jLabel10);
        jLabel10.setBounds(20, 130, 100, 20);

        jLabel11.setText("Tanggal Selesai");
        panelAlpha1.add(jLabel11);
        jLabel11.setBounds(20, 160, 110, 14);

        jLabel12.setText("Jenis Pewangi");
        panelAlpha1.add(jLabel12);
        jLabel12.setBounds(20, 190, 110, 14);

        jComboBoxPewangi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-", "Lily", "Orange" }));
        jComboBoxPewangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPewangiActionPerformed(evt);
            }
        });
        panelAlpha1.add(jComboBoxPewangi);
        jComboBoxPewangi.setBounds(130, 190, 200, 20);
        panelAlpha1.add(jDateTglSelesai);
        jDateTglSelesai.setBounds(130, 160, 200, 20);
        panelAlpha1.add(jDateTglTerima);
        jDateTglTerima.setBounds(130, 130, 200, 20);

        jComboBoxNama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-", "Aas Suhendar" }));
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
        jComboBoxNama.setBounds(130, 20, 200, 20);

        jLabel13.setText("Jumlah Satuan");
        panelAlpha1.add(jLabel13);
        jLabel13.setBounds(390, 30, 100, 14);

        jLabel15.setText("Total Tagihan");
        panelAlpha1.add(jLabel15);
        jLabel15.setBounds(390, 70, 100, 14);

        jLabel17.setText("Keterangan  Pembayaran");
        panelAlpha1.add(jLabel17);
        jLabel17.setBounds(390, 100, 170, 14);

        jComboBoxPembayaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Pilih-", "Lunas", "Cash Bon" }));
        jComboBoxPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPembayaranActionPerformed(evt);
            }
        });
        panelAlpha1.add(jComboBoxPembayaran);
        jComboBoxPembayaran.setBounds(565, 100, 130, 20);

        jLabel16.setText("Total Bayar");
        panelAlpha1.add(jLabel16);
        jLabel16.setBounds(390, 140, 100, 14);

        jLabel5.setText("Kembalian");
        panelAlpha1.add(jLabel5);
        jLabel5.setBounds(390, 180, 100, 14);
        panelAlpha1.add(jtxtKodePelanggan);
        jtxtKodePelanggan.setBounds(130, 50, 200, 30);
        panelAlpha1.add(jtxtKodeLaundry);
        jtxtKodeLaundry.setBounds(130, 90, 200, 30);

        jtxtJumlahSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtJumlahSatuanKeyTyped(evt);
            }
        });
        panelAlpha1.add(jtxtJumlahSatuan);
        jtxtJumlahSatuan.setBounds(500, 20, 200, 30);
        panelAlpha1.add(jtxtTotalTagihan);
        jtxtTotalTagihan.setBounds(500, 60, 200, 30);

        jtxtTotalbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTotalbayarKeyTyped(evt);
            }
        });
        panelAlpha1.add(jtxtTotalbayar);
        jtxtTotalbayar.setBounds(500, 130, 200, 30);
        panelAlpha1.add(jtxtKembalian);
        jtxtKembalian.setBounds(500, 170, 200, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Jumlah Bayar");
        panelAlpha1.add(jLabel8);
        jLabel8.setBounds(390, 210, 130, 17);
        panelAlpha1.add(jtxtJumlahBayar);
        jtxtJumlahBayar.setBounds(530, 210, 170, 30);

        jTableSatuanLaundry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTableSatuanLaundry);

        panelAlpha1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 220, 310, 130);

        jbtnTambahkan.setText("Tambahkan");
        jbtnTambahkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTambahkanActionPerformed(evt);
            }
        });
        panelAlpha1.add(jbtnTambahkan);
        jbtnTambahkan.setBounds(20, 360, 120, 23);

        jTableFormSatuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Laundry", "Banyaknya", "Harga", "Total Harga"
            }
        ));
        jScrollPane2.setViewportView(jTableFormSatuan);

        panelAlpha1.add(jScrollPane2);
        jScrollPane2.setBounds(360, 250, 400, 150);

        jbtnSimpan.setForeground(new java.awt.Color(0, 0, 0));
        jbtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/aas/apps/mvc/images/save_all.png"))); // NOI18N
        jbtnSimpan.setText("Simpan");
        jbtnSimpan.setFocusPainted(false);
        jbtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSimpanActionPerformed(evt);
            }
        });
        panelAlpha1.add(jbtnSimpan);
        jbtnSimpan.setBounds(630, 410, 130, 40);

        panel1.add(panelAlpha1);
        panelAlpha1.setBounds(20, 150, 800, 470);

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
        jbtnMenuUtama.setBounds(690, 110, 130, 30);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPewangiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPewangiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPewangiActionPerformed

    private void jComboBoxNamaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNamaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int kode = 0;
            int kodePelanggan = 0;
            try {
                String nama = jComboBoxNama.getSelectedItem().toString();
                kodePelanggan = satuanController.getKodePelanggan(nama);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(kodePelanggan);
            jtxtKodePelanggan.setText(String.valueOf(kodePelanggan));
        }
    }//GEN-LAST:event_jComboBoxNamaItemStateChanged

    private void jComboBoxNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNamaActionPerformed

    private void jComboBoxPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPembayaranActionPerformed

    private void jbtnTambahkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTambahkanActionPerformed
        // TODO add your handling code here:
        try {
            int row = jTableSatuanLaundry.getSelectedRow();
            String kode = (String) tableModelSatuan.getValueAt(row, 0);
            namaPakaian = (String) tableModelSatuan.getValueAt(row, 1);
            String hargaLaundry = (String) tableModelSatuan.getValueAt(row, 2);

            jTableFormSatuan.setValueAt(kode, 0, 0);
            jTableFormSatuan.setValueAt(namaPakaian, 0, 1);
            jTableFormSatuan.setValueAt(hargaLaundry, 0, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtnTambahkanActionPerformed

    private void jbtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            boolean validasi = false;
            String kodeTransaksi = "";
            String kodePelanggan = jtxtKodePelanggan.getText();
            String kd_laundry = jtxtKodeLaundry.getText();
            String jenisLayanan = "";
            java.sql.Date tglTerima = new java.sql.Date(jDateTglTerima.getDate().getTime());
            java.sql.Date tglSelesai = new java.sql.Date(jDateTglSelesai.getDate().getTime());
            String pewangi = jComboBoxPewangi.getSelectedItem().toString();
            String jumlahKiloan = "0";
            String jenisPakaian = namaPakaian;
            double jumlahSatuan = Double.valueOf(jtxtJumlahSatuan.getText());
            harga = Double.parseDouble(jTableFormSatuan.getValueAt(0, 3).toString());
            String hargaSatuan = jTableFormSatuan.getValueAt(0, 3).toString();
            totalTagihan = jumlahSatuan * harga;
            String tagihan = String.valueOf(totalTagihan);
            String keteranganL = "";
            String keteranganT = jComboBoxPembayaran.getSelectedItem().toString();
            String btnStatus = jbtnSimpan.getText();

            System.out.println("tgl terima :" + tglTerima);
            System.out.println("tgl selesai :" + tglSelesai);

            if (kodePelanggan.isEmpty() || kd_laundry.isEmpty() || pewangi.equals("-Pilih-") || keteranganT.equals("-Pilih-")) {
                JOptionPane.showMessageDialog(null, "Terdapat Field Kosong, harap mengisi semua field", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                validasi = satuanController.simpanTransaksi(kd_laundry, jenisLayanan,
                        pewangi, jumlahKiloan, jumlahSatuan, jenisPakaian, hargaSatuan,
                        tagihan, keteranganL, kodePelanggan, kd_laundry, tglTerima,
                        tglSelesai, tagihan, keteranganT);
                if (validasi == true) {
                    JOptionPane.showMessageDialog(null, "Data Transaksi Laundry Satuan Berhasil Disimpan", "Simpan Transaksi", JOptionPane.INFORMATION_MESSAGE);
                    satuanController.cetakStruk();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Transaksi Laundry Satuan Gagal Disimpan", "Simpan Transaksi", JOptionPane.INFORMATION_MESSAGE);
                }
                reset();
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jbtnSimpanActionPerformed

    private void jtxtJumlahSatuanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtJumlahSatuanKeyTyped
        // TODO add your handling code here:
        try {
            jumSatuan = Integer.parseInt(jtxtJumlahSatuan.getText().toString());
            if (jumSatuan <= 0) {
                JOptionPane.showMessageDialog(null, "Maaf jumlah satuan tidak boleh minus atau nol");
                jtxtJumlahSatuan.setText("");
                jtxtTotalTagihan.setText("");
                jtxtJumlahBayar.setText("");
                jTableFormSatuan.setValueAt(null, 0, 2);
                jTableFormSatuan.setValueAt(null, 0, 4);
            } else {
                jTableFormSatuan.setValueAt(jumSatuan, 0, 2);
                int harga = Integer.parseInt(jTableFormSatuan.getValueAt(0, 3).toString());
                totalTagihan = jumSatuan * harga;
                jTableFormSatuan.setValueAt(totalTagihan, 0, 4);
                jtxtJumlahBayar.setText(String.valueOf(totalTagihan));
                jtxtTotalTagihan.setText(String.valueOf(totalTagihan));
            }

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jtxtJumlahSatuanKeyTyped

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
            java.util.logging.Logger.getLogger(UIDLaundrySatuanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIDLaundrySatuanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIDLaundrySatuanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIDLaundrySatuanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIDLaundrySatuanTransaksi().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFormSatuan;
    private javax.swing.JTable jTableSatuanLaundry;
    private id.aas.apps.mvc.usuDesign.Button jbtnMenuUtama;
    private id.aas.apps.mvc.usuDesign.Button jbtnSimpan;
    private javax.swing.JButton jbtnTambahkan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtJumlahBayar;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtJumlahSatuan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtKembalian;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtKodeLaundry;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtKodePelanggan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtTotalTagihan;
    private id.aas.apps.mvc.usuDesign.TextBox jtxtTotalbayar;
    private id.aas.apps.mvc.usuDesign.Panel panel1;
    private id.aas.apps.mvc.usuDesign.PanelAlpha panelAlpha1;
    // End of variables declaration//GEN-END:variables
}
