package com.db.devchallenge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;

public class LocationServiceTest {

	private LocationServiceGMaps locationService = new LocationServiceGMaps();

	@Test
	public void getWestfieldGeolocation() // E20 1EJ
	{
		GeoLocation results = locationService.getGeoLocation("E14 5BT");
		//results.setLatitude(locationService.getGeoLocation("NW1 3HZ").getLatitude());
		//results.setLongitude(locationService.getGeoLocation("NW1 3HZ").getLongitude());		
		assertThat(results.getLatitude()).isEqualTo(51.5131966);
		assertThat(results.getLongitude()).isEqualTo(-0.0283023);
	}
	
	//a test explicitly
	
	@Test
	public void testHaversine() {
		GeoLocation results = locationService.getGeoLocation("E14 5BT");
		LocationServiceGMaps results3 = new LocationServiceGMaps();
		assertThat(results3.haversine(results.getLatitude(), results.getLongitude(), 11, 19)).isEqualTo(4824.434019063103);

	}

}
