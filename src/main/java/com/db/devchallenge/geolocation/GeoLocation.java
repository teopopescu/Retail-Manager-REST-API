package com.db.devchallenge.geolocation;

import lombok.Data;
import java.util.*;
import java.net.URL;
import java.net.URLEncoder;

import org.json.*;





@Data

public class GeoLocation  { 
	
	  double longitude;
	  double latitude;
	 // static String outcome;
	 
	
	  /*
	   
	  public static String getOutcome() {
		return outcome;
	}

	public static void setOutcome(String outcome) {
		GeoLocation.outcome = outcome;
	}

	public static  void getGeolocation(String address) throws Exception
		{
		    // Build a URL
		    String link  = "http://maps.google.com/maps/api/geocode/json?" +
		                    "sensor=false&address=";
		
			//String link="https://maps.googleapis.com/maps/api/geocode/json?address=" + addr + "&key=AIzaSyDRfDEfT8_yzJsneS3CwodB8UDotytBB8E";
		    link += URLEncoder.encode(address, "UTF-8");
		   // link = link +  URLEncoder.encode(address, "UTF-8") + "&key=AIzaSyDRfDEfT8_yzJsneS3CwodB8UDotytBB8E";
		   
		   
		    URL url = new URL(link);
		 
		    // Read from the URL
		    Scanner scan = new Scanner(url.openStream());
		    String output = new String();
		    while (scan.hasNext())
		        output += scan.nextLine(); 
		    scan.close(); 
		 
		    // Build a JSON object
		    JSONObject anObject = new JSONObject(output);
		  
		 
		    // Get the result
		    JSONObject result = anObject.getJSONArray("results").getJSONObject(0);
		    System.out.println(result.getString("formatted_address"));
		    JSONObject location =
		        result.getJSONObject("geometry").getJSONObject("location");
		    outcome= "Latitude is: " + location.getDouble("lat") +
		                        ". Longitude is: " + location.getDouble("lng");
		    System.out.println(outcome);
		              
		}
	  
	  
	/*
	private double getLongitude() {
        
		return longitude;
    }

    private double getLatitude() {
        return latitude;
    }
    	
	 */ 
}		


	  
	  

