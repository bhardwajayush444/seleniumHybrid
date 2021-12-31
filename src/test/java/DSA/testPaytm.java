package DSA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class testPaytm {
    public static void main(String[] args) throws IOException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//        driver.findElement(By.linkText("Privacy")).click();
//        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(file, new File("img.png"));
//        driver.navigate().back();

        int a[]={1,2,7,3,4,0,5};
        Set<Integer> mySet=new TreeSet<>();
        for(int i:a) {
            mySet.add(i);
        }
        int missing=0;
        for(int i=0;i<=mySet.size()-1;i++){
            if(!mySet.contains(i)){
             missing=i;
             break;
            }
        }
        System.out.println(missing);




    }
}
