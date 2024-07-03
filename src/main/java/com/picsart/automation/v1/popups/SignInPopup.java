package com.picsart.automation.v1.popups;

import com.picsart.automation.v1.BaseComponent;
import com.picsart.automation.v1.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPopup extends BaseComponent {

    private static final By ROOT_LOCATOR = By.xpath("//div[contains(@class,'overlay-content')]");

    @FindBy(xpath = "//div[@data-testid='registration-modal-container']")
    public WebElement popupContainer;

    @FindBy(xpath = "//h3[@data-testid='Sign-in-options-title']")
    public WebElement title;

    @FindBy(xpath = "//button[contains(@data-pulse-name,'Continue with email')]")
    public WebElement continueWithEmailButton;

    @FindBy(css = "[class*='modalCloseWrapper'] > svg")
    private WebElement closeSingInPopupButton;


    public SignInPopup(BasePage parent) {
        super(parent, ROOT_LOCATOR);
    }


    public void closePopup() {
        closeSingInPopupButton.click();
        parent.switchToRoot();
    }

    public boolean isVisible() {
        return popupContainer.isDisplayed();
    }

    @Override
    public void waitUntilInvisible() {
        getWait().until(ExpectedConditions.invisibilityOf(popupContainer));
    }

    public String getTittle() {
        return title.getText();
    }
}
