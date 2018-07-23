package com.capgemini.paymentwalletapplication.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBUtil {
public static Connection getConnection() throws ClassNotFoundException,SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Capgemini123");
	 return conn;
}
}
