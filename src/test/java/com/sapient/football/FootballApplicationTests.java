package com.sapient.football;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.sapient.football.model.Country;
import com.sapient.football.model.League;
import com.sapient.football.model.Standing;
import com.sapient.football.service.FootballService;

@RunWith(MockitoJUnitRunner.class)
public class FootballApplicationTests {

	@Test
	public void contextLoads() {
	}

	@InjectMocks
	FootballService serviceImpl;

	@Mock
	RestTemplate restTemplate;

	@Test
	public void testStandings() throws Exception {
		List<Country> countries = new ArrayList<>();
		Country country = new Country(41, "England");
		countries.add(country);
//		when(serviceImpl.getCountries()).thenReturn(countries);

		String url = "https://apiv2.apifootball.com/?action=get_countries&APIkey=" + FootballService.APIKEY;
		URI uri = new URI(url);
		ParameterizedTypeReference<List<Country>> typeRef = new ParameterizedTypeReference<List<Country>>() {
		};
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, null, typeRef))
				.thenReturn(new ResponseEntity(countries, HttpStatus.OK));

		List<League> leagues = new ArrayList<>();
		League league = new League(country, 148, "Premier League");
		leagues.add(league);
//		when(serviceImpl.getLeagues(country.getCountry_id())).thenReturn(leagues);

		url = "https://apiv2.apifootball.com/?action=" + "get_leagues&country_id=" + country.getCountry_id()
				+ "&APIkey=" + FootballService.APIKEY;
		uri = new URI(url);
		ParameterizedTypeReference<List<League>> leagueRef = new ParameterizedTypeReference<List<League>>() {
		};
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, null, leagueRef))
		.thenReturn(new ResponseEntity(leagues, HttpStatus.OK));
		
		
		//Standings
		Standing standing = new Standing();
		Standing standing1 = new Standing();
		standing.setCountry_id(41);
		standing.setCountry_name("England");
		standing.setLeague_id(148);
		standing.setLeague_name("Premier League");
		standing.setTeam_id(2626);
		standing.setTeam_name("Manchester City");
		List<Standing> standingList = new ArrayList<Standing>();
		standingList.add(standing);
		
		url = "https://apiv2.apifootball.com/?action=get_standings" + "&league_id=" + league.getLeague_id() + "&APIkey="
				+ FootballService.APIKEY;
		uri = new URI(url);
		ParameterizedTypeReference<List<Standing>> standingRef = new ParameterizedTypeReference<List<Standing>>() {
		};
		Mockito.when(restTemplate.exchange(uri, HttpMethod.GET, null, standingRef))
		.thenReturn(new ResponseEntity(standingList, HttpStatus.OK));
		
		assertTrue(serviceImpl.getStandings("England", "Premier League", "Manchester City") 
				!= null);
		assertTrue(serviceImpl.getStandings("England", "Premier League", "Manchester City").equals(
				standing));
	}

}
