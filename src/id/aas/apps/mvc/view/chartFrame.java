/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.view;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Yora Radityo
 */
public class chartFrame extends javax.swing.JFrame {

    /**
     * Creates new form chartFrame
     */
    public chartFrame() {
        initComponents();
        bar();
        pie();
        this.setSize(555, 425);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void bar() {
        try {
            double Lunas = 0;
            double Casbon = 0;

            String queryLunas = "SELECT SUM(total_tagihan) from transaksi where keterangan='Lunas'";
            String queryCasbon = "SELECT SUM(total_tagihan) from transaksi where keterangan='Cash Bon'";
            ConnectionDB.InstanceDB.openConnection();
            ResultSet rs = ConnectionDB.InstanceDB.RunSelectQuery(queryLunas);
            while (rs.next()) {
                Lunas = rs.getDouble(1);
            }
            System.out.println(Lunas);

            ResultSet rs1 = ConnectionDB.InstanceDB.RunSelectQuery(queryCasbon);
            while (rs1.next()) {
                Casbon = rs1.getDouble(1);
            }
            System.out.println(Casbon);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.setValue(Lunas, "Lunas", "Catatan Uang Pendapatan");
            dataset.setValue(Casbon, "Cash Bon", "Catatan Uang Pendapatan");

            JFreeChart chart = ChartFactory.createBarChart3D(
                    "Catatan Uang Pendapatan dan Piutang Laundry",
                    "Keterangan Pembayaran",
                    "Jumlah Uang",
                    dataset);
            chart.setBorderVisible(false);
            chart.setBackgroundPaint(null);

//            BufferedImage image = chart.createBufferedImage(500, 300);
//            jLabel1.setIcon(new ImageIcon(image));
            ChartPanel cPanel = new ChartPanel(chart);
            setBounds(100, 100, 685, 429);
            jPanel2 = new JPanel();
            jPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(jPanel2);
            jPanel2.setLayout(null);
            jPanel2.add(cPanel);
            jTabbedPane1.add(jPanel2);
            setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void pie() {
        try {
            int nilaiKiloan = 0;
            int nilaiSatuan = 0;
            //create pie chart
            String queryKiloan = "SELECT COUNT(*) FROM laundry WHERE jenis_layanan='Laundry Kiloan'";
            String querySatuan = "SELECT COUNT(*) FROM laundry WHERE jenis_layanan='Laundry Satuan'";
            ConnectionDB.InstanceDB.openConnection();
            ResultSet rs = ConnectionDB.InstanceDB.RunSelectQuery(queryKiloan);
            while (rs.next()) {
                nilaiKiloan = rs.getInt(1);
            }
            System.out.println(nilaiKiloan);

            ResultSet rs1 = ConnectionDB.InstanceDB.RunSelectQuery(querySatuan);
            while (rs1.next()) {
                nilaiSatuan = rs1.getInt(1);
            }
            System.out.println(nilaiSatuan);
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            pieDataset.setValue("Laundry Kiloan", nilaiKiloan);
            pieDataset.setValue("Laundry Satuan", nilaiSatuan);

            JFreeChart chart = ChartFactory.createPieChart3D(
                    "Perbandingan Pengguna Layanan Laundry",
                    pieDataset,
                    true,
                    true,
                    false);

            chart.setBorderVisible(false);
            chart.setBackgroundPaint(null);

            ChartPanel cPanel = new ChartPanel(chart);
            setBounds(100, 100, 685, 429);
            jPanel1 = new JPanel();
            jPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(jPanel1);
            jPanel1.setLayout(null);
            jPanel1.add(cPanel);
            jTabbedPane1.add(jPanel1);
            setVisible(true);

//            BufferedImage image3 = chart.createBufferedImage(500, 300);
//            jLabel2.setIcon(new ImageIcon(image3));
//            jLabel2.setLocation(20, 20);
        } catch (Exception e) {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuUtama = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 551, 333);

        jTabbedPane1.addTab("Grafik Pengguna Layanan Laundry", jPanel1);

        jPanel2.setLayout(null);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 551, 397);

        jTabbedPane1.addTab("Grafik Pendapatan dan Piutang Laundry", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuUtama.setText("Exit");
        jMenuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUtamaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuUtama);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUtamaActionPerformed
        // TODO add your handling code here:
//        new UIDmenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuUtamaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuUtama;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
