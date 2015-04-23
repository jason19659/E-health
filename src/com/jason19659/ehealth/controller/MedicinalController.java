/**
 * 
 */
package com.jason19659.ehealth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.service.MedicinalService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.controller
 *
 * 2015年4月22日
 */
@Controller
@RequestMapping("/api/medicinal")
public class MedicinalController {
	@Autowired
	private MedicinalService service;
	
	@RequestMapping("/get/{medicinal_id}")
	@ResponseBody
	public Medicinal get(@PathVariable String medicinal_id,HttpServletRequest request) {
		return service.selectByPrimaryKey(medicinal_id);
	}
	
	@RequestMapping("/showAll")
	@ResponseBody
	public List<Medicinal> showAll() {
		return service.selectAll();
	}
	
	@RequestMapping("/showTop10")
	@ResponseBody
	public List<Medicinal> showTop10() {
		return service.selectTop10();
	}
	
	@RequestMapping("/showTop5")
	@ResponseBody
	public List<Medicinal> showTop5() {
		return service.selectTop5();
	}
	@RequestMapping("/showMost4")
	@ResponseBody
	public List<Medicinal> showMost4() {
		return service.selectMost4();
	}
}
