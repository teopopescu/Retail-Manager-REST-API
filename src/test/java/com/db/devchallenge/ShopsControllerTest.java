package com.db.devchallenge;

import static org.assertj.core.api.Assertions.contentOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletContext;
import javax.swing.text.AbstractDocument.Content;

import org.apache.catalina.mapper.Mapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.db.devchallenge.model.Shop;
import com.db.devchallenge.ShopsRepository;

import junit.framework.Assert;

/*

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
public class ShopsControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	private ShopsRepository shopsRepository = new ShopsRepository();
	private String json=" \"json\": \"request\"";

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}
	
	
	
	//FIX POST METHOD x
	//FIX GEOLOCATION NULLPOINTER  x 
	// test Get all shops x
	//in @After clear the data in tests x 
	// each test uses data for different shops; put shosprepositroy.someshops in shopsrepository constructor; x
	//CLEAN CODE  x
	// use concurrent hashmap; <-- it has atomic operations : you can PUT and GET the previous value; x 
	
	// _________________
	
	// Read section on Java Concurrency in Practice;
	// read about concurrent HashMap; what methods it has, what guarantees, what
		// it doesn't guarantee; <=- understand it pretty well;
	

	// update Shop but return previous version of Shop to the client (for
	// example, postcode1 (old) and postcode2 (new) <--stored in the map but
	// postcode1 will be returned to client;
	
	
	
	//do the concurrent test:  // try to do the concurrent test: the PUT and GET previous version;
	 //submit final version to GitHub on Sunday; 
	

	@Test
	public void testGetShops() throws Exception { // APPLICATION_JSON_UTF8
		mockMvc.perform(MockMvcRequestBuilders.get("/shops").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath(".name").value("Tesco"))
				.andExpect(MockMvcResultMatchers.jsonPath(".address").value("Address"))
				.andExpect(MockMvcResultMatchers.jsonPath(".postcode").value("NW1 3HZ"));
		

	}

/*
	@Test
	public void testPostShop() throws Exception {
		
		
		  mockMvc.perform(post("/shops").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON_UTF8).content("{\"json \":\"request\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	*/
	
	@Test
	public void testPostShop() throws Exception {
		
		
		  mockMvc.perform(post("/shops").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"Tesco\",\"address\":\"Hoy Street\",\"postcode\":\"E16\"}"	))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	
	
	// Test Nearest shop
	@Test
	public void testNearestShop() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/shops/findNearest").accept(MediaType.APPLICATION_JSON_VALUE)
				.param("lat", "23").param("lng", "46")).andExpect(MockMvcResultMatchers.status().isOk())
				 .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath(".name").value("Tesco"));
		
	}
	
	/*
	@Test 
	public void testConcurrency() throws Exception
	{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/shops").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.jsonPath(".name").value("Tesco"))
		.andExpect(MockMvcResultMatchers.jsonPath(".address").value("Address"))
		.andExpect(MockMvcResultMatchers.jsonPath(".postcode").value("NW1 3HZ"));
		
		mockMvc.perform(put("/shops").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content("{\"name\":\"Tesco\"}"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		//.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.jsonPath(".name").value("Tesco"))
		.andExpect(MockMvcResultMatchers.jsonPath(".address").value("Address"))
		.andExpect(MockMvcResultMatchers.jsonPath(".postcode").value("NW1 3HZ")); 
		
	}*/
		
		
		 
//"{\"name\":\"Tesco\", \"address\":\"Hoy street\", \"postcode\":\"E16 1XD\" }"

	
	@After
	public void delete() {
		ShopsRepository.allShops.remove(shopsRepository); 
															
	}
	

}
