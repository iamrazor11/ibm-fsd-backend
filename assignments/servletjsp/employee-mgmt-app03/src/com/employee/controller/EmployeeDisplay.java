package com.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.Dao;
import com.employee.java.Employee;


/**
 * Servlet implementation class EmployeeDisplay
 */
@WebServlet("/EmployeeDisplay")
public class EmployeeDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public EmployeeDisplay() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("EmployeeDisplay called");
		//resp.getWriter().append("Served at: ").append(req.getContextPath());
		List<Employee> empList=new ArrayList<Employee>();	
		Dao d=new Dao();
		empList=(ArrayList<Employee>) d.displayAll();

		req.setAttribute("empList", empList);
		//System.out.println("empList="+empList);
		RequestDispatcher rd = req.getRequestDispatcher("displayEmployee.jsp");
		rd.forward(req, resp);
		
	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		//List<Employee> empList=new ArrayList<Employee>();	
		//Dao d=new Dao();
		//empList=(ArrayList<Employee>) d.displayAll();

		//req.setAttribute("empList", empList);
		//System.out.println("empList="+empList);
		//RequestDispatcher rd = req.getRequestDispatcher("displayEmployee.jsp");
		//rd.forward(req, resp);
	}

}
