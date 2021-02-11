package com.bluzen.acs.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluzen.acs.obj.LoginForm;
import com.bluzen.acs.obj.WebAccount;
import com.bluzen.acs.service.Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Inject
	Service service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String none(HttpServletRequest req,ModelMap model) throws Exception{
		
		return "sign";
	}
	
	@RequestMapping(value = "/sign", method = RequestMethod.GET)
	public String main(HttpServletRequest req,ModelMap model) throws Exception{
		
		return "sign";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(LoginForm lf,HttpServletRequest req,ModelMap model) throws Exception{
		
		HttpSession Session = req.getSession();
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		WebAccount vo = (WebAccount)service.login(lf);
		if(vo != null) {
			Session.setAttribute("User", vo);
			result.put("Code",0);
			result.put("Msg", "Success");
		}else {
			Session.setAttribute("User", null);
			result.put("Code",-1);
			result.put("Msg", "Fail");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
        session.invalidate();
        
        return "redirect:/sign";
	}
}
