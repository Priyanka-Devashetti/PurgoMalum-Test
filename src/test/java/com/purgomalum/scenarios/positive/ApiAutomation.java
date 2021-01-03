package com.purgomalum.scenarios.positive;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;

public class ApiAutomation {
	
	String URL_PREFIX = "https://www.purgomalum.com/service";
	
	
	@Test
	public void returns_status_code_200_for_valid_api_request(){
		String outputFormat = "/json";
		String inputText = "?text=this is sample test input";
		String API_URL = URL_PREFIX + outputFormat + inputText;
		
		System.out.println(API_URL);
		int statusCode =
				RestAssured.given()
	                .contentType("application/json")
	            .when()
	                .get(API_URL)
	            .then()
	                .statusCode(200)
	                    .log().body().extract().response().statusCode();
		
		Assert.assertEquals(200, statusCode);
	}
	
	@Test
	public void returns_output_in_expected_output_format(){
		String outputFormat = "/plain";
		String inputText = "?text=this is sample test input";
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
		
		String expectedOutput = "this is sample test input";
		
		Assert.assertEquals(expectedOutput, output);
	}
	
	@Test
	public void replace_with_special_character_in_case_of_profinitywords(){
		String outputFormat = "/plain";
		String inputText = "?text=This is a vulgar movie &add=vulgar";
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
		String expectedOutput = "This is a ****** movie";
		
		Assert.assertEquals(expectedOutput, output);
		
		
		
	}
	
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
	public void returns_true_when_there_is_profinity_word_in_input(){
		String outputFormat = "/containsprofanity";
		String inputText = "?text=this is some test bullshit input";	
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
		
		String expectedOutput = "true";
		Assert.assertEquals(expectedOutput, output);
		
	}
	
	

}
