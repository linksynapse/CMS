package com.bluzen.acs.view;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluzen.acs.obj.CreateUser;
import com.bluzen.acs.obj.Extension;
import com.bluzen.acs.obj.PermitCard;
import com.bluzen.acs.obj.SearchWorkerResult;
import com.bluzen.acs.obj.UserModify;
import com.bluzen.acs.obj.WebAccount;
import com.bluzen.acs.service.Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	@Inject
	Service service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/implDashboard", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ProjectSite(HttpServletRequest req,ModelMap model) throws Exception{
		
		HttpSession Session = req.getSession();
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		WebAccount vo = (WebAccount)Session.getAttribute("User");
		if(vo == null) {
			result.put("Code",-1);
			result.put("Msg", "Your sesion expired.");
		} else {
			result.put("Code",0);
			result.put("Data",service.getDashboard());
			result.put("Msg", "Success");
		}
		
		return result;
	}
	
	@RequestMapping(value = "/implDashboardEx", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ProjectSiteEx(@RequestParam(defaultValue="")int pjt,HttpServletRequest req,ModelMap model) throws Exception{
		
		HttpSession Session = req.getSession();
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		WebAccount vo = (WebAccount)Session.getAttribute("User");
		if(vo == null) {
			result.put("Code",-1);
			result.put("Msg", "Your sesion expired.");
		} else {
			result.put("Code",0);
			result.put("Data",service.getDashboardEx(pjt));
			result.put("Msg", "Success");
		}
		
		return result;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> EnableUpdate(@RequestParam(defaultValue="")String AuthKey,HttpServletRequest req,ModelMap model) throws Exception{
		
		HttpSession Session = req.getSession();
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		logger.info(AuthKey);
		
		WebAccount vo = (WebAccount)Session.getAttribute("User");
		if(vo == null && vo.getSecurity() > 5) {
			result.put("Code",-1);
			result.put("Msg", "Your sesion expired.");
		} else {	
			result.put("Code", service.setHWupdate(AuthKey));
			result.put("Msg", "Success");
		}
		
		return result;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/crtuser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> creatuser(
			@RequestParam(defaultValue="badge")String badge,
			@RequestParam(defaultValue="nationalid")String nationalid,
			@RequestParam(defaultValue="name")String name,
			@RequestParam(defaultValue="national")int national,
			@RequestParam(defaultValue="gender")int gender,
			@RequestParam(defaultValue="position")int position,
			@RequestParam(defaultValue="company")int company,
			@RequestParam(defaultValue="company")int company_2,
			@RequestParam(defaultValue="camp")int camp,
			@RequestParam(defaultValue="cardnumber")String cardnumber,
			@RequestParam(defaultValue="N/A")String notes,
			@RequestParam(defaultValue="N/A")String mobiles,
			@RequestParam(defaultValue="01/01/99")String DateOfIssuance,
			@RequestParam(value="projectsite[]")List<Integer> projectsite,
			HttpServletRequest req) {
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		try {
			CreateUser UserVo = new CreateUser();
			UserVo.setBadge(badge);
			UserVo.setNationalid(nationalid);
			UserVo.setName(name);
			UserVo.setNational(national);
			UserVo.setGender(gender);
			UserVo.setPosition(position);
			UserVo.setCompany(company);
			UserVo.setCamp(camp);
			UserVo.setCardnumber(cardnumber);
			UserVo.setCompany_2(company_2);
			UserVo.setMobile(mobiles);
			UserVo.setNotes(notes);
			UserVo.setDateOfIssuance(DateOfIssuance);
			
			if(service.createuser(UserVo) != 0) {
				for(int x : projectsite) {
					PermitCard PermitVo = new PermitCard();
					PermitVo.setBadge(UserVo.getBadge());
					PermitVo.setProjectsite(x);
					if(service.permitcard(PermitVo) == 0) {
						throw new Exception();
					}
				}
			}else {
				throw new Exception();
			}
			result.put("Code", 0);
			result.put("Msg", "Create Successful");
			
		} catch(Exception e) {
			result.put("Code",-1);
			result.put("Msg", "Check your infomation something duplicate.");
		}
		return result;
	}
	
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> modifyuser(
			@RequestParam(defaultValue="badge")String badge,
			@RequestParam(defaultValue="nationalid")String nationalid,
			@RequestParam(defaultValue="name")String name,
			@RequestParam(defaultValue="national")int national,
			@RequestParam(defaultValue="gender")int gender,
			@RequestParam(defaultValue="position")int position,
			@RequestParam(defaultValue="company")int company,
			@RequestParam(defaultValue="company")int company_2,
			@RequestParam(defaultValue="camp")int camp,
			@RequestParam(defaultValue="N/A")String notes,
			@RequestParam(defaultValue="N/A")String mobiles,
			@RequestParam(defaultValue="01/01/99")String DateOfIssuance,
			@RequestParam(defaultValue="cardnumber")String cardnumber,
			@RequestParam(value="projectsite[]")List<Integer> projectsite,
			HttpServletRequest req) {
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		try {
			UserModify UserVo = new UserModify();
			UserVo.setBadge(badge);
			UserVo.setNationalid(nationalid);
			UserVo.setName(name);
			UserVo.setNational(national);
			UserVo.setGender(gender);
			UserVo.setPosition(position);
			UserVo.setCompany(company);
			UserVo.setCamp(camp);
			UserVo.setCardnumber(cardnumber);
			UserVo.setPermit(projectsite);
			UserVo.setCompany_2(company_2);
			UserVo.setMobile(mobiles);
			UserVo.setNotes(notes);
			UserVo.setDateOfIssuance(DateOfIssuance);
			
			int r = service.setUserinfomation(UserVo);
			if(r != 0) {
				result.put("Code",r);
				result.put("Msg", "Error");
				return result;
			}
			
			result.put("Code", 0);
			result.put("Msg", "Modify Successful");
			
		} catch(Exception e) {
			result.put("Code",-1);
			result.put("Msg", "Check your infomation something duplicate.");
		}
		return result;
	}
	
	@RequestMapping(value = "/enable", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> enable(@RequestParam(defaultValue="")String badge,HttpServletRequest req,ModelMap model) throws Exception{
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		try {

			int r = service.enableuser(badge);
			if(r == 0) {
				throw new Exception();
			}
			
			result.put("Code", 0);
			result.put("Msg", "Modify Successful");
			
		} catch(Exception e) {
			result.put("Code",-1);
			result.put("Msg", "Check your infomation something duplicate.");
		}
		return result;
	}
	
	@RequestMapping(value = "/disable", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> disable(@RequestParam(defaultValue="")String badge,@RequestParam(defaultValue="")int reason,HttpServletRequest req,ModelMap model) throws Exception{
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		try {

			int r = service.disableuser(badge, reason);
			if(r == 0) {
				throw new Exception();
			}
			
			result.put("Code", 0);
			result.put("Msg", "Modify Successful");
			
		} catch(Exception e) {
			result.put("Code",-1);
			result.put("Msg", "Check your infomation something duplicate.");
		}
		return result;
	}
	
	@RequestMapping(value = "/extUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> extuser(Extension vo,
			HttpServletRequest req,ModelMap model) throws Exception{
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		try {

			int r = service.extensionuser(vo);
			if(r == 0) {
				throw new Exception();
			}
			
			result.put("Code", 0);
			result.put("Msg", "Modify Successful");
			
		} catch(Exception e) {
			result.put("Code",-1);
			result.put("Msg", "Check your infomation something duplicate.");
		}
		return result;
	}
}
