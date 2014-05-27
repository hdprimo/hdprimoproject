<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
	<s:form action="country-search">	
		<table>	
			<tr>
				<td>
					<s:textfield name="country" theme="simple">Introduza as iniciais do país a pesquisar (Exemplo: PT)</s:textfield>
				</td>
				<td>
					<s:submit value="Pesquisar" theme="simple"></s:submit>
				</td>
			</tr>
		</table>		 	
	</s:form>
	
	<div>
		<b><s:property value="languageText"/></b><s:property value="language"/>
	</div>
	<div>
		<b><s:property value="populationText"/></b><s:property value="population"/>
	</div>
	<div>
		<b><s:property value="currencyText"/></b><s:property value="currency"/>
	</div>
	<div>
		<b><s:property value="capitalText"/></b><s:property value="capital"/>
	</div>
	<div>
		<b><s:property value="icaoText"/></b><s:property value="icao"/>
	</div>
	<div>
		<b><s:property value="latitudeText"/></b><s:property value="latitude"/>
	</div>
	<div>
		<b><s:property value="longitudeText"/></b><s:property value="longitude"/>
	</div>
	<div>
		<b><s:property value="meteorologicText"/></b>
	</div>
	<s:if test="%{temperature != null && temperature != ''}">
		<div>
			<ul>
			  <li><b><s:property value="temperatureText"/></b><s:property value="temperature"/></li>
			  <li><b><s:property value="humidityText"/></b><s:property value="humidity"/></li>
			  <li><b><s:property value="windText"/></b><s:property value="wind"/></li>
			  <li><b><s:property value="geralInformationText"/></b><s:property value="geralinformation"/></li>
			</ul>
		</div>
	</s:if>
</body>
</html>