package com.db.devchallenge;

import com.db.devchallenge.model.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.db.devchallenge.ShopsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
@RequestMapping("/api/v1/shops")
public class ShopsController {
  // get all shops
  // add a shop
  // get nearest shop (later)
	
	 ArrayList<Shop> shopsList = new ArrayList<Shop>(); 
	 
	 
	public ShopsController() {
		// TODO Auto-generated constructor stub
	}
	
	
  @Autowired
 // take out from comment and solve issue private ShopsRepository shopsRepository;
 

  @RequestMapping(method = RequestMethod.GET)  
  @ResponseBody 
  public List<Shop> getAllShops()  {
	  
	  for (Shop eachShop: shopsList) { 
 	       System.out.println(eachShop.toString());
	  }

	  
//return all shops added
    return shopsList;
  }
 
  public void addShop(Shop shopEntity)
  {
      shopsList.add(shopEntity);
	   
  }
  
  
  
  public static void main(String[] args)
  
  {
	  Scanner scan = new Scanner(System.in);
      System.out.println("Please enter a shop name : ");
      String name = scan.nextLine();
      System.out.println("Please enter address  : ");
      String address = scan.nextLine();
      System.out.println("Please enter postcode : ");
      String postcode2 = scan.nextLine();
	  
     ShopsController aShopObject = new ShopsController();
     
	   Shop firstShop = new Shop(name,address,postcode2);
	   aShopObject.addShop(firstShop);
       
     System.out.println();
     System.out.println("Add new shops: ");
     System.out.println("Enter number of shops to be added: ");
     int countNewShops = scan.nextInt();

     
     
     for (int i = 0; i < countNewShops; i++) {
    	 Shop newShops = new Shop();

         System.out.println("Enter details for shop: " + i);
         System.out.println();
         
         System.out.println("Enter name: ");
         newShops.setShopName(scan.nextLine());
         System.out.println();	
         
         System.out.println("Enter address: ");
         newShops.setShopAddress(scan.nextLine());

         System.out.println("Enter postcode: ");
         newShops.setShopPostcode(scan.nextLine());
         
         aShopObject.addShop(newShops);
     }
        System.out.println();
        
        
         aShopObject.getAllShops();
         
     }
         
}


     
 

  








