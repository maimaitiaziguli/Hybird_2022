package api_projects.api_Jamal;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpartanTestWith_Json_Path {

    /*
  Given accept type is json
  And path parameter id is 11
  When user sends request to "/spartans/{id}"
  Then status code is 200
  And content-type is "application/json;char
  And response payload value match the following
  id is 11
  name is "Nona"
  gender is "Female"
  phone is 7959094216
   */

    @BeforeClass
    public static void setUpClass(){

    RestAssured.baseURI = "http://54.172.251.212:8000";
}

         @Test
        public void test (){

              // Given accept type is json
             //  And path parameter id is 11
             //  When user sends request to "/spartans/{id}"

             Response response = RestAssured.given().accept(ContentType.JSON)
                                 .pathParam("id",11)
                                 .when().get("/api/spartans/{id}");

             //  Then status code is 200
             int statusCode  = response.statusCode();
             Assert.assertEquals(statusCode,200);


             // This is how to read value with path()method
             int id = response.path("id");
             System.out.println("id = " + id);

             String name = response.path("name");
             System.out.println("name = " + name);

             long phone = response.path("phone");
             System.out.println("phone = " + phone);



             //This is  how read value with jsonPath
             // first create JsonPath class object then store the
             // jsonPath data to the created object
             JsonPath jsonPath = response.jsonPath();


             int id2 = jsonPath.getInt("id");
             System.out.println("id2 = " + id2);

          String name2 =  jsonPath.getString("name");
             System.out.println("name2 = " + name2);

             String gender2 = jsonPath.getString("gender");
             System.out.println("Gender2: "+gender2);

             long phoneNumber2 = jsonPath.getLong("phone");
             System.out.println("phoneNumber2 = " + phoneNumber2);





            //  And content-type is "application/json;char
             Assert.assertTrue(response.contentType().equals("application/json"));




             // id is 11
             //  name is "Nona"
             //  gender is "Female"
             //  phone is 7959094216






         }


}
