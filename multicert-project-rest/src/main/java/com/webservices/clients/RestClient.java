package com.webservices.clients;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.w3c.dom.Document;

import com.webservices.objects.CountryInfo;
import com.webservices.utilities.CountryInfoReader;

public class RestClient {
	private Client client;
	private WebTarget target;
	
	public RestClient(String targetUrl){
			client = ClientBuilder.newClient();
			target = client.target(targetUrl);			
			// "http://www.webserviceX.NET/globalweather.asmx/"
		}

		public CountryInfo getInfo(String path, Map<String,String> queryParams, int option, CountryInfo countryInfo) throws Exception{		
			target = target.path(path);
			//"GetWeather"
			
			for(Entry map:queryParams.entrySet()){
				target = target.queryParam((String)map.getKey(), map.getValue());
			}		
					
			//1-CountryInfo
			//2-Icao
			//3-weather			
			switch(option){
			case 1: countryInfo =  CountryInfoReader.readDataCountryInfo(target.request(MediaType.APPLICATION_XML).get().readEntity(Document.class), countryInfo);
					break;
			case 2: countryInfo.setIcaoCapital(CountryInfoReader.readDataWebx(target.request(MediaType.APPLICATION_XML).get().readEntity(String.class)));
					break;
					
			case 3:// countryInfo = new CountryInfo();
					//System.out.println(target.request(MediaType.APPLICATION_XML).get().readEntity(String.class));
				    countryInfo =  CountryInfoReader.readDataWeather(target.request(MediaType.APPLICATION_XML).get().readEntity(Document.class), countryInfo);
				    break;
			}
			
			return countryInfo;
		
		}
}
