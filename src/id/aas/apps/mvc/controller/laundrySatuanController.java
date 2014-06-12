/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.model.laundrySatuanModel;
import id.aas.apps.mvc.pojoEntity.laundrySatuanMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aas Suhendar
 */
public class laundrySatuanController {
    private laundrySatuanModel LSModel;
    private ResultSet rs;

    public laundrySatuanController() {
    LSModel=new laundrySatuanModel();
    }

    public laundrySatuanModel getLSModel() {
        return LSModel;
    }

    public void setLSModel(laundrySatuanModel LSModel) {
        this.LSModel = LSModel;
    }
    
    public Object[] getHeaderTable(){
        Object[] headerTable={"Kode Pakaian","Nama Pakaian","Harga"};
        return headerTable;
    }
    
    public ArrayList<Object[]> getAllDataLSatuan()throws SQLException{
        ArrayList<Object[]> LSatuan=new ArrayList<>();
        try {
            rs=LSModel.getAllDataLaundrySatuan();
            while (rs.next()) {
                Object[]obj=new Object[4];
                obj[0]=rs.getString("KODE_PAKAIAN");
                obj[1]=rs.getString("NAMA_PAKAIAN");
                obj[2]=rs.getString("HARGA");
                LSatuan.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return LSatuan;
    }
    
    public boolean olahDataLSatuan(String btnStatus, String kode_pakaian, String nama_pakaian, String harga)throws SQLException{
        boolean valid=false;
        try {
            if (btnStatus.equalsIgnoreCase("Simpan")) {
                double hargaInput=Double.valueOf(harga);
                laundrySatuanMaster l=new laundrySatuanMaster(nama_pakaian, hargaInput);
                valid=LSModel.insertLaundrySatuan(l);
            }else if (btnStatus.equalsIgnoreCase("Edit")) {
                double hargaInput=Double.valueOf(harga);
                int kd_pakaian=Integer.parseInt(kode_pakaian);
                laundrySatuanMaster l=new laundrySatuanMaster(kd_pakaian, nama_pakaian, hargaInput);
                valid=LSModel.updateLaundrySatuan(l);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }
    
    public boolean hapusDataLSatuan(String kode_pakaian)throws SQLException{
        boolean valid=false;
        try {
            int kode=Integer.parseInt(kode_pakaian);
            valid=LSModel.deleteLaundrySatuan(kode);
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }
}
