/**
 * 
 */
package com.jason19659.ehealth.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.service.LuceneService;
import com.jason19659.ehealth.service.MedicinalService;
import com.jason19659.ehealth.utils.LuceneUtil;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 *         com.jason19659.ehealth.controller.admin
 *
 *         2015年4月26日
 */
@Controller
public class LuceneController {
	
	@Autowired
	private LuceneService luceneService;

	@RequestMapping("/admin/reIndex")
	public String createIndex() {
		luceneService.createIndex();
		return "redirect:/admin/medicinal.html";
	}
	
	@RequestMapping("/search")
	public List<Medicinal> search(String query) {
		return luceneService.search(query);
	}
}
