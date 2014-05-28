package com.webservices.utilities;

import org.w3c.dom.*;

import com.webservices.objects.CountryCoordinates;
import com.webservices.objects.CountryInfo;
import com.webservices.objects.CountryWeatherInfo;

public class CountryInfoReader {
	
	private static Element getUniqueElement(Element node, String tagName) throws Exception
    {
        NodeList nl = node.getElementsByTagName(tagName);

        if (nl.getLength()!=1)
        {
            throw new Exception("Formato inválido.");
        }
        return (Element) nl.item(0);
    }

	private static String getElementTxt(Element root,String tagName) throws Exception 
    {
		Element node = getUniqueElement(root,tagName);
        NodeList nl = node.getChildNodes();
        if (nl.getLength()!=1)
        {
        	throw new Exception("Formato inválido.");
        }
        return nl.item(0).getNodeValue();
    }
	
	private static Element getUniqueChildElement(Element node, String tagName) throws Exception
    {
        NodeList nl = node.getChildNodes();
        Element childWithTagName = null;
        for (int i = 0;  i < nl.getLength(); i++) {
            Node childNode = nl.item(i);
            if (childNode instanceof Element && childNode.getNodeName().equals(tagName)) {
                childWithTagName = (Element) childNode;
            }
        }
        if (childWithTagName == null) {
        	throw new Exception("Formato inválido.");
        }
        return childWithTagName;
    }


	public static CountryInfo readDataCountryInfo (Document xml,CountryInfo countryInfo) throws Exception{
		Element root = xml.getDocumentElement();
		Element country = getUniqueElement(root,"country");		
		
		countryInfo = 
				new CountryInfo(getElementTxt(country,"languages"),
						Integer.parseInt(getElementTxt(country,"population")),
						getElementTxt(country, "currencyCode"),
						getElementTxt(country, "capital"),
						getElementTxt(country, "countryName"));
		
		return countryInfo;
	}
	
	public static String readDataWebx (String xml) throws Exception{
		String location;
		int firstPos=0;
		int lastPos=0;
		try{
			firstPos = xml.indexOf("Location");
			lastPos = xml.indexOf("Location", firstPos+1);
	
			location = xml.substring(firstPos, lastPos);
			firstPos = location.indexOf("(");
			lastPos = location.indexOf(")");
		}catch(Exception e){
			return xml;
		}
		return location.substring(firstPos+1, lastPos);
		
	}
	
	public static CountryInfo readDataWeather (Document xml, CountryInfo countryInfo) throws Exception{
		Element root = xml.getDocumentElement();
		Element observation = getUniqueChildElement(root,"observation");	
		
		CountryWeatherInfo weather = 
				new CountryWeatherInfo(Integer.parseInt(getElementTxt(observation,"humidity")), 
						Integer.parseInt(getElementTxt(observation,"temperature")), 
						Integer.parseInt(getElementTxt(observation,"windSpeed")), 
						getElementTxt(observation,"clouds"));

		CountryCoordinates coordinates = 
				new CountryCoordinates(Double.parseDouble(getElementTxt(observation,"lat")),
						Double.parseDouble(getElementTxt(observation,"lng")));
		
		countryInfo.setWeather(weather);
		countryInfo.setCoordinates(coordinates);
		
		return countryInfo;
	}


}
