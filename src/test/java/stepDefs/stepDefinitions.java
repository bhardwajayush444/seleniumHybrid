package stepDefs;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccountsPage;
import pages.LoginPage;
import utils.ElementUtil;

import java.util.List;

public class stepDefinitions {
    LoginPage loginPage=new LoginPage(driverFactory.get_driver());
    ElementUtil myUtils=new ElementUtil(driverFactory.get_driver());
    AccountsPage accountsPage=new AccountsPage(driverFactory.get_driver());
    private static String title;
    @Given("user is on login page")
    public void userIsOnloginPage(){
        driverFactory.get_driver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user gets the title of page")
    public void getPageTitle(){
        title=driverFactory.get_driver().getTitle();
    }
    @Then("page title should be {string}")
    public void assertExpectedTitle(String expectedTitle){
        Assert.assertEquals(title,expectedTitle);
    }
    @Then("forgot your password link should be displayed")
    public void forgotPasswordLinkDisplayed(){
        Assert.assertTrue(loginPage.isForgotLinkExist());
    }
    @When("user enters username {string} and password {string}")
    public void enterUsername(String username,String password){
        loginPage.login(username,password);
    }
    @Given("user is on Account page")
    public void userIsOnAccountPage(){
        System.out.println(driverFactory.get_driver().getTitle());
    }
    @Then("user gets the account sections")
    public void userGetsAccountSections(DataTable table){
        List<String> myTable= table.asList();
        List<String> actualList=accountsPage.getAccountSectionsList();
        Assert.assertTrue(actualList.containsAll(myTable));
    }
}
