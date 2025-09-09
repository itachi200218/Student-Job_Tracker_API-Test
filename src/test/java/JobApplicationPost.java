import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class JobApplicationPost extends BaseURI{
    Response res;
    @Test
    public void JobSpecificPost() {
        String payload = "{"
                + "\"company\": \"Google\","
                + "\"role\": \"Frontend Developer\","
                + "\"status\": \"Applied\","
                + "\"appliedDate\": \"2024-04-09\","
                + "\"link\": \"https://example.com\""
                + "}";
        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/jobs")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        System.out.println("Status post : " + res.statusCode()+ BaseURI.token);
        res.prettyPrint();
    }
}
