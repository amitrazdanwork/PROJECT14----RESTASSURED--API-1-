package tests.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;

import org.hamcrest.Matcher;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import payloads.User;
import utils.DataProviders;

public class PostTests {

	User userpayload;

	/* -------------------- POST API - TESTS ----------------------- */
	@Test(description = "Validate that API should return API status code within 2XX series", groups = {
			"USER - POST API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 1)
	public void PostUserTestMethod1(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		Response response = UserEndPoints.createUser(userpayload);
		Matcher<String> matcher1 = matchesPattern("^20[0-9]$");
		// Boolean res = matcher1.matches(String.valueOf(response.getStatusCode()));

		System.out.println("Response : " + response.asPrettyString() + " username :" + this.userpayload.getUsername());
		assertThat("Assertion 1", matcher1.matches(String.valueOf(response.getStatusCode())));

	}

	@Test(description = "Validate that API should return API status code as 200", groups = {
			"USER - POST API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 2)
	public void PostUserTestMethod2(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		Response response = UserEndPoints.createUser(userpayload);
		assertThat(response.getStatusCode(), is(200));

	}

	@Test(description = "Validate that API should return a response payload i.e. Non-empty response body and response header", groups = {
			"USER - POST API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 3)
	public void PostUserTestMethod3(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);
		Response response = UserEndPoints.createUser(userpayload);

		String responseBody = response.getBody().toString();
		assertThat(responseBody, not(isEmptyString()));

		String responseHeaders = response.getHeaders().toString();
		assertThat(responseHeaders, not(isEmptyString()));

	}

	@Test(description = "Validate that API should return response of type = JSON", groups = {
			"USER - POSt API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 4)
	public void PostUserTestMethod4(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		Response response = UserEndPoints.createUser(userpayload);

		assertThat(response.getContentType(), is("application/json"));

	}

	@Test(description = "Validate that API should should adhere to Response structure as per data model mentioned in API Spec or API Doc.- JSON SCHEMA VALIDATION", groups = {
			"USER - POSt API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 5)
	public void PostUserTestMethod5(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		Response response = UserEndPoints.createUser(userpayload);
		assertThat(response.jsonPath().prettyPrint(),
				JsonSchemaValidator.matchesJsonSchemaInClasspath("User\\Post_JsonSchema.json"));
	}

	@Test(description = "Valdiate that API should return response body as per the req spec", groups = {
			"USER - POST API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 6)
	public void PostUserTestMethod6(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		Response response = UserEndPoints.createUser(userpayload);

		assertThat(response.body().jsonPath().get("code"), is(200));
		assertThat(response.body().jsonPath().get("type"), is("unknown"));

//		System.out.println("Message :"+response.body().jsonPath().get("message"));

		assertThat(response.body().jsonPath().get("message").toString().length(), is(greaterThan(6)));
	}

	@Test(description = "Valdiate that API should return response headers as per the req spec", groups = {
			"USER - POST API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 7)
	public void PostUserTestMethod7(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		Response response = UserEndPoints.createUser(userpayload);

		Headers headers = response.getHeaders();

		assertThat("Contains required headers", headers.hasHeaderWithName("Content-type"));

		assertThat(response.getHeader("Content-type"), is("application/json"));
	}

}
