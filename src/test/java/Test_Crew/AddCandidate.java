package Test_Crew;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class AddCandidate {


    Login login ;

        @Test
        public void addCandidate() {
            login = new Login();
            login.Login_Testcases();

            RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates";
            String Json = "{\n" +
                    "\"firstName\":\"Basma\",\n" +
                    "\"lastName\":\"Badr\",\n" +
                    "\"email\":\"abc@artbc.abc\"\n" +
                    "}";

              given().auth().oauth2(login.Token)

                    .contentType("application/json")
                    .post(Json)
                    .then().log().all()
                    .assertThat().statusCode(200).and()
                    // .body("responseMessage", Is.is ("Success"))
                    .extract().response()
            ;
        }


    }
