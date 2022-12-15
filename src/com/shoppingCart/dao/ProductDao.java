package com.shoppingCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import com.shoppingCart.model.CartVO;
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
				productVO.setPrice(resultSet.getDouble("price"));
				productVO.setImageName(resultSet.getString("imagename"));
				productList.add(productVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		return productList;
	}
	public List<CartVO> getProductDetailsById(List<CartVO> cartList)
	{
		List<CartVO> cartProductList = null;
		CartVO cartVONew = null;
		if(null != cartList && cartList.size()>0)
		{
			cartProductList = new ArrayList<>();
			Iterator<CartVO> itr = cartList.iterator();
			while(itr.hasNext())
			{
				CartVO cartVO =  itr.next();
				String query ="select * from product where productid =?";
				try {
					pstmt = this.connection.prepareStatement(query);
					pstmt.setInt(1,cartVO.getProductId());
					resultSet = pstmt.executeQuery();
					while(resultSet.next())
					{
						cartVONew = new CartVO();
						cartVONew.setCategory(resultSet.getString("category"));
						cartVONew.setPrice(resultSet.getDouble("Price"));
						cartVONew.setProductId(resultSet.getInt("productid"));
						cartVONew.setProductName(resultSet.getString("productname"));
						cartVONew.setQuantity(cartVO.getQuantity());
						cartVONew.setImageName(resultSet.getString("imagename"));
						cartProductList.add(cartVONew);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		return cartProductList;
		
	}
}
