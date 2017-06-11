package com.db.devchallenge.geolocation;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import lombok.Value;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LocationServiceGMaps implements LocationService {

	public static final double R = 6372.8; // In kilometers

	public LocationServiceGMaps() {

	}

	// private final static Logger LOG =
	// LoggerFactory.getLogger(LocationServiceGMaps.class);

	// @Value -> to inject a property (leave until later)
	private String apiKey = "AIzaSyDRfDEfT8_yzJsneS3CwodB8UDotytBB8E";

	@Override
	public GeoLocation getGeoLocation(String postcode) {

		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDRfDEfT8_yzJsneS3CwodB8UDotytBB8E");
		GeocodingResult[] results = null;
		try {
			results = GeocodingApi.geocode(context, postcode).await();
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GeoLocation object2 = new GeoLocation(results[0].geometry.location.lng, results[0].geometry.location.lat);

		return object2;
	}

	public double haversine(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;

	}
}