package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class Insert {
	public static void insert(String column, String values, person p) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO public.newtable ( " + column + " ) " + "VALUES ( " + values + " );";
			System.out.println(sql);
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
    	  try {
    		  Class.forName("org.postgresql.Driver");
    	         c = DriverManager
    	        		 .getConnection("jdbc:postgresql://localhost:5432/postgres",
    	                 "postgres", "root");
    	         c.setAutoCommit(false);
    	         System.out.println("Record Updating ---------");

    	         stmt = c.createStatement();
    	         String sqlUpdate = "UPDATE public.newtable SET PName = '"+p.getName()+"' WHERE Pid = " +p.getId() +" ;";
    	         System.out.println(sqlUpdate);
    	         stmt.executeUpdate(sqlUpdate);

    	         stmt.close();
    	         c.commit();
    	         c.close();
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("---------------Catch Block (Inser Update)-------------");
		}
			e.printStackTrace();
			System.out.println("---------------Catch Block (Insert)-------------");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Records created successfully");
	}
}