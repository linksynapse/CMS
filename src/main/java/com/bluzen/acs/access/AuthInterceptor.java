package com.bluzen.acs.access;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bluzen.acs.obj.WebAccount;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object handler) throws Exception {
		
		WebAccount vo = null;
		
		try 
		{
			HttpSession Session = req.getSession();
			vo = (WebAccount)Session.getAttribute("User");
			
			if(vo != null) {
				return true;
			} else {
				throw new Exception("Require Login");
			}
		}
		catch(Exception e)
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/sign");
            throw new ModelAndViewDefiningException(modelAndView);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}