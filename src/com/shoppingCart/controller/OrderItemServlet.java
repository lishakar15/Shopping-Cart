package com.shoppingCart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppinCart.DBConnection.DbConnection;
import com.shoppingCart.dao.OrdersDao;
import com.shoppingCart.model.CartVO;
import com.shoppingCart.model.OrdersVO;
import com.shoppingCart.model.UserVO;
@WebServlet("/order-item")
public class OrderItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Integer id = Integer.parseInt(request.getParameter("id"));
		UserVO userVO = (UserVO)request.getSession().getAttribute("user");
		if(null == userVO)
		{
			response.sendRedirect("Login.jsp");
		}
		else
		{
		OrdersVO ordersVo = null;
		CartVO cartVO = null;
		List<CartVO> cartList = (List<CartVO>) request.getSession().getAttribute("cartList");
		if(null!= cartList)
		{
			boolean isItemFound = false;
			for(CartVO c : cartList)
			{
				if(id.equals(c.getProductId()))
				{
					cartVO = c;
					isItemFound = true;
					break;
				}
			}
			if(isItemFound)
			{
				ordersVo = new OrdersVO();
				ordersVo.setProductId(cartVO.getProductId());
				ordersVo.setQuantity(cartVO.getQuantity());
				ordersVo.setProductName(cartVO.getProductName());
				ordersVo.setUserId(userVO.getId());
				double totalAmt = cartVO.getPrice()*cartVO.getQuantity();
				ordersVo.setTotalAmount(String.valueOf(totalAmt));
			}
			
		}
		try 
		{
			OrdersDao ordersDao = new OrdersDao(DbConnection.getConnection());
			ordersDao.insertOrderDetails(ordersVo);
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	}
}
