package com.shoppingCart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingCart.model.UserVO;

@WebServlet("/buy-now")
public class BuyNowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		UserVO userVO= (UserVO)request.getSession().getAttribute("user");
		if(null == userVO)
		{
			response.sendRedirect("Login.jsp");
		}
		if(null != userVO)
		{
			Integer productId  = Integer.parseInt(request.getParameter("id"));
			Integer userId = userVO.getId();
		}
	}
}
		
