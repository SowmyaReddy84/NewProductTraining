package com.niit.SkillMappingBackEnd.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnect {
	public static Properties loadPropertiesFile() throws Exception {// use static block

		Properties prop = new Properties();
	
		InputStream in = new FileInputStream("F:\\Project details\\jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public static Connection connect()
	{
		Connection con = null;

		try {

			Properties prop;
			try {
				prop = loadPropertiesFile();

				String driverClass = prop.getProperty("MYSQLJDBC.driver");//can write i
				String url = prop.getProperty("MYSQLJDBC.url");
				String username = prop.getProperty("MYSQLJDBC.username");
				String password = prop.getProperty("MYSQLJDBC.password");

				Class.forName(driverClass);

				con = DriverManager.getConnection(url, username, password);
			


		/*	if (con != null) {
				System.out.println("connection created successfully using properties file");
			}

			else {
				System.out.println(" unable to create connection");
			}*/

		}catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 
				
		return con;
	}
	}

