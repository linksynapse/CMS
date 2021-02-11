package com.bluzen.acs.obj;

public class SearchIORequest{
	String Badge;
	String Name;
	String Company;
	String Type;
	String Start;
	String Location;
	String End;
	public String getStart() {
		return Start;
	}
	public void setStart(String start) {
		Start = start;
	}
	public String getEnd() {
		return End;
	}
	public void setEnd(String end) {
		End = end;
	}
	String Region;
	public String getBadge() {
		return Badge;
	}
	public void setBadge(String badge) {
		Badge = badge;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
}