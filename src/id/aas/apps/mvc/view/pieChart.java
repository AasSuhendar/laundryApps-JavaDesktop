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
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Aas Suhendar
 */
public class pieChart extends JFrame {

    private JPanel contentPane;

    public pieChart() throws SQLException {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 429);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
//        run();

    }

    
        

    public static void main(String[] args) throws SQLException {
//        pieChart p = new pieChart();
//        p.setVisible(true);
//        p.run();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    int nilaiKiloan = 0;
                    int nilaiSatuan = 0;

                    pieChart frame = new pieChart();
                    frame.setVisible(true);
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
                    
                    JFreeChart chart=ChartFactory.createPieChart3D(
                            "Perbandingan Pengguna Layanan Laundry", 
                            pieDataset, 
                            true, 
                            true, 
                            false);
                    ChartPanel cPanel = new ChartPanel(chart);
                    frame.setContentPane(cPanel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
