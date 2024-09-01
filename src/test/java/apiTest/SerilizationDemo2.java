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

public class SerilizationDemo2 
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
		Header header = new Header();
		header.setKey("myKey");
		header.setValue("myValue");
		List<Header> headelist= new ArrayList<Header>();
		headelist.add(header);
		Request request =new Request();
		request.setUrl("google.com");
		request.setMethod("htttp");
		request.setHeader(headelist);
		Info info =new Info();
		info.setDesc("creating collection");
		info.setSchema("this is sample schema");
		Item item =new Item();
		item.setName("Sample Name");
		item.setRequest(request);
		List<Item> itemlist =new ArrayList<Item>();
		itemlist.add(item);
		Collection collection = new Collection();
		collection.setInfo(info);
		collection.setItem(itemlist);
		CollectionRoot coll= new CollectionRoot();
		coll.setCollection(collection);
		
		given()
			.log().all()
			.baseUri("https://api.twilio.com")
			
		    .body(coll)
		.when()
			.post()
		.then()
			.log().all();
		
	}
	
	

}
