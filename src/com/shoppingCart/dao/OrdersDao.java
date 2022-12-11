package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCart.model.OrdersVO;

public class OrdersDao {

	private Connection connection =null;
	private PreparedStatement pstmt = null;		
	private ResultSet resultSet= null;
	public OrdersDao(Connection con)
	{
		this.connection = con;
	}
	
	public int insertOrderDetails(OrdersVO ordersVO)
	{
		int count = 0;
		if(null!= ordersVO)
		{
			String query ="insert into orders(productid,userid,quantity,totalamount,orderdate) values(?,?,?,?,?)";
			try {
				PreparedStatement pstmt = this.connection.prepareStatement(query);
				pstmt.setInt(1, ordersVO.getProductId());
				pstmt.setInt(2, ordersVO.getUserId());
				pstmt.setInt(3, ordersVO.getQuantity());
				pstmt.setString(4,ordersVO.getTotalAmount());
				pstmt.setString(5, ordersVO.getOrderDate());
				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return count;
	}
	public List<OrdersVO> getOrderDetails(int userId)
	{
		String query = " select o.orderdate,o.quantity,o.totalamount,p.productname,p.category from orders o inner join product p on o.productid = p.productid where o.userid= ?;";
		List<OrdersVO> ordersList = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, userId);
			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				ordersVO = new OrdersVO();
				ordersVO.setOrderDate(resultSet.getString("orderdate"));
				ordersVO.setProductName(resultSet.getString("productname"));
				ordersVO.setProductCategory(resultSet.getString("category"));
				ordersVO.setQuantity(resultSet.getInt("quantity"));
				ordersVO.setTotalAmount(resultSet.getString("totalamount"));
				ordersList.add(ordersVO);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ordersList;
		
	}
}
