package com.purgomalum.scenarios.negative;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;

public class ApiAutomation {
	
	String URL_PREFIX = "https://www.purgomalum.com/service";
	
	
	@Test
	public void returns_error_when_profinity_words_exceeds_threshold(){
		String outputFormat = "/plain";
		String inputText = "?text=This is a vulgar movie &add=vulgar,a,b,c,d,e,f,g,h,i,j,k,l";
		String API_URL = URL_PREFIX + outputFormat + inputText;
		System.out.println(API_URL);
		String output =
				RestAssured.given()
	                .contentType("application/json")
	            .when()
	                .get(API_URL)
	            .then()
	                .statusCode(200)
	                    .log().body().extract().response().asString();
		String expectedOutput = "User Black List Exceeds Limit of 10 Words.";
		
		Assert.assertEquals(expectedOutput, output);
		
	}
	
	@Test
	public void return_error_when_No_input(){
		String outputFormat = "/plain";
		String inputText = "?text=";
		String API_URL = URL_PREFIX + outputFormat + inputText;
		System.out.println(API_URL);
		String output =
				RestAssured.given()
	                .contentType("application/json")
	            .when()
	                .get(API_URL)
	            .then()
	                .statusCode(200)
	                    .log().body().extract().response().asString();
		String expectedOutput = "No Input";
		Assert.assertEquals(expectedOutput, output);
		
		
	}
	
	@Test
	public void returns_status_code_405_for_non_get_method(){
		String outputFormat = "/json";
		String inputText = "?text=this is sample test input";
		String API_URL = URL_PREFIX + outputFormat + inputText;
		
		System.out.println(API_URL);
		int statusCode =
				RestAssured.given()
	                .contentType("application/json")
	            .when()
	                .post(API_URL)
	            .then()
	                .statusCode(405)
	                    .log().body().extract().response().statusCode();
		
		Assert.assertEquals(405, statusCode);
	}
	
	
	
	

}
