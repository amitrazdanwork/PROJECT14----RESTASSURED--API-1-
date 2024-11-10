package endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.User;
import utils.ReadProperty;

public class UserEndPoints {

	//This class defined the CRUD operations methods you for your APIs

	public static Response createUser(User payload) {

		ReadProperty prop=new ReadProperty();
		
		Response response = 
				given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .body(payload)
				.when()
				  .post(prop.getPostUrl())
				  .andReturn();

		return response;

	}
	
	public static Response getUser(String username) {

		ReadProperty prop=new ReadProperty();
		
		Response response = 
				given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("username", username)
				.when()
				  .get(prop.getGetUrl())
				  .andReturn();

		return response;

	}

	
	public static Response updateUser(String username, User UserPayload) {

		ReadProperty prop=new ReadProperty();
		
		Response response = 
				given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("username", username)
				  .body(UserPayload)
				.when()
				  .put(prop.getPutUrl())
				  .andReturn();

		return response;

	}
	
	public static Response deleteUser(String username) {

		ReadProperty prop=new ReadProperty();

		Response response = 
				given()
				  .contentType(ContentType.JSON)
				  .accept(ContentType.JSON)
				  .pathParam("username", username)
				.when()
				  .delete(prop.getDeleteUrl())
				  .andReturn();

		return response;

	}
	
}
