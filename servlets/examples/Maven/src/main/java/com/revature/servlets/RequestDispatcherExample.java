package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDispatcherExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestDispatcherExample() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("this is my servlet page");
		/*RequestDispatcher rd = request.getRequestDispatcher("home.html");
		rd.forward(request, response);*/
		
		
		RequestDispatcher rd2 = request.getRequestDispatcher("ForwardServlet");
		rd2.forward(request, response);
		
		//forward vs include
		//RequestDispatcher forward vs sendRedirect
		//rd2.include(request, response);
		//response.sendRedirect("ForwardServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}









