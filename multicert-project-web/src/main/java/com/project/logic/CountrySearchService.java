package com.project.logic;

import java.util.HashMap;

import com.general.utilities.BusinessLogic;
import com.webservices.objects.CountryInfo;

public class CountrySearchService {

	public HashMap<String,Object> searchCountry(String country) throws Exception{
		BusinessLogic logic = new BusinessLogic();
		CountryInfo countryInfo = logic.getcountryInfoInfo(country);
		
		HashMap<String,Object> result = new HashMap<String, Object>();
	
		result.put("language", countryInfo.getLanguage());
		result.put("population", countryInfo.getPopulation());
		result.put("currency", countryInfo.getCurrency());
		result.put("capital", countryInfo.getCapital());
		result.put("icao", countryInfo.getIcaoCapital());
		result.put("latitude", countryInfo.getCoordinates().getLatitude());
		result.put("longitude", countryInfo.getCoordinates().getLongitude());
		result.put("humidity", countryInfo.getWeather().getHumidity());
		result.put("temperature",countryInfo.getWeather().getTemperature());
		result.put("wind",countryInfo.getWeather().getWindSpeed());
		result.put("geralinformation",countryInfo.getWeather().getCloudsInfo());
		
		
		return result;
	}
}
