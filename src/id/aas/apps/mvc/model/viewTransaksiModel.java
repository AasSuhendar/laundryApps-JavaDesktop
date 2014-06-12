/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.pojoEntity.Laundry;
import id.aas.apps.mvc.pojoEntity.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aas Suhendar
 */
public class viewTransaksiModel {

    private ResultSet rs;

    public viewTransaksiModel() {
        ConnectionDB.InstanceDB.openConnection();
    }

    public ResultSet getAllDataTransaksi() throws SQLException {
        try {
            String query = "SELECT transaksi.kd_transaksi, transaksi.kd_laundry, pelanggan.nama, laundry.jenis_layanan, laundry.jenis_pawangi, transaksi.tgl_terima, transaksi.tgl_selesai, "
                    + "laundry.berat, laundry.jenis_pakaian, laundry.jumlah_pakaian, laundry.total, laundry.keterangan, transaksi.keterangan "
                    + "FROM transaksi, laundry, pelanggan "
                    + "WHERE transaksi.id_pelanggan=pelanggan.id_pelanggan AND transaksi.kd_laundry=laundry.kd_laundry "
                    + "ORDER BY transaksi.kd_transaksi ASC";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet cariData(String sortir, String cari) throws SQLException {
        try {
            String query = "SELECT transaksi.kd_transaksi, transaksi.kd_laundry, pelanggan.nama, laundry.jenis_layanan, laundry.jenis_pawangi, transaksi.tgl_terima, transaksi.tgl_selesai, "
                    + "laundry.berat, laundry.jenis_pakaian, laundry.jumlah_pakaian, laundry.total, laundry.keterangan, transaksi.keterangan "
                    + "FROM transaksi, laundry, pelanggan "
                    + "WHERE transaksi.id_pelanggan=pelanggan.id_pelanggan AND transaksi.kd_laundry=laundry.kd_laundry AND " + sortir + " LIKE '%" + cari + "%'";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
        }
        return rs;
    }

    public boolean updateDataPengambilan(Laundry l, Transaksi t) throws SQLException {
        boolean status = false;
        try {
            String queryLaundry = "UPDATE laundry SET keterangan='" + l.getKeterangan() + "' WHERE kd_laundry=" + l.getKd_laundry();
            String queryTransaksi = "UPDATE transaksi SET keterangan='" + t.getKeterangan() + "' WHERE kd_transaksi=" + t.getKd_transaksi();
            status=ConnectionDB.InstanceDB.RunQuery(queryLaundry);
            System.out.println(queryLaundry);
            System.out.println("Status L:" + status);
            status = ConnectionDB.InstanceDB.RunQuery(queryTransaksi);
            System.out.println(queryTransaksi);
            System.out.println("Status T: " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
