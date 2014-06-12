/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.controller.adminController;
import id.aas.apps.mvc.pojoEntity.Laundry;
import id.aas.apps.mvc.pojoEntity.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aas Suhendar
 */
public class transaksiKiloanModel {

    private ResultSet rs;
    
    public transaksiKiloanModel() {
        ConnectionDB.InstanceDB.openConnection();
    }
    
    
    public ResultSet getAllDataTransaksiKiloan() throws SQLException {
        try {
            String query = "SELECT transaksi.kd_transaksi, transaksi.kd_laundry, pelanggan.nama, laundry.jenis_layanan, laundry.jenis_pawangi, transaksi.tgl_terima, transaksi.tgl_selesai, "
                    + "laundry.berat, laundry.jenis_pakaian, laundry.jumlah_pakaian, laundry.total, laundry.keterangan, transaksi.keterangan "
                    + "FROM transaksi, laundry, pelanggan "
                    + "WHERE transaksi.id_pelanggan=pelanggan.id_pelanggan AND transaksi.kd_laundry=laundry.kd_laundry AND laundry.jenis_layanan='Laundry Kiloan'";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("model" + e.getMessage());
        }
        return rs;
    }

    public boolean insertTransaksiKiloan(Laundry l, Transaksi t) throws SQLException {
        boolean status = false;
        try {
            String queryLaundry = "INSERT INTO laundry (kd_laundry,jenis_layanan, jenis_pawangi, berat, jumlah_pakaian, jenis_pakaian, harga_satuan, total, keterangan) "
                    + "VALUES (" + l.getKd_laundry() + ",'Laundry Kiloan','" + l.getJenisPewangi() + "'," + l.getJumBerat() + "," + l.getJumPakaian() + ",'-'," + l.getHargaSatuan() + "," + l.getTotalTagihan() + ",'Belum Diambil')";
            String queryTransaksi = "INSERT INTO transaksi (kd_laundry, id_pelanggan, tgl_terima, tgl_selesai, total_tagihan, keterangan)"
                    + "VALUES (" + t.getKd_laundry() + "," + t.getKd_pelanggan() + ",STR_TO_DATE('" + t.getTgl_terima() + "','%Y-%m-%d'),STR_TO_DATE('" + t.getTgl_selesai() + "','%Y-%m-%d')," + t.getTotalTagihan() + ",'" + t.getKeterangan() + "')";
            status = ConnectionDB.InstanceDB.RunQuery(queryLaundry);
            System.out.println(queryLaundry);
            System.out.println("Status L:" + status);
            status = ConnectionDB.InstanceDB.RunQuery(queryTransaksi);
            System.out.println(queryTransaksi);
            System.out.println("Status T: " + status);

        } catch (Exception e) {
            System.out.println("model" + e.getMessage());
        }
        return status;
    }

    public ResultSet ambilNamaPelanggan() throws SQLException {
        try {
            String query = "SELECT NAMA FROM PELANGGAN";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("model" + e.getMessage());
        }
        return rs;
    }

    public ResultSet ambilKodePelanggan(String nama) throws SQLException {
        try {
            String query = "SELECT ID_PELANGGAN FROM PELANGGAN WHERE NAMA='" + nama + "'";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("model" + e.getMessage());
        }
        return rs;
    }

    public ResultSet ambilKodeLaundry() throws SQLException {
        try {
            String query = "SELECT KD_LAUNDRY FROM LAUNDRY ORDER BY KD_LAUNDRY ASC";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("model" + e.getMessage());
        }
        return rs;
    }

    public ResultSet ambilHargaSatuan() throws SQLException {
        try {
            String query = "SELECT HARGA FROM LAUNDRY_KILOAN WHERE STATUS='Aktif'";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("model" + e.getMessage());
        }
        return rs;
    }
}
