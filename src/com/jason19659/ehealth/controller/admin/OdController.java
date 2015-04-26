/**
 * 
 */
package com.jason19659.ehealth.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.ehealth.model.Order;
import com.jason19659.ehealth.service.OrderService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.controller.admin
 *
 * 2015年4月24日
 */
@Controller
@RequestMapping("/admin")
public class OdController {	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/showAllOrders")
	@ResponseBody
	public List<Order> showAll() {
		return orderService.selectAll();
	}
}
