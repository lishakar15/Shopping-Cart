package com.shoppingCart.controller;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoppingCart.model.CartVO;
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Integer productId = Integer.parseInt(request.getParameter("id"));
		Integer quantity = 1; //Default quantity
		HttpSession session = request.getSession();
		List<CartVO> cartList = (List<CartVO>) session.getAttribute("cartList");
		List<CartVO> cartListNew = new ArrayList<CartVO>();
		CartVO cartVO = null;
		if(null == cartList)
		{
			cartVO = new CartVO();
			cartVO.setProductId(productId);
			cartVO.setQuantity(quantity);
			cartListNew.add(cartVO);
			session.setAttribute("cartList", cartListNew);
			response.sendRedirect("index.jsp");
		}
		else
		{
			boolean isIdExists = false;
			for(CartVO cart:cartList)
			{
				if(productId.equals(cart.getProductId()))
				{
					isIdExists = true;
					break;

				}
			}
			if(isIdExists == false)
			{
				cartListNew = cartList;
				cartVO = new CartVO();
				cartVO.setProductId(productId);
				cartVO.setQuantity(quantity);
				cartListNew.add(cartVO);
				session.setAttribute("cartList", cartList);
				response.sendRedirect("index.jsp");
			}
			if(isIdExists)
			{
				response.getWriter().println("Product already exists my bro and the id is "+productId);
			}
		}
	}
}
