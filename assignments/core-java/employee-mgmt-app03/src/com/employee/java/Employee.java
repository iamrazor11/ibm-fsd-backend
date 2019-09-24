package com.employee.java;

public class Employee {
	String name;
	//int age;
	int id;
	String design;
	String dept;
	String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//public int getAge() {
		//return age;
	//}
	//public void setAge(int age) {
		//this.age = age;
	//}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Employee(int id, String name, String design, String dept, String country) {
		super();
		this.id= id;
		this.name = name;
		//this.age = age;
		this.design = design;
		this.dept = dept;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee Details:\n id= " + id + "\n name= " + name + "\n Total designation=" + design + "\n department= " + dept + "\n country= " + country+ "\n";
	}
	
	public String exportString() {
		return id+","+name+","+","+design+","+dept+","+country;
	}
		

}
