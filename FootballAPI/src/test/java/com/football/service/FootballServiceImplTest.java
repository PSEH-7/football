package com.football.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

@TestComponent
@SpringBootTest
public class FootballServiceImplTest {

	@Mock
	private FootballServiceImpl footballServiceImpl;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Test
	public void getDetailsSuccess() {
		String expectedOutput = "CuntryName:INDIA";
		
		assertEquals(expectedOutput, doReturn("CuntryName:INDIA").when(restTemplate.getForObject(anyString(),String.class)));
	}
	@Test
	public void getDetailsFailure() {
		assertNull(null, doReturn(null).when(restTemplate.getForObject(anyString(),Integer.class)));
	}
	@Test
	public void getDetailsBadRequest() {
		assertNull(HttpStatus.BAD_REQUEST, doReturn(HttpStatus.BAD_REQUEST).when(restTemplate.getForObject(anyString(),Integer.class)));
	}
}
