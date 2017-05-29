package com.db.devchallenge.geolocation;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import lombok.Value;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.log4j.spi.LoggerFactory;



public class LocationServiceGMaps implements LocationService {

  public LocationServiceGMaps() {
    
  }

  //private final static Logger LOG = LoggerFactory.getLogger(LocationServiceGMaps.class);

  //@Value -> to inject a property (leave until later)
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


    GeoLocation object = new GeoLocation(results[0].geometry.location.lng,results[0].geometry.location.lat);

    return object;
  }
}
 	