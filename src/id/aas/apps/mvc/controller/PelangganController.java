/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.model.PelangganModel;
import id.aas.apps.mvc.pojoEntity.Pelanggan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aas Suhendar
 */
public class PelangganController {

    private PelangganModel pM;
    private ResultSet rs;

    public PelangganController() {
        pM = new PelangganModel();
    }

    public PelangganModel getpM() {
        return pM;
    }

    public void setpM(PelangganModel pM) {
        this.pM = pM;
    }
    
    public Object[] getHeaderTablePelanggan() {
        Object[] headerTable = {"ID Pelanggan", "Nama Pelanggan", "No Telepon", "Alamat"};
        return headerTable;
    }

    public ArrayList<Object[]> getAllDataPelanggan() throws SQLException {
        ArrayList<Object[]> pelanggan = new ArrayList<>();
        try {
            rs = pM.getAllDataPelanggan();
            while (rs.next()) {
                Object[] obj = new Object[5];
                obj[0] = rs.getString("ID_PELANGGAN");
                obj[1] = rs.getString("NAMA");
                obj[2] = rs.getString("TLP");
                obj[3] = rs.getString("ALAMAT");
                pelanggan.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pelanggan;
    }
    
    public ArrayList<Object[]> cariDataPelangggan(String nama)throws SQLException{
        ArrayList<Object[]> pelanggan=new ArrayList<>();
        try {
            rs=pM.cariDataPelanggan(nama);
            while (rs.next()) {
                Object[] obj=new Object[5];
                obj[0] = rs.getString("ID_PELANGGAN");
                obj[1] = rs.getString("NAMA");
                obj[2] = rs.getString("TLP");
                obj[3] = rs.getString("ALAMAT");
                pelanggan.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pelanggan;
    }
    
    public boolean olahDataPelanggan(String status, String id_pelanggan, String nama, String no_tlp, String alamat) throws SQLException{
        boolean valid = false;
        try {   
            if (status.equalsIgnoreCase("Simpan")) {
                Pelanggan p=new Pelanggan(nama, alamat, no_tlp);
                valid=pM.insertDataPelanggan(p);
            } else if (status.equalsIgnoreCase("Edit")) {
                Pelanggan p=new Pelanggan(Integer.parseInt(id_pelanggan), nama, alamat, no_tlp);
                valid=pM.updateDataPelanggan(p);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }

    public boolean hapusDataPelanggan(String id_pelanggan) throws SQLException{
        boolean valid = false;
        try {
            int id = Integer.parseInt(id_pelanggan);
            valid= pM.deleteDataPelanggan(id);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }

}
