package com.bluzen.acs.persistence;

import java.util.List;

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

public interface DAO{
	public WebAccount login(LoginForm vo) throws Exception;
	public List<PsInfo> getDashboard() throws Exception;
	public List<PsInfo> getDashboardEx(int pjt) throws Exception;
	public List<SearchWorkerResult> getWorkerSearch(SearchWorkerResult vo) throws Exception;
	public List<SearchWorkerResult> getWorkerSearchlimit(SearchWorkerResult vo) throws Exception;
	public List<SearchIOResult> getIOSearch(SearchIORequest vo) throws Exception;
	public List<SearchIOResult> getIOSearchLimit(SearchIORequest vo) throws Exception;
	public List<HardwareInfo> getHardware() throws Exception;
	public int setHWupdate(String AuthKey) throws Exception;
	public int createuser(CreateUser cu) throws Exception;
	public int permitcard(PermitCard cu) throws Exception;
	public List<Product> getCamp() throws Exception;
	public List<Product> getCompany() throws Exception;
	public List<Product> getGender() throws Exception;
	public List<Product> getNationality() throws Exception;
	public List<Product> getPosition() throws Exception;
	public List<Product> getProjectsite() throws Exception;
	public SelectUser getUserPerBadge(String Badge) throws Exception;
	public List<Integer> getUserPermit(String Badge) throws Exception;
	public int setUserinfomation(UserModify vo) throws Exception;
	public int deletePermit(UserModify vo) throws Exception;
	public int enableuser(String badge) throws Exception;
	public int disableuser(String badge,int reason) throws Exception;
	public int extensionuser(Extension vo) throws Exception;
	public int InsertNationality(Category vo) throws Exception;
	public int InsertCamp(Category vo) throws Exception;
	public int InsertPosition(Category vo) throws Exception;
	public int UpdateNationality(Category vo) throws Exception;
	public int UpdateCamp(Category vo) throws Exception;
	public int UpdatePosition(Category vo) throws Exception;
	public int DeleteNationality(Category vo) throws Exception;
	public int DeleteCamp(Category vo) throws Exception;
	public int DeletePosition(Category vo) throws Exception;
	public int InsertCompany(Category vo) throws Exception;
	public int UpdateCompany(Category vo) throws Exception;
	public int DeleteCompany(Category vo) throws Exception;
}