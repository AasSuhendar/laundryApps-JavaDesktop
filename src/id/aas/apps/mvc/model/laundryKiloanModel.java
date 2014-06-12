/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.pojoEntity.laundryKiloanMaster;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aas Suhendar
 */
public class laundryKiloanModel {

    private ResultSet rs;

    public laundryKiloanModel() {
        ConnectionDB.InstanceDB.openConnection();
    }

    public ResultSet getAllDataLaundryKiloan() throws SQLException {
        try {
            String query = "SELECT * FROM LAUNDRY_KILOAN";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean insertLaundryKiloan(laundryKiloanMaster l) throws SQLException {
        boolean status = false;
        try {
            String query = "INSERT INTO laundry_kiloan VALUES ('" + l.getKd_kiloan() + "','" + l.getHargaPerKilo() + "','" + l.getStatus() + "')";
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean updateLaundryKiloan(laundryKiloanMaster l) throws SQLException {
        boolean status = false;
        try {
            String query = "UPDATE laundry_kiloan SET harga=" + l.getHargaPerKilo() + ", status='" + l.getStatus() + "' WHERE kode_kiloan='" + l.getKd_kiloan() + "'";
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean deleteLaundryKiloan(String kode_kiloan) throws SQLException {
        boolean status = false;
        try {
            String query = "DELETE FROM laundry_kiloan WHERE kode_kiloan='" + kode_kiloan + "'";
            status=ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : "+status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
