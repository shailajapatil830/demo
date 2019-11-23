package com.mavenit.selenium.training.driver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.This;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverManager  {


    public static WebDriver driver;

    public DriverManager(){
        PageFactory.initElements(driver,this);
    }

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
