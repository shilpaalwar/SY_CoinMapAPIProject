package stepdefs;

import Specifications.CommonSpecs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.BasePage;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PriceConvert_stepdef{

	RequestSpecification res ;
	static Response response;
	static JsonPath jsResponse;
	static double priceInGBP, priceinDOGE;
	static Logger log = Logger.getLogger(PriceConvert_stepdef.class);
	
	@Given("User calls priceConvert API with <{int}> and <{int}> and {string}")
	public void user_calls_price_convert_api_with(Integer id, Integer amount, String convert) {
		{
			res = given().spec(CommonSpecs.requestSpec(id, amount, convert));
			log.info("Request Specification is build");
		}
	}
	

	@Given("User calls priceConvert API with <{int}> and {string}")
	public void user_calls_price_convert_api_with(Integer id, String convert) {
		{
			res = given().spec(CommonSpecs.requestSpec_double(id, priceInGBP, convert));
			log.info("Request Specification is build");
		}
	}
	
	@When("user call API with GET Request")
	public void user_call_GET_Request()
	{
		response = res.when().get(BasePage.getProperty("conversion_endpoint"))
		.then().spec(CommonSpecs.responseSpec(200)).extract().response();
		log.info("API GET Request trigger for Price conversion");
	}
	
	@Then("API Call return Success Code {int}")
	public void user_call_GET_Request(int statusCode)
	{
		assertEquals(response.getStatusCode(),statusCode);
		log.info("API Resonse Status Code is : " + response.getStatusCode());
	}
	
	
	@And("verify price in GBP in API repsonse")
	public void verify_price_in_GBP_in_APIrepsonse()
	{	
		String strResponse = response.asString();
		JsonPath js = new JsonPath(strResponse);
		priceInGBP = js.getDouble("data.quote.GBP.price");
		log.info("Price in GBP : " + priceInGBP);
	}
	
	@And("Verify price in DOGE in API repsonse")
	public void verify_price_in_DOGE_in_APIrepsonse()
	{	
		String strResponse = response.asString();
		System.out.println(strResponse);
		JsonPath js = new JsonPath(strResponse);
		priceinDOGE = js.getDouble("data.quote.DOGE.price");
		log.info("Price in DOGE : " + priceinDOGE);
	}
	
}
