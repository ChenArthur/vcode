package com.val.code.nocache;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCaptchaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  
	
    @Override  
    protected void doGet(HttpServletRequest reqeust,  
            HttpServletResponse response) throws ServletException, IOException {  
        this.doPost(reqeust, response);  
    }  
  
    protected void doPost(HttpServletRequest reqeust,  
            HttpServletResponse response) throws ServletException, IOException {  
        // 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        // 禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        SCaptcha instance = new SCaptcha();  
        Cookie cookie = new Cookie("scaptcha", instance.getCode());  
        cookie.setMaxAge(1800);  
        response.addCookie(cookie);  
        instance.write(response.getOutputStream());  
    }
}
