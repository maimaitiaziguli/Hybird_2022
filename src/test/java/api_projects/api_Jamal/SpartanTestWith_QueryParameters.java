package api_projects.api_Jamal;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class SpartanTestWith_QueryParameters {


    /*
    Given accept type is json
    And query parameter values are:
    gender/Female
    nameContains/e
    When user send GET request to /api/spartans/search
    Then response status code should be 200
    And response content type should be application/json;charset=UTF-8
    And "Female" should be in the response payload
    */


   // My First Approach:
   /*
    @BeforeClass
    public static void setUpClass(){
        RestAssured.baseURI = "http://54.172.251.212:8000";
    }

@Test
    public void testWithQueryParms (){
        String queryParameter = "/?gender=Female&nameContains=g";
        Response response = RestAssured.given().accept(ContentType.JSON).when()
                           .get("/api/spartans/search"+queryParameter);
        response.prettyPrint();


        // verify response code 200
    Assert.assertEquals(    response.statusCode(),200);

    // verify response content type "application/json"
    Assert.assertEquals(response.contentType(),"application/json");

    //  verify "Female" is in the response payload
    Assert.assertTrue(response.body().asString().contains("Female"));

    }
     */


    // Second Approach (recommended)
//( we changed the import classes of RestAssured and JUnit Assert (changed to static))

    @BeforeClass
    public static void setUpClass(){
        baseURI = "http://54.172.251.212:8000";
    }

    @Test
    public void queryParam1(){

        //   Given accept type is json
        //    And query parameter values are:
        //    gender/Female
        //    nameContains/e
        //   When user send GET request to /api/spartans/search
     Response response =  given().accept(ContentType.JSON)
                         .queryParam("gender","Female")
                         .queryParam("nameContains","j")
                         .when().get("/api/spartans/search");


       // hen response status code should be 200
        assertEquals(response.statusCode(),200);

        //    And response content type should be application/json;charset=UTF-8
        assertEquals(response.contentType(),"application/json");

        //    And "Female" should be in the response payload
             assertTrue(response.body().asString().contains("Female"));

        // verify there is no "Male" in the payload
        assertFalse(response.body().asString().contains("Male"));

        //    And "Janette" should be in the response payload
        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();

    }



    @Test
    public void queryParam2(){

        // creating a map for queries
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("gender","Female");
        queryMap.put("nameContains","j");

        //   Given accept type is json
        //    And query parameter values are:
        //    gender/Female
        //    nameContains/e
        //   When user send GET request to /api/spartans/search
        Response response =  given().accept(ContentType.JSON)
                .queryParams(queryMap)
                .when().get("/api/spartans/search");


        // hen response status code should be 200
        assertEquals(response.statusCode(),200);

        //    And response content type should be application/json;charset=UTF-8
        assertEquals(response.contentType(),"application/json");

        //    And "Female" should be in the response payload
        assertTrue(response.body().asString().contains("Female"));

        // verify there is no "Male" in the payload
        assertFalse(response.body().asString().contains("Male"));

        //    And "Janette" should be in the response payload
        assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();




    }





}
