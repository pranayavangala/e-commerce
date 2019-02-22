package com.lp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lp.dao.AppDAO;
import com.lp.form.Product;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product p = new Product();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setPrice(Float.parseFloat(request.getParameter("price")));
		p.setDescription(request.getParameter("description"));
		
		int result = AppDAO.updateProduct(p);
		
		if(result == 1){
			response.sendRedirect("editproducts.jsp?status=success");
		}
		else{
			response.sendRedirect("editproducts.jsp?status=failed in update");
		}
		
	}

}
