package org.jerry.light4j.member.common.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	public static String getIpAddr(HttpServletRequest request){  
         String ipAddress = null;  
         ipAddress = request.getHeader("x-forwarded-for");  
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
         ipAddress = request.getHeader("Proxy-Client-IP");  
         }  
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
             ipAddress = request.getHeader("WL-Proxy-Client-IP");  
         }  
         if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
             ipAddress = request.getRemoteAddr();  
         }  
         if(ipAddress!=null && ipAddress.length()>15){
             if(ipAddress.indexOf(",")>0){  
                 ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
             }  
         }  
         return ipAddress;   
    }  
	
	public static String getRequestPort(HttpServletRequest request){
		return request.getLocalPort()+""; 
	}
}
