package com.db.devchallenge;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;

public class LocationServiceTest {

	private  LocationService locationService; 
	
	@Test
	public void getWestfieldGeolocation()  //E20 1EJ 
	{
	GeoLocation results= locationService.getGeoLocation("E20 1EJ");
	//assertThat(results.getLatitude()).isEqualTo(56.874584);
	}
	
	@Test
	public void getDBGeolocation()  //E20 1EJ 
	{
	
		
		
	}
	/*@Test
	public void testHaversine()
	{
		GeoLocation results= locationService.getGeoLocation("NW13HZ");
		assertThat(haversine(results.getLatitude()), results.getLongitude(), 51.5027, 0.0173).isEqualTo(11.2654));
		
	}*/
	
	
}

