package com.sapient.football.model;

import java.io.Serializable;

public class Standing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country_name;
	private Integer league_id;
	private String league_name;
	private Integer team_id;
	private String team_name;
	private Integer overall_league_position;

	public Standing() {

	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Integer getLeague_id() {
		return league_id;
	}

	public void setLeague_id(Integer league_id) {
		this.league_id = league_id;
	}
	
	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Integer getOverall_league_position() {
		return overall_league_position;
	}

	public void setOverall_league_position(Integer overall_league_position) {
		this.overall_league_position = overall_league_position;
	}

	public Standing(String country_name, Integer league_id, String league_name, Integer team_key, String team_name,
			Integer overall_league_position) {
		super();
		this.country_name = country_name;
		this.league_id = league_id;
		this.league_name = league_name;
		this.team_id = team_key;
		this.team_name = team_name;
		this.overall_league_position = overall_league_position;
	}
	
	


}
