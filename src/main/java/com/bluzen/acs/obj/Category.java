package com.bluzen.acs.obj;

public class Category {
	Integer ProductCodeNumber;
	String Name;
	String ShortCut;
	String Address;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getShortCut() {
		return ShortCut;
	}
	public void setShortCut(String shortCut) {
		ShortCut = shortCut;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Integer getProductCodeNumber() {
		return ProductCodeNumber;
	}
	public void setProductCodeNumber(Integer productCodeNumber) {
		ProductCodeNumber = productCodeNumber;
	}
}
