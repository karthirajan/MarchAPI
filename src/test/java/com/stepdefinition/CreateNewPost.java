package com.stepdefinition;

import java.util.HashMap;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestModel.CreateOrder;

public class CreateNewPost {
	
	static RequestSpecification requestSpec;
	static Response response;
	
	@Given("^user is using the baseURI$")
	public void user_is_using_the_baseURI() throws Throwable {
		
		RequestSpecification request = RestAssured.with();
		 requestSpec = request.given().contentType(ContentType.JSON).baseUri("http://petstore.swagger.io/v2/");
	    
	}

	@When("^The user makes the post call to the endpoint \"([^\"]*)\" with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_makes_the_post_call_to_the_endpoint_with_and(String endpoint, String Id, String petId, String qnty, String shipdate, String status, String complete) throws Throwable {
	    
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		CreateOrder order = new CreateOrder();
		order.setId(Integer.parseInt(Id));
		order.setPetId(Long.parseLong(petId));
		order.setQuantity(Long.parseLong(qnty));
		order.setShipDate(shipdate);
		order.setStatus(status);
		order.setComplete(Boolean.parseBoolean(complete));
	   response = requestSpec.body(order).headers(headers).post(endpoint);
		
		
	}

	@Then("^user need to get a response code: (\\d+)$")
	public void user_need_to_get_a_response_code(int code) throws Throwable {
		
		Assert.assertEquals(code, response.getStatusCode());
		System.out.println("march batch execution"+response.getStatusCode());
	    
	}

	@When("^User retrive order details \"([^\"]*)\"$")
	public void user_retrive_order_details(String endpoint) throws Throwable {
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		 response = requestSpec.headers(headers).get(endpoint);
	   
	}

	@When("^validate the details$")
	public void validate_the_details() throws Throwable {
		String text = response.getBody().asString();
		System.out.println("get method :"+text);
	    
	}




}
