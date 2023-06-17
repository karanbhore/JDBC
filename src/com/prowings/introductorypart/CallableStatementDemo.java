package com.prowings.introductorypart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class CallableStatementDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "Pass@123");

        CallableStatement callableStmt = con.prepareCall("{CALL addStudent(?, ?, ?, ?)}");

        int id = 10;
        String name = "John Doe";
        String phone = "1234567890";
        String city = "New York";

        callableStmt.setInt(1, id);
        callableStmt.setString(2, name);
        callableStmt.setString(3, phone);
        callableStmt.setString(4, city);

        callableStmt.execute();
        System.out.println("added successfully.......");

        callableStmt.close();
        con.close();
    }
}
