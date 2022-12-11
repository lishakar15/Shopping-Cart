package com.shoppingCart.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shoppingCart.model.CartVO;
@WebServlet("/cart-inc-dec")
public class CartIncDecServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		List<CartVO> cartList = (List<CartVO>)request.getSession().getAttribute("cartList");
		if(null!=cartList && !cartList.isEmpty())
		{
			if("increment".equals(action))
			{
				for(CartVO cartVO: cartList)
				{
					if(id == cartVO.getProductId())
					{
						int quantity = cartVO.getQuantity();
						double price= cartVO.getPrice();
						quantity++;
						cartVO.setQuantity(quantity);
						double priceNew=price*quantity; 
						cartVO.setPrice(priceNew);
						response.sendRedirect("Cart.jsp");
					}
				}
			}
			if("decrement".equals(action))
			{
				for(CartVO cartVO: cartList)
				{
					if(id == cartVO.getProductId())
					{
						int quantity = cartVO.getQuantity();
						if(quantity>1)
						{
							quantity--;
							cartVO.setQuantity(quantity);
						}
						response.sendRedirect("Cart.jsp");
					}
				}
			}
		}
		else
		{
			response.sendRedirect("Cart.jsp");
		}
	}
}
