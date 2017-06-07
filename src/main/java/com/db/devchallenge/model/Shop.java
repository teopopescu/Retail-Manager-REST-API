package com.db.devchallenge.model;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;

/*To discuss
 * what I did 
 * constructors, lat and lng on the model <-- comment them out and GET will work; find nearest error;
 * reversed(lat and lng includeD) means findnearest will return a null object and GET won't work; 
 * nearestShop null object: I am not doing anything with the calculatedDistance; 
 * look at POST method; if doing  POST on Postman, nothing happens and server crashes; 
 * 
 * 
 * Next steps by Friday:
 * -implement changes
 * -write tests for each method;
 * -integration and functional tests
 * 
 */

public class Shop {

	private String name;
	private String address;
	private String postcode2;
	private double latitude;
	private double longitude;

	public Shop() {

		this.name = null;
		this.address = null;
		this.postcode2 = null;
		this.latitude = 0;
		this.longitude = 0;

	}

	private LocationServiceGMaps locationVariable1;

	public Shop(String newName, String newAddress, String newPostcode, double newLat, double newLng) {

		name = newName;
		address = newAddress;
		postcode2 = newPostcode;
		latitude = locationVariable1.getGeoLocation(newPostcode).getLatitude();
		newLat = latitude;
		longitude = locationVariable1.getGeoLocation(newPostcode).getLongitude();
		newLng = longitude;
	}

	public Shop(String newName, String newAddress, String newPostcode) {

		name = newName;
		address = newAddress;
		postcode2 = newPostcode;
		longitude = locationVariable1.getGeoLocation(newPostcode).getLatitude();
		latitude = locationVariable1.getGeoLocation(newPostcode).getLongitude();
		// use setters?
	}

	public void getShop() {

		System.out.println("Name, Address, and Postcode");
		System.out.println(name + "\t" + address + "\t" + postcode2);
	}

	public void setShopName(String newShopName) {
		this.name = newShopName;
	}

	public void setShopAddress(String newShopAddress) {
		this.address = newShopAddress;
	}

	public void setShopPostcode(String newPostcode) {
		this.postcode2 = newPostcode;
	}

	public String getShopName() {
		return name;
	}

	public String getShopAddress() {
		return address;
	}

	public String getShopPostcode() {
		return postcode2;
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

	@Override
	public String toString() {
		return "Shop name: " + this.getShopName() + ", shop address: " + this.getShopAddress() + ", shop postcode: "
				+ this.getShopPostcode();
	}

}
