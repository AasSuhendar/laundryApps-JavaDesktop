/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.pojoEntity.Laundry;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aas Suhendar
 */
public class laundryModel {

    private ResultSet rs;

    public laundryModel() {
        ConnectionDB.InstanceDB.openConnection();
    }

    public ResultSet getAllDataLaundry() throws SQLException {
        try {
            String query = "SELECT * FROM LAUNDRY";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean insertDataLaundry(Laundry l) throws SQLException {
        boolean status = false;
        try {
            String query = "INSERT INTO laundry (jenis_layanan, jenis_pewangi, berat,jumlah_pakaian, jenis_pakaian, harga_satuan, total, keterangan) "
                    + "VALUES ('" + l.getJenisLayanaan() + "','" + l.getJenisPewangi() + "'," + l.getJumBerat() + "," + l.getJumPakaian() + ",'" + l.getJenisPakaian() + "'," + l.getHargaSatuan() + " ," + l.getTotalTagihan() + ",'" + l.getKeterangan() + "')";
            status=ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
    
    
}
