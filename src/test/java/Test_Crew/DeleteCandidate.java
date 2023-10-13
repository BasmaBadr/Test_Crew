package Test_Crew;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteCandidate {

Login login;
    @Test
    public void deleteCandidate() {
        login = new Login();
        login.Login_Testcases();

        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates";
        String Json = "{\n" +
                "\"id\":\"20\",\n" + "}";

          given().auth().oauth2(login.Token)

                .contentType("application/json")
                .delete(Json)
                .then().log().all()
                .assertThat().statusCode(200).and()
                // .body("responseMessage", Is.is ("Success"))
                .extract().response()
        ;
    }
}
