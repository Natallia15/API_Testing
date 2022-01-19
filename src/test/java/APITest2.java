import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest2 {

    Root pet = new Root(125,null,"Bobic",null,null,null);

    @Test
    public void second() {
        Root root = given()
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2")
                .body(pet)
                .when()
                .post("pet/")
                .as(Root.class);
        System.out.println(root.name);
    }
}
