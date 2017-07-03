
package com.db.devchallenge;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;
import com.db.devchallenge.model.Shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.concurrent.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Component
public class ShopsRepository {

	private LocationServiceGMaps locationService = new LocationServiceGMaps();
	public static final ConcurrentHashMap<String, Shop> allShops = new ConcurrentHashMap<String, Shop>(200);

	public ShopsRepository() {
		
	}

	public void addShop(Shop shop2) {

		GeoLocation geolocation = locationService.getGeoLocation(shop2.getPostcode());

		shop2.setLatitude(geolocation.getLatitude());
		shop2.setLongitude(geolocation.getLongitude());

		allShops.putIfAbsent(shop2.getName(), shop2);

	}


}
