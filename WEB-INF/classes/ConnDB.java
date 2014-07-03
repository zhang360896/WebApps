/**
 * @(#)ConnDB.java
 *
 *
 * @author 
 * @version 1.00 2014/6/26
 */
package com.login; 
 
import java.sql.*;

public class ConnDB {

    private Connection ct = null;
    String dbName="";
    public ConnDB(String name)
    {
    	dbName = name;
    }
    Connection getConnection()
    {
    	try {
    	
    	   Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
    	   ct = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:3045;databaseName="+dbName, "sa", "987654");
    	}catch(Exception e){
    	     e.printStackTrace();	
    	 }
    	return ct;
    }
    void shutdownConnection()
    {
    	 try {
    	 	ct.close();
    	 }catch(Exception e){
    	 	e.printStackTrace();	
    	 }
    }
    
}