package Specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utility.BasePage;

import static io.restassured.RestAssured.*;

public class CommonSpecs {
	static RequestSpecification reqspec ; 

	public static RequestSpecification requestSpec(int id, int amount, String convert)
	{
		return new RequestSpecBuilder().setBaseUri(BasePage.getProperty("baseURL"))
				.addHeader("Accept","application/json")
				.addHeader("X-CMC_PRO_API_KEY", "44ec6add-a43b-4be4-9cfb-1c6285788c55")
				.addQueryParam("id", id)
				.addParam("amount", amount)
				.addQueryParam("convert", convert)
				.build();
	}
	
	public static ResponseSpecification responseSpec(int statusCode)
	{
		return new ResponseSpecBuilder().expectStatusCode(200)
				.build();
	}

	public static RequestSpecification requestSpec_double(Integer id, double priceInGBP, String convert) 
	{
		return new RequestSpecBuilder().setBaseUri(BasePage.getProperty("baseURL"))
				.addHeader("Accept","application/json")
				.addHeader("X-CMC_PRO_API_KEY", "44ec6add-a43b-4be4-9cfb-1c6285788c55")
				.addQueryParam("id", id)
				.addParam("amount", priceInGBP)
				.addQueryParam("convert", convert)
				.build();
	
}
}
