package com.db.devchallenge;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	//public static final HashMap<String, Shop> nearestShopMap = new HashMap<String, Shop>(100);

	@RequestMapping(value = "/shops", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Shop> getAllShops() {

		shopsRepository.someShops();
		return ShopsRepository.allShops;

	}

	private LocationServiceGMaps locationVariable3;

	@RequestMapping(value = "/shops", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Shop> addShop(String shopName, String shopAddress, String shopPostcode) {

		// ShopsRepository.allShops.put(shopName, new Shop(shopName,
		// shopAddress, shopPostcode,
		// locationVariable3.getGeoLocation(shopPostcode).getLatitude(),locationVariable3.getGeoLocation(shopPostcode).getLongitude()
		// ));
		ShopsRepository.allShops.put(shopName, new Shop(shopName, shopAddress, shopPostcode));

		return new ResponseEntity<Shop>(ShopsRepository.allShops.get(getAllShops()), HttpStatus.OK);
		// definitely not the right version;
	}

	@Autowired
	private LocationServiceGMaps locationVariable;
	double calculatedDistance = 0;

	@RequestMapping(value = "/shops/findNearest", method = RequestMethod.GET)
	@ResponseBody
	public Shop getNearestShop(@RequestParam("lat") double lat, @RequestParam("lng") double lng) // public
																									// Shop
	{

		Shop finalReturnShop = new Shop();
		double nearestDistance = Double.MAX_VALUE;
		
		for (Map.Entry<String, Shop> entry : ShopsRepository.allShops.entrySet()) {
			
				
			calculatedDistance = locationVariable.haversine(entry.getValue().getLatitude(), entry.getValue().getLongitude(), lat, lng);
			
			if (calculatedDistance <= nearestDistance) {
				nearestDistance = calculatedDistance;
				finalReturnShop = entry.getValue();
			}
			
		}

		/*
		for (Map.Entry<String, Shop> entry : ShopsRepository.allShops.entrySet()) {

			GeoLocation location = locationVariable.getGeoLocation(entry.getValue().getShopPostcode());
			calculatedDistance = locationVariable.haversine(location.getLatitude(), location.getLongitude(), lat, lng);
			// finalReturnShop=entry.getValue();

			if (calculatedDistance <= nearestDistance) {
				nearestDistance = calculatedDistance;
				finalReturnShop = entry.getValue();
				
			}
		}*/
		return finalReturnShop; // return finalReturnShop

	}
}

/*
 * 
 * // this is the shop postcode:
 * ShopsRepository.allShops.get(getAllShops()).getShopPostcode()
 * 
 * public HashMap<String,Shop> showAllShops( HashMap<String, Shop> ashopsMap ) {
 * 
 * return aShopsMap;
 * 
 * 
 * 
 * public void displayAllShops() { showAllShops(aShopsMap); } }
 * 
 * 
 */
