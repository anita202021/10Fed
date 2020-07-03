package services;

import com.jayway.restassured.response.Response;
import helpers.ApiHelper;

public class RegisterKioskService extends ApiHelper {

    public static Response getRegistrationNo() {
        return fetchBaseUrlKiosk().get("/api/Kiosk/generate-registration-key");
    }
}
