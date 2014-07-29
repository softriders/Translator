package com.kasun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {

	private static final Logger log = LoggerFactory.getLogger(DBConnection.class);

	public Connection con = null;

	public void createConnecction() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con =
			 DriverManager.getConnection("jdbc:mysql://localhost/Translate",
			 "root", "root");
//			Class.forName("org.sqlite.JDBC");
//			con = DriverManager.getConnection("jdbc:sqlite:vilage.db");

			log.info("Connection Created");
		} catch (ClassNotFoundException | SQLException ex) {
			log.error("Error in Connection " + ex);
		}
	}

	public void closeConnection() throws SQLException {
		con.close();
		con = null;
		log.info("Connection closed");
	}

}
