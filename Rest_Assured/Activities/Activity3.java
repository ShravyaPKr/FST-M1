package RestAssuredActivities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	RequestSpecification requestSpecifi;
	ResponseSpecification responseSpecifi;

	@BeforeClass
	public void setUp() {
		// Create request specification
		requestSpecifi = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				// Setting base URL
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.build();

		responseSpecifi = new ResponseSpecBuilder()
				// Checking status code in response
				.expectStatusCode(200)
				// Checking response content type
				.expectContentType("application/json")
				// Checking if response contains name property
				.expectBody("status", equalTo("alive"))
				// Build response specification
				.build();
	}

	@DataProvider
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { { 77232, "Riley", "alive" }, { 77233, "Hansel", "alive" } };
		return testData;
	}

	@Test(priority = 1)
	// Test case using a DataProvider
	public void addPets() {
		String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
		Response response = given().spec(requestSpecifi)
				.body(reqBody) 
				.when().post();

		reqBody = "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";
		response = given().spec(requestSpecifi) 
				.body(reqBody) 
				.when().post(); 

		// Assertions
		response.then().spec(responseSpecifi); 
	}

	// Test case using a DataProvider
	@Test(dataProvider = "petInfoProvider", priority = 2)
	public void getPets(int id, String name, String status) {
		Response response = given().spec(requestSpecifi) 
				.pathParam("petId", id)
				.when().get("/{petId}"); 

		System.out.println(response.asPrettyString());
		// Assertions
		response.then().spec(responseSpecifi)
				.body("name", equalTo(name)); // Additional Assertion
	}

	// Test case using a DataProvider
	@Test(dataProvider = "petInfoProvider", priority = 3)
	public void deletePets(int id, String name, String status) {
		Response response = given().spec(requestSpecifi)
				.pathParam("petId", id) 
				.when().delete("/{petId}");

		// Assertions
		response.then().body("code", equalTo(200));
	}

}
