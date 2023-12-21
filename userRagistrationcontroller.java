package com.mydata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydata.dao.UserRegisterdao;
import com.mydata.dao.UserRegisterdaoimple;
import com.mydata.model.UserRegister;

public class userRagistrationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userRagistrationcontroller() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// input read

		String n = request.getParameter("pname");

		String un = request.getParameter("uname");

		String pass = request.getParameter("pass1");

		String confirmpass = request.getParameter("pass2");

		String e = request.getParameter("email");

		String ph = request.getParameter("phone");

		if (pass.equals(confirmpass)) {

			UserRegister ur = new UserRegister(n, un, pass, e, ph);

			UserRegisterdao ud = new UserRegisterdaoimple();

			int res = ud.saveuser(ur);

			if (res > 0) {
				request.getRequestDispatcher("Login.html").forward(request, response);

			} else {
				out.print("<b>try again </b>");

				request.getRequestDispatcher("Register.html").include(request, response);

			}
		} else {
			out.print("<b>pass and confirm pass must be same </b>");
			request.getRequestDispatcher("Register.html").include(request, response);

		}
	}

}
