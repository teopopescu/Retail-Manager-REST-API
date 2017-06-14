package com.db.devchallenge;

import static org.assertj.core.api.Assertions.contentOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletContext;
import javax.swing.text.AbstractDocument.Content;

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

import junit.framework.Assert;

/*
Questions
 -do I need to get tests for each JSON parameter? see get methods

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
public class ShopsControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	// test Get all shops
	@Test
	public void testGetShops() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/shops").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Tesco"));
				// .andExpect(MockMvcResultMatchers.content().json(" ")); <-- or like this?

	}

	// Test post shop
	@Test
	public void testPostShop() throws Exception {

		mockMvc.perform(post("/shops").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	// Test Nearest shop
	@Test
	public void testNearestShop() throws Exception {
		mockMvc.perform(get("/shops/findNearest").param("lat", "23").param("lng", "46")).andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.content().json(" "));
		// .andExpect(jsonPath("$.name").value("Tesco")); <-- but what is wrong with this?
	}
	
/*	Comments 
    ________________________
  
  
 
// find nearest shops test
	@Test
	public void getNearestShopTest() {
		this.mockMvc.perform(get("/shops/findNearest").param("lat", "23").param("lng", "46")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("Tesco"));
	}*/

	/*
	
	  
	// test Get all shops
	 * 
	 *  * // Taken from Spring Integration Testing documentation!!!
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8")); 
	 * 
	@Test
	public void testGetShops() throws Exception {

		mockMvc.perform(get("/shops")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
				// .andExpect(content().contentType("application/json")) //this
				.andExpect(jsonPath("$.name", is("Tesco")));
				// .andExpect(jsonPath("$.name").value("Tesco"));
				  }
*/
	/*
	// Post method test
	@Test
	public void postShopTest() {
		String json = content().contentType(MediaType.APPLICATION_JSON_VALUE); // this is the problem 
																			
		mockMvc.perform(
				post("/shops").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}*/
	
}
