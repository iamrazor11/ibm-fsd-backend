package com.employee.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.employee.dao.Dao;
import com.employee.java.Employee;


//@ComponentScan(basePackages= {"com.employee.config","com.employee.java","com.employee.service","com.employee.dao","com.employee.main"})
@Configuration

public class EmployeeConfig {
	@Lazy
	@Bean
	public Employee passEmployee() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("passEmployee Enter Id:");
		int nId=sc.nextInt();
		System.out.println("Enter Name:");
		String nName=sc.next();
		//System.out.println("Enter Age:");
		//int nAge=sc.nextInt();
		System.out.println("Enter Designation:");
		String nDesign=sc.next();
		System.out.println("Enter Department:");
		String nDept=sc.next();
		System.out.println("Enter Country:");
		String nCountry=sc.next();
		Employee newEmp = new Employee(nId, nName, nDesign, nDept, nCountry);
		return newEmp;
	}
	
	@Lazy
	@Bean
	public Employee passUpdateEmployee() {
		
		Scanner sc=new Scanner(System.in);
//		System.out.println("passEmployee Enter Id:");
//		int nId=sc.nextInt();
		System.out.println("Enter Name:");
		String nName=sc.next();
		//System.out.println("Enter Age:");
		//int nAge=sc.nextInt();
		System.out.println("Enter Designation:");
		String nDesign=sc.next();
		System.out.println("Enter Department:");
		String nDept=sc.next();
		System.out.println("Enter Country:");
		String nCountry=sc.next();
		Employee newEmp = new Employee(0, nName, nDesign, nDept, nCountry);
		return newEmp;
	}
	
//	@Bean
//	public importer()
	
	@Bean
	public Dao passDao() {
		return new Dao();
	}
	

}
