package com.db.devchallenge.geolocation;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.json.JSONObject;
import com.google.code.geocoder.*;
import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.GeocodingApi;

	public class LocationServiceGMaps implements LocationService {
	 
		public LocationServiceGMaps() {
			// TODO Auto-generated constructor stub
		}
		
		
	 // private final static Logger LOG = LoggerFactory.getLogger(LocationServiceGMaps.class);
	 
	  //@Value -> to inject a property (leave until later)
	  private String apiKey = "AIzaSyDRfDEfT8_yzJsneS3CwodB8UDotytBB8E";
	 
	  @Override
	  public LocationServiceGMaps getGeolocation(String postcode) {
	    
		  //use GMaps JAR x 
	    // GeoApiContext x
	    // GeocodingApi x 
//	    GeocodingResult result x
//	    //if this does not compile, install Lombok Eclipse plugin
//	    return new GeoLocation(result.lat, result.long);
		    
		
		 
		  GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDRfDEfT8_yzJsneS3CwodB8UDotytBB8E");
		  GeocodingResult[] results = null;
		try {
			results = GeocodingApi.geocode(context,
			    postcode).await();
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
		  System.out.println(results[0].formattedAddress);
		  
		  return null;
	  }
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String test="NW13HZ";
		
		System.out.println("This is the result");
		LocationServiceGMaps test123= new LocationServiceGMaps();
		test123.getGeolocation(test);
		
		
	}
	
	}
	/*
	 
	 
	
	
	
	
	
/*	
	@SpringBootApplication

	@RestController


		public String zipcode;
		
		  
		public static void main(String[] args) throws Exception {
			SpringApplication.run(GradleFilesApplication.class, args);
			
			
			Scanner scan= new Scanner(System.in);
			System.out.print("Enter a postcode: ");
			zipcode=scan.next();
			System.out.println();
			GeoLocation.getGeolocation(zipcode);
			 
		
			}
			
		@RequestMapping("/Geolocation1") 
		public @ResponseBody String getResult() throws Exception {
		
		return GeoLocation.getOutcome();
		
			
			
		}
		}
*/
	

	

	
	

	

