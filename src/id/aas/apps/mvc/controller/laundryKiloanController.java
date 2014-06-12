/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.model.laundryKiloanModel;
import id.aas.apps.mvc.pojoEntity.laundryKiloanMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aas Suhendar
 */
public class laundryKiloanController {
    private laundryKiloanModel LKModel;
    private ResultSet rs;

    public laundryKiloanController() {
    LKModel=new laundryKiloanModel();
    }

    public laundryKiloanModel getLKModel() {
        return LKModel;
    }

    public void setLKModel(laundryKiloanModel LKModel) {
        this.LKModel = LKModel;
    }
    
    public Object[] getHeaderTable(){
        Object[] headerTable={"Kode Kiloan","Harga Per Kilo","Status"};
        return headerTable;
    }
    
    public ArrayList<Object[]> getAllDataLKiloan()throws SQLException{
        ArrayList<Object[]> LKiloan=new ArrayList<>();
        try {
            rs=LKModel.getAllDataLaundryKiloan();
            while (rs.next()) {
                Object[]obj=new Object[4];
                obj[0]=rs.getString("KODE_KILOAN");
                obj[1]=rs.getDouble("HARGA");
                obj[2]=rs.getString("STATUS");
                LKiloan.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return LKiloan;
    }
    
    public boolean olahDataLKiloan(String btnstatus, String kode_kiloan, String harga, String status)throws SQLException{
        boolean valid=false;
        try {
            if (btnstatus.equalsIgnoreCase("Simpan")) {
                laundryKiloanMaster l=new laundryKiloanMaster(kode_kiloan, Integer.parseInt(harga), status);
                valid=LKModel.insertLaundryKiloan(l);
            }else if(btnstatus.equalsIgnoreCase("Edit")){
                laundryKiloanMaster l=new laundryKiloanMaster(kode_kiloan, Integer.parseInt(harga), status);
                valid=LKModel.updateLaundryKiloan(l);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }
    
    public boolean hapusDataLKiloan(String kode_kiloan)throws SQLException{
        boolean valid=false;
        try {
            valid=LKModel.deleteLaundryKiloan(kode_kiloan);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return valid;
    }
    
}
