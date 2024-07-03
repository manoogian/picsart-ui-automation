package com.picsart.automation.v1.sections;

import com.picsart.automation.v1.BaseComponent;
import com.picsart.automation.v1.pages.SearchPageContentSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterSection extends BaseComponent {

    private static final By ROOT_LOCATOR = By.xpath("//div[contains(@class,'search-header-triggersHolder')]");

    @FindBy(xpath = "//*[@id='filter_icon']")
    private WebElement filterButton;

    @FindBy(xpath = "//div[contains(@class,'search-filter-root')]")
    private WebElement filterSection;

    public FilterSection(SearchPageContentSection parent) {
        super(parent, ROOT_LOCATOR);
    }

    public void expandSection() {
        if (!isSectionExpanded()) {
            filterButton.click();
        }
    }

    public void collapseSection() {
        if (isSectionExpanded()) {
            filterButton.click();
        }
    }

    public boolean isSectionExpanded() {
        return filterButton.getAttribute("data-automation").equals("open");

    }

    @Override
    public boolean isVisible() {
        return filterButton.isDisplayed();
    }

    @Override
    public void waitUntilInvisible() {
        getWait().until(ExpectedConditions.invisibilityOf(filterSection));
    }
}
