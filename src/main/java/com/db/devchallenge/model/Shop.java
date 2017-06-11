package com.db.devchallenge.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;

public class Shop {

	private String name;
	private String address;
	private String postcode;
	private double latitude;
	private double longitude;

	private LocationServiceGMaps locationService = new LocationServiceGMaps();

	public Shop() {

		this.name = null;
		this.address = null;
		this.postcode = null;
		this.latitude = 1;
		this.longitude = 0;

	}

	public Shop(String newName, String newAddress, String newPostcode, double newLat, double newLng) {

		name = newName;
		address = newAddress;
		postcode = newPostcode;
		latitude = newLat;
		longitude = newLng;

	}

	public Shop(String newName, String newAddress, String newPostcode) {

		name = newName;
		address = newAddress;
		postcode = newPostcode;

		GeoLocation geolocation = locationService.getGeoLocation(newPostcode);
		latitude = geolocation.getLatitude();

		longitude = geolocation.getLongitude();

	}

	public void getShop() {

		System.out.println("Name, Address, and Postcode");
		System.out.println(name + "\t" + address + "\t" + postcode);
	}

	public void setShopName(String newShopName) {
		this.name = newShopName;
	}

	public void setShopAddress(String newShopAddress) {
		this.address = newShopAddress;
	}

	public void setShopPostcode(String newPostcode) {
		this.postcode = newPostcode;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getShopName() {
		return name;
	}

	public String getShopAddress() {
		return address;
	}

	public String getShopPostcode() {
		return postcode;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Shop name: " + this.getShopName() + ", shop address: " + this.getShopAddress() + ", shop postcode: "
				+ this.getShopPostcode();
	}

}
