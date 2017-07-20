package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextExample")
public class ServletContextExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextExample() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext sc1 = getServletContext();
		
		//ServletContext sc2 = getServletConfig().getServletContext(); 
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println("<br>");
		pw.println(sc1.getInitParameter("globalVariable"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
