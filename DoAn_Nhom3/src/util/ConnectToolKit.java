package util;

import java.util.*;
import java.sql.*;
public class ConnectToolKit {
 static String url="jdbc:mysql://localhost:3306/quanlycuahangchay";
 static String user="root";
 static String pass="";
 static Connection con = null;
 
 public static Connection getConnect() {
	 if(con == null) {
		 try {
			con = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 return con;
 }
 
}
