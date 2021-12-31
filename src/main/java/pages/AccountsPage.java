package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;
    private By accountSections=By.cssSelector("div#center_column span");
    public AccountsPage(WebDriver driver){
        this.driver=driver;
    }
    public List<String> getAccountSectionsList(){
        List<String> accountSectionsText=new ArrayList<>();
        List<WebElement> accountSectionsHeader=driver.findElements(accountSections);
        for(WebElement e:accountSectionsHeader){
            String text=e.getText();
            accountSectionsText.add(text);
            System.out.println(text);
        }
        return accountSectionsText;
    }
}
