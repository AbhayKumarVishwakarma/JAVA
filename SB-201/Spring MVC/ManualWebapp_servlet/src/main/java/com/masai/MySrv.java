package com.masai;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MySrv extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String snum1= request.getParameter("num1");
		String snum2= request.getParameter("num2");
		
		
		
		
		int n1= Integer.parseInt(snum1);
		int n2= Integer.parseInt(snum2);
		
		//Student student = new Student(------);
		
		//Student registedStudent= studentService.registerStudent(student);
		
		//SL--> DAL---> DB
		int result = n1+n2;
		
		request.setAttribute("resultdata", result);
		
		
		request.getRequestDispatcher("output.jsp").forward(request, response);
		
		
		
//		response.setContentType("text/html");
//		PrintWriter pw= response.getWriter();
//		
//		
//	
//		
//		//pw.print("<body bgcolor='yellow'><h1>Welcome to Servlet</h1></body>");
//		
//		pw.print("<body bgcolor='yellow'>");
//		
//		pw.print("<h1>Welcome to Servlet</h1>");
//		pw.print("<h2>Result is : "+result+"</h2>");
//		pw.print("</body>");
		

		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
