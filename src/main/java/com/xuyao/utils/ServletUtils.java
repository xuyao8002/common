package com.xuyao.utils;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ServletUtils {

	/** project url */
	public static final String PROJECT_URL = "projectUrl";

	/** base url */
	public static final String PROJECT_BASE_URL = "baseUrl";

	/**
	 * 获取项目访问路径：http://localhost:8080/xxxx
	 * @param request
	 * @return
	 */
    public static String getProjectUrl(HttpServletRequest request){
    	ServletContext servletContext = request.getServletContext();
    	return (String) servletContext.getAttribute(PROJECT_URL);
    }
    
    public static void setProjectUrls(HttpServletRequest request){
    	String url = request.getScheme() +"://" + request.getServerName()  
	        + ":" +request.getServerPort();
    	ServletContext servletContext = request.getServletContext();
    	servletContext.setAttribute(PROJECT_BASE_URL, url);
    	servletContext.setAttribute(PROJECT_URL, url + request.getContextPath());
    }
    
    /**
     * 获取项目访问根路径：http://localhost:8080
     * @param request
     * @return
     */
    public static String getBaseUrl(HttpServletRequest request){
    	ServletContext servletContext = request.getServletContext();
    	return (String) servletContext.getAttribute(PROJECT_BASE_URL);
    }
    
}