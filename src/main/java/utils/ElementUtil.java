package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
    private WebDriver driver;
    public ElementUtil(WebDriver driver){
        this.driver=driver;
    }

    public void myActions(By element, String elementType){
        if(elementType.equalsIgnoreCase("button")){
            driver.findElement(element).click();
        }
        else if(elementType.equalsIgnoreCase("textbox")){
            driver.findElement(element).clear();
            driver.findElement(element).click();
        }
        else{
            System.out.println("wrong action displayed");
        }
    }
}
