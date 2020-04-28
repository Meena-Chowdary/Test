package com.cts.om.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.om.entities.Order;
import com.cts.om.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService service;
	
	@RequestMapping("/all")
	List<Order> getOrder(){
		return service.getorders();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
	void addOrder(@RequestBody Order order) {
		service.addOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateOrder(@RequestBody Order order) {
		service.updateOrder(order);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteId")
	void deleteOrder(@PathVariable Long orderId) {
		service.deleteOrder(orderId);
	}

}
