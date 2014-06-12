/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.view;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aas Suhendar
 */
public class frameChart extends JFrame {

    private JTabbedPane tabPane;
    private JLabel label1, label2, label3;
    private JPanel panel1, panel2, panel3;

    public frameChart() throws SQLException {
        super("Chart");

        tabPane = new JTabbedPane();
        panel1 = new JPanel();
        tabPane.addTab("Grafik Pendepatan dan Piutang", null, panel1, "Panel Pertama");

        panel2 = new JPanel();
        tabPane.addTab("Grafik Pengguna Layanan UMLLaundry", null, panel2, "Panel Kedua");

        getContentPane().add(tabPane);
        setChartBar();
        setChartPie();
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setVisible(true);
    }

    public void setChartBar() throws SQLException {
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
                "Catatan Uang Pendapatan dan Piutang",
                "Keterangan Pembayaran",
                "Jumlah Uang",
                dataset);
        ChartPanel cPanel = new ChartPanel(chart);
        panel1.add(cPanel);
    }

    public void setChartPie() throws SQLException {
        int nilaiKiloan = 0;
        int nilaiSatuan = 0;

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
        ChartPanel cPane2 = new ChartPanel(chart);
        panel2.add(cPane2);
    }
}
