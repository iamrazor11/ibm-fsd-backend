package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.Dao;
import com.employee.java.Employee;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public EmployeeController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Dao d=new Dao();
		int nId=Integer.parseInt(request.getParameter("id"));
		String nName=request.getParameter("name");
		String nDesign=request.getParameter("design");
		String nDept=request.getParameter("dept");
		String nCountry=request.getParameter("country");
		PrintWriter out = response.getWriter();
		
		
		
		Employee newEmp = new Employee(nId, nName, nDesign, nDept, nCountry);
		int insert=d.insert(newEmp);
		if(insert>0) {
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("<h2>"+insert+"Records Inserted</h2><br> <p><a href='index.jsp'>Go Home</a></p></body></html>");
		}
	}

}
