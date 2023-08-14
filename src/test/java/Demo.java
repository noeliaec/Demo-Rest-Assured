import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    @Test
    public void testGetUsers(){
        baseURI = "https://reqres.in/api";

        String body = given()
                    .when()
                        .get("/users")
                    .then()
                        .statusCode(200)
                        .body("data[1].first_name", equalTo("Janet"))
                        .extract().body().asString();

        System.out.println(body);
    }
    @Test
    public void testPostUser(){
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Hades");
        map.put("job", "Quality Assurance");

                given()
                        .body(map.toString())
                        .log().all()
                .when()
                        .post("/users")
                .then()
                        .log().all()
                        .statusCode(201);
                }
}
