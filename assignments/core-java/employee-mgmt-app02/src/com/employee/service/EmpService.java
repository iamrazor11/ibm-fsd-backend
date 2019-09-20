package com.employee.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.employee.dao.Dao;
import com.employee.java.Employee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.*;
import java.util.List;
import java.util.Scanner;



public class EmpService implements Callable<Object>{
	Dao d=new Dao();
	public List<Employee> empList = new ArrayList<Employee>();
	public void getInput() throws IOException {
		int choice = 0;
		do {
			try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the option: \n 1.add\n 2.view \n 3.update \n 4.delete \n 5.view all \n 6.Import \n7.Export \n 10.exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					add();
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					update(x);
					break;
				case 4:{
						System.out.println("Enter Emp Id");
						x= sc.nextInt();
						delete(x);
						break;
				}
				case 5:
					viewAll();
					break;
				case 6:
				ExecutorService e= Executors.newFixedThreadPool(7);
				Future<Boolean> f=e.submit(new Callable<Boolean>() {
						public Boolean call() throws RuntimeException, IOException {
							System.out.print("Thread : "+Thread.currentThread().getName());
							imported();
							return true;
						}
					});
					e.shutdown();
					break; 
				case 7:
					ExecutorService e2= Executors.newFixedThreadPool(7);
					Future<Boolean> f2=e2.submit(new Callable<Boolean>() {
							public Boolean call() throws IOException {
								System.out.print("Thread : "+Thread.currentThread().getName());
								exporter();
								return true;
							}
						});
					e2.shutdown();
						break;
				case 10:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid entry please try again!!");
			}
			}catch(InputMismatchException e) {
				System.out.println("Error...Enter a number");
			}
			
		}while(choice!=10);
	}
	public void add() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id:");
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
		empList.add(newEmp);
		d.insert(newEmp);
		
	}
	public void view(int x) {
		//empList.forEach(e->{if(e.getId()==x) {
			//System.out.println(e);
		//}});
		d.display(x);
	}
	public void update(int x) {
		//List<Employee> tempEmpList = new ArrayList<Employee>();
		//empList.forEach(e->{
			//if(e.getId()!=x) {
				//tempEmpList.add(e);
			//}
			//else {
				//System.out.println(e);
			//}
		//});
		//empList=tempEmpList;
		//add();
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter Emp Id:");
		//int eid=sc.nextInt();
//		empList.forEach(e->{
//			if(e.getId()==x) {
//				
//				System.out.println("Enter Name:");
//				String nName=sc.next();
//				System.out.println("Enter Age:");
//				int nAge=sc.nextInt();
//				System.out.println("Enter Designation:");
//				String nDesign=sc.next();
//				System.out.println("Enter Department:");
//				String nDept=sc.next();
//				System.out.println("Enter Country:");
//				String nCountry=sc.next();
//				e.setName(nName);
//				e.setAge(nAge);
//				e.setDesign(nDesign);
//				e.setDept(nDept);
//				e.setCountry(nCountry);
//				
//			}
//		});
		//System.out.println("Enter Id:");
		int nId=x;
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
		//empList.add(newEmp);
		d.update(x,newEmp);
	}
	public void delete(int x) {
		List<Employee> tempEmpList = new ArrayList<Employee>();
		empList.forEach(e->{
			if(e.getId()!=x) {
				tempEmpList.add(e);
			}
		});
		d.delete(x);
		empList=tempEmpList;
	}
	public void viewAll() {
		//empList.forEach(e->{
		//	System.out.println(e);
			d.displayAll();
		//});
	}
	
	public void imported() throws RuntimeException, IOException {
		BufferedReader in = null;
			in = new BufferedReader(new FileReader("C:\\Training\\input.txt"));
			String buf;
			while((buf=in.readLine())!=null) {
				//System.out.println(buf);
				String[] arr=buf.split(",");
				
				Employee newEmp = new Employee(Integer.parseInt(arr[1]), arr[0], arr[2], arr[3], arr[4]);
				//empList.add(newEmp);
				d.insert(newEmp);
			}
			in.close();
				
	}
	public void exporter() throws IOException{
	//BufferedWriter out=null;
	 //PrintWriter out = null;
		String str;
		List<Employee> eList=new ArrayList<Employee>();
		eList=d.export();
		final PrintWriter out = new PrintWriter(new FileWriter("C:\\Training\\output.txt"));
		eList.forEach(e->{
			//System.out.println(e.exportString());
			out.write(e.exportString());
			//out.write('\r\n');
			out.write("\r\n");
			
		});
		
		out.flush();
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
		
