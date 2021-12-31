package stepDefs;

import POJO.user;
import factory.apiFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class apiStepDefs {
    @Autowired
    private apiFactory apiSpec;

    public static Response response;
    public static ValidatableResponse vresponse;

    @Given("user hits the get request with id {int}")
    public void hitGetRequest(int id){
        apiSpec=new apiFactory();
        response=apiFactory.hitGetRequest1("/api/users/2");
        vresponse=response.then();
    }
    @Given("user hits the post request with data as")
    public void creatingUser(DataTable table){
        apiSpec=new apiFactory();
        Map<String,String> tableData=table.asMap(String.class,String.class);
        user userObj=user.builder().name(tableData.get("name")).job("job").build();
        String json=apiFactory.getJsonString(userObj);
        response=apiFactory.hitPostRequest("/api/users",json);
        vresponse=response.then();
    }

    @Then("status code should be {int}")
    public void assertStatusCode(int ExpectedStatus){
        vresponse.statusCode(ExpectedStatus);
    }
    @Then("validates json schema {string}")
    public void validateJsonSchema(String schemaName){
        apiFactory.validateJSONSchema(schemaName,response);
    }


}
