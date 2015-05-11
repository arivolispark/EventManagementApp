package com.eventmanagement.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBUtility {
    private static Connection connection = null;
 
    public static Connection getConnection() {
        System.out.println("\n DBUtility::getConnection()");
        if (connection == null) {
        	try {
        		Properties prop = new Properties();
                InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
                prop.load(inputStream);

                String driver = prop.getProperty("driver");
                System.out.println("\n driver: " + driver);
                
                String url = prop.getProperty("url");
                System.out.println(" url: " + url);
                
                String user = prop.getProperty("user");
                System.out.println(" user: " + user);
                
                String password = prop.getProperty("password");
                System.out.println(" driver: " + driver);                
                
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n connection: " + connection);
    	return connection;
    }
}