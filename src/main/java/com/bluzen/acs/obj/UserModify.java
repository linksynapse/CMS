package com.bluzen.acs.obj;

import java.util.List;

public class UserModify{
	String badge;
	String nationalid;
	String name;
	int national;
	int gender;
	int position;
	int company;
	int camp;
	String cardnumber;
	List<Integer> permit;
	int Company_2;
	String Mobile;
	String Notes;
	String DateOfIssuance;
	
	public int getCamp() {
		return camp;
	}
	public void setCamp(int camp) {
		this.camp = camp;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getNationalid() {
		return nationalid;
	}
	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNational() {
		return national;
	}
	public void setNational(int national) {
		this.national = national;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public List<Integer> getPermit() {
		return permit;
	}
	public void setPermit(List<Integer> permit) {
		this.permit = permit;
	}
	public int getCompany_2() {
		return Company_2;
	}
	public void setCompany_2(int company_2) {
		Company_2 = company_2;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getDateOfIssuance() {
		return DateOfIssuance;
	}
	public void setDateOfIssuance(String dateOfIssuance) {
		DateOfIssuance = dateOfIssuance;
	}
}