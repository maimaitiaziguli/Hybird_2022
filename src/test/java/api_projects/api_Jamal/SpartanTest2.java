package api_projects.api_Jamal;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SpartanTest2 {


    @Test
    public void viewSpartans2(){

        /*
        Given accept type is jason
        When user send GET request to spartanUrl
        Then response status code 200
        And response body should be json format
         */

        String  spartanBaseUrl = "http://54.172.251.212:8000";
        String endpoint = "/api/spartans";


        // Given accept type is jason
        // add accept type and store response body into a variable
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseUrl+endpoint);

        //verify status code 200
        Assert.assertEquals(response.statusCode(),200);

        // verify response body json format
Assert.assertEquals(response.contentType(),"application/json");

    }








}
