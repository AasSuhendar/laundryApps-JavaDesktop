/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.view;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aas Suhendar
 */
public class barChart extends JFrame {

    private JPanel contentPane;

    public barChart() throws SQLException {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 429);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        this.setChart();
        this.setVisible(true);
        
    }
    
    public void setChart()throws SQLException{
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
        this.setContentPane(cPanel);
    }
}
