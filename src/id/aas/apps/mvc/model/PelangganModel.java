/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import id.aas.apps.mvc.pojoEntity.Pelanggan;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Aas Suhendar
 */
public class PelangganModel {
    private ResultSet rs;

    public PelangganModel() {
        ConnectionDB.InstanceDB.openConnection();
    }

    public ResultSet getAllDataPelanggan() throws SQLException {
        try {
            String query = "SELECT * FROM PELANGGAN";
            rs = ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public ResultSet cariDataPelanggan(String nama)throws SQLException{
        try {
            String query="SELECT * FROM PELANGGAN WHERE NAMA LIKE '%"+nama+"%'";
            rs=ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    public boolean insertDataPelanggan(Pelanggan p) throws SQLException {
        boolean status = false;
        try {
            String query = "INSERT INTO Pelanggan (nama,tlp,alamat) "
                    + "VALUES ('" + p.getNama() + "','" + p.getTlp() + "','" + p.getAlamat() + "')";
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean updateDataPelanggan(Pelanggan p) throws SQLException {
        boolean status = false;
        try {
            String query = "UPDATE Pelanggan SET nama='" + p.getNama() + "' , tlp='" + p.getTlp() + "', alamat='" + p.getAlamat() + "' WHERE id_pelanggan=" + p.getKd_pelanggan();
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean deleteDataPelanggan(int id_pelanggan) throws SQLException {
        boolean status = false;
        try {
            String query = "DELETE FROM Pelanggan WHERE id_pelanggan=" + id_pelanggan;
            status = ConnectionDB.InstanceDB.RunQuery(query);
            System.out.println(query);
            System.out.println("Status : " + status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
