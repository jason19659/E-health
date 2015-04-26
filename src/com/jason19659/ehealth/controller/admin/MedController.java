/**
 * 
 */
package com.jason19659.ehealth.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String add(Medicinal medicinal,HttpServletRequest request,@RequestParam MultipartFile imageFile) throws IOException {
		medicinal.setId(UUID.randomUUID().toString());
		medicinal.setPubdate(new Date());
		medicinal.setImage(upload(request, imageFile, medicinal.getId()));
		Service.insert(medicinal);
		return "redirect:/admin/medicinal.html";
	}
	
	@RequestMapping("/delMedicinal")
	public String delete(String id,HttpServletRequest request) {
		Service.deleteByPrimaryKey(id);
		return "redirect:/admin/medicinal.html";
	}
	
	@RequestMapping("/alertMedicinal")
	public String alert(Medicinal medicinal,HttpServletRequest request,@RequestParam MultipartFile imageFile) throws IOException {
		medicinal.toAlert();
		if (imageFile != null) {
			String imagePath = upload(request, imageFile, medicinal.getId());
			medicinal.setImage(imagePath);
		}
		Service.updateByPrimaryKeySelective(medicinal);
		return "redirect:/admin/medicinal.html";
	}
	
	private String upload(HttpServletRequest request,@RequestParam MultipartFile image,String id) throws IOException {
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			String Filename = id+image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".")) ;
			FileUtils.copyInputStreamToFile(image.getInputStream(), new File(realPath,Filename));
			
			return (basePath + "/upload/"+ Filename);
			
		
	}
	
}
