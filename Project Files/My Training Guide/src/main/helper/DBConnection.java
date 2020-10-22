/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.helper;

import java.sql.*;

/**
 *
 * @author Baler-Gamer
 */
public class DBConnection {
    public static Connection con;
    public static String dbFile = FileURL.dbURL;
    public static String dbUrl = "jdbc:ucanaccess://"+dbFile.trim()+";memory=true";
    public static Connection getConnection()
    {
        try {
            con = DriverManager.getConnection(dbUrl,"","");
        } catch (Exception e) {
            System.out.println(""+ e);
        }
        return con;
    }
}
