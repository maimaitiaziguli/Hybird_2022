package api_projects.api_Jamal;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SpartanTest1 {

 /*
 When user send GET request to /api/spartans/ endpoint :
 Then status code mut be 200
 And body should contain Allen
  */

  String spartanBaseUrl = "http://54.172.251.212:8000";
  String endpoint = "/api/spartans";

  @Test
  public void viewSpartans(){
     Response response =  RestAssured.get(spartanBaseUrl+endpoint);

     // print status code
     System.out.println("Status code: "+response.statusCode());

     // print body
      System.out.println(response.body().prettyPrint());

    // Verify status code 200
      Assert.assertEquals(response.statusCode(),200);

      // verify body contains Allen
      Assert.assertTrue(response.body().asString().contains("Allen"));
  }




}
