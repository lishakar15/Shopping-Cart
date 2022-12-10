package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.shoppingCart.model.UserVO;

public class UserDao {
	private Connection connection =null;
	private PreparedStatement pstmt = null;		
	private ResultSet resultSet= null;
	
	public UserDao(Connection con)
	{
		this.connection = con;
	}
	
	public UserVO getUserDetails(String emailId, String password)
	{
		UserVO userVO = null;
		String query = "select * from user where emailid = ? and password = ?";
		try {
			pstmt = this.connection.prepareStatement(query);
			pstmt.setString(1, emailId);
			pstmt.setString(2, password);
			resultSet = pstmt.executeQuery();
			if(resultSet.next())
			{
				userVO = new UserVO();
				userVO.setId(resultSet.getInt("id"));
				userVO.setUserName(resultSet.getString("username"));
				userVO.setEmailId(resultSet.getString("emailid"));
				userVO.setPassword(resultSet.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return userVO;
	}
	
	
	

}
