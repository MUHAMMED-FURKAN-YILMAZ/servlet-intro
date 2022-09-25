package com.tpe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		
		//extract values
		String userName = request.getParameter("username");
		String password=request.getParameter("password");
		
		//validate values
		if(userName.isEmpty() || password.isEmpty()) {
			response.getWriter().append("username or password can't be empty");
			return;
		}
		if(!(userName.equals("user")&&password.equals("pass"))) {
			response.getWriter().append("login failed..");
			
		}else {
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/liststudent");
			dispatcher.forward(request, response);
		}
	}
}