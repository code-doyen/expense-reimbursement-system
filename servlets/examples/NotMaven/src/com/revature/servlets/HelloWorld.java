package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloWorld() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloWorld - init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		super.service(arg0, arg1);
//	}

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("service");
    	super.service(req, resp);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
	}

}
