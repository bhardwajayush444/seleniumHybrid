package factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.configReader;
import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class apiFactory {
    private configReader FileReader;
    Properties props;
    public static String baseURI;
    public static String jsonString;

    public apiFactory(){
        FileReader=new configReader();
        props=FileReader.init_prop();
        baseURI=props.getProperty("baseURI");
        System.out.println("inside api factory constructor");
    }

    public static RequestSpecification getBasicRequest(Map<String,String> requestHeaders){
        RequestSpecBuilder requestBuilder=new RequestSpecBuilder().setBaseUri(baseURI)
                .addHeaders(requestHeaders).log(LogDetail.ALL);
        RequestSpecification specification=requestBuilder.build();
        return specification;
    }
    public static ResponseSpecification getBasicResponse(){
        ResponseSpecBuilder responseBuiilder=new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        ResponseSpecification responseSpecification=responseBuiilder.build();
        return responseSpecification;
    }

    public static Response hitGetRequest1(String url){
        Map<String,String> RequestHeaders=new HashMap<>();
        RequestHeaders.put("Content-Type","application/json");
        Response response=given().spec(getBasicRequest(RequestHeaders)).when().get(url).then().spec(getBasicResponse())
                .extract().response();
        return response;

    }

    public static Response hitPostRequest(String url,String JsonBody){
        Map<String,String> RequestHeaders=new HashMap<>();
        RequestHeaders.put("Content-Type","application/json");
        Response response=given().spec(getBasicRequest(RequestHeaders)).body(JsonBody).when().post(url)
                .then().spec(getBasicResponse()).extract().response();
        return response;
    }
    public static Response hitPutRequest(String url,String JsonBody){
        Map<String,String> RequestHeaders=new HashMap<>();
        RequestHeaders.put("Content-Type","application/json");
        Response response=given().spec(getBasicRequest(RequestHeaders)).body(JsonBody).when()
                .put(url).then().spec(getBasicResponse()).extract().response();
        return response;
    }
    public static String getJsonString(Object myObj){
        ObjectMapper mapper=new ObjectMapper();
        try {
             jsonString=mapper.writeValueAsString(myObj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;

    }

    public static void validateJSONSchema(String schema,Response response){
        String schemaName=schema+".json";
        File file=new File("./src/test/resources/schema/"+schemaName);
        ValidatableResponse vresponse=response.then();
        vresponse.body(matchesJsonSchema(file));

    }
}
