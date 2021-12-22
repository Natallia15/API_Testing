import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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
          // System.out.println(pets[i].toJson());
       }
    }

// "pet/findByStatus?status=sold"
}