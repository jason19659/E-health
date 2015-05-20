/**
 * 
 */
package com.jason19659.ehealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.service.LuceneService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 *         com.jason19659.ehealth.controller.admin
 *
 *         2015年4月26日
 */
@Controller
@RequestMapping("/")
public class LuceneController {
	
	@Autowired
	private LuceneService luceneService;

	@RequestMapping("/admin/reIndex")
	public String createIndex() {
		luceneService.createIndex();
		return "redirect:/admin/medicinal.html";
	}
	
	@RequestMapping("/api/search")
	@ResponseBody
	public List<Medicinal> search(String query) {
		return luceneService.search(query);
	}
}
