package com.country_service_Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.country_service_beans.Country;
import com.country_service_controllers.Addresponse;

public class CountryService {
	static HashMap<Integer,Country> CountryIDMap ;
	public CountryService() {
		CountryIDMap = new HashMap<Integer, Country >();
		
		Country indiancountry=new Country(1,"india","NewDelhi");
		Country usacountry=new Country(2,"USA","Washington");
		Country ukcountry=new Country(3,"UK","London");
		
		CountryIDMap.put(1, indiancountry);
		CountryIDMap.put(2, usacountry);
		CountryIDMap.put(3, ukcountry);
	}
	public List getAllCountries() {
		List countries=new ArrayList(CountryIDMap.values());
		return countries;
		
		
		
	}
	
	public Country getCountrybyID(int id) {
		Country	country=CountryIDMap.get(id);
		return country ;
	}
	
	public Country getCountrybyName(String countryName) {
		
		Country con= null;
		for(int i : CountryIDMap.keySet() ) {
			if(CountryIDMap.get(i).getCountryName().equals(countryName)) {
				con=CountryIDMap.get(i);
				
			}
		}
		return con;
		
		
	}
	public Country addCountry(Country country) {
		country.setId(getmaxID());
		CountryIDMap.put(country.getId(), country);
		return country;
		
		
	}
	public Country updateCountry(Country con) {
		if (con.getId()>0) {
			CountryIDMap.put(con.getId(), con);
		}
		return con;
	}
	
	public Addresponse	DeleteCountry(int id) {
		
		CountryIDMap.remove(id);
		Addresponse res=new Addresponse();
		res.setMsg("Country is deleted");
		res.setId(id);
		return res;
	}
	
	
	//Utility method to get max id	
		
	public static int getmaxID() {
		
		int max=0;
		for(int i:CountryIDMap.keySet()) {
			if(i>=max) {
				
				max=i;
				}
			}
		return max+1;		
	}
		
		
		
		
		
		
		
	}
	
	
	
	



