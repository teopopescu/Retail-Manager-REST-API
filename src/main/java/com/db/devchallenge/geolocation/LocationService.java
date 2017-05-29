package com.db.devchallenge.geolocation;

import com.google.maps.errors.ApiException;

public interface LocationService {

	//public LocationServiceGMaps getGeolocation(String postcode); 
		GeoLocation getGeoLocation(String poscode);
}


