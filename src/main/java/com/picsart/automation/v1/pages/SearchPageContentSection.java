package com.picsart.automation.v1.pages;

import com.picsart.automation.v1.popups.SignInPopup;
import com.picsart.automation.v1.sections.ColorSection;
import com.picsart.automation.v1.sections.FilterSection;
import com.picsart.automation.v1.sections.LicenseSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPageContentSection extends BasePage {

    @FindBy(xpath = "//h1[text()='Search results']/ancestor::div[contains(@class, 'search-header') and not(@data-testid='container')]")
    private WebElement searchPageHeader;

    @FindBy(xpath = "//div[contains(@id,'base_card_item')]")
    private List<WebElement> baseCardItems;

    @FindBy(xpath = "//div[contains(@id,'base_card_item0')]")
    private WebElement firstCardItem;

    @FindBy(xpath = "//div[contains(@id,'base_card_item')]//button[contains(@id,'try_now_button_item')]")
    private List<WebElement> baseCardItemTryNowButtons;

    @FindBy(xpath = "//div[contains(@id,'base_card_item')]//button[contains(@id,'like_button_item')]")
    private List<WebElement> baseCardItemLikeButtons;

    @FindBy(xpath = "//div[contains(@id,'base_card_item')]//button[contains(@id,'save_button_item')]")
    private List<WebElement> baseCardItemsSaveButtons;

    @FindBy(xpath = "//div[contains(@id,'base_card_item')]//div[contains(@class,'premium-icon-root')]")
    private List<WebElement> baseCardItemsPremiumIcons;

    private final String PREMIUM_ICONS_XPATH = "//div[contains(@class,'premium-icon-root')]";
    private final String TRY_NOW_BUTTON_XPATH = "//button[contains(@id,'try_now_button_item')]";
    private final String LIKE_BUTTON_XPATH = "//button[contains(@id,'like_button_item')]";
    private final String SAVE_BUTTON_XPATH = "//button[contains(@id,'save_button_item')]";

    private final Actions actions;
    private final By premiumIconsRelativeLocator = By.xpath("//div[contains(@id,'base_card_item')]//div[contains(@class,'premium-icon-root')]");;

    public SearchPageContentSection(WebDriver driver) {
        super(driver);
        switchToRoot();
        this.actions = new Actions(driver);
    }

    @FindBy(xpath = "//*[contains(@id,'miniapp-frame') and @title='Mini app SDK']")
    private WebElement searchPageFrame;

    @Override
    public void switchToRoot() {
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOf(searchPageFrame)));
    }

    public boolean isSearchPageHeaderPresent() {
        return wait.until(ExpectedConditions.visibilityOf(searchPageHeader)).isDisplayed();
    }

    public FilterSection getFilterSection() {
        return new FilterSection(this);
    }

    public LicenseSection getLicenseSection() {
        return new LicenseSection(this);
    }

    public ColorSection getColorSection() {
        return new ColorSection(this);
    }

    public SignInPopup getSingInPopup() {
        this.switchToParentFrame();
        return new SignInPopup(this);
    }

    public boolean isAnyPremiumIconVisible() {
        List<WebElement> premiumIcons = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(premiumIconsRelativeLocator)));
        return !premiumIcons.isEmpty();
    }
    public boolean areAllPremiumIconInvisible() {
        return wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(premiumIconsRelativeLocator)));
    }

    public boolean isLikeButtonDisplayed() {
        return isComponentDisplayed(LIKE_BUTTON_XPATH);
    }

    public boolean isSaveButtonDisplayed() {
        return isComponentDisplayed(SAVE_BUTTON_XPATH);
    }

    public boolean isTryNowButtonDisplayed() {
        return isComponentDisplayed(TRY_NOW_BUTTON_XPATH);
    }

    private boolean isComponentDisplayed(String target) {
        hoverOverCardItem(firstCardItem);
        return wait.until(ExpectedConditions.visibilityOf(firstCardItem.findElement(By.xpath(target)))).isDisplayed();
    }

    public boolean isComponentsDisplayed(String target) {
        for (WebElement baseCardItem : baseCardItems) {
            hoverOverCardItem(baseCardItem);
            WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(baseCardItem.findElement(By.xpath(target))));
            if (!targetElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }


    private void hoverOverCardItem(WebElement baseCardItem) {
        actions.moveToElement(baseCardItem).pause(2000).perform();
    }

    public void likeFirstCard() {
//        WebElement baseCardItem = baseCardItems.get(0);
        hoverOverCardItem(firstCardItem);
        firstCardItem.findElement(By.xpath(LIKE_BUTTON_XPATH)).click();
    }

    public String getFirstCardLink(){
        return firstCardItem.findElement(By.xpath("//a")).getAttribute("href");
    }

    public CardEditPage clickTryNowOnTheFirstCard() {
//        WebElement baseCardItem = baseCardItems.get(0);
        hoverOverCardItem(firstCardItem);
        firstCardItem.findElement(By.xpath(TRY_NOW_BUTTON_XPATH)).click();
        return new CardEditPage(driver);
    }


    public void saveFirstCard() {
        WebElement baseCardItem = baseCardItems.get(0);
        hoverOverCardItem(baseCardItem);
        baseCardItem.findElement(By.xpath(SAVE_BUTTON_XPATH)).click();
    }

    public WebElement getRootElement() {
        return searchPageFrame;
    }
}
