package api_projects.api_Jamal;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpartansTest_POJO_Deserialization {

    @BeforeClass
    public static void setUpClass() {
        baseURI = "http://54.172.251.212:8000";
    }

    @Test
    public void test() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");

        response.prettyPrint();


        Spartan spartan = response.body().as(Spartan.class);
        System.out.println(spartan.toString());

        Assert.assertEquals(spartan.getName(),"Meta");
        Assert.assertEquals(spartan.getGender(),"Female");
        Assert.assertEquals(spartan.getId(),15);
        Assert.assertEquals(spartan.getPhone(),new Long(1938695106));










    }









}