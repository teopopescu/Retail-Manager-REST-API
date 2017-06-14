package com.db.devchallenge;

import java.util.HashMap;
import java.util.Map;

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
	public HashMap<String, Shop> getAllShops() {

		shopsRepository.someShops();
		return ShopsRepository.allShops;

	}

	@RequestMapping(value = "/shops", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addShop(@RequestBody Shop shop) {
		System.out.println("Adding shop " + shop);
		shopsRepository.addShop(shop);

	}

	@Autowired
	private LocationServiceGMaps locationVariable;
	double calculatedDistance = 0;

	@RequestMapping(value = "/shops/findNearest", method = RequestMethod.GET)
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
