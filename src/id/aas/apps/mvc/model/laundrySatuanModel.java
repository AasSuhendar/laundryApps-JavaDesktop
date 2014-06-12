/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.pojoEntity.laundrySatuanMaster;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aas Suhendar
 */
public class laundrySatuanModel {

    private ResultSet rs;

    public laundrySatuanModel() {
        
    }

    public ResultSet getAllDataLaundrySatuan() throws SQLException {
        try {
            String query = "SELECT * FROM LAUNDRY_SATUAN";
            ConnectionDB.InstanceDB.openConnection();
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean insertLaundrySatuan(laundrySatuanMaster l) throws SQLException {
        boolean status = false;
        try {
            String query = "INSERT INTO laundry_satuan (nama_pakaian,harga) VALUES ('" + l.getNamaPakaian() + "'," + l.getHarga() + ")";
            ConnectionDB.InstanceDB.openConnection();
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean updateLaundrySatuan(laundrySatuanMaster l) throws SQLException {
        boolean status = false;
        try {
            String query = "UPDATE laundry_satuan SET nama_pakaian='" + l.getNamaPakaian() + "', harga=" + l.getHarga() + " WHERE kode_pakaian=" + l.getKd_pakaian() + "";
            ConnectionDB.InstanceDB.openConnection();
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean deleteLaundrySatuan(int kode_pakaian) throws SQLException {
        boolean status = false;
        try {
            String query = "DELETE FROM laundry_satuan WHERE kode_pakaian=" + kode_pakaian + "";
            ConnectionDB.InstanceDB.openConnection();
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
