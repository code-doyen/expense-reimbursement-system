package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ServletConfigExample")
public class ServletConfigExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConfigExample() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("doGEt");
    	doPost(req, resp);
    } 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig sc1 = getServletConfig();
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.println(sc1.getInitParameter("jdbcHostName"));
	}

}
















