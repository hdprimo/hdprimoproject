package com.webservices.objects;

public class CountryInfo {
	private String language;
	private int population;
	private String currency;
	private String capital;
	private String icaoCapital;
	private CountryCoordinates coordinates;
	private CountryWeatherInfo weather;
	private String countryName;

	public CountryInfo(String language, int population, String currency,
			String capital, String countryName) {
		super();
		this.language = language;
		this.population = population;
		this.currency = currency;
		this.capital = capital;		
		this.countryName = countryName;
		coordinates = new CountryCoordinates();
		weather = new CountryWeatherInfo();
	}

	public CountryInfo() {
		coordinates = new CountryCoordinates();
		weather = new CountryWeatherInfo();
	}

	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}

	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
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

	
	public String getIcaoCapital() {
		return icaoCapital;
	}

	public void setIcaoCapital(String icaoCapital) {
		this.icaoCapital = icaoCapital;
	}

	
	public CountryCoordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(CountryCoordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	
	public CountryWeatherInfo getWeather() {
		return weather;
	}
	
	public void setWeather(CountryWeatherInfo weather) {
		this.weather = weather;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
