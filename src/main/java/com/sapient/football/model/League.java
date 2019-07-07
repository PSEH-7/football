package com.sapient.football.model;

import java.io.Serializable;

public class League implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Country country;
	private Integer league_id;
	private String league_name;

	public League() {
	}

	public League(Country country, Integer league_id, String league_name) {
		super();
		this.country = country;
		this.league_id = league_id;
		this.league_name = league_name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getLeague_id() {
		return league_id;
	}

	public void setLeague_id(Integer league_id) {
		this.league_id = league_id;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

}
