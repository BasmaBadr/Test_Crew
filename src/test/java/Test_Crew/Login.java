package Test_Crew;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class Login {
    public Object String;

    public String Token;

    @Test
    public void Login_Testcases() {
        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String Json = "{\n" +
                "            \"Username\": \"Admin\",\n" +
                "            \"Password\": \"admin123\",\n" +

                "}";
        Response response = given()
//                .auth().preemptive()
//                .basic("ADMIN_PANEL", "Web@Admin#123")
                .contentType("text/html; charset=UTF-8")
                .body(Json).log().all()
                .get().then().log().all()
                .assertThat().statusCode(200).and()
                .extract().response();
          Token = response.path("token");

         System.out.println(Token);



    }
}
