package api_projects.api_Jamal;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SpartanTestWith_PathParameters {

   /*
    Given accept type is json
    And ID parameter value is 18
    When user send GET request to /api/spartan/{id}
    Then response status code should be 200
    And response content type should be application/json;charset=UTF-8
    And "Allen" should be in the response payload
    */
@Test
    public void spartansTest3(){

        String  spartanBaseUrl = "http://54.172.251.212:8000";
        String endpoint = "/api/spartans/";
        int idValue = 18;

        //Given accept type is json
       Response response = RestAssured.given().accept("application/json")
                           .when().get(spartanBaseUrl+endpoint+idValue);

       // Verifying status code
       int expectedStatusCode = 200;
       int actualStatusCode = response.statusCode();
       // System.out.println(actualStatusCode);
       Assert.assertEquals(actualStatusCode,expectedStatusCode);


       // Verifying response content type is application/json
        String actualContentType = response.contentType();
        String expectedContentType = "application/json";
    System.out.println("actual content type: "+actualContentType);
    Assert.assertEquals(actualContentType,expectedContentType);



   //  Verify "Allen" is in the response payload

    Assert.assertTrue(response.asString().contains("Allen"));


    }






 /*
    Given accept type is json
    And ID parameter value is 500
    When user send GET request to /api/spartan/{id}
    Then response status code should be 404
    And response content type should be application/json;charset=UTF-8
    And "Not Found" message should be in the response payload
    */

    @Test
    public void spartanNegative(){


   /* The Blow is my approach

      String  spartanBaseUrl = "http://54.172.251.212:8000";
       String endpoint = "/api/spartans/";
       int idValue = 500;

     //  Given accept type is json
     //  And ID parameter value is 500
     //  When user send GET request to /api/spartan/{id}

       Response response = RestAssured.given().accept("application/json")
                          .when().get(spartanBaseUrl+endpoint+idValue);


    */

        RestAssured.baseURI = "http://54.172.251.212:8000";
        Response response = RestAssured.given().accept(ContentType.JSON).and().pathParam("id",18)
                .when().get("/api/spartans/{id}");

        // Then response status code should be 404
        int actualStatusCode = response.statusCode();
        int expectedStatusCode = 404;
        // System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode,expectedStatusCode);


//    And response content type should be application/json;charset=UTF-8

        String expectedContentType = "application/json";
        String actualContentType  = response.contentType();
        Assert.assertEquals(actualContentType,expectedContentType);


        //   And "Not Found" message should be in the response payload

        String expectedMessage = "Not Found";
        boolean result  = response.asString().contains(expectedMessage);
        System.out.println(result);







    }


}
