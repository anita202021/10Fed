package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import com.typesafe.config.Config;
import utilities.ConfigLoader;

import java.net.URI;

import static com.jayway.restassured.RestAssured.given;

public class ApiHelper {
    static Config conf = ConfigLoader.load();


    static String testApiUrl = conf.getString("testApiUrl");


    public static Gson gson;

    public static RequestSpecification auth() {
        RestAssured.baseURI = URI.create(testApiUrl).toString();
        return given()
                .header("Content-Type", "application/json");
    }

    protected static RequestSpecification fetchBaseUrl(String token) {
        RestAssured.baseURI = URI.create(testApiUrl).toString();
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", token);
    }

    protected static RequestSpecification fetchBaseUrlKiosk() {
        RestAssured.baseURI = URI.create(testApiUrl).toString();
        return given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "B8514F94E9E6C39B77C933EB529A1");
    }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }

}
