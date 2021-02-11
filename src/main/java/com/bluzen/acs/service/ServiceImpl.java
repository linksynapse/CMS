package com.bluzen.acs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.bluzen.acs.obj.Category;
import com.bluzen.acs.obj.CreateUser;
import com.bluzen.acs.obj.Extension;
import com.bluzen.acs.obj.HardwareInfo;
import com.bluzen.acs.obj.LoginForm;
import com.bluzen.acs.obj.PermitCard;
import com.bluzen.acs.obj.Product;
import com.bluzen.acs.obj.PsInfo;
import com.bluzen.acs.obj.SearchIORequest;
import com.bluzen.acs.obj.SearchIOResult;
import com.bluzen.acs.obj.SearchWorkerResult;
import com.bluzen.acs.obj.SelectUser;
import com.bluzen.acs.obj.UserModify;
import com.bluzen.acs.obj.WebAccount;
import com.bluzen.acs.persistence.DAO;

@Repository
public class ServiceImpl implements Service {
	@Inject
	private DAO dao;
	
	@Override
	public WebAccount login(LoginForm vo) throws Exception{
		return dao.login(vo);
	}
	
	@Override
	public List<PsInfo> getDashboard() throws Exception{
		return dao.getDashboard();
	}
	
	@Override
	public List<PsInfo> getDashboardEx(int pjt) throws Exception{
		return dao.getDashboardEx(pjt);
	}
	
	@Override
	public List<SearchWorkerResult> getWorkerSearch(SearchWorkerResult vo) throws Exception{
		return dao.getWorkerSearch(vo);
	}
	
	@Override
	public List<SearchIOResult> getIOSearch(SearchIORequest vo) throws Exception{
		return dao.getIOSearch(vo);
	}
	
	@Override
	public List<SearchIOResult> getIOSearchLimit(SearchIORequest vo) throws Exception{
		return dao.getIOSearchLimit(vo);
	}
	
	@Override
	public List<HardwareInfo> getHardware() throws Exception{
		return dao.getHardware();
	}
	
	@Override
	public int setHWupdate(String AuthKey) throws Exception{
		return dao.setHWupdate(AuthKey);
	}
	
	@Override
	public int createuser(CreateUser cu) throws Exception{
		return dao.createuser(cu);
	}
	
	@Override
	public int permitcard(PermitCard cu) throws Exception{
		return dao.permitcard(cu);
	}
	
	@Override
	public List<Product> getCamp() throws Exception{
		return dao.getCamp();
	}
	
	@Override
	public List<Product> getCompany() throws Exception{
		return dao.getCompany();
	}
	
	@Override
	public List<Product> getGender() throws Exception
	{
		return dao.getGender();
	}
	
	@Override
	public List<Product> getNationality() throws Exception{
		return dao.getNationality();
	}
	
	@Override
	public List<Product> getPosition() throws Exception{
		return dao.getPosition();
	}
	
	@Override
	public List<Product> getProjectsite() throws Exception{
		return dao.getProjectsite();
	}
	
	@Override
	public SelectUser getUserinfomation(String Badge) throws Exception{
		SelectUser result = dao.getUserPerBadge(Badge);
		result.setPermit(dao.getUserPermit(Badge));
		
		return result;
	}
	
	@Override
	public List<SearchWorkerResult> getWorkerSearchlimit(SearchWorkerResult vo) throws Exception{
		return dao.getWorkerSearchlimit(vo);
	}
	
	@Override
	public int setUserinfomation(UserModify vo) throws Exception{
		if(dao.setUserinfomation(vo) > 0) {
			if(dao.deletePermit(vo) > 0) {
				for(int x : vo.getPermit()) {
					PermitCard cu = new PermitCard();
					cu.setBadge(vo.getBadge());
					cu.setProjectsite(x);
					dao.permitcard(cu);
				}
				
				return 0;
			}else {
				return -1;
			}
		}else {
			return -2;
		}
	}
	
	@Override
	public int enableuser(String badge) throws Exception{
		return dao.enableuser(badge);
	}
	
	@Override
	public int disableuser(String badge, int reason) throws Exception{
		return dao.disableuser(badge,reason);
	}
	
	@Override
	public int extensionuser(Extension vo) throws Exception{
		return dao.extensionuser(vo);
	}
	
	@Override
	public int InsertNationality(Category vo) throws Exception{
		return dao.InsertNationality(vo);
	}
	
	@Override
	public int InsertCamp(Category vo) throws Exception{
		return dao.InsertCamp(vo);
	}
	
	@Override
	public int InsertPosition(Category vo) throws Exception
	{
		return dao.InsertPosition(vo);
	}
	
	@Override
	public int UpdateNationality(Category vo) throws Exception
	{
		return dao.UpdateNationality(vo);
	}
	
	@Override
	public int UpdateCamp(Category vo) throws Exception
	{
		return dao.UpdateCamp(vo);
	}
	
	@Override
	public int UpdatePosition(Category vo) throws Exception
	{
		return dao.UpdatePosition(vo);
	}
	
	@Override
	public int DeleteNationality(Category vo) throws Exception
	{
		return dao.DeleteNationality(vo);
	}
	
	@Override
	public int DeleteCamp(Category vo) throws Exception
	{
		return dao.DeleteCamp(vo);
	}
	
	@Override
	public int DeletePosition(Category vo) throws Exception
	{
		return dao.DeletePosition(vo);
	}
	
	@Override
	public int InsertCompany(Category vo) throws Exception
	{
		return dao.InsertCompany(vo);
	}
	
	@Override
	public int UpdateCompany(Category vo) throws Exception
	{
		return dao.UpdateCompany(vo);
	}
	
	@Override
	public int DeleteCompany(Category vo) throws Exception{
		return dao.DeleteCompany(vo);
	}
}