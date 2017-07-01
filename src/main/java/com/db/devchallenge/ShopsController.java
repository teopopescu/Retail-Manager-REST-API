package com.db.devchallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;
import com.db.devchallenge.model.Shop;

@RestController
public class ShopsController {

	public ShopsController() {

	}

	@Autowired
	private ShopsRepository shopsRepository;

	@RequestMapping(value = "/shops", method = RequestMethod.GET)
	@ResponseBody
	public ConcurrentHashMap<String, Shop> getAllShops() {

		//shopsRepository.someShops();
		return ShopsRepository.allShops;
	
	}
		
	///--------IGNORE VERSION ABOVE 
	
	//PREVIOUS WORKING VERSION OF POST
	/*
	@RequestMapping(value = "/shops", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Shop addShop(@RequestBody Shop shop) {
		
		Shop shop1 = new Shop();
		shop1=shop;
	
		shopsRepository.addShop1(shop); 
		//shopsRepository.allShops.put(shop.getName(), shop);
		
		return shop1;
		
	}*/
	
	//TRY ON GETTING PREVIOUS VALUE <--DONE
	@RequestMapping(value = "/shops", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Shop addShop(@RequestBody Shop shop) {
		
		shopsRepository.addShop1(shop); 
		
		return ShopsRepository.allShops.put(shop.getName(), shop);
		
		/*
		if (!ShopsRepository.allShops.containsKey(shop1.getName()))

			return ShopsRepository.allShops.put(shop.getName(), shop);
		else
			return ShopsRepository.allShops.put(shop1.getName(), shop1);	
		*/
		}
		
	
	
	//TO DO 
			//reduce static variables; nothing apart from constants 
			//move out business logic into the service 
			//clean code; 
	//1H
			
			//slides: what have i done, how i've done it;10-15 minutes to talk about it; 
			//task, demo, code, what learned'

	//1H
		//ANSWER QUESTIONS
	//ANSWER: WALK ME THROUGH YOUR CODE! 
			//validate input and delegate to other bits; 
		
		/*
		Doing
		//hint for conc: concurrentHashMap put functionality: read what happens with put method 
		
			
		Done 
			//add missing functionality to update 
		
		*/
	
	
	
	@RequestMapping(value = "/shops", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateShop(@RequestBody Shop shop2) {
		
		shopsRepository.addShop1(shop2); 
		
		//ShopsRepository.allShops.put(shop2.getName(), shop2);
	}
	
	
	
	

	@Autowired
	private LocationServiceGMaps locationVariable;
	double calculatedDistance = 0;

	@RequestMapping(value = "/shops/findNearest", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Shop getNearestShop(@RequestParam("lat") double lat, @RequestParam("lng") double lng)

	{

		Shop finalReturnShop = null;
		double nearestDistance = Double.MAX_VALUE;

		for (Map.Entry<String, Shop> entry : ShopsRepository.allShops.entrySet()) {

			calculatedDistance = locationVariable.haversine(entry.getValue().getLatitude(),
					entry.getValue().getLongitude(), lat, lng);

			if (calculatedDistance <= nearestDistance) {
				nearestDistance = calculatedDistance;
				finalReturnShop = entry.getValue();
			}

		}

		return finalReturnShop;

	}
}
