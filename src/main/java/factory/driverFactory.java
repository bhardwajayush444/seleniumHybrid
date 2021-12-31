package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
    public static synchronized WebDriver get_driver(){
        return tlDriver.get();
    }
    public WebDriver init_driver(String browser){
        System.out.println("Browser value is :"+browser);
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else{
            System.out.println("invalid browser value passed");
        }
        get_driver().manage().deleteAllCookies();
        get_driver().manage().window().maximize();
        return get_driver();
    }
}
