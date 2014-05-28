package com.general.utilities;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.webservices.clients.RestClient;
import com.webservices.objects.CountryInfo;

public class BusinessLogic {

	public CountryInfo getcountryInfoInfo(String country) throws Exception{
		RestClient geo;
		CountryInfo countryInfo = new CountryInfo();
		
		Map<String,String> queryParams = new HashMap<String, String>();
		
		try{
			geo = new RestClient("http://api.geonames.org/");
			//queryParams.put("lang", Locale.getDefault().getLanguage());
			queryParams.put("lang", "pt");
			queryParams.put("country", country);
			queryParams.put("username", "hdprimo");
			queryParams.put("style", "full");
			
			countryInfo = geo.getInfo("countryInfo", queryParams,1, countryInfo);
		}catch(Exception e){e.printStackTrace();}
			
		try{
			geo = new RestClient("http://www.webservicex.net/globalweather.asmx/");
			
			queryParams = new HashMap<String, String>();
			queryParams.put("CityName", countryInfo.getCapital());
			queryParams.put("countryName", countryInfo.getCountryName());		
			
			countryInfo = geo.getInfo("GetWeather", queryParams,2, countryInfo); 
		}catch(Exception e){e.printStackTrace();}
		
		try{
			geo = new RestClient("http://api.geonames.org/");
			
			queryParams = new HashMap<String, String>();
			queryParams.put("ICAO", countryInfo.getIcaoCapital());
			queryParams.put("username", "hdprimo");
			
			countryInfo = geo.getInfo("weatherIcao", queryParams,3, countryInfo);
		}catch(Exception e){e.printStackTrace();}
			
		return countryInfo;
	}
	
}
