package com.db.devchallenge;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;

public class LocationServiceTest {

	private  LocationService locationService; 
	
	@Test
	public void getWestfieldGeolocation()  //E20 1EJ 
	{
	GeoLocation results= locationService.getGeolocation("E20 1EJ");
	assertThat().isEqualTo(56.874584);
	}
	
	@Test
	public void getDBGeolocation()  //E20 1EJ 
	{
	
		
		
	}
	
	
}

