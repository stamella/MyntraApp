package com.mycart.myntraapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mycart.myntraapp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

	@Query("{'customerId': ?0}")
	public List<Order> findByCustomerId(int customerId);
}
