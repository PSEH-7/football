package com.sapient.football.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.Country;
import com.sapient.football.model.League;
import com.sapient.football.model.Team;

@Service
public class FootballService {

	@Autowired
	RestTemplate restTemplate;

	public static final String APIKEY = "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";

	@SuppressWarnings("unchecked")
	public List<Country> getCountries() {
		List<Country> countries = null;
		try {
			String url = "https://apiv2.apifootball.com/?action=get_" + "countries&APIkey=" + APIKEY;
			URI uri = new URI(url);
			ResponseEntity<Object> result = restTemplate.exchange(uri, HttpMethod.GET, null, Object.class);
			System.out.println(result);
			countries = (List<Country>) result.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return countries;
	}
	
	public List<League> getLeagues() {
		List<League> leagues = null;
		try {
			String url = "https://apiv2.apifootball.com/?action=" + "get_leagues&country_id=41&APIkey=" + APIKEY;
			URI uri = new URI(url);
			ParameterizedTypeReference<List<League>> typeRef = new ParameterizedTypeReference<List<League>>() {
			};
			ResponseEntity<List<League>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, typeRef);
			leagues = responseEntity.getBody();
			System.out.println(leagues.get(0));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return leagues;
	}

	public List<Team> getTeams() {
		List<Team> team = null;
		try {
			String url = "https://apiv2.apifootball.com/?action=get_teams&" + "league_id=148&APIkey=" + APIKEY;
			URI uri = new URI(url);
			ParameterizedTypeReference<List<Team>> typeRef = new ParameterizedTypeReference<List<Team>>() {
			};
			ResponseEntity<List<Team>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, typeRef);
			team = responseEntity.getBody();
			System.out.println(team.get(0).getTeam_badge());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return team;
	}

//	public List<League> getLeagues() {
//	List<League> leagues = null;
//	try {
//		String url = "https://apiv2.apifootball.com/?action="
//				+ "get_leagues&country_id=41&APIkey="+APIKEY;
//		URI uri = new URI(url);
//		ResponseEntity<Object> result = restTemplate.
//				exchange(uri, HttpMethod.GET, null, Object.class);
//		System.out.println(result);
//		leagues = (List<League>) result.getBody();
//	} catch (URISyntaxException e) {
//		e.printStackTrace();
//	}
//	return leagues;
//}
}
