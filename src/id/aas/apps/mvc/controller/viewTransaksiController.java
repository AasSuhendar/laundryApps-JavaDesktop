/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.model.viewTransaksiModel;
import id.aas.apps.mvc.pojoEntity.Laundry;
import id.aas.apps.mvc.pojoEntity.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aas Suhendar
 */
public class viewTransaksiController {

    private viewTransaksiModel viewTM;
    private ResultSet rs;

    public viewTransaksiController() {
        viewTM = new viewTransaksiModel();
    }

    public viewTransaksiModel getViewTM() {
        return viewTM;
    }

    public void setViewTM(viewTransaksiModel viewTM) {
        this.viewTM = viewTM;
    }

    public ArrayList<Object[]> getAllDataTransaksi() throws SQLException {
        ArrayList<Object[]> transaksi = new ArrayList<>();
        try {
            rs = viewTM.getAllDataTransaksi();
            while (rs.next()) {
                Object[] obj = new Object[15];
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getString(5);
                obj[5] = rs.getString(6);
                obj[6] = rs.getString(7);
                obj[7] = rs.getString(8);
                obj[8] = rs.getString(9);
                obj[9] = rs.getString(10);
                obj[10] = rs.getString(11);
                obj[11] = rs.getString(12);
                obj[12] = rs.getString(13);
                transaksi.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return transaksi;

    }

    public Object[] getHeaderTableTransaksi() {
        Object[] headerTable = {"Kode Transaksi", "Kode Laundry", "Nama", "Jenis Layanan", "Jenis Pewangi", "Tgl Terima", "Tgl Selesai", "Berat", "Jenis Pakaian", "Jumlah Pakaian", "Tagihan", "Ket Laundry", "Ket Pembayaran"};
        return headerTable;
    }

//    public ResultSet searchDataTransaksi(String sortir, String cari) throws SQLException{
//        try {
//            rs=viewTM.cariData(sortir, cari);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return rs;
//    }
    public ArrayList<Object[]> searchDataTransaksi(String sortir, String cari) throws SQLException {
        ArrayList<Object[]> transaksi = new ArrayList<>();
        try {
            rs = viewTM.cariData(sortir, cari);
            while (rs.next()) {
                Object[] obj = new Object[15];
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getString(5);
                obj[5] = rs.getString(6);
                obj[6] = rs.getString(7);
                obj[7] = rs.getString(8);
                obj[8] = rs.getString(9);
                obj[9] = rs.getString(10);
                obj[10] = rs.getString(11);
                obj[11] = rs.getString(12);
                obj[12] = rs.getString(13);
                transaksi.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transaksi;
    }

    public boolean updatePengambilan(String kodeLaundry, String keteranganL, String kodeTransaksi, String keteranganT) throws SQLException {
        boolean valid = false;
        try {
            int kd_laundry = Integer.parseInt(kodeLaundry);
            int kd_transaksi = Integer.parseInt(kodeTransaksi);

            Laundry l = new Laundry(kd_laundry, keteranganL);
            Transaksi t = new Transaksi(kd_transaksi, keteranganT);
            valid = viewTM.updateDataPengambilan(l, t);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }
}
