package com.bluzen.acs.obj;

import java.util.List;

public class SelectUser{
	String Badge;
	String NPNumber;
	String Name;
	int Nationality;
	int Gender;
	int Position;
	int Company;
	int Company_2;
	int Camp;
	String CardNumber;
	String Expire;
	int Used;
	String Mobile;
	String Notes;
	String DateOfIssuance;
	List<Integer> Permit;
	
	public String getBadge() {
		return Badge;
	}
	public void setBadge(String badge) {
		Badge = badge;
	}
	public String getNPNumber() {
		return NPNumber;
	}
	public void setNPNumber(String nPNumber) {
		NPNumber = nPNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getNationality() {
		return Nationality;
	}
	public void setNationality(int nationality) {
		Nationality = nationality;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
	public int getCompany() {
		return Company;
	}
	public void setCompany(int company) {
		Company = company;
	}
	public int getCamp() {
		return Camp;
	}
	public void setCamp(int camp) {
		Camp = camp;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public String getExpire() {
		return Expire;
	}
	public void setExpire(String expire) {
		Expire = expire;
	}
	public int getUsed() {
		return Used;
	}
	public void setUsed(int used) {
		Used = used;
	}
	public List<Integer> getPermit() {
		return Permit;
	}
	public void setPermit(List<Integer> permit) {
		Permit = permit;
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