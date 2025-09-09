import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class JobApplicationPut extends BaseURI {

    @Test
    public void Put() {
        String payload = "{\"status\": \"Offer\"}";

        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put("/api/jobs/"+BaseURI.token)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Status Put : " + res.getStatusCode());
        res.prettyPrint();
    }
}
