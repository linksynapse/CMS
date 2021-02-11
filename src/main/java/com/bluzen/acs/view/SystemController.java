package com.bluzen.acs.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

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

import com.bluzen.acs.obj.Category;
import com.bluzen.acs.obj.CreateUser;
import com.bluzen.acs.obj.HardwareInfo;
import com.bluzen.acs.obj.PermitCard;
import com.bluzen.acs.obj.Product;
import com.bluzen.acs.obj.SearchIORequest;
import com.bluzen.acs.obj.SearchWorkerResult;
import com.bluzen.acs.obj.WebAccount;
import com.bluzen.acs.service.Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SystemController {
	
	private static final Logger logger = LoggerFactory.getLogger(SystemController.class);
	@Inject
	Service service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(HttpServletRequest req,ModelMap model) throws Exception{
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		model.addAttribute("Security", wa.getSecurity());
		return "dashboard";
	}
	
	@RequestMapping(value = "/dashboard_detail", method = RequestMethod.GET)
	public String dashboard_detail(@RequestParam(defaultValue="")int pjt,HttpServletRequest req,ModelMap model) throws Exception{
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		for(Product p : service.getProjectsite()) {
			if(p.getValue() == pjt) {
				model.addAttribute("PageName", p.getName());
				model.addAttribute("ProjectCode", p.getValue());
				break;
			}
		}
		
		model.addAttribute("Security", wa.getSecurity());
		return "dashboard_detail";
	}
	
	@RequestMapping(value = "/searchWorker", method = RequestMethod.GET)
	public String searchWorker(
			@RequestParam(defaultValue="")String Badge,
			@RequestParam(defaultValue="")String NationalID,
			@RequestParam(defaultValue="")String Name,
			@RequestParam(defaultValue="")String Nationality,
			@RequestParam(defaultValue="")String Gender,
			@RequestParam(defaultValue="")String Position,
			@RequestParam(defaultValue="")String Company,
			@RequestParam(defaultValue="")String Camp,
			@RequestParam(defaultValue="")String Status,
			@RequestParam(defaultValue="")String Location,
			@RequestParam(defaultValue="")String Company_2,
			@RequestParam(defaultValue="")String Mobile,
			@RequestParam(defaultValue="")String CardNumber,
			@RequestParam(defaultValue="")String Notes,
			@RequestParam(defaultValue="99")int Used,
			HttpServletRequest req,ModelMap model) throws Exception{
		
		SearchWorkerResult sr = new SearchWorkerResult();
		sr.setBadge(Badge);
		sr.setNationalID(NationalID);
		sr.setName(Name);
		sr.setNationality(Nationality);
		sr.setGender(Gender);
		sr.setPosition(Position);
		sr.setCompany(Company);
		sr.setCamp(Camp);
		sr.setStatus(Status);
		sr.setLocation(Location);
		sr.setSubContractor(Company_2);
		sr.setMobile(Mobile);
		sr.setCardNumber(CardNumber);
		sr.setNotes(Notes);
		sr.setUsed(Used);
		
		List<SearchWorkerResult> lsr = null;
		if(Badge.isEmpty() && NationalID.isEmpty() && Name.isEmpty() && Nationality.isEmpty() && Gender.isEmpty() && Position.isEmpty() && Company.isEmpty() && Camp.isEmpty() && Status.isEmpty() && Location.isEmpty() && Company_2.isEmpty() && Mobile.isEmpty() && CardNumber.isEmpty() && Notes.isEmpty() && Used == 99) {
			lsr = service.getWorkerSearchlimit(sr);
		}else {
			lsr = (List<SearchWorkerResult>)service.getWorkerSearch(sr);
		}
		
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		model.addAttribute("Security", wa.getSecurity());
		model.addAttribute("Workers", lsr);
		
		return "searchworker";
	}
	
	@RequestMapping(value = "/searchIO", method = RequestMethod.GET)
	public String searchIO(
			@RequestParam(defaultValue="")String Badge,
			@RequestParam(defaultValue="")String Name,
			@RequestParam(defaultValue="")String Company,
			@RequestParam(defaultValue="")String Type,
			@RequestParam(defaultValue="")String Region,
			@RequestParam(defaultValue="")String Location,
			@RequestParam(defaultValue="")String Start,
			@RequestParam(defaultValue="")String End,
			Locale locale,
			HttpServletRequest req,ModelMap model) throws Exception{
		
		boolean limitFlag = false;
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
	    String EndDate = sdfDate.format(Date.from(now.toInstant().plus(Duration.ofHours(7))));
	    String StartDate = sdfDate.format(Date.from(now.toInstant().plus(Duration.ofHours(6))));
		
	    SearchIORequest sr = new SearchIORequest();
		sr.setBadge(Badge);
		sr.setName(Name);
		sr.setCompany(Company);
		sr.setType(Type);
		sr.setRegion(Region);
		sr.setLocation(Location);
		if(Start.isEmpty()) {
			limitFlag = true;
			Start = StartDate;
		}else {
			logger.info(Start);
		}
		sr.setStart(Start);
		if(End.isEmpty()) {
			limitFlag = true;
			End = EndDate;
		}else {
			logger.info(End);
		}
		sr.setEnd(EndDate);
		
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		model.addAttribute("Security", wa.getSecurity());
		if(limitFlag) {
			model.addAttribute("Historys", service.getIOSearchLimit(sr));
		}else {
			model.addAttribute("Historys", service.getIOSearch(sr));
		}
		
		
		return "searchio";
	}
	
	@RequestMapping(value = "/hardware", method = RequestMethod.GET)
	public String hardware(HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		List<HardwareInfo> hi = (List<HardwareInfo>)service.getHardware();
		for(int i = 0;i< hi.size();i++) {
			HardwareInfo dummy = hi.get(i);
			dummy.setAction("<button class=\"btn btn-primary\" value=\"Apply\" OnClick=\"javascript:update(\'"
					+ dummy.getAuthKey() + "\')\" type=\"submit\">Sync User</button>");
			hi.set(i, dummy);
		}
		
		model.addAttribute("Security", wa.getSecurity());
		model.addAttribute("Hardwares", hi);
		
		return "hardware";
	}
	
	@RequestMapping(value = "/addAccount", method = RequestMethod.GET)
	public String createaccount(HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		model.addAttribute("National", service.getNationality());
		model.addAttribute("Gender", service.getGender());
		model.addAttribute("Position",service.getPosition());
		model.addAttribute("Company", service.getCompany());
		model.addAttribute("Camp", service.getCamp());
		model.addAttribute("ProjectSite",service.getProjectsite());
		model.addAttribute("Security", wa.getSecurity());
		
		return "createaccount";
	}
	
	@RequestMapping(value = "/mgruser", method = RequestMethod.GET)
	public String manageruser(
			@RequestParam(defaultValue="")String Badge,
			@RequestParam(defaultValue="")String NationalID,
			@RequestParam(defaultValue="")String Name,
			@RequestParam(defaultValue="")String Nationality,
			@RequestParam(defaultValue="")String Gender,
			@RequestParam(defaultValue="")String Position,
			@RequestParam(defaultValue="")String Company,
			@RequestParam(defaultValue="")String Camp,
			@RequestParam(defaultValue="")String Status,
			@RequestParam(defaultValue="")String Location,
			@RequestParam(defaultValue="")String Company_2,
			@RequestParam(defaultValue="")String Mobile,
			@RequestParam(defaultValue="")String CardNumber,
			@RequestParam(defaultValue="")String Notes,
			@RequestParam(defaultValue="99")int Used,
			HttpServletRequest req,ModelMap model) throws Exception{
		
		SearchWorkerResult sr = new SearchWorkerResult();
		sr.setBadge(Badge);
		sr.setNationalID(NationalID);
		sr.setName(Name);
		sr.setNationality(Nationality);
		sr.setGender(Gender);
		sr.setPosition(Position);
		sr.setCompany(Company);
		sr.setCamp(Camp);
		sr.setStatus(Status);
		sr.setLocation(Location);
		sr.setSubContractor(Company_2);
		sr.setMobile(Mobile);
		sr.setCardNumber(CardNumber);
		sr.setNotes(Notes);
		sr.setUsed(Used);
		
		List<SearchWorkerResult> lsr = null;
		if(Badge.isEmpty() && NationalID.isEmpty() && Name.isEmpty() && Nationality.isEmpty() && Gender.isEmpty() && Position.isEmpty() && Company.isEmpty() && Camp.isEmpty() && Status.isEmpty() && Location.isEmpty() && Company_2.isEmpty() && Mobile.isEmpty() && CardNumber.isEmpty() && Notes.isEmpty() && Used == 99) {
			lsr = service.getWorkerSearchlimit(sr);
		}else {
			lsr = (List<SearchWorkerResult>)service.getWorkerSearch(sr);
		}
		
		
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		model.addAttribute("Security", wa.getSecurity());
		model.addAttribute("Workers", lsr);
		
		return "manageuser";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String userprofile(@RequestParam(defaultValue="")String Badge,HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		model.addAttribute("Userinfo",service.getUserinfomation(Badge));
		model.addAttribute("National", service.getNationality());
		model.addAttribute("Gender", service.getGender());
		model.addAttribute("Position",service.getPosition());
		model.addAttribute("Company", service.getCompany());
		model.addAttribute("Camp", service.getCamp());
		model.addAttribute("ProjectSite",service.getProjectsite());
		model.addAttribute("Security", wa.getSecurity());
		return "profile";
	}
	
	@RequestMapping(value = "/camp", method = RequestMethod.GET)
	public String modifyCamp(
			@RequestParam(defaultValue="5")int category,
			@RequestParam(defaultValue="N/A")String name,
			@RequestParam(defaultValue="N/A")String shortcut,
			@RequestParam(defaultValue="5")int action,
			HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		Category cg = new Category();
		cg.setAddress("N/A");
		cg.setName(name);
		cg.setProductCodeNumber(category);
		cg.setShortCut(shortcut);
		
		switch(action) {
			case 1:
				service.InsertCamp(cg);
				model.addAttribute("msg","Create successfully.");
				break;
				
			case 2:
				service.UpdateCamp(cg);
				model.addAttribute("msg","Update successfully.");
				break;
				
			case 3:
				try {
					service.DeleteCamp(cg);
					model.addAttribute("msg","Delete successfully.");
				}catch(Exception e){
					model.addAttribute("msg","Can not remove category because relationship");
				}
				break;
				
			default:
				break;
		}
		
		model.addAttribute("Name", "Management Camp");
		model.addAttribute("data", service.getCamp());
		model.addAttribute("Security", wa.getSecurity());
		return "category";
	}
	
	@RequestMapping(value = "/nationality", method = RequestMethod.GET)
	public String modifyNationality(
			@RequestParam(defaultValue="5")int category,
			@RequestParam(defaultValue="N/A")String name,
			@RequestParam(defaultValue="N/A")String shortcut,
			@RequestParam(defaultValue="5")int action,
			HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		Category cg = new Category();
		cg.setAddress("N/A");
		cg.setName(name);
		cg.setProductCodeNumber(category);
		cg.setShortCut(shortcut);
		
		switch(action) {
			case 1:
				service.InsertNationality(cg);
				model.addAttribute("msg","Create successfully.");
				break;
				
			case 2:
				service.UpdateNationality(cg);
				model.addAttribute("msg","Update successfully.");
				break;
				
			case 3:
				try {
					service.DeleteNationality(cg);
					model.addAttribute("msg","Delete successfully.");
				}catch(Exception e){
					model.addAttribute("msg","Can not remove category because relationship");
				}
				break;
				
			default:
				break;
		}
		
		model.addAttribute("Name", "Management Nationality");
		model.addAttribute("data", service.getNationality());
		model.addAttribute("Security", wa.getSecurity());
		return "category";
	}
	
	@RequestMapping(value = "/position", method = RequestMethod.GET)
	public String modifyPosition(
			@RequestParam(defaultValue="5")int category,
			@RequestParam(defaultValue="N/A")String name,
			@RequestParam(defaultValue="N/A")String shortcut,
			@RequestParam(defaultValue="5")int action,
			HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		Category cg = new Category();
		cg.setAddress("N/A");
		cg.setName(name);
		cg.setProductCodeNumber(category);
		cg.setShortCut(shortcut);
		
		switch(action) {
			case 1:
				service.InsertPosition(cg);
				model.addAttribute("msg","Create successfully.");
				break;
				
			case 2:
				service.UpdatePosition(cg);
				model.addAttribute("msg","Update successfully.");
				break;
				
			case 3:
				try {
					service.DeletePosition(cg);
					model.addAttribute("msg","Delete successfully.");
				}catch(Exception e){
					model.addAttribute("msg","Can not remove category because relationship");
				}
				break;
				
			default:
				break;
		}
		
		model.addAttribute("Name", "Management Position");
		model.addAttribute("data", service.getPosition());
		model.addAttribute("Security", wa.getSecurity());
		return "category";
	}
	
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String modifyCompany(
			@RequestParam(defaultValue="5")int category,
			@RequestParam(defaultValue="N/A")String name,
			@RequestParam(defaultValue="N/A")String shortcut,
			@RequestParam(defaultValue="5")int action,
			HttpServletRequest req,ModelMap model) throws Exception {
		HttpSession Session = req.getSession();
		WebAccount wa = (WebAccount)Session.getAttribute("User");
		
		Category cg = new Category();
		cg.setAddress("N/A");
		cg.setName(name);
		cg.setProductCodeNumber(category);
		cg.setShortCut(shortcut);
		
		switch(action) {
			case 1:
				service.InsertCompany(cg);
				model.addAttribute("msg","Create successfully.");
				break;
				
			case 2:
				service.UpdateCompany(cg);
				model.addAttribute("msg","Update successfully.");
				break;
				
			case 3:
				try {
					service.DeleteCompany(cg);
					model.addAttribute("msg","Delete successfully.");
				}catch(Exception e){
					model.addAttribute("msg","Can not remove category because relationship");
				}
				break;
				
			default:
				break;
		}
		
		model.addAttribute("Name", "Management Company");
		model.addAttribute("data", service.getCompany());
		model.addAttribute("Security", wa.getSecurity());
		return "category";
	}
}
