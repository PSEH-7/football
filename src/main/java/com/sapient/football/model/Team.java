package com.sapient.football.model;

import java.io.Serializable;

public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer team_key;
	private String team_name;

	public Team() {

	}

	public Team(Integer team_key, String team_name) {
		super();
		this.team_key = team_key;
		this.team_name = team_name;
	}

	public Integer getTeam_key() {
		return team_key;
	}

	public void setTeam_key(Integer team_key) {
		this.team_key = team_key;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

}
