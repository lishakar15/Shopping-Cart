package com.shoppingCart.controller;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppinCart.DBConnection.DbConnection;
import com.shoppingCart.dao.UserDao;
import com.shoppingCart.model.UserVO;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		if (null != emailId && null != password) 
		{
			try 
			{
				UserDao userDao = new UserDao(DbConnection.getConnection());
				UserVO userVO = userDao.getUserDetails(emailId,password);
				if(null != userVO)
				{
				System.out.println("Login SuccessFull");
				request.getSession().setAttribute("user",userVO );
				response.sendRedirect("index.jsp");
				}
				else
				{
					System.out.println("Login Failed");
				}
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}

		}
	}
}
