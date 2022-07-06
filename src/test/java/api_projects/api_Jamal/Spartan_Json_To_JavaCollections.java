package api_projects.api_Jamal;

import static io.restassured.RestAssured.*;

import io.cucumber.plugin.event.Node;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

public class Spartan_Json_To_JavaCollections {

    @BeforeClass
   public static void setUpClass(){
       RestAssured.baseURI ="http://54.172.251.212:8000";
  }

    /*
  Given accept type is json
  And path parameter id is 11
  When user sends request to "/spartans/{id}"
  Then status code is 200
  And content-type is "application/json;char
  And response payload value match the following
  "id" : 11
  "name" : "Nona"
  "gender" : "Female"
  "phone":  7959094216
   */
@Test
    public void test1(){

    // Given accept type is json
    //  And path parameter id is 11
    //  When user sends request to "/spartans/{id}"
    Response response = given().accept(ContentType.JSON)
                        .pathParam("id",11)
                        .and().when().get("/api/spartans/{id}");

    // Then status code is 200
    //  And content-type is "application/json;char
    Assert.assertEquals(response.statusCode(),200);
    Assert.assertEquals(response.contentType(),"application/json");


    // And response payload value match the following
    //  "id" : 11
    //  "name" : "Nona"
    //  "gender" : "Female"
    //  "phone":  7959094216

    // first convert the response body (Json) to collection(Map)
    Map<String , Object> spartansMap = response.body().as(Map.class);

    int id = (int) spartansMap.get("id");
    System.out.println("id = " +  spartansMap.get("id"));
    // or
   System.out.println(id);

   Assert.assertEquals("Verification Failed",spartansMap.get("id"),11);


    System.out.println(spartansMap.get("name"));
    Assert.assertEquals(spartansMap.get("name"),"Nona");
    // or
    String name = (String)spartansMap.get("name");
    System.out.println(name);
    Assert.assertEquals(name,"Nona");


    System.out.println(spartansMap.get("gender"));
    Assert.assertEquals(spartansMap.get("gender"),"Female");
    // or
    String gender = (String) spartansMap.get("gender");
    System.out.println(gender);
    Assert.assertEquals(gender,"Female");


    System.out.println(spartansMap.get("phone"));
   // Assert.assertEquals(spartansMap.get("phone"),7959094216); we can not 
    // or
    long phone = (long)spartansMap.get("phone");
    Assert.assertEquals(spartansMap.get("phone"),phone);




}






}
