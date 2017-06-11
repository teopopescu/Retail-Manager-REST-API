package com.db.devchallenge.geolocation;

import com.google.maps.errors.ApiException;

public interface LocationService {

	GeoLocation getGeoLocation(String poscode);

	double haversine(double lat1, double lon1, double lat2, double lon2);

}
