package PostRequests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class differentWaysToCreatePostRequestsBody {
	
	//post request body using hashmap
	
	//@Test
	
	void testPostUsingHashmap() {
		
		HashMap data= new HashMap();
		
		data.put("name","Luna");
		data.put("location","Finland");
		data.put("phone","1234567");
		
		String courseArr[]= {"C", "C++"};
		data.put("courses", courseArr);
		
		given()
		
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Luna"))
		.body("location", equalTo("Finland"))
		.body("phone", equalTo("1234567"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type","application/json")
		.log().all();	
		
		
	} 
	
	//post request body using org.json/json library
	//@Test
	
	void testPostUsingJsonLibrary() {
		
		JSONObject data= new JSONObject();
		
		data.put("name","Luna");
		data.put("location","Finland");
		data.put("phone","1234567");
		
		String courseArr[]= {"C", "C++"};
		data.put("courses", courseArr);
		
		given()
		
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Luna"))
		.body("location", equalTo("Finland"))
		.body("phone", equalTo("1234567"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type","application/json")
		.log().all();	
		
		
	}
	
	//@Test (priority=2)
	
	void deletePostRequest() {
		
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/bbe5")
		
		.then()
		.statusCode(200);
		
		
	}
	
	//post request body using pojo class
	@Test
	
	void testPostUsingPojo() {
		
		PojoPostRequest data= new PojoPostRequest();
		
		data.setName("Luna");
		data.setLocation("Finland");
		data.setPhone("1234567");
		String coursesArr[]= {"C","C++"}; 
		data.setCourses(coursesArr);
		
		
		given()
		
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Luna"))
		.body("location", equalTo("Finland"))
		.body("phone", equalTo("1234567"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type","application/json")
		.log().all();	
		
		
	}
	
	@Test (priority=2)
	
	void deletePostRequest() {
		
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/bd34")
		
		.then()
		.statusCode(200);
		
		
	}
}
