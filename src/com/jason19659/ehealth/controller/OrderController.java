/**
 * 
 */
package com.jason19659.ehealth.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.model.MedicinalDto;
import com.jason19659.ehealth.model.Order;
import com.jason19659.ehealth.model.OrderDetail;
import com.jason19659.ehealth.model.User;
import com.jason19659.ehealth.service.MedicinalService;
import com.jason19659.ehealth.service.OrderDetailService;
import com.jason19659.ehealth.service.OrderService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.controller
 *
 * 2015年4月24日
 */
@Controller
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private MedicinalService service;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	
	@RequestMapping("/{medicinal_id}")
	public String orderGWC(@PathVariable String medicinal_id,HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		HttpSession session = request.getSession();
		if (session.getAttribute("isLogin") == null || !(Boolean)session.getAttribute("isLogin")) {
			return "redirect:"+basePath+"login.html";
		} else {
			LinkedList<MedicinalDto> medicinals;
			Medicinal m = service.selectByPrimaryKey(medicinal_id);
			MedicinalDto medicinalDto = new MedicinalDto(m);
			boolean flag = false;
			if (session.getAttribute("gwc") == null) {
				medicinals = new LinkedList<MedicinalDto> ();
				medicinals.add(medicinalDto);
				session.setAttribute("gwc", medicinals);
			}  else {
				medicinals  = (LinkedList<MedicinalDto>)  session.getAttribute("gwc") ;
				for (int i = 0; i < medicinals.size(); i++) {
					System.out.println(medicinals.get(i).getId());
					System.out.println(":"+medicinal_id);
					if (medicinals.get(i).getId().equals(medicinal_id) ) {
						medicinals.get(i).setAmount(medicinals.get(i).getAmount()+1);
						flag = true;
					}
				} 
				if(!flag) {
					medicinalDto.setAmount(1);
					medicinals.add(medicinalDto);
				}
				session.setAttribute("gwc", medicinals);
			}
		}
		
		return "redirect:"+basePath+"gwc.jsp";
	}
	@RequestMapping("/preSubmitOrder")
	public String preSubmitOrder(MedicinalDto med,HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String button = request.getParameter("button");
		HttpSession session = request.getSession();
		LinkedList<MedicinalDto> meds = (LinkedList<MedicinalDto>)  session.getAttribute("gwc") ;
		if (button.equals("确认")) {
			for (int i = 0 ; i < meds.size();i++) {
				if (meds.get(i).getId().equals(med.getId())) {
					meds.get(i).setAmount(med.getAmount());
				} 
			}
		}
		if (button.equals("删除")) {
			for (int i = 0 ; i < meds.size();i++) {
				if (meds.get(i).getId().equals( med.getId())) {
					meds.remove(i);
				}
			}
		}
		return "redirect:"+basePath+"gwc.jsp";
	}
	@RequestMapping("/submitOrder")
	public String submitOrder(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String button = request.getParameter("button");
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		if (button.equals("提交订单")) {
			if (!StringUtils.isEmpty(address)) {
				User u = (User)session.getAttribute("user");
				u.setAddress(address);
				session.setAttribute("user", u);
				return "redirect:"+basePath+"/api/order/orderDetail";
			}
		}
		return "redirect:"+basePath+"index.html";
	}
	
	@RequestMapping("/orderDetail")
	public String orderDetail(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String address = request.getParameter("address");
		String reOK = request.getParameter("reOK");
		HttpSession session = request.getSession();
		if ("确认".equals(reOK)) {
			//生成订单
			User user = (User)session.getAttribute("user");
			Order order =  new Order();
			String orderId = UUID.randomUUID().toString();
			//生成Order
			order.setIsValid(true);
			order.setPubdate(new Date());
			order.setId(orderId);
			order.setOrderId(orderId);
			order.setUserId(user.getId());
			order.setIsDeal(false);
			
			BigDecimal price = new BigDecimal(0);
			//生成Order detaile
			LinkedList<MedicinalDto> medicinals = (LinkedList<MedicinalDto>)  session.getAttribute("gwc");
			for (int i = 0; i < medicinals.size(); i++) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setMedicinalId(medicinals.get(i).getId());
					orderDetail.setId(UUID.randomUUID().toString());
					orderDetail.setUserId(user.getId());
					orderDetail.setPrice(medicinals.get(i).getPrice());
					orderDetail.setOrderId(orderId);
					orderDetail.setAmount(medicinals.get(i).getAmount());
					orderDetailService.insert(orderDetail);
					price.add(medicinals.get(i).getPrice());
			}
			order.setPrice(price);
			order.setDetail("系统时间:"+new Date() +"id为"+user.getId()+"的用户下订单,总金额"+price+"元");
			orderService.insert(order);
			session.removeAttribute("gwc");
			session.setAttribute("msg", "下单成功,请等待工作人员于你联系");
			return "/information";
		} else {
			LinkedList<MedicinalDto> medicinals = (LinkedList<MedicinalDto>)  session.getAttribute("gwc");
			BigDecimal total = new BigDecimal(0);
			for (int i = 0 ; i < medicinals.size();i++) {
			
					BigDecimal b =  medicinals.get(i).getPrice().multiply(new BigDecimal(medicinals.get(i).getAmount()));
					total = total.add(b);
			}
			System.out.println(total);
			session.setAttribute("total", total);
			return "redirect:"+basePath+"orderDetail.jsp";
		}
	}
}
