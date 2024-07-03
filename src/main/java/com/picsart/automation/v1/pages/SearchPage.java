package com.picsart.automation.v1.pages;

import com.picsart.automation.v1.popups.CookiesPopup;
import com.picsart.automation.v1.popups.SignInPopup;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void switchToRoot() {
        driver.switchTo().defaultContent();
    }

    public SearchPageContentSection contentSection() {
        return new SearchPageContentSection(driver);
    }

    public SearchPageHeaderSection headerSection() {
        return new SearchPageHeaderSection(driver);
    }

    public CookiesPopup cookiesPopup() {
        return new CookiesPopup(this);
    }

    public SignInPopup getSingInPopup() {
        return new SignInPopup(this);
    }
}
