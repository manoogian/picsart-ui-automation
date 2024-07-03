package com.picsart.automation.v1.sections;

import com.picsart.automation.v1.BaseComponent;
import com.picsart.automation.v1.pages.SearchPageContentSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ColorSection extends BaseComponent {

    private static final By ROOT_LOCATOR = By.xpath("//div[@data-testid='accordion-item-root' and .//h4[text()='Color']]");

    protected final String COLORLESS_LOCATOR_TEMPLATE = "//div[@data-testid='accordion-item-root' and .//h4[text()='Color']]//li[@aria-label='colors <color>']";

    @FindBy(xpath = "//div[@data-testid='accordion-item-header' and .//h4[text()='Color']]")
    protected WebElement colorSection;

    public ColorSection(SearchPageContentSection parent) {
        super(parent, ROOT_LOCATOR);
    }

    @Override
    public boolean isVisible() {
        return colorSection.isDisplayed();
    }

    @Override
    public void waitUntilInvisible() {
        getWait().until(ExpectedConditions.invisibilityOf(colorSection));
    }

    public void expandSection() {
        if (isSectionExpanded()) {
            colorSection.findElement(By.cssSelector(" > svg")).click();
        }
    }

    public void collapseSection() {
        if (!isSectionExpanded()) {
            colorSection.findElement(By.cssSelector(" > svg")).click();
        }
    }

    public boolean isSectionExpanded() {
        return !colorSection.getAttribute("class").contains("hide");
    }

    public boolean isSectionVisible() {
        return colorSection.isDisplayed();
    }

    public void addColor(String color) {
        if (isSectionExpanded() && colorSection.isDisplayed()) {
            findChild(By.xpath(COLORLESS_LOCATOR_TEMPLATE.replace("<color>", color))).click();
        }
    }
}
