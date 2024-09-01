package apiTest;
import static io.restassured.RestAssured.*;

import pojo.Root;

public class SerilizationDemo 
{
	public static void main(String args[])
	{
		Root root =new Root();
		root.setName("Sachin");
		root.SetCompany("ATOS");
		given()
			.log().all()
			.baseUri("https://api.twilio.com")
			
		    .body(root)
		.when()
			.post()
		.then()
			.log().all();
		
	}
	
	

}
