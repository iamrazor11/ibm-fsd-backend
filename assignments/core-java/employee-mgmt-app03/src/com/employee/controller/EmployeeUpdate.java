package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.Dao;
import com.employee.java.Employee;

/**
 * Servlet implementation class EmployeeUpdate
 */
@WebServlet("/EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public EmployeeUpdate() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	String e;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("In getMethod");
		e=request.getParameter("id");
		RequestDispatcher rd = request.getRequestDispatcher("updateEmployeeForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Dao d= new Dao();			
		
		
		
		//int e=Integer.parseInt(request.getParameter("id"));
		String nName=request.getParameter("name");
		String nDesign=request.getParameter("design");
		String nDept=request.getParameter("dept");
		String nCountry=request.getParameter("country");
		Employee newEmp = new Employee(Integer.parseInt(e), nName, nDesign, nDept, nCountry);

		PrintWriter out = response.getWriter();
		
		
		int update=d.update(Integer.parseInt(e),newEmp);
		out.println("<html><body><h3>"+update+" Employees Updated</h3> <br> <p><a href='index.jsp'>Go Home</a></p></body></html>");
	}

}
