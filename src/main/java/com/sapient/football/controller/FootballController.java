package com.sapient.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.football.model.Country;
import com.sapient.football.model.Standing;
import com.sapient.football.service.FootballService;

@RestController
public class FootballController {

	@Autowired
	FootballService service;
	
	
	@GetMapping("/countries")
	public List<Country> getCountries() {
		return service.getCountries();
	}
	
	
	@GetMapping("/standings/{countryname}/{leaguename}/{teamname}")
	public List<Standing> getStandings(@PathVariable("countryname") String countryname,
			@PathVariable("leaguename") String leaguename,
			@PathVariable("teamname") String teamname) {
		return service.getStandings(countryname, leaguename, teamname);
	}
	

//	@GetMapping("/leagues")
//	public List<League> getLeagues() {
//		return service.getLeagues();
//	}
//	
//
//	@GetMapping("/standings")
//	public List<Standing> getStandings() {
//		return service.getStandings();
//	}
//
//	@GetMapping("/teams")
//	public List<Team> getTeams() {
//		return service.getTeams();
//	}
//
//	@GetMapping("/team/{name}")
//	public String getTeams(@PathVariable("name") String name) {
//		List<League> leagueList = service.getLeagues();
//		League league = leagueList.get(0);
//		
//		List<Team> teamList = service.getTeams();
//		Team team = teamList.get(0);
//		return team.getTeam_name();
//	}

}
