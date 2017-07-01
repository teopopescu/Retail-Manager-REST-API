package com.db.devchallenge;

import java.util.Scanner;


/*
import java.util.Scanner;


import lombok.Data;
import java.util.*;
import java.net.URL;
import java.net.URLEncoder;

import org.json.*;


import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.db.devchallenge.geolocation.GeoLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.db.devchallenge.geolocation.GeoLocation;
import com.db.devchallenge.geolocation.LocationService;
import com.db.devchallenge.geolocation.LocationServiceGMaps;
import com.db.devchallenge.model.Shop;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

		
		
	}

}