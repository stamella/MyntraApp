package com.mycart.myntraapp.entity;

import java.util.Objects;

public class Item {
	private int itemId;
	private int quantity;
	private int productId;
	private double price;

	public Item() {
		super();
	}

	public Item(int itemId, int quantity, int productId, double price) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.productId = productId;
		this.price = price;
	}


	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;

		if (productId != other.productId)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", quantity=" + quantity + ", productId=" + productId + ", price=" + price
				+ "]";
	}
	
	

}