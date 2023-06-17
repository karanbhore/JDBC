package com.prowings.introductorypart;

public class Employees {

	private int id;
	private String name;
	private String salary;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int id, String name, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
