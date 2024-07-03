package com.picsart.automation.v1.regression;

import com.picsart.automation.v1.pages.CardEditPage;
import com.picsart.automation.v1.pages.SearchPage;
import com.picsart.automation.v1.pages.SearchPageContentSection;
import com.picsart.automation.v1.popups.SignInPopup;
import com.picsart.automation.v1.sections.ColorSection;
import com.picsart.automation.v1.sections.FilterSection;
import com.picsart.automation.v1.sections.LicenseSection;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class IntegrationTest extends BaseTest {


    private SearchPage page;

    @BeforeMethod
    public void preparePage() {
        driver.navigate().to("https://picsart.com/search/images/");
        page = new SearchPage(driver);
        page.cookiesPopup().acceptCookies();
        page.refresh(); // We need to refresh page since otherwise it loads a different experience
    }

    @Test
    public void integrationTest() {
        SearchPageContentSection searchPageContentSection = page.contentSection();
        Assert.assertTrue(searchPageContentSection.isSearchPageHeaderPresent());

        Assert.assertTrue(searchPageContentSection.isAnyPremiumIconVisible());


        FilterSection filterSection = searchPageContentSection.getFilterSection();
        filterSection.collapseSection();
        Assert.assertFalse(filterSection.isSectionExpanded());

        LicenseSection licenseSection = searchPageContentSection.getLicenseSection();
        ColorSection colorSection = searchPageContentSection.getColorSection();
        licenseSection.waitUntilInvisible();
        Assert.assertFalse(licenseSection.isVisible());
        Assert.assertFalse(colorSection.isSectionVisible());

        filterSection.expandSection();
        licenseSection.addFilter("Personal");
        filterSection.collapseSection();
        Assert.assertTrue(searchPageContentSection.areAllPremiumIconInvisible());
        Assert.assertTrue(searchPageContentSection.isLikeButtonDisplayed());
        Assert.assertTrue(searchPageContentSection.isSaveButtonDisplayed());
        Assert.assertTrue(searchPageContentSection.isTryNowButtonDisplayed());

        searchPageContentSection.likeFirstCard();
        SignInPopup singInPopup = searchPageContentSection.getSingInPopup();
        Assert.assertTrue(singInPopup.isVisible());
        Assert.assertEquals(singInPopup.getTittle(), "Get started with Picsart");
        singInPopup.closePopup();

        filterSection.expandSection();
        licenseSection.removeFilter("Personal");
        filterSection.collapseSection();
        Assert.assertTrue(searchPageContentSection.isAnyPremiumIconVisible());

        Assert.assertTrue(searchPageContentSection.isTryNowButtonDisplayed());
        String firstCardLink = searchPageContentSection.getFirstCardLink();
        CardEditPage cardEditPage = searchPageContentSection.clickTryNowOnTheFirstCard();
        cardEditPage.switchToRoot();
        Assert.assertTrue(cardEditPage.isCardAddedWithHref(firstCardLink));
    }
}
