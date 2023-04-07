package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ResourceBundle;


public class AppTest
{
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setupdrive(String browser,String link)
    {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get(link);
        driver.manage().window().maximize();
    }

    @Test
    void getitemfrompage() throws InterruptedException{
        ResourceBundle r = ResourceBundle.getBundle("config");
        String username =r.getString("uname");
        String password =r.getString("passo");
        driver.findElement(By.cssSelector("input[name=login]")).sendKeys(username);
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name=commit]")).click();
        //Thread.sleep(1000);

    }



    @AfterClass
    void driveclose(){
        driver.close();
    }

}
