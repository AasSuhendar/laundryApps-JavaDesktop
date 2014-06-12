/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.aas.apps.mvc.connectionDB;

/**
 *
 * @author Aas Suhendar
 */
public class testConnection {
    public static void main(String[] args) {
       ConnectionDB.InstanceDB.openConnection();
       ConnectionDB.InstanceDB.closeConnection();
    }
}
