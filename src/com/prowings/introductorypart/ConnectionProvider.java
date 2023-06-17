package com.prowings.introductorypart;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

	static Connection con;

	public static Connection createConnection() {
		System.out.println("welcome to database connection......");
//		load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

//			creat connection
			try {
				Properties myProp=new Properties();
				myProp.load(new FileInputStream("F:\\java programs\\JDBC\\src\\databaBase.properties"));
				String url=myProp.getProperty("dburl");
				String usr=myProp.getProperty("dbusername");
				String pwd=myProp.getProperty("dbpwd");
				System.out.println(url);
				
				con = DriverManager.getConnection(url,usr,pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("connection created successfully.........");
		System.out.println();
		return con;
	}

}
