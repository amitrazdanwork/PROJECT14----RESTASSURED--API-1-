package tests.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import payloads.User;
import utils.DataProviders;

public class PutTests {

	Faker faker;
	User userpayload;

	/* -------------------- PUT API - TESTS ----------------------- */
	@Test(description = "Validate that API should return API status code within 2XX series", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 15)
	public void PutUserTestMethod1(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are teh elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);

		System.out.println(response.asPrettyString());

		Matcher<String> matcher1 = matchesPattern("^20[0-9]$");
		assertThat("Assertion 1", matcher1.matches(String.valueOf(response.getStatusCode())));
	}

	@Test(description = "Validate that API should return API status code as 200", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 16)
	public void PutUserTestMethod2(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {
	
		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);
		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are teh elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);
		assertThat(response.getStatusCode(), is(200));

	}

	@Test(description = "Validate that API should return a response payload ie. Non-empty response body and response header", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 17)
	public void PutUserTestMethod3(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are teh elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);

		String responseBody = response.getBody().toString();
		assertThat(responseBody, not(isEmptyString()));

		String responseHeaders = response.getHeaders().toString();
		assertThat(responseHeaders, not(isEmptyString()));

	}

	@Test(description = "Validate that API should return response of type = JSON", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 18)
	public void PutUserTestMethod4(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are teh elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);

		assertThat(response.getContentType(), is("application/json"));

	}

	@Test(description = "Validate that API should should adhere to Response structure as per data model mentioned in API Spec or API Doc.- JSON SCHEMA VALIDATION", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 19)
	public void PutUserTestMethod5(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);
		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are teh elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);

		assertThat(response.jsonPath().prettyPrint(),
				JsonSchemaValidator.matchesJsonSchemaInClasspath("User\\Put_JsonSchema.json"));

	}

	@Test(description = "Valdiate that API should return response body with details of all existing users", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 20)
	public void PutUserTestMethod6(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are teh elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);

		assertThat(response.getBody().jsonPath().get("code"), is(200));
		assertThat(response.getBody().jsonPath().get("type"), is("unknown"));
		assertThat(response.getBody().jsonPath().get("message").toString().length(), is(greaterThan(6)));

	}

	@Test(description = "Validate that API should return response headers as per the spec", groups = {
			"USER - PUT API" }, dataProvider = "AllData", dataProviderClass = DataProviders.class, priority = 21)
	public void PutUserTestMethod7(String UserId, String Username, String Firstname, String Lastname, String Email,
			String Password, String Phone, String Status) {

		faker=new Faker();
		userpayload = new User();

		userpayload.setId(Integer.valueOf(UserId));
		userpayload.setEmail(Email);
		userpayload.setFirstName(Firstname);
		userpayload.setLastName(Lastname);
		userpayload.setPassword(Password);
		userpayload.setUserStatus(Integer.valueOf(Status));
		userpayload.setUsername(Username);

		UserEndPoints.createUser(userpayload); // Pre-requisite

		// Below mentioned are the elements that we want to update for the user we
		// created in previous createUser request.
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(1);

		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), this.userpayload);

		assertThat(response.getHeader("access-control-allow-headers"), is("Content-Type, api_key, Authorization"));
		assertThat(response.getHeader("Access-Control-Allow-Methods"), is("GET, POST, DELETE, PUT"));
	}

}
