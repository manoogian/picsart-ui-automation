package com.picsart.automation.v1.popups;

import com.picsart.automation.v1.BaseComponent;
import com.picsart.automation.v1.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesPopup extends BaseComponent {

    @FindBy(xpath = "//*[@class='banner-content']")
    public WebElement cookiePopup;

    @FindBy(xpath = "//*[@class='banner-content']//button[@id='onetrust-accept-btn-handler']")
    public WebElement AcceptAllCookieButton;

    @FindBy(xpath = "//*[@class='banner-content']//button[@id='onetrust-pc-btn-handler']")
    public WebElement ManageCookieButton;

    private static final By ROOT_LOCATOR = By.xpath("//div[@id='onetrust-banner-sdk']");

    public CookiesPopup(BasePage parent) {
        super(parent, ROOT_LOCATOR);
    }

    public void acceptCookies() {
        AcceptAllCookieButton.click();
    }

    public boolean isVisible() {
        return cookiePopup.isDisplayed();
    }

    @Override
    public void waitUntilInvisible() {

    }
}
