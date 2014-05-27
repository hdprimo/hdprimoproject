package com.webservices.objects;

public class CountryWeatherInfo {
	private int humidity;
	private int temperature;
	private int windSpeed;
	private String cloudsInfo;
	
	public CountryWeatherInfo(int humidity, int temperature, int windSpeed,
			String cloudsInfo) {
		super();
		this.humidity = humidity;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.cloudsInfo = cloudsInfo;
	}
	
	public CountryWeatherInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getCloudsInfo() {
		return cloudsInfo;
	}
	public void setCloudsInfo(String cloudsInfo) {
		this.cloudsInfo = cloudsInfo;
	}
}
