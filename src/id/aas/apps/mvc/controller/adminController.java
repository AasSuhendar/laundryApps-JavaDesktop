/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.controller;

import id.aas.apps.mvc.model.adminModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aas Suhendar
 */
public class adminController {

    private adminModel aM;
    private ResultSet rs;
    private boolean status;
//    private String status;

    public adminController() {
        aM = new adminModel();
    }

    public adminModel getaM() {
        return aM;
    }

    public void setaM(adminModel aM) {
        this.aM = aM;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void cekLogin(String user, String pass) throws SQLException {

        try {
            rs = aM.cekLogin(user, pass);
            while (rs.next()) {
                if (user.equals(rs.getString(2)) && pass.equals(rs.getString(3))) {
                    this.status = true;
                    String username = rs.getString(2);
                    String password = rs.getString(3);
                    System.out.println(username);
                    System.out.println(password);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
