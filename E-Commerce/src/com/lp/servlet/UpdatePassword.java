package com.lp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.dao.AppDAO;

/**
 * Servlet implementation class UpdatePassword
 */

@WebServlet("/changePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username=(String)request.getSession().getAttribute("username");
		
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");

		if(AppDAO.updatePassword(username, oldpassword,newpassword)==1)
		{
			if(AppDAO.getUserType(username)==1)
			{
				response.sendRedirect("adminchangepassword.jsp?status=success");
			}
			else
			{
				response.sendRedirect("userchangepassword.jsp?status=success");
			}
			
		}
		else
		{
			request.getSession().invalidate();
			response.sendRedirect("login.jsp?status=please verify your login");
		}
	}
}
