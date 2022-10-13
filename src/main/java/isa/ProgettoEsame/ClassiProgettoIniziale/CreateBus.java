package isa.ProgettoEsame.ClassiProgettoIniziale;
/*
 * Copyright 2003 Sun Microsystems, Inc.  ALL RIGHTS RESERVED.
 * Use of this software is authorized pursuant to the terms of the license found at
 * http://developer.java.sun.com/berkeley_license.html.
 */ 


import java.sql.*;
     
public class CreateBus {

	public static void main(String args[]) {
		String url = "jdbc:db2://localhost:25001/c2c";
	        
		Connection con;
		String createString;
		createString = "create table BUS " + 
						"(ID_BUS int NOT NULL, " +
						"PLATE varchar(20), " +
						"YEAR int, " +
						"DESCRIPTION varchar(40), " +
						"DATE_LAST_REV date, " +
						"DATE_LAST_CARSERV date, " +
						"constraint pk_boy_id primary key (ID_BUS))";
	
		Statement stmt;
	
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: "); 
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url,"db2admin","serena");
	
			stmt = con.createStatement();							
	   		stmt.executeUpdate(createString); //comando che crea la tabella
	
			stmt.close();
			con.close();
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}

