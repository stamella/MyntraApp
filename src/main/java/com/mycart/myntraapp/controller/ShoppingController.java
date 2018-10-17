package com.mycart.myntraapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;

import com.mycart.myntraapp.entity.Item;
import com.mycart.myntraapp.entity.Order;
import com.mycart.myntraapp.entity.Product;

@Controller
public class ShoppingController {

	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	private static final String baseUrl = "http://localhost:9090/";
	private static final String baseUrlProduct = "http://10.246.92.147:9090/";
	

	private Random r;
	private List<Item> cartItems;

	public ShoppingController() {
		r = new Random();
		cartItems = new ArrayList<>();
	}

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping(path = "/addtocart")
	public String addToCart(HttpServletRequest request, Model model, @RequestParam int productId, @RequestParam double price) {
		HttpSession session = request.getSession();
		
		boolean present = false;
		for (Item i : cartItems) {
			if (i.getProductId() == productId) {
				i.setQuantity(i.getQuantity()+1);
				present = true;
			}
		}
		if (!present) {
			Item item = new Item(r.nextInt(500) + 500, 1, productId, price);
			cartItems.add(item);
		}
		double total = 0;
		for (Item i : cartItems) {
			total = total + i.getPrice()*i.getQuantity();
		}
		session.setAttribute("cartsize", cartItems.size());
		session.setAttribute("total", total);
		session.setAttribute("customerId", 221700);
		session.setAttribute("cart", cartItems);
		return "index";
	}

	@RequestMapping(path = "/placeorder")
	public String placeOrder(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		double total = (double) session.getAttribute("total");
		int customerId = (int) session.getAttribute("customerId");
		List<Item> items = (List<Item>) session.getAttribute("cart");
		Order order = new Order(r.nextInt(800) + 89898, total, LocalDate.now(), customerId, "Sorry", items);
		order = REST_TEMPLATE.postForObject(baseUrl + "order", order, Order.class);
		System.out.println(order);
		return "redirect:/orders";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, SessionStatus status) {
		HttpSession session = request.getSession();
		session.invalidate();
		status.setComplete();
		cartItems.clear();
		return "index";
	}

	@RequestMapping("/cart")
	public String cart(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		List<Item> items = (List<Item>) session.getAttribute("cart");
		//model.addAttribute("cartItem", items);
		return "cartPage";
	}
	@RequestMapping("/orders")
	public String orderPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		List<Order> orders = (List<Order>) REST_TEMPLATE.getForObject(baseUrl + "customer/orders/"+customerId, Object.class);
		System.out.println(orders);
		model.addAttribute("orders", orders);
		return "ordersPage";
	}
	
	@RequestMapping("/products/search")
	public String productSearch(HttpServletRequest request, Model model, @RequestParam String search) {
		HttpSession session = request.getSession();
		// int customerId = (int) session.getAttribute("customerId");
		
		List<Product> listProducts = (List<Product>) REST_TEMPLATE.getForObject(baseUrlProduct+"product/search?search="+search, Object.class);
		model.addAttribute("searchProduct", listProducts);
		return "index";
	}
	
	@RequestMapping("/orders/cancel")
	public String cancelProduct(HttpServletRequest request, Model model, @RequestParam int orderId) {
		HttpSession session = request.getSession();
		// int customerId = (int) session.getAttribute("customerId");
		
		REST_TEMPLATE.put(baseUrl+"/order/"+orderId+"?status=CANCELLED", Object.class);
	//	model.addAttribute("searchProduct", listProducts);
		return "forward:/orders";
	}
	
	
	
}