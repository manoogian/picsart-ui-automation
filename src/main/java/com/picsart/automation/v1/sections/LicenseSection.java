package com.picsart.automation.v1.sections;

import com.picsart.automation.v1.BaseComponent;
import com.picsart.automation.v1.pages.SearchPageContentSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LicenseSection extends BaseComponent {

    protected static final By ROOT_LOCATOR = By.xpath("//div[@data-testid='accordion-item-root' and .//h4[text()='License']]");


    @FindBy(xpath = "//div[@data-testid='accordion-item-header' and .//h4[text()='License']]")
    private WebElement header;

    @FindBy(xpath = "//li[@id = 'checkbox_filter_item0']")
    private WebElement allCheckbox;

    @FindBy(xpath = "//li[@id = 'checkbox_filter_item1']")
    private WebElement commercialCheckbox;

    @FindBy(xpath = "//li[@id = 'checkbox_filter_item2']")
    private WebElement personalCheckbox;

    public LicenseSection(SearchPageContentSection parent) {
        super(parent, ROOT_LOCATOR);
    }

    public void expandSection() {
        if (isSectionExpanded()) {
            header.findElement(By.cssSelector(" > svg")).click();
        }
    }

    public void collapseSection() {
        if (!isSectionExpanded()) {
            header.findElement(By.cssSelector(" > svg")).click();
        }
    }

    public boolean isSectionExpanded() {
        return !header.getAttribute("class").contains("hide");
    }

    @Override
    public boolean isVisible() {
        return header.isDisplayed();
    }

    @Override
    public void waitUntilInvisible() {
        getWait().until(ExpectedConditions.invisibilityOf(header));
    }

    public void addFilter(String filter) {
        changeFilter(filter);
    }

    public void removeFilter(String filter) {
        changeFilter(filter);
    }

    private void changeFilter(String filter) {
        if (isSectionExpanded() && isVisible()) {
            switch (filter.toUpperCase()) {
                case "ALL":
                    allCheckbox.click();
                case "COMMERCIAL":
                    commercialCheckbox.click();
                case "PERSONAL":
                    personalCheckbox.click();
            }
        }
    }

}
