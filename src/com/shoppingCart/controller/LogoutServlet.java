package com.shoppingCart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/user-logout")
public class LogoutServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		System.out.println("User logged out");
		request.getSession().removeAttribute("user");
		response.sendRedirect("index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
	}
}
