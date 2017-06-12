package com.db.devchallenge.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;

public class Shop {

	
	@Override
	public String toString() {
		return "Shop [name=" + name + ", address=" + address + ", postcode=" + postcode + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private String name;
	private String address;
	private String postcode;
	private double latitude;
	private double longitude;

	//private LocationServiceGMaps locationService = new LocationServiceGMaps();

	
/*

	

	public Shop(String newName, String newAddress, String newPostcode) {

		name = newName;
		address = newAddress;
		postcode = newPostcode;

		GeoLocation geolocation = locationService.getGeoLocation(newPostcode);
		latitude = geolocation.getLatitude();

		longitude = geolocation.getLongitude();

	}
	*/
	public Shop(){
		System.out.println("Called constructor");
		
	}
	
	
}