import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class JobApplicationDel {
    @Test
    public void dele(){
        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/api/jobs/"+BaseURI.token)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        System.out.println("Status delete: " + res.statusCode());
        res.prettyPrint();

        BaseURI.token = res.jsonPath().getString("[0]._id");

    }
    }

