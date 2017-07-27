package com.revature.ajax;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(RequestHelper.process(request)));
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
		response.setContentType("application/json");
		response.getWriter().write(new ObjectMapper().writeValueAsString(RequestHelper.process(request)));
	}

}
