package testPackage;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.pages.Home;
import gui.pages.Results;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final ThreadLocal<JSONFileManager> testData = new ThreadLocal<>();

    @Description("Given the browser is open, When I navigate to Google Home, Then the google logo will be displayed")
    @Test(description = "Check that google logo is displayed")
    public void checkThatGoogleLogoIsDisplayed() {
        new Home(driver.get()).navigate();
        Validations.assertThat()
                .element(driver.get(), Home.googleLogo_image())
                .matchesReferenceImage()
                .withCustomReportMessage("Assert That the google logo image is displayed properly")
                .perform();
    }

    @Description("Given the browser is open, When I navigate to Google Home, And I search for SHAFT_Engine, Then the result stats text will not be empty")
    @Test(description = "Check that the result stats text is not empty when you search for SHAFT_Engine")
    public void checkThatResultStatsIsNotEmpty() {
        new Home(driver.get()).navigate().searchForQuery(testData.get().getTestData("searchQuery"));
        Validations.assertThat()
                .element(driver.get(), Results.resultStats_label())
                .text()
                .doesNotEqual("")
                .withCustomReportMessage("Assert that result stats text is not empty")
                .perform();
    }

    @Description("Given the browser is open, When I navigate to Google Home, Then the google logo will be displayed")
    @Test(description = "Check that google logo is displayed")
    public void checkThatGoogleLogoIsDisplayed11() {
        new Home(driver.get()).navigate();
        Validations.assertThat()
                .element(driver.get(), Home.googleLogo_image())
                .matchesReferenceImage()
                .withCustomReportMessage("Assert That the google logo image is displayed properly")
                .perform();
    }

    @Description("Given the browser is open, When I navigate to Google Home, And I search for SHAFT_Engine, Then the result stats text will not be empty")
    @Test(description = "Check that the result stats text is not empty when you search for SHAFT_Engine")
    public void checkThatResultStatsIsNotEmpty11() {
        new Home(driver.get()).navigate().searchForQuery(testData.get().getTestData("searchQuery"));
        Validations.assertThat()
                .element(driver.get(), Results.resultStats_label())
                .text()
                .doesNotEqual("")
                .withCustomReportMessage("Assert that result stats text is not empty")
                .perform();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.set(DriverFactory.getDriver());
        testData.set(new JSONFileManager("src/test/resources/TestDataFiles/googleSearch.json"));
    }

    @AfterMethod
    public void afterMethod(){
        BrowserActions.closeCurrentWindow(driver.get());
    }
}
