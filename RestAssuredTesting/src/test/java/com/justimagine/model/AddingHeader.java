package com.justimagine.model;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class AddingHeader {
	
	@Test
	public void addKeyvaluePairHeaders() {
		
		// Add a header as key value
		RestAssured.given().header("someHeader","somevalue");
		RestAssured.given().headers("someHeader","somevalue");
		
		// Add header as a Map
		Map<String,String> requestHeaders = new HashMap<>();
		requestHeaders.put("someHeader","somevalue");
		RestAssured.given().headers(requestHeaders);
		
		// Add header using Header class
		Header requestHeader1 = new Header("someHeader","somevalue");
		RestAssured.given().header(requestHeader1);
		
		// Add header using Header and Headers class
		Header requestHeader2 = new Header("someHeader","somevalue");
		Headers requestHeaders3 = new Headers(requestHeader2);
		RestAssured.given().headers(requestHeaders3);
		
		// Add header with multiple values
		RestAssured.given().header("someHeader","someFirstvalue", "someSecondvalue");
		
		// Changing default behavior of merging
		RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("header1"));
		
		// Change overwrite behavior if not
		RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().mergeHeadersWithName("header1"));	
		
	}
}
