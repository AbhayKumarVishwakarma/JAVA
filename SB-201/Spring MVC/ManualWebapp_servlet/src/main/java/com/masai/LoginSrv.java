package com.masai;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginSrv extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		String page="error.jsp";
		
		if(username.equals("admin") && password.equals("1234")) {
			
			page="success.jsp";
		}
		
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

}
