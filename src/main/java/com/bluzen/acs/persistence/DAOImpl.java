package com.bluzen.acs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
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

@Repository
public class DAOImpl implements DAO { 
	@Inject
	private SqlSession sql;
	
	@Override
	public WebAccount login(LoginForm vo) throws Exception{
		return sql.selectOne("manage.account.login", vo);
	}
	
	@Override
	public List<PsInfo> getDashboard() throws Exception{
		return sql.selectList("manage.dashboard.infomation");
	}
	
	@Override
	public List<SearchWorkerResult> getWorkerSearch(SearchWorkerResult vo) throws Exception{
		if(vo.getUsed() > 9) {
			return sql.selectList("manage.search.infomationouse", vo);
		}else {
			return sql.selectList("manage.search.infomation", vo);
		}
	}
	
	@Override
	public List<SearchIOResult> getIOSearch(SearchIORequest vo) throws Exception{
		return sql.selectList("manage.search.history", vo);
	}
	
	@Override
	public List<SearchIOResult> getIOSearchLimit(SearchIORequest vo) throws Exception{
		return sql.selectList("manage.search.historylimit", vo);
	}
	
	@Override
	public List<HardwareInfo> getHardware() throws Exception{
		return sql.selectList("manage.search.hardware");
	}
	
	@Override
	public int setHWupdate(String AuthKey) throws Exception{
		return sql.update("manage.hardware.hwupdate", AuthKey);
	}
	
	@Override
	public int createuser(CreateUser cu) throws Exception{
		return sql.insert("manage.account.user", cu);
		
	}
	
	@Override
	public int permitcard(PermitCard cu) throws Exception{
		return sql.insert("manage.account.permit", cu);
	}
	
	@Override
	public List<Product> getCamp() throws Exception{
		return sql.selectList("manage.product.camp");
	}
	
	@Override
	public List<Product> getCompany() throws Exception{
		return sql.selectList("manage.product.company");
	}
	
	@Override
	public List<Product> getGender() throws Exception
	{
		return sql.selectList("manage.product.gender");
	}
	
	@Override
	public List<Product> getNationality() throws Exception{
		return sql.selectList("manage.product.nationality");
	}
	
	@Override
	public List<Product> getPosition() throws Exception{
		return sql.selectList("manage.product.position");
	}
	
	@Override
	public List<Product> getProjectsite() throws Exception{
		return sql.selectList("manage.product.projectsite");
	}
	
	@Override
	public SelectUser getUserPerBadge(String Badge) throws Exception{
		return sql.selectOne("manage.account.userinfo", Badge);
	}
	
	@Override
	public List<Integer> getUserPermit(String Badge) throws Exception{
		return sql.selectList("manage.account.userpermit", Badge);
	}
	
	@Override
	public List<SearchWorkerResult> getWorkerSearchlimit(SearchWorkerResult vo) throws Exception{
		return sql.selectList("manage.search.infomationlimit", vo);
	}
	
	@Override
	public int setUserinfomation(UserModify vo) throws Exception{
		return sql.update("manage.account.usermodify", vo);
	}
	
	@Override
	public int deletePermit(UserModify vo) throws Exception{
		return sql.delete("manage.account.permitdelete", vo);
	}
	
	@Override
	public int enableuser(String badge) throws Exception{
		return sql.update("manage.account.userenable", badge);
	}
	
	@Override
	public int disableuser(String badge,int reason) throws Exception{
		Map<String,Object> r = new HashMap<String,Object>();
		r.put("badge", badge);
		r.put("reason", reason);
		return sql.update("manage.account.userdisable", r);
	}
	
	@Override
	public int extensionuser(Extension vo) throws Exception{
		return sql.update("manage.account.userextension", vo);
	}
	
	@Override
	public int InsertNationality(Category vo) throws Exception{
		return sql.insert("adding.category.Nationality",vo);
	}
	
	@Override
	public int InsertCamp(Category vo) throws Exception{
		return sql.insert("adding.category.Camp",vo);
	}
	
	@Override
	public int InsertPosition(Category vo) throws Exception
	{
		return sql.insert("adding.category.Position",vo);
	}
	
	@Override
	public int InsertCompany(Category vo) throws Exception
	{
		return sql.insert("adding.category.Company",vo);
	}
	
	@Override
	public int UpdateNationality(Category vo) throws Exception
	{
		return sql.update("adding.category.mNationality",vo);
	}
	
	@Override
	public int UpdateCamp(Category vo) throws Exception
	{
		return sql.update("adding.category.mCamp",vo);
	}
	
	@Override
	public int UpdatePosition(Category vo) throws Exception
	{
		return sql.update("adding.category.mPosition",vo);
	}
	
	@Override
	public int UpdateCompany(Category vo) throws Exception
	{
		return sql.update("adding.category.mCompany",vo);
	}
	
	@Override
	public int DeleteNationality(Category vo) throws Exception
	{
		return sql.delete("adding.category.dNationality",vo);
	}
	
	@Override
	public int DeleteCamp(Category vo) throws Exception
	{
		return sql.delete("adding.category.dCamp",vo);
	}
	
	@Override
	public int DeletePosition(Category vo) throws Exception
	{
		return sql.delete("adding.category.dPosition",vo);
	}
	
	@Override
	public int DeleteCompany(Category vo) throws Exception
	{
		return sql.delete("adding.category.dCompany",vo);
	}
	
	@Override
	public List<PsInfo> getDashboardEx(int pjt) throws Exception{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("pjt", pjt);
		return sql.selectList("manage.dashboard.infomationSfEx", parameters);
	}
}