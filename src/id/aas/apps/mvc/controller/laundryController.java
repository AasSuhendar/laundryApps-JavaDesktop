/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.model.laundryModel;
import id.aas.apps.mvc.pojoEntity.Laundry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aas Suhendar
 */
public class laundryController {

    private laundryModel lM;
    private ResultSet rs;

    public laundryController() {
        lM = new laundryModel();
    }

    public laundryModel getlM() {
        return lM;
    }

    public void setlM(laundryModel lM) {
        this.lM = lM;
    }

    public ArrayList<Object[]> getAllDataLaundry() throws SQLException {
        ArrayList<Object[]> pelanggan = new ArrayList<>();
        try {
            rs = lM.getAllDataLaundry();
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

    public boolean simpanDataLaundry(String status, String kd_laundry, String jenisLayanaan, String jenisPewangi, String jumBerat, String jumPakaian, String jenisPakaian, String hargaSatuan, String totalTagihan, String keterangan) throws SQLException {
        boolean valid = false;
        try {
            if (status.equalsIgnoreCase("Simpan")) {
                int kodeLaundry=Integer.parseInt(kd_laundry);
                double berat=Double.valueOf(jumBerat);
                double jumlahPakaian=Double.valueOf(jumPakaian);
                double harga=Double.valueOf(hargaSatuan);
                double tagihan=Double.valueOf(totalTagihan);
                Laundry l=new Laundry(kodeLaundry, jenisLayanaan, jenisPewangi, berat, jumlahPakaian, jenisPakaian, harga, tagihan, keterangan);
                valid=lM.insertDataLaundry(l);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }
}
