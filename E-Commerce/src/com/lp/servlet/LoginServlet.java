package com.lp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.dao.AppDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username").trim();

		if(AppDAO.isValidUser(username,request.getParameter("password").trim())!=0)
		{
			

			if(AppDAO.getUserType(username)==1)
			{
				request.getSession().setAttribute("username",username);
				response.sendRedirect("adminhome.jsp");
			}
			else
			{
				
				request.getSession().setAttribute("username",username);
				response.sendRedirect("userhome.jsp");
			}
		}
		else
		{
			response.sendRedirect("login.jsp?status=Invalid Username and Password Or Your Account is Not Yet Activated");
		}
	}
}
