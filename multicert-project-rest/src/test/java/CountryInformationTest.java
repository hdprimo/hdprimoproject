import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.w3c.dom.Document;

import com.webservices.objects.CountryInfo;
import com.webservices.utilities.CountryInfoReader;


public class CountryInformationTest {

	@Test
	public void testGetInfo() {
		Client client;
		WebTarget target;
		
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/multicert-project-rest/");			
		target = target.path("countryinformation/getInfo");
		target = target.queryParam("country", "PT");
		CountryInfo countryInfo =  target.request(MediaType.APPLICATION_JSON).get().readEntity(CountryInfo.class);

		assertNotNull(countryInfo);
	}

}
