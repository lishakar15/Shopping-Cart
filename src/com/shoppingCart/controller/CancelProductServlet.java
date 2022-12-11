package com.shoppingCart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingCart.model.CartVO;
@WebServlet("/cancel-item")
public class CancelProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		List<CartVO> cartList = (List<CartVO>)request.getSession().getAttribute("cartList");
		if(null!=cartList && !cartList.isEmpty())
		{
				for(CartVO cartVO: cartList)
				{
					if(id == cartVO.getProductId())
					{
						cartList.remove(cartVO);
						break;
					}
				}
				response.sendRedirect("Cart.jsp");
		}
	}
}
