package com.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.pojo.Pojo;
import com.football.service.FootballServiceImpl;


@RestController
public class FootballController {
	private static final String PATH = "/error";

	@Autowired
	private FootballServiceImpl footballService;
	
	@Autowired
	private Pojo pojo;

	@RequestMapping(path = "/standings", produces = "application/json; charset=UTF-8")
    @ResponseBody
	
	public ResponseEntity<Pojo> getFootballDetails(@RequestParam("countryName") String countryName,
			@RequestParam("leagueName") String leagueName, @RequestParam("teamName") String teamName) {
		
		String data = footballService.getDetails(countryName, leagueName, teamName);
		
		pojo.setPojo(data);
		ResponseEntity<Pojo> entity = new ResponseEntity<Pojo>(pojo, HttpStatus.OK);
		return entity;

	}
	
}
