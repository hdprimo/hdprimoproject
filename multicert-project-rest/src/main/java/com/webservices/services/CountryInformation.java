package com.webservices.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.general.utilities.BusinessLogic;
import com.webservices.objects.CountryInfo;

@Path("/countryinformation")
public class CountryInformation {

	@GET
	@Path("/getInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public CountryInfo getInfo(@QueryParam("country") String country){
		
		CountryInfo countryInfo=new CountryInfo();
		try{
			BusinessLogic logic = new BusinessLogic();
			countryInfo = logic.getcountryInfoInfo(country);
		}catch(Exception e){
			e.printStackTrace();
		}
		return countryInfo;
	}
}
