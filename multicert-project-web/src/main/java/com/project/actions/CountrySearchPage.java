package com.project.actions;

import java.util.HashMap;

import com.general.utilities.BusinessLogic;
import com.opensymphony.xwork2.ActionSupport;
import com.project.logic.CountrySearchService;
import com.webservices.objects.CountryInfo;

public class CountrySearchPage extends ActionSupport {

	private String country, language,currency,capital,icao,meteorologicInfo,geralinformation;
	private int population, temperature, wind;
	private double latitude, longitude, humidity;
	
	public String execute() throws Exception{
		if(country != null && !"".equals(country)){
			CountrySearchService logic = new CountrySearchService();
			HashMap<String,Object> countryInfo = logic.searchCountry(country);
			
			setLanguage(String.valueOf(countryInfo.get("language")));
			setPopulation(Integer.parseInt(String.valueOf(countryInfo.get("population"))));
			setCurrency(String.valueOf(countryInfo.get("currency")));
			setCapital(String.valueOf(countryInfo.get("capital")));
			setIcao(String.valueOf(countryInfo.get("icao")));
			setLatitude(Double.parseDouble(String.valueOf(countryInfo.get("latitude"))));
			setLongitude(Double.parseDouble(String.valueOf(countryInfo.get("longitude"))));
			setHumidity(Double.parseDouble(String.valueOf(countryInfo.get("humidity"))));
			setTemperature(Integer.parseInt(String.valueOf(countryInfo.get("temperature"))));
			setWind(Integer.parseInt(String.valueOf(countryInfo.get("wind"))));
			setGeralinformation(String.valueOf(countryInfo.get("geralinformation")));			
			setMeteorologicInfo(String.valueOf(countryInfo.get("meteorologic")));

		}
		return SUCCESS;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getMeteorologicInfo() {
		return meteorologicInfo;
	}

	public void setMeteorologicInfo(String meteorologicInfo) {
		this.meteorologicInfo = meteorologicInfo;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getGeralinformation() {
		return geralinformation;
	}

	public void setGeralinformation(String geralinformation) {
		this.geralinformation = geralinformation;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getWind() {
		return wind;
	}

	public void setWind(int wind) {
		this.wind = wind;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}	

	public String getLanguageText(){
		return getText("language.text");
	}
	
	public String getPopulationText(){
		return getText("population.text");
	}
	
	public String getCurrencyText(){
		return getText("currency.text");
	}
	
	public String getCapitalText(){
		return getText("capital.text");
	}

	public String getIcaoText(){
		return getText("icao.text");
	}

	public String getLatitudeText(){
		return getText("latitude.text");
	}
	
	public String getLongitudeText(){
		return getText("longitude.text");
	}

	public String getHumidityText(){
		return getText("humidity.text");
	}
	
	public String getWindText(){
		return getText("wind.text");
	}
	
	public String getTemperatureText(){
		return getText("temperature.text");
	}
	
	public String getGeralInformationText(){
		return getText("geralinformation.text");
	}
	
	public String getMeteorologicText(){
		return getText("meteorologic.text");
	}

}
