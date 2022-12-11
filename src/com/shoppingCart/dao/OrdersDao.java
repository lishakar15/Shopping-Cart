package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoppingCart.model.OrdersVO;

public class OrdersDao {

	private Connection connection =null;
	private PreparedStatement pstmt = null;		
	private ResultSet resultSet= null;
	public OrdersDao(Connection con)
	{
		this.connection = con;
	}
	
	public boolean insertOrderDetails(OrdersVO ordersVO)
	{
		Boolean isDataInserted = false;
		if(null!= ordersVO)
		{
			String query ="insert into orders(productid,productname,userid,quantity,totalamount) values(?,?,?,?,?)";
			try {
				PreparedStatement pstmt = this.connection.prepareStatement(query);
				pstmt.setInt(1, ordersVO.getProductId());
				pstmt.setString(2, ordersVO.getProductName());
				pstmt.setInt(3, ordersVO.getUserId());
				pstmt.setInt(4, ordersVO.getQuantity());
				pstmt.setString(5,ordersVO.getTotalAmount());
				int count = pstmt.executeUpdate();
				if(count>0)
				{
					isDataInserted = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return isDataInserted;
	}
}
