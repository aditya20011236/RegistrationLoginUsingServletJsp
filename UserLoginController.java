package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.UserLogindao;
import com.mydata.dao.UserLogindaoimple;
import com.mydata.model.UserLogin;

public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String u=request.getParameter("username");
		
		String pass=request.getParameter("password");
		
		UserLogin ul=new UserLogin(u, pass);
		
		UserLogindao dao=new UserLogindaoimple();
		
		String output=dao.validuser(ul);
		
		if(output.equalsIgnoreCase("valid")) {
			
			request.getRequestDispatcher("home.html").forward(request, response);
			
			
		}else {
			out.print("<b>Invalid username or password </b>");
			
			request.getRequestDispatcher("Login.html").include(request, response);
		}
		
		
		
		
		
	}

}
