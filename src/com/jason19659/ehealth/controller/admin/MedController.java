/**
 * 
 */
package com.jason19659.ehealth.controller.admin;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.service.MedicinalService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.controller.admin
 *
 * 2015年4月23日
 */
@Controller
@RequestMapping("/admin")
public class MedController {
	@Autowired
	private MedicinalService Service; 
	
	
	@RequestMapping("/addMedicinal")
	public String add(Medicinal medicinal,HttpServletRequest request) {
		medicinal.setId(UUID.randomUUID().toString());
		medicinal.setPubdate(new Date());
		Service.insert(medicinal);
		return "redirect:/admin/medicinal.html";
	}
	
	@RequestMapping("/delMedicinal")
	public String delete(String id,HttpServletRequest request) {
		Service.deleteByPrimaryKey(id);
		return "redirect:/admin/medicinal.html";
	}
	
	@RequestMapping("/alertMedicinal")
	public String alert(Medicinal medicinal,HttpServletRequest request) {
		medicinal.toAlert();
		Service.updateByPrimaryKeySelective(medicinal);
		return "redirect:/admin/medicinal.html";
	}
	
	
}
