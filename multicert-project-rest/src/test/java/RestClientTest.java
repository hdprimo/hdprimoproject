import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.general.utilities.BusinessLogic;
import com.webservices.objects.CountryInfo;


public class RestClientTest {

	@Test
	public void testGetCountryInfo(){
		CountryInfo country=null;
		try {
			BusinessLogic logic = new BusinessLogic();
			country=logic.getcountryInfoInfo("PT");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Country: " + country.getCountryName() + "; Capital: " +country.getCapital() + "; Currency: " + country.getCurrency() + "; Language: " + country.getLanguage() + "; Population: " + country.getPopulation());
		System.out.println("ICAO: " + country.getIcaoCapital());
		System.out.println("Clouds info: " + country.getWeather().getCloudsInfo() + "; Humidity: " + country.getWeather().getHumidity() + "; Temperature: " + country.getWeather().getTemperature() + "; Wind Speed: " + country.getWeather().getWindSpeed() + "; latitude: " + country.getCoordinates().getLatitude() + "; longitude: " + country.getCoordinates().getLongitude());
		assertNotNull(country);
	}

}
