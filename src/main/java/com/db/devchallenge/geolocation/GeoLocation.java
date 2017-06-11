package com.db.devchallenge.geolocation;

import lombok.Data;

@Data
public class GeoLocation {

	// private final double longitude;
	// private final double latitude;
	double longitude;
	double latitude;

	public GeoLocation(double lng, double lat) {
		this.latitude = lat;
		this.longitude = lng;

	}

}