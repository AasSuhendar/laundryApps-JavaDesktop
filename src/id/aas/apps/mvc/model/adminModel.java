/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.aas.apps.mvc.model;

import id.aas.apps.mvc.connectionDB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aas Suhendar
 */
public class adminModel {
    private ResultSet rs;

    public adminModel() {
        ConnectionDB.InstanceDB.openConnection();
    }
    
    public ResultSet cekLogin(String user, String pass)throws SQLException{
        try {
            String query="SELECT * FROM ADMIN WHERE USERNAME='"+user+"' AND PASSWORD='"+pass+"'";
            rs=ConnectionDB.InstanceDB.RunSelectQuery(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
