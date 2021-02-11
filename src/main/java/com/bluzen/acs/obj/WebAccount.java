package com.bluzen.acs.obj;

public class WebAccount{
	int idx;
	int Security;
	int Owner;
	String Name;
	String ShortCutName;
	String Description;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getSecurity() {
		return Security;
	}
	public void setSecurity(int security) {
		Security = security;
	}
	public int getOwner() {
		return Owner;
	}
	public void setOwner(int owner) {
		Owner = owner;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getShortCutName() {
		return ShortCutName;
	}
	public void setShortCutName(String shortCutName) {
		ShortCutName = shortCutName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}