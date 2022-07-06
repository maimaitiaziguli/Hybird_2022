package api_projects.api_Jamal;

import static io.restassured.RestAssured .*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class SpartanTestWith_Hamcrest_Chaining {


    @BeforeClass
    public static void setUpClass(){
        baseURI = "http://54.172.251.212:8000";
    }
     /*
  Given accept type is json
  And path parameter id is 15
  When user sends request to "/spartans/{id}"
  Then status code is 200
  And content-type is "application/json;char
  And json data has following
  "id": 15
  "name": "Meta"
  "gender": "Female"
  "phone": 1938695106
   */

    @Test
    public void test1 (){

        // request body
        given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{id}")
                      // response body
                .then().statusCode(200)
                .and()
                .assertThat().contentType("application/jso");
    }


    @Test
    public void test2(){


        // chaining the the request and response using Hamcrest Matchers

 // request
        given().accept(ContentType.JSON).pathParam("id",15)
                .when().get("/api/spartans/{id}")
// response
                .then().assertThat().statusCode(200).and()
                .assertThat().contentType("application/json").and()
                .assertThat().body("id",equalTo(15),"name",equalTo("Meta"),
                "gender",equalTo("Female"),"phone",equalTo(1938695106));


// assertThat()
    }


}
