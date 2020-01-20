package hw_3.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;

public class MobileCloudRestApi {

    private static final String ROOT_URL = ApiProperties.getInstance().getProperty("path");;
    private static final String DEVICE = "device/";
    private static final String INSTALL = "storage/install/";
    public static final String PROPERTY_TOKEN = ApiProperties.getInstance().getProperty("token");;
    public static final String SERIAL = ApiProperties.getInstance().getProperty("serial");

    private MobileCloudRestApi() {
    }

    private HashMap<String, String> params = new HashMap<>();
    private static File fileApp;

    public static class RequestBuilder {
        MobileCloudRestApi mobileCloudRestApi;

        private RequestBuilder(MobileCloudRestApi mobileCloudRestApi) {
            this.mobileCloudRestApi = mobileCloudRestApi;
        }

        //Install application on the device
        public Response installApp(){
            return RestAssured
                    .given()
                        .spec(requestSpecification())
                    .with()
                        .queryParams(mobileCloudRestApi.params)
                        .multiPart("file", fileApp)
                        .contentType("multipart/form-data")
                        .log().all()
                    .when()
                        .post(ROOT_URL + INSTALL)
                    .prettyPeek();
        }

        //Search for fully operational, available device
        public Response getDevice() {
            return RestAssured
                    .given()
                        .spec(requestSpecification())
                    .with()
                        .queryParams(mobileCloudRestApi.params)
                        .log().all()
                    .when()
                        .post(ROOT_URL + DEVICE)
                    .prettyPeek();
        }

        public RequestBuilder serial(String serialNumber) {
            mobileCloudRestApi.params.put("serial", serialNumber);
            return this;
        }

        public RequestBuilder file(File fileApp) {
            mobileCloudRestApi.fileApp = fileApp;
            return this;
        }
    }

    public static RequestBuilder with() {
        MobileCloudRestApi mobileCloudApi = new MobileCloudRestApi();
        return new RequestBuilder(mobileCloudApi);
    }


    private static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType("JSON")
                .setAccept("JSON")
                .addHeader("Authorization", "Bearer " + PROPERTY_TOKEN)
                .build();
    }
}
