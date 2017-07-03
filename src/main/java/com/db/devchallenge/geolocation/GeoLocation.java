package com.db.devchallenge.geolocation;

import lombok.Data;

@Data
public class GeoLocation {

	double longitude;
	double latitude;

	public GeoLocation(double lng, double lat) {
		this.latitude = lat;
		this.longitude = lng;

	}

}