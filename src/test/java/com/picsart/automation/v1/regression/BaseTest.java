package com.picsart.automation.v1.regression;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    @Parameters({"width", "height"})
    public void setUp(int width, int height) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(width, height));
        this.driver = driver;
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
