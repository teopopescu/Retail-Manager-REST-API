package com.db.devchallenge;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	/*
	 * @RequestMapping(value = "/shops", method = RequestMethod.POST, consumes =
	 * "application/json", produces = "application/json") //@ResponseBody
	 * //public ResponseEntity<Shop> addShop( @RequestBody String shopName,
	 * String shopAddress, String shopPostcode) { public ResponseEntity<Shop>
	 * addShop( @RequestBody Shop shop1) {
	 * 
	 * /* String shopName="Deutsche Bank"; String
	 * shopAddress="10 Upper Bank Street"; String shopPostcode="E14 5BT";
	 * 
	 * shop1.setShopName(shopName); shop1.setShopAddress(shopAddress);
	 * shop1.setShopPostcode(shopPostcode);
	 * 
	 * ShopsRepository.allShops.put(shopName, shop1);
	 * 
	 * return new ResponseEntity<Shop>(shop1, HttpStatus.OK); }
	 * 
	 * @RequestMapping(value="/shops", method=RequestMethod.POST) public void
	 * add(@RequestBody Shop shop1) { Shop model = new Shop();
	 * model.setShopName(shop1.getShopName());
	 * model.setShopAddress(shop1.getShopAddress());
	 * model.setShopPostcode(shop1.getShopPostcode());
	 * 
	 * ShopsRepository.allShops.put(model.getShopName(), model);
	 * 
	 * 
	 * }
	 *
	 *
	 */

	@RequestMapping(value = "/shops", method = RequestMethod.POST)
	public void addShop(@RequestBody Shop shop) {

		shopsRepository.addShop(shop);

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
