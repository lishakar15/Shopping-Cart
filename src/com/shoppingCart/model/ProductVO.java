package com.shoppingCart.model;

public class ProductVO {
	
	private int productId;
	private String productName;
	private String price;
	private String category;
	private String imageName;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "ProductDao [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", category=" + category + ", imageName=" + imageName + "]";
	}
	public ProductVO(int productId, String productName, String price, String category, String imageName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.imageName = imageName;
	}
	public ProductVO()
	{
		
	}

}
