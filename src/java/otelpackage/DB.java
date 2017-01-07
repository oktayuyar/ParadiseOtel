/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oktay
 */
public class DB {
    private static String connectionString;
    private static String password;
    private static String username;
    private static Connection sCon;
    public DB(){
        sCon=null;
        connectionString="";
    }

    public static Connection open() {       
        try {
            if (sCon == null) {                
                    connectionString = "jdbc:mysql://localhost:3306/odev?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
                    username = "root";
                    password = "";             
                Class.forName("com.mysql.jdbc.Driver");
                sCon = DriverManager.getConnection(connectionString, username, password);
            }           
        } catch (Exception ex) {
            try {
                sCon.close();            
            } catch (SQLException ex1) {            
            }
        }
        return sCon;
    }

    public static void close() {
        if (sCon != null) {
            try {
                if (!sCon.isClosed()) {
                    sCon.close();
                }
            } catch (SQLException ex) {
            }
        }

    }

    /**
     * @return the connectionString
     */
    public String getConnectionString() {
        return connectionString;
    }

    /**
     * @param connectionString the connectionString to set
     */
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    /**
     * @return the sCon
     */
    public Connection getsCon() {
        return sCon;
    }

    /**
     * @param sCon the sCon to set
     */
    public void setsCon(Connection sCon) {
        this.sCon = sCon;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}

  

