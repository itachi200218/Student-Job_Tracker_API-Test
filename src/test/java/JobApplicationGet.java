import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class JobApplicationGet extends BaseURI {

    @Test
    public void JobApplicationget() {
        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get("/api/jobs")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println("Status get : " + res.statusCode());
        res.prettyPrint();

        BaseURI.token = res.jsonPath().getString("[0]._id");
        System.out.println("Stored Job ID in BaseURI.token: " + BaseURI.token);
    }
}
