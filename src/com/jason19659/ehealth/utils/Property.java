package com.jason19659.ehealth.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * net.team42.jason.robot.util
 *
 * 2014年5月28日
 */
public class Property {
	public static final Properties properties;
	
	private Property() {
	}
	
	static {
		 // 生成文件对象  
	    File pf = null;
		try {
			pf = new File(Property.class.getClassLoader().getResource("").toURI().getPath()+"project.properties");
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}  

	    // 生成文件输入流  
	    FileInputStream inpf = null;
	    try {  
	        inpf = new FileInputStream(pf);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  

	    // 生成properties对象  
	    properties = new Properties();  
	    System.out.println("配置文件载入成功");
	    try {  
	    	properties.load(inpf);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
	public static final Integer bannerImageWidth =Integer.parseInt(properties.getProperty("bannerImageWidth"));
	public static final Integer bannerImageHeight = Integer.parseInt(properties.getProperty("bannerImageHeight"));
	public static final Integer storeImageWidth = Integer.parseInt(properties.getProperty("storeImageWidth"));
	public static final Integer storeImageHeight = Integer.parseInt(properties.getProperty("storeImageHeight"));
	public static final Integer foodImageWidth = Integer.parseInt(properties.getProperty("foodImageWidth"));
	public static final Integer foodImageHeight = Integer.parseInt(properties.getProperty("foodImageHeight"));
		
}
