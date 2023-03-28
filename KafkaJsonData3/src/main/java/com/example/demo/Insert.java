package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Insert {
	public static void insert(String column, String values, person p) {
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<person> ListPerson = new ArrayList<person>();
		HashMap<Integer, person> SetPerson = new HashMap<Integer, person>();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT * FROM newtable;";
			System.out.println("1");
			rs = stmt.executeQuery(sql);
			System.out.println(" ---- "+rs.next());
//			while (rs.next()) {
//				System.out.println("3");
//				person prsn = new person(rs.getString(1), rs.getInt(3), rs.getInt(2));
//				ListPerson.add(prsn);
//				SetPerson.put(rs.getInt(3), prsn);
//			}

//			Logic for Insert or Update

			if (SetPerson.containsKey(p.getId())) {
				String sqlUpdate = "UPDATE public.newtable SET PName = '" + p.getName() + "' WHERE Pid = " + p.getId()
						+ " ;";
				stmt.executeUpdate(sqlUpdate);
				System.out.println("----Update Successefully----");
			} else {
				String sql1 = "INSERT INTO public.newtable ( " + column + " ) " + "VALUES ( " + values + " );";
				stmt.executeUpdate(sql1);
				person prsn = new person(rs.getString(1), rs.getInt(3), rs.getInt(2));
				ListPerson.add(prsn);
				SetPerson.put(p.getId(), prsn);
				System.out.println("----Insert Successefully----");
			}

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.out.println("-------------------INSERT CATCH BLOCK----------------------------");
			System.out.println(e);
		}
	}
}