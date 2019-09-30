package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.java.Employee;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class Dao {
public static int flag=0;
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";
//	// Database credentials
//	static final String USER = "training";
//	static final String PASS = "training";
//	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	MysqlDataSource dataSource = new MysqlDataSource();
	{
	dataSource.setDatabaseName("jdbctraining");
	dataSource.setUser("training");
	dataSource.setPassword("training");
	dataSource.setServerName("localhost");
	if(flag==0) {
	System.out.println("Connecting...");
	try {
		conn = dataSource.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn.setAutoCommit(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Connection Established: "+conn);
	}
	}
	public void insert(Employee e){
		
		try {
//		System.out.println("Connecting...");
//		conn = dataSource.getConnection();
//		conn.setAutoCommit(true);
//		System.out.println("Connection Established: "+conn);
//		
//		System.out.println("Creating statement...");
//		//stmt = conn.createStatement();
		flag++;
		String query1="insert into EmployeeData (id,name,designation,department,country) values (?,?,?,?,?)";
		pstmt=conn.prepareStatement(query1);
		pstmt.setInt(1, e.getId());
		pstmt.setString(2,e.getName());
		pstmt.setString(3, e.getDesign());
		pstmt.setString(4, e.getDept());
		pstmt.setString(5, e.getCountry());
		
		int insertCount = pstmt.executeUpdate();
		pstmt.close();
		System.out.println(insertCount + " Employee(s) inserted");
		}
		catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
		se.printStackTrace();
	}
}	
	public void delete(int e) {
		try {
//			System.out.println("Connecting...");
//			conn = dataSource.getConnection();
//			conn.setAutoCommit(true);
//			System.out.println("Connection Established: "+conn);
//			
//			System.out.println("Creating statement...");
//			//stmt = conn.createStatement();
			flag++;
			String query1="delete from EmployeeData where id=?";
			pstmt=conn.prepareStatement(query1);
			pstmt.setInt(1, e);
			
			int deleteCount = pstmt.executeUpdate();
			pstmt.close();
			if(deleteCount<=0)
				System.out.println("Error in Deletion");
			System.out.println(deleteCount + " Employee(s) deleted");
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
	
	public List<Employee> displayAll() {
		try {
//			System.out.println("Connecting...");
//			conn = dataSource.getConnection();
//			conn.setAutoCommit(true);
//			System.out.println("Connection Established: "+conn);
//			
//			System.out.println("Creating statement...");
//			//stmt = conn.createStatement();
			flag++;
			List<Employee> empList=new ArrayList<Employee>();
			String query1="select * from EmployeeData";
			pstmt=conn.prepareStatement(query1);
			
			rs = pstmt.executeQuery();
			//if(rs<0)
				//System.out.println("Error in selection");
			System.out.println(rs + " Employee(s) displayed");
			
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i)+"|");
			}
			
System.out.println();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d | \t%s | \t%s | \t%s | \t%s |\n", id, name, designation, department, country);
				empList.add(new Employee(id,name,designation,department,country));
			}
			pstmt.close();
			return empList;
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
		return null;
	}
	
	public void display(int e) {
		try {
//			System.out.println("Connecting...");
//			conn = dataSource.getConnection();
//			conn.setAutoCommit(true);
//			System.out.println("Connection Established: "+conn);
//			
//			System.out.println("Creating statement...");
//			//stmt = conn.createStatement();
			flag++;
			String query1="select * from EmployeeData where id=?";
			pstmt=conn.prepareStatement(query1);
			pstmt.setInt(1, e);
			
			rs = pstmt.executeQuery();
			//if(rs<0)
				//System.out.println("Error in selection");
			System.out.println(rs + " Employee(s) displayed");
			
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i)+"|");
			}
			
System.out.println();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d | \t%s | \t%s | \t%s | \t%s |\n", id, name, designation, department, country);
			}
			
			pstmt.close();
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
	
	
	public void update(int id, Employee e) {
		try {
//			System.out.println("Connecting...");
//			conn = dataSource.getConnection();
//			conn.setAutoCommit(true);
//			System.out.println("Connection Established: "+conn);
//			
//			System.out.println("Creating statement...");
//			//stmt = conn.createStatement();
			flag++;
			String query1="update EmployeeData set id=?,name=?,designation=?,department=?,country=? where id=? ";
			pstmt=conn.prepareStatement(query1);
			pstmt.setInt(1, id);
			pstmt.setString(2,e.getName());
			pstmt.setString(3, e.getDesign());
			pstmt.setString(4, e.getDept());
			pstmt.setString(5, e.getCountry());
			pstmt.setInt(6, id);
			
			int insertCount = pstmt.executeUpdate();
			pstmt.close();
			System.out.println(insertCount + " Employee(s) u");
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
	}
	
	public ArrayList<Employee> export() {
		try {
			ArrayList<Employee> empList=new ArrayList<Employee>();
//			System.out.println("Connecting...");
//			conn = dataSource.getConnection();
//			conn.setAutoCommit(true);
//			System.out.println("Connection Established: "+conn);
//			
//			System.out.println("Creating statement...");
//			//stmt = conn.createStatement();
			flag++;
			String query1="select * from EmployeeData";
			pstmt=conn.prepareStatement(query1);
			
			rs = pstmt.executeQuery();
			//if(rs<0)
				//System.out.println("Error in selection");
			System.out.println(rs + " Employee(s) displayed");
			
			ResultSetMetaData rsmeta = rs.getMetaData();
			int cols = rsmeta.getColumnCount();
			for(int i=1; i <= cols; i++) {
				System.out.print("\t" + rsmeta.getColumnName(i)+"|");
			}
			
System.out.println();
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				empList.add(new Employee(id,name,designation,department,country));
				// Display values
				//System.out.format("\t%d | \t%s | \t%s | \t%s | \t%s |\n", id, name, designation, department, country);
				
			}
			
			pstmt.close();
			return empList;
			}
			catch (SQLException se) { // Handle errors for JDBC se.printStackTrace(); }
				se.printStackTrace();
		}
		return null;

	}
	{
//	try {
//		//conn.close();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}	
	}


	
}
