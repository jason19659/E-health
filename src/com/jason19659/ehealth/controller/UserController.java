/**
 * 
 */
package com.jason19659.ehealth.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.ehealth.model.User;
import com.jason19659.ehealth.service.UserService;
import com.jason19659.ehealth.utils.EncodeUtil;
import com.jason19659.ehealth.utils.ReplaceSpecialString;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.controller
 *
 * 2015年4月19日
 */
@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request) {
		User daoUser = userService.selectByUsername(user.getUsername());
		if (user.getUsername() == null || user.getPassword() == null) {
			return "redirect:/index.html";
		}
		if (daoUser == null) {
			request.getSession().setAttribute("errMsg", "用户名不存在");
			return "/information.html";
		} else if (EncodeUtil.checkPassword(user.getPassword(), daoUser.getPassword())) {
			request.getSession().setAttribute("errMsg", "密码错误");
			return "/information.html";
		} else  {
			request.getSession().setAttribute("user", daoUser);
			request.getSession().setAttribute("isLogin", true);
			if (daoUser.getComptence().equals("admin")) {
				return "redirect:/admin";
			}
		}
		
		return "redirect:/index.html";
	}
	
	
	@RequestMapping("/register")
	public String register(User u,HttpServletRequest req) {
		u.setUsername(ReplaceSpecialString.replaceTag(u.getUsername()));
		u.setId(UUID.randomUUID().toString());
		User dUser = userService.selectByUsername(u.getUsername());
		if (!req.getParameter("repassword").equals(u.getPassword())) {
			req.getSession().setAttribute("errMsg", "请输入一致的密码");
			System.out.println("请输入一致的密码");
			return "redirect:/register.html";
		}
		if (dUser != null) {
			req.getSession().setAttribute("errMsg", "用户名已存在");
			System.out.println("用户名已存在");
			return "redirect:/register.html";
		} else {
			u.setPassword(EncodeUtil.encodePassword(u.getPassword()));
			u.setComptence("user");
			userService.insert(u);
			req.getSession().setAttribute("user", userService.selectByUsername(u.getUsername()));
			req.getSession().setAttribute("isLogin", true);
		}
		return "redirect:/index.html";
	}
	
	@RequestMapping("/usercheck")
	@ResponseBody
	public String index(HttpServletRequest request) {
		try {
			String username = request.getParameter("username");
			User user = userService.selectByUsername(username);
			if (username == null || username.equals("")) {
				return "用户名已存在";
			}
			if (user != null) {
				return "用户名已存在";
			}
		} catch (Exception e) {
			return "检测异常";
		}
		
		return "用户名可用";
	}
	
	@RequestMapping("/isLogin")
	@ResponseBody
	public User isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") != null && !session.getAttribute("user").equals("")) {
			if (session.getAttribute("isLogin") != null && (Boolean)session.getAttribute("isLogin")) {
				return (User) session.getAttribute("user");
			}
		}
		return null;
	}
	
	@RequestMapping("/quit")
	public String quit(HttpServletRequest request) {
		request.getSession().setAttribute("user", "");
		request.getSession().setAttribute("isLogin", false);
		return "redirect:/index.html";
	}
}
