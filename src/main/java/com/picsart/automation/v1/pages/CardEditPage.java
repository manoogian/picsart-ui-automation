package com.picsart.automation.v1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CardEditPage extends BasePage {

    @FindBy(xpath = "//img[contains(@class,'image-root')]")
    public List<WebElement> imageFrames;

    @FindBy(xpath = "//section[@data-testid='editor-header']")
    public WebElement pageHeader;

    public CardEditPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void switchToRoot() {
        driver.switchTo().parentFrame();
    }

    public boolean isCardAddedWithHref(String href){
       wait.until(ExpectedConditions.visibilityOf(pageHeader));
        return driver.getCurrentUrl().contains(href);
    }


}
