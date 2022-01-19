import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
 import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
 import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class APITest {
   @Test
    public void first(){
      Root[] pets = given()
               .contentType(ContentType.JSON)
               .baseUri("https://petstore.swagger.io/v2")
               .when()
              .get("pet/findByStatus?status=sold")
               //.then()
               //.statusCode(200)
               .body()
               //.prettyPrint();
                .as(Root[].class);
       for (int i=0; i<pets.length; i++){
           System.out.println(pets[i].toJson());
       }
    }
    @Test
    public void second(){
        Root pets = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                //.when()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                //.then()
                //.statusCode(200)
               .post("/pet")
                .as(Root.class);
               System.out.println(pets.toJson());
            }

       /* Root pet1 = new Root(12222, new Category(1,"dog"),"Bobic",null,null,"sold");
    @Test
    public void third(){
        Root pets = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                //.when()
                .body(pet1)
                //.then()
                //.statusCode(200)
                .post("/pet")
                .as(Root.class);
        System.out.println(pets.name);
    }*/
    @Test
    public void exam_9() {
        Root_1 pets = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")

                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"string\",\n" +
                        "    \"firstName\": \"string\",\n" +
                        "    \"lastName\": \"string\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"string\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("/user/createWithArray")
                .as(Root_1.class);
        System.out.println(pets.toJson());
    }
    @Test
    public void exam() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
               request.body("[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"string\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]");
        Response response = request.post("https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
        Root_1 mes = response.as(Root_1.class);
        Assert.assertEquals(mes.message, "ok");
        System.out.println("message: "+mes.message);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The status code recieved: " + statusCode);
    }
    @Test
    public void getUserByLogin(){
        Root_3 user = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get(
                        "/user/login")
                //.then()
                //.statusCode(200)
                .body()
                //.prettyPrint();
                .as(Root_3.class);

            System.out.println(user.toJson());
        }
    }


