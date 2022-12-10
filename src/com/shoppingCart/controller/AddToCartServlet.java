package com.shoppingCart.controller;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Integer productId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		List<Integer> productIdList = (List<Integer>) session.getAttribute("productIdList");
		List<Integer> prodIdListNew = new ArrayList<Integer>();
		
		if(null == productIdList)
		{
			prodIdListNew.add(productId);
			session.setAttribute("productIdList", prodIdListNew);
		}
		else
		{
			boolean isIdExists = false;
			for(Integer id:productIdList)
			{
				if(productId.equals(id))
				{
					isIdExists = true;
					break;

				}
			}
			if(isIdExists == false)
			{
				prodIdListNew = productIdList;
				prodIdListNew.add(productId);
				session.setAttribute("productIdList", prodIdListNew);
				response.sendRedirect("index.jsp");
			}
			if(isIdExists)
			{
				response.getWriter().println("Product already exists my bro and the id is "+productId);
			}
		}
	}
}
