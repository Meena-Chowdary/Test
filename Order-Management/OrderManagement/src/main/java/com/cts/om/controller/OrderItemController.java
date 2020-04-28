package com.cts.om.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.om.entities.OrderItem;
import com.cts.om.service.OrderItemService;

@RestController
@RequestMapping("/item")
public class OrderItemController {
	@Autowired
	 private OrderItemService service;
	
	@RequestMapping("/all")
	List<OrderItem> getOrderItems() {
	 return	service.getOrderItem();
	}
	
	@RequestMapping(method= RequestMethod.POST ,value="/add")
	void addOrderItem(@RequestBody OrderItem orderitem) {
		service.addOrderItem(orderitem);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateOrderItem(@RequestBody OrderItem orderitem) {
		service.updateOrderItem(orderitem);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteId")
	void deleteOrderItem(@PathVariable Long orderItemId) {
		service.deleteOrderItem(orderItemId);
	}
}
