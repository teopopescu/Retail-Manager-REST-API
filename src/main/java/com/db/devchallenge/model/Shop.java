package com.db.devchallenge.model;

public class Shop {

	private String name;
    private String address;
    private String postcode2;
	
	public Shop() {
		
		   this.name = null;
	        this.address = null;
	        this.postcode2 = null;
		
		// TODO Auto-generated constructor stub
	}

	    public Shop( String newName, String newAddress, String newPostcode){

	        name = newName;
	        address = newAddress;
	        postcode2 = newPostcode;
	    }
	    public void getShop(){

	        System.out.println("Name, Address, and Postcode");
	        System.out.println(name + "\t" + address + "\t" + postcode2);
	    }
	    public void Shop(String name, String address, String postcode)
	    {
	    	
	    	name =name;
	    	address=address;
	    	postcode2=postcode;
	    	
	    }
	    public void setShopName(String newShopName) {
	        this.name = newShopName;
	    }

	    public void setShopAddress(String newShopAddress) {
	        this.address = newShopAddress;
	    }

	    public void setShopPostcode(String newPostcode) {
	        this.postcode2 = newPostcode;
	    }

	    public String getShopName() {
	        return name;
	    }

	    public String getShopAddress() {
	        return address;
	    }

	    public String getShopPostcode() {
	        return postcode2;
	    }

	    @Override
	    public String toString() {
	        return "Shop name: " + this.getShopName() + 
	               ", shop address: " + this.getShopAddress() + 
	               ", shop postcode: " + this.getShopPostcode();
	    }
	
	
	}

        









   