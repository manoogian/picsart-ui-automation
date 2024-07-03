package com.picsart.automation.v1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public WebElement findChild(By by) {
//        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        return driver.findElement(by);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public static void switchToSearchPageFrame(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'miniapp-frame') and @title='Mini app SDK']")));
    }

    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public abstract void switchToRoot();
}
