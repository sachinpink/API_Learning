package apiTest;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import pojo.Collection;
import pojo.CollectionRoot;
import pojo.Header;
import pojo.Info;
import pojo.Item;
import pojo.Request;

public class DeserilizationDemo 
{
	public static void main(String args[])
	{
		/*{
		  "collection": {
	    "info": {
	      "desc": "creating collection",
	      "schema": "this is sample schema"
	    },
	    "item": [
	      {
	        "name": "Sample Name",
	        "request": {
	          "url": "google.com",
	          "method": "htttp",
	          "header": [
	            {
	              "key": "myKey",
	              "value": "myValue"
	            }
	          ]
	        }
	      }
	    ]
	  }
	}*/
		
		
		CollectionRoot collResponseRoot	=given()
			
			.baseUri("https://run.mocky.io/v3/5b0e5ed2-02e7-4b6c-aed1-4ff1a1cb7f45")
		.when()
			.post()
		.then()
			.extract().response().as(CollectionRoot.class);
		
		String desc= collResponseRoot.getCollection().getInfo().getDesc();
		List<Item> listofItem = collResponseRoot.getCollection().getItem();
		for(Item item: listofItem)
		{
			System.out.println("name of collection = "+item.getName());
			System.out.println("URL of Request = "+item.getRequest().getUrl());
		}
		
		
		System.out.println("Desc of collection = "+desc);
		//System.out.println("name of collection = "+name);
		
		
		
	}
	
	

}
