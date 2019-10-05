package com.football.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FootballServiceImpl {

	public String getDetails(String countryName, String leagueName, String teamName) {
		RestTemplate restTemplate = new RestTemplate();
		String apiKey = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
		String uri = "https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey="+apiKey;
		
		String inline = restTemplate.getForObject(uri, String.class);
		return inline;
	}
	
}
