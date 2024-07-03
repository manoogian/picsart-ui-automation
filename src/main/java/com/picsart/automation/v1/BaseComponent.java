package com.picsart.automation.v1;

import com.picsart.automation.v1.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseComponent {

    private final WebElement root;

    private final WebDriverWait wait;

    protected final BasePage parent;

    public BaseComponent(BasePage parent, By rootLocator) {
        WebElement tmpRoot = parent.findChild(rootLocator);
        PageFactory.initElements(tmpRoot, this);
        root = tmpRoot;
        this.wait = parent.getWait();
        this.parent = parent;

    }

    protected WebElement getRoot() {
        return root;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    protected WebElement findChild(By locator) {
        return root.findElement(locator);
    }

    public abstract boolean isVisible();

    public abstract void waitUntilInvisible();
}
