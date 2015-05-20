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
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		Medicinal m = service.selectByPrimaryKey(medicinal_id);
		m.setImage(basePath + m.getImage());
		return m;
	}
	
	@RequestMapping("/showAll")
	@ResponseBody
	public List<Medicinal> showAll(HttpServletRequest request) {
		
		return doImages(service.selectAll(), request);
	}
	
	@RequestMapping("/showTop10")
	@ResponseBody
	public List<Medicinal> showTop10(HttpServletRequest request) {
		return  doImages(service.selectTop10(),request);
	}
	
	@RequestMapping("/showTop5")
	@ResponseBody
	public List<Medicinal> showTop5(HttpServletRequest request) {
		return  doImages(service.selectTop5(),request);
	}
	@RequestMapping("/showMost4")
	@ResponseBody
	public List<Medicinal> showMost4(HttpServletRequest request) {
		return  doImages(service.selectMost4(),request);
	}
	
	private List<Medicinal> doImages(List<Medicinal> l,HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		List<Medicinal> ms = service.selectAll();
		for (Medicinal m : ms) {
			m.setImage(basePath + m.getImage());
		}
		return ms;
	}
}
