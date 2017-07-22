package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/PrintWriterExample")
public class PrintWriterExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrintWriterExample() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("PRintWriter - init");
		super.init(config);
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service");
		super.service(arg0, arg1);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		System.out.println("doGet");
		//doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		// pw.println("<html><body>"
		// + "<h2>Hello World!</h2>"
		// + "</body></html>");

		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");

		pw.println("<html><body>" + "<h2>Hello " 
		+ fname + " " + lname + ", How are you?" 
				+ "</h2>");
		
		
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = request.getHeader(name);
			
			pw.println(name + ":" + value);
			pw.println("<br>");
			
			//pw.println("name : " + e.nextElement() + ", value: " + request.getHeader());
			
		}
		pw.println("</body></html>");
	}

}

















