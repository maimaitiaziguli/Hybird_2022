package api_projects.api_Jamal;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class SpartanTestWith_Path_Method {



  @BeforeClass
  public static void setUpClass(){
      RestAssured.baseURI = "http://54.172.251.212:8000";
  }

  /*
  Given accept type is json
  And path parameter id is 10
  When user sends request to "/spartans/{id}"
  Then status code is 200
  And content-type is "application/json;char
  And response payload value match the following
  id is 10
  name is "Lorenza"
  gender is "Female"
  phone is 3312820936
   */



    @Test  // first solution (me)
    public void pathMethodTest(){


       // Given accept type is json
       // And path parameter id is 10
       Response response = RestAssured.given().accept(ContentType.JSON)
               .pathParam("id", 10)
               .when().get("/api/spartans/{id}");


        //  verifying
        //          id is 10
        //        name is "Lorenza"
        //        gender is "Female"
        //        phone is 3312820936


        Assert.assertTrue(response.body().asString().contains("Lorenza"));
        Assert.assertTrue(response.body().asString().contains("Female"));
        Assert.assertTrue(response.body().asString().contains("3312820936"));

        // verifying status code 200
        Assert.assertEquals("Status code is not verified",200, response.statusCode());

        //verify content-type is json
        Assert.assertTrue(response.contentType().equals("application/json"));

response.prettyPrint();


    }



    @Test  // second solution
    public void pathMethodTest2(){


        // Given accept type is json
        //  And path parameter id is 10
        //  When user sends request to "/spartans/{id}"

       Response response = RestAssured.given().accept(ContentType.JSON)
                           .pathParam("id",10)
                           .when().get("/api/spartans/{id}");


       // Then status code is 200
        long statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);

        //  And content-type is "application/json;char
        String contentType = response.contentType();
        Assert.assertEquals(contentType,"application/json");

        //  And response payload value match the following
        //  id is 10
        int ID = response.path("id");
        System.out.println("ID = " + ID);

        //  name is "Lorenza"
        String name = response.body().path("name").toString();
        System.out.println("name = " + name);

        //  gender is "Female"
        String gender = response.body().path("gender").toString();
        System.out.println("gender = " + gender);

        //  phone is 3312820936
        long phone = response.body().path("phone");
        System.out.println("phone = " + phone);

        // verify
        Assert.assertEquals(ID,10);
        Assert.assertEquals(name,"Lorenza");
        Assert.assertEquals(gender,"Female");
        Assert.assertEquals(phone,3312820936l);



    }



    @Test
    public void test3(){

       Response response = RestAssured.get("/api/spartans");

       // Extract all the ids and print them
      List<Integer> ids =  response.path("id");
        System.out.println("id = " + ids);

        // Extract all the names and print them
        List<String> listOfNames = response.path("name");
        System.out.println("listOfNames = " + listOfNames);
        System.out.println("size of names = " + listOfNames.size());
        System.out.println("==================================================");
        System.out.println("names = " +listOfNames.get(9));

        // Extract all the genders and print them
        List<String> listOfGender = response.path("gender");
        System.out.println("listOfGender = " + listOfGender);

        // Extract all the phones and print them
        List<Integer> listOfPhoneNumbers = response.path("phone");
        System.out.println("listOfPhoneNumbers = " + listOfPhoneNumbers);


 // ===============================================================================

        // Extract the the id 9 and print them
        int id = response.path("id[9]");
        System.out.println("id = " + id);

        // Extract the the first id  and print them
        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        // Extract the the last id  and print them
        int lastId = response.path("id[-1]");
        System.out.println("lastId = " + lastId);


        // Extract the tenth name
        String name = response.path("name[9]");
        System.out.println("name = " + name);
        // or
        System.out.println("name = " +listOfNames.get(9));


        // Extract the first name
        String firstName = response.path("name[0]");
        System.out.println("first name = " + firstName);
        // or
        System.out.println("name = " +listOfNames.get(0));


        System.out.println("+++++++++________________________+++++++++++++============");

        // Extract the last name
        String lastName = response.path("name[-1]");
        System.out.println("last name = " + lastName);



        String gender = response.path("gender[9]");
        System.out.println("gender = " + gender);

        long phone = response.path("phone[9]");
        System.out.println("phone = " + phone);









    }



}

