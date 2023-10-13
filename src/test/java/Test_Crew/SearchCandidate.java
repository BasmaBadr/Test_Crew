package Test_Crew;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SearchCandidate {
    Login login ;
    @Test
    public void searchCandidate() {
        login = new Login();
        login.Login_Testcases();

        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates";
        String Json = "{\n" +
                "\"vacancyId\":\"4\",\n" + "}";

        given().auth().oauth2(login.Token)

                .contentType("application/json")
                .get(Json)
                .then().log().all()
                .assertThat().statusCode(200).and()
                // .body("responseMessage", Is.is ("Success"))
                .extract().response()
        ;
    }
}
