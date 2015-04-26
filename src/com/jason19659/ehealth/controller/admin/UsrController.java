/**
 * 
 */
package com.jason19659.ehealth.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.model.User;
import com.jason19659.ehealth.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.controller.admin
 *
 * 2015年4月23日
 */
@Controller
@RequestMapping("/admin")
public class UsrController {
	@Autowired
	private UserService service; 
	
	@RequestMapping("/showAllUser")
	@ResponseBody
	public List<User> showAll() {
		return service.selectAll();
	}
	
	@RequestMapping("/delUser")
	public String delete(String id,HttpServletRequest request) {
		service.deleteByPrimaryKey(id);
		return "redirect:/admin/user.html";
	}
	
	@RequestMapping("/grantUserToAdmin")
	public String a(String id,HttpServletRequest request) {
		
		User u = service.selectByPrimaryKey(id);
		u.setComptence("admin");
		service.updateByPrimaryKeySelective(u);
		return "redirect:/admin/user.html";
	}
	
	@RequestMapping("/grantUserToRoot")
	public String r(String id,HttpServletRequest request) {
		User u = service.selectByPrimaryKey(id);
		u.setComptence("root");
		service.updateByPrimaryKeySelective(u);
		return "redirect:/admin/user.html";
	}
	
	@RequestMapping("/cancelUserGrant")
	public String b(String id,HttpServletRequest request) {
		User u = service.selectByPrimaryKey(id);
		u.setComptence("user");
		service.updateByPrimaryKeySelective(u);
		return "redirect:/admin/user.html";
	}
}
