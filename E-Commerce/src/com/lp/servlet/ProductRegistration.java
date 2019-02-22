package com.lp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.dao.AppDAO;
import com.lp.form.Product;

@WebServlet({"/productreg"})

public class ProductRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Product product=new Product();
		
		product.setName(request.getParameter("productname"));
		product.setManifatcuredName( request.getParameter("mname"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setCategory(request.getParameter("category"));
		product.setDescription(request.getParameter("description"));
	
		if(AppDAO.addProdut(product)==1)
		{
			response.sendRedirect("adminhome.jsp?status=success");
		}
		else
		{
			response.sendRedirect("adminhome.jsp?status=failed");
		}
	}
}
