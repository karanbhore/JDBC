package com.prowings.introductorypart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRecordManagement {

	static Connection con;
	static PreparedStatement pstmt;
	static Statement stmt;
	static {
		System.out.println("welcome to database.......");
	}

	public static boolean addEmployees(Employees e) {
		boolean f = false;
		String q = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";

		try {
			con = ConnectionProvider.createConnection();
			pstmt = con.prepareStatement(q);

			// Check if the employee ID already exists in the database
			String checkQuery = "SELECT COUNT(*) FROM employees WHERE id = ?";
			PreparedStatement checkStmt = con.prepareStatement(checkQuery);
			checkStmt.setInt(1, e.getId());
			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			checkStmt.close();

			if (count > 0) {
				System.out.println("Employee with ID " + e.getId() + " already exists in the database.");
			} else {
				pstmt.setInt(1, e.getId());
				pstmt.setString(2, e.getName());
				pstmt.setString(3, e.getSalary());

				pstmt.executeUpdate();
				f = true;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		if (f) {
			System.out.println("Employee added to database record.");
		}
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++");
		return f;
	}

	public static void updateEmployee(Employees e) {
		String q = "update employees set salary = ? where id = ?";
		System.out.println(q);

		try {
			con = ConnectionProvider.createConnection();
			pstmt = con.prepareStatement(q);

			pstmt.setString(1, e.getSalary());
			pstmt.setInt(2, e.getId());

			pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Employee updated in the database record.");
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++");

	}

	public static void deleteEmployee(Employees e) {
		String q = "delete from employees where id = ?";

		try {
			con = ConnectionProvider.createConnection();
			pstmt = con.prepareStatement(q);

			pstmt.setInt(1, e.getId());

			pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Employee deleted in the database record.");
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++");

	}

	public static void showAllEmployees() {
		boolean f = false;
		try {
//		jdbc code to insert...
			con = ConnectionProvider.createConnection();
			String q = "select * from employees;";

			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);

			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String salary = set.getString(3);

				System.out.println("employee from database...");
				System.out.println("Id " + id);
				System.out.println("Name " + name);
				System.out.println("salary " + salary);
				System.out.println("++++++++++++++++++++++++++++++++");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
