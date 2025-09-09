import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseURI {
    public static String token;
   @BeforeClass
    public void BaseUri(){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://student-job-tracker-1-q8rh.onrender.com";
    }
}
