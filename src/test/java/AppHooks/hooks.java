package AppHooks;

import factory.apiFactory;
import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.configReader;

import java.util.Properties;

public class hooks {
    private driverFactory myFactory;
    private WebDriver driver;
    private configReader FileReader;
    Properties props;
    private apiFactory apiStart;


    @Before("@UI")
    public void launchBrowser(){
        FileReader=new configReader();
        props=FileReader.init_prop();
        String browser=props.getProperty("browser");
        myFactory=new driverFactory();
        driver=myFactory.init_driver(browser);
    }

    @After("@UI")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName=scenario.getName().replaceAll(" ","_");
            byte[] srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcPath,"image/png",screenshotName);
        }
        driver.quit();

    }
}
