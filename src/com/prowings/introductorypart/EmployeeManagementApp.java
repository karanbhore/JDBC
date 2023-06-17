package com.prowings.introductorypart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeManagementApp {

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("welcome to EmployeeManagementApp");

		Employees emp1 = new Employees(13, "Paresh", "100000");
		emp1.setSalary("200000");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("PRESS 1 to ADD Employee");
			System.out.println("PRESS 2 to DELETE Employee");
			System.out.println("PRESS 3 to UPDATE Employee");
			System.out.println("PRESS 4 to DISPLAY Employee");
			System.out.println("PRESS 5 to EXIT App");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
//				add Employee
				EmployeeRecordManagement.addEmployees(emp1);

			} else if (c == 2) {
//				delete employee
				EmployeeRecordManagement.deleteEmployee(emp1);

			} else if (c == 3) {
//				Update Employee
				EmployeeRecordManagement.updateEmployee(emp1);

			} else if (c == 4) {
//				display employees
				EmployeeRecordManagement.showAllEmployees();

			} else if (c == 5) {
//				exit
				break;
			} else {

			}

		}
		System.out.println("thank you for using my application...!");
		System.out.println("see you soon ....bye bye!!");
	}
}