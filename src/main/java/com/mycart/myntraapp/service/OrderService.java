package com.mycart.myntraapp.service;

import java.time.LocalDate;
import java.util.List;

import com.mycart.myntraapp.entity.Order;

public interface OrderService {
	
	public Order submitOrder(Order order);

	public Order updateOrder(Order order);

	public Order cancelOrder(int orderId);

	public Order deleteOrder(int orderId);

	public Order getOrder(int orderId);

	public List<Order> getOrderByCustomerId(int customerId);

	public List<Order> getOrderByDate(LocalDate date);

	public List<Order> getOrders();

}
