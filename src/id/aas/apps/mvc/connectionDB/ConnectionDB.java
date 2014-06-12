/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aas Suhendar
 */
public enum ConnectionDB {

    InstanceDB;
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;
    private boolean isConnected;
    private String message;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/tubes_dp";
    private final String user = "root";
    private final String password = "";

    private ConnectionDB() {

    }

    public void openConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
            isConnected = true;
            message = "Database Connected";
            System.out.println(message);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection OnConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
            isConnected = true;
            message = "Database Connected";
            System.out.println(message);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    public void closeConnection() {
        try {
            if (connection != null) {
                resultset.close();
                statement.close();
                connection.close();
                message = "Database Disconnected";
                System.out.println(message);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet RunSelectQuery(String query){
        try {
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultset;
    }
    
    public boolean RunQuery(String query){
        isConnected = false;
        try{
            statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            if(result> 0){
                isConnected=true;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return isConnected;
    }

    public boolean isIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    
    
}
