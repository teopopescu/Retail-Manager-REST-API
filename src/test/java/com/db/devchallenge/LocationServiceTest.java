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
	public void getWestfieldGeolocation() {
		GeoLocation results = locationService.getGeoLocation("E14 5BT");

		assertThat(results.getLatitude()).isEqualTo(51.5131966);
		assertThat(results.getLongitude()).isEqualTo(-0.0283023);
	}

	@Test
	public void testHaversine() {
		GeoLocation results = locationService.getGeoLocation("E14 5BT");
		assertThat(locationService.haversine(results.getLatitude(), results.getLongitude(), 11, 19))
				.isEqualTo(4824.434019063103);

	}

}
