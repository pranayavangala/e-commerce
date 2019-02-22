package com.lp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.dao.AppDAO;
import com.lp.form.UserForm;

@WebServlet("/userregistration")
public class UserRegistration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserForm userForm=new UserForm();

		String userName=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		
		System.out.println("name is "+name);

		userForm.setUserName(userName);
		userForm.setName(name);
		userForm.setAddress(address);
		userForm.setEmail(email);
		userForm.setMobile(Long.parseLong(mobile));
		userForm.setPassword(password);

		if(AppDAO.userRegistration(userForm)==1)
		{
			response.sendRedirect("newuser.jsp?status=success");
		}
		else
		{
			response.sendRedirect("newuser.jsp?status=User All Ready Exist");
		}
	}
}
