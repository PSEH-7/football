package com.football.pojo;

import java.io.Serializable;

public class Pojo implements Serializable{

	String countryid;
	String countryName;
	String leageId;
	String leageName;
	String teamId;
	String teamName;
	String overallLeagePosition;
	
	String data;
	
	public Pojo() {
		// TODO Auto-generated constructor stub
	}
	public String getPojo() {
		return data;
	}
	public void setPojo(String data) {
		this.data = data;
	}
	
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getLeageId() {
		return leageId;
	}
	public void setLeageId(String leageId) {
		this.leageId = leageId;
	}
	public String getLeageName() {
		return leageName;
	}
	public void setLeageName(String leageName) {
		this.leageName = leageName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getOverallLeagePosition() {
		return overallLeagePosition;
	}
	public void setOverallLeagePosition(String overallLeagePosition) {
		this.overallLeagePosition = overallLeagePosition;
	}
	
}
