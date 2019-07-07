package com.sapient.football.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.Country;
import com.sapient.football.model.League;
import com.sapient.football.model.Standing;
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
			ParameterizedTypeReference<List<Country>> typeRef = new ParameterizedTypeReference<List<Country>>() {
			};
			ResponseEntity<List<Country>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, typeRef);
			countries = responseEntity.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return countries;
	}

	public List<League> getLeagues(Integer countryId) {
		List<League> leagues = null;
		try {
			String url = "https://apiv2.apifootball.com/?action=" + "get_leagues&country_id=" + countryId + "&APIkey="
					+ APIKEY;
			URI uri = new URI(url);
			ParameterizedTypeReference<List<League>> typeRef = new ParameterizedTypeReference<List<League>>() {
			};
			ResponseEntity<List<League>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, typeRef);
			leagues = responseEntity.getBody();
			System.out.println(leagues.get(0));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return leagues;
	}

	public List<Team> getTeams(Integer leagueId) {
		List<Team> team = null;
		try {
			String url = "https://apiv2.apifootball.com/?action=get_teams&" + "league_id=" + leagueId + "&APIkey="
					+ APIKEY;
			URI uri = new URI(url);
			ParameterizedTypeReference<List<Team>> typeRef = new ParameterizedTypeReference<List<Team>>() {
			};
			ResponseEntity<List<Team>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, typeRef);
			team = responseEntity.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return team;
	}

	public List<Standing> getStandings(Integer leagueId) {
		List<Standing> standings = null;
		try {
			String url = "https://apiv2.apifootball.com/?action=get_standings" + "&league_id=" + leagueId + "&APIkey="
					+ APIKEY;
			URI uri = new URI(url);
			ParameterizedTypeReference<List<Standing>> typeRef = new ParameterizedTypeReference<List<Standing>>() {
			};
			ResponseEntity<List<Standing>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, typeRef);
			standings = responseEntity.getBody();
			System.out.println(standings.get(0));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return standings;
	}

	public Standing getStandings(String countryname, String leaguename, String teamname) {
		// Country
		List<Country> countries = getCountries();
		List<Country> filteredCountryList = countries.stream().filter(e -> e.getCountry_name().equals(countryname))
				.collect(Collectors.toList());
		if (filteredCountryList.isEmpty()) {
			return null;
		}
		Country country = filteredCountryList.get(0);

		// league
		List<League> leagues = getLeagues(country.getCountry_id());
		List<League> filteredLeagueList = leagues.stream().filter(e -> e.getLeague_name().equals(leaguename))
				.collect(Collectors.toList());
		if (filteredLeagueList.isEmpty()) {
			return null;
		}
		League league = filteredLeagueList.get(0);

		// team
		List<Team> teams = getTeams(league.getLeague_id());
		List<Team> filteredTeamList = teams.stream().filter(e -> e.getTeam_name().equals(teamname))
				.collect(Collectors.toList());
		if (filteredLeagueList.isEmpty()) {
			return null;
		}
//		Team team = filteredTeamList.get(0);
		//standing
		List<Standing> standings = getStandings(league.getLeague_id());
		List<Standing> filteredStandingsList = standings.stream()
				.filter(e -> e.getTeam_name().equals(teamname))
				.filter(e -> e.getCountry_name().equals(countryname))
				.filter(e -> e.getLeague_name().equals(leaguename))
				.collect(Collectors.toList());
		if (filteredStandingsList.isEmpty()) {
			return null;
		}
		
		Standing standing = filteredStandingsList.get(0);
		standing.setCountry_id(country.getCountry_id());
		return standing;
	}
}
