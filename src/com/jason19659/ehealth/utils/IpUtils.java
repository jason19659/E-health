/**
 * 
 */
package com.jason19659.ehealth.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * cn.ichudian.nsapp2.utils
 *
 * 2014年12月2日
 */
public class IpUtils {
	public static String getClientIP(HttpServletRequest request) {   
		String trueIp = request.getRemoteAddr();
		if (!trueIp.equalsIgnoreCase("127.0.0.1") && !trueIp.equalsIgnoreCase("localhost") && !trueIp.equalsIgnoreCase("::1")) {
			return trueIp;
		}
	    String ip = request.getHeader("x-forwarded-for");   
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	        ip = request.getHeader("Proxy-Client-IP");   
	    }   
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	        ip = request.getHeader("WL-Proxy-Client-IP");   
	  
	    }   
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	        ip = request.getRemoteAddr();   
	    }   
	    return ip;   
	} 
}
