package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCart.model.ProductVO;

public class ProductDao {
	private Connection connection =null;
	private PreparedStatement pstmt = null;		
	private ResultSet resultSet= null;

	public ProductDao(Connection con)
	{
		this.connection=con;
	}
	public List<ProductVO> getProductDetails()
	{
		ProductVO productVO = null;
		List<ProductVO> productList = new ArrayList<>();
		String query = "select * from product";
		try {
			pstmt = this.connection.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				productVO = new ProductVO();
				productVO.setProductId(resultSet.getInt("productid"));
				productVO.setProductName(resultSet.getString("productname"));
				productVO.setCategory(resultSet.getString("category"));
				productVO.setPrice(resultSet.getString("price"));
				productVO.setImageName(resultSet.getString("imagename"));
				productList.add(productVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return productList;
	}
}
