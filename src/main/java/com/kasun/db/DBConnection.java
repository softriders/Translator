package com.kasun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {

    private static final Logger log = LoggerFactory.getLogger(DBConnection.class);

    public static Connection con = null;
    
//   public static void main(String[] args){
//    	try {
//			System.out.println(DBConnection.getSinhaleMean("go","vbp","I_mean"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    }

    public static void createConnecction() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/TestTranslate", "root", "root");
            log.info("Connection created");
            // Class.forName("org.sqlite.JDBC");
            // con = DriverManager.getConnection("jdbc:sqlite:vilage.db");

        } catch (ClassNotFoundException | SQLException ex) {
            log.error("Error in Connection " + ex);
        }
    }

    public static void closeConnection() throws SQLException {
        con.close();
        con = null;
        log.info("Connection closed");
    }

    public static String getVerbIngMean(String verb) throws SQLException {
        String verbMean = "";
        String QUARY = "SELECT mean FROM VBG WHERE vb ='" + verb + "';";
        log.info("Quary: " + QUARY);

        try {

            createConnecction();
            Connection connection = con;
            java.sql.Statement stm = (java.sql.Statement) connection.createStatement();

            ResultSet res = stm.executeQuery(QUARY);

            if (res.next()) {
                verbMean = res.getString("mean");
            }

            closeConnection();

        } catch (Exception ex) {
            log.error("Error " + ex);
        }
        return verbMean;
    }
    //get any meaning from database
    public static String getSinhaleMean(String verb,String table,String col) throws SQLException {
        String verbMean = "";
        String QUARY = "SELECT"+col+"FROM " +table+ "WHERE vb ='" + verb + "';";
        log.info("Quary: " + QUARY);

        try {

            createConnecction();
            Connection connection = con;
            java.sql.Statement stm = (java.sql.Statement) connection.createStatement();

            ResultSet res = stm.executeQuery(QUARY);

            if (res.next()) {
                verbMean = res.getString("mean");
            }

            closeConnection();

        } catch (Exception ex) {
            log.error("Error " + ex);
        }
        return verbMean;
    }
    

    // public static void main(String[] args) throws SQLException {
    // System.out.print("Enter a Verb : ");
    // Scanner in = new Scanner(System.in);
    // String input = in.nextLine();
    // String output = getVerbIngMean(input);
    // System.out.println("Meaning of " + input + " is :" + output);
    // }
}
