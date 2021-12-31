package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public By emailID=By.id("email");
    public By password=By.id("passwd");
    public By loginButton=By.id("SubmitLogin");
    public By forgotLink=By.linkText("Forgot your password?");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public boolean isForgotLinkExist(){
        return driver.findElement(forgotLink).isDisplayed();
    }
    public void login(String userName,String Password){
        driver.findElement(emailID).sendKeys(userName);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(loginButton).click();
    }

}
