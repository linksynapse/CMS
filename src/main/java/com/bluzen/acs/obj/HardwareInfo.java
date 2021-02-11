package com.bluzen.acs.obj;

public class HardwareInfo{
	String AuthKey;
	String Serial;
	String Location;
	String Status;
	String DoorType;
	String Region;
	String Action;
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public String getAuthKey() {
		return AuthKey;
	}
	public void setAuthKey(String authKey) {
		AuthKey = authKey;
	}
	public String getSerial() {
		return Serial;
	}
	public void setSerial(String serial) {
		Serial = serial;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDoorType() {
		return DoorType;
	}
	public void setDoorType(String doorType) {
		DoorType = doorType;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
}