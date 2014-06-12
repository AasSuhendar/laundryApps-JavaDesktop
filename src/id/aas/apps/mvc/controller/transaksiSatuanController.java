/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.model.transaksiSatuanModel;
import id.aas.apps.mvc.pojoEntity.Laundry;
import id.aas.apps.mvc.pojoEntity.Transaksi;
import java.io.File;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Aas Suhendar
 */
public class transaksiSatuanController {

    private transaksiSatuanModel transSM;
    private ResultSet rs;

    public transaksiSatuanController() {
        transSM = new transaksiSatuanModel();
    }

    public transaksiSatuanModel getTransSM() {
        return transSM;
    }

    public void setTransSM(transaksiSatuanModel transSM) {
        this.transSM = transSM;
    }

    public Object[] getTableHeaderTransaksiSatuan() {
        Object[] headerTable = {"Kode", "Nama", "Banyak", "Harga Satuan", "Total"};
        return headerTable;
    }

    public Object[] getTableHeaderSatuanLaundry() {
        Object[] headerTable = {"Kode Pakaian", "Jenis Laundry", "Harga"};
        return headerTable;
    }

    public ArrayList<Object[]> getAllSatuanLaundry() throws SQLException {
        ArrayList<Object[]> LSatuan = new ArrayList<>();
        try {
            rs = transSM.ambilDataLaundrySatuan();
            while (rs.next()) {
                Object[] obj = new Object[4];
                obj[0] = rs.getString("KODE_PAKAIAN");
                obj[1] = rs.getString("NAMA_PAKAIAN");
                obj[2] = rs.getString("HARGA");
                LSatuan.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return LSatuan;
    }

    public ArrayList<Object[]> getNamaPelanggan() throws SQLException {
        ArrayList<Object[]> pelanggan = new ArrayList<>();
        try {
            rs = transSM.ambilNamaPelanggan();
            while (rs.next()) {
                Object[] obj = new Object[2];
                obj[0] = rs.getString(1);
                pelanggan.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("coontroller" + e.getMessage());
        }
        return pelanggan;
    }

    public int getKodePelanggan(String nama) throws SQLException {
        int kodePelanggan=0;
        try {
            rs = transSM.ambilKodePelanggan(nama);
            while (rs.next()) {
                kodePelanggan=rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("coontroller" + e.getMessage());
        }
        return kodePelanggan;
    }
    
    public int getKodeLaundry() throws SQLException {
        int kodeLaundry=0;
        try {
            rs = transSM.ambilKodeLaundry();
            while (rs.next()) {
                kodeLaundry=rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("coontroller" + e.getMessage());
        }
        return kodeLaundry;
    }

    public boolean simpanTransaksi(String kd_laundryL, String jenisLayanaan,
            String jenisPewangi, String jumBerat, double jumPakaian, String jenisPakaian,
            String hargaSatuan, String totalTagihanL, String keteranganL,
            String kd_pelanggan, String kd_laundryT, Date tgl_terima, Date tgl_selesai,
            String totalTagihanT, String keteranganT) throws SQLException {
        boolean valid = false;
        try {
            int kode_laundry = Integer.parseInt(kd_laundryT);
            double berat = Double.parseDouble(jumBerat);
            double harga = Double.parseDouble(hargaSatuan);
            double total_tagihan = Double.parseDouble(totalTagihanL);
            int kode_palanggan = Integer.parseInt(kd_pelanggan);
            int kode_Laundry = Integer.parseInt(kd_laundryT);
            double total_Tagihan = Double.parseDouble(totalTagihanT);

            Laundry l = new Laundry(kode_laundry, jenisLayanaan, jenisPewangi, berat, jumPakaian, jenisPakaian, harga, total_tagihan, keteranganL);
            Transaksi t = new Transaksi(kode_palanggan, kode_Laundry, tgl_terima, tgl_selesai, total_Tagihan, keteranganT);
            valid = transSM.insertTransaksiSatuan(l, t);

        } catch (NumberFormatException e) {
            System.out.println("coontroller" + e.getMessage());
        }
        return valid;
    }
    
    public void cetakStruk() {
        JasperReport jasperReport;
        JasperDesign jasperDesign;
        JasperPrint jasperPrint;
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
            File file = new File("C:\\Users\\Aas Suhendar\\Documents\\NetBeansProjects\\AppsLaundryTubesDP\\src\\id\\aas\\apps\\mvc\\view\\StrukSatuan.jrxml");
//           
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, ConnectionDB.InstanceDB.OnConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    

}
