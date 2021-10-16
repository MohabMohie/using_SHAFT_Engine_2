package gui.pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {
    //variables
    private WebDriver driver;
    private final String url = System.getProperty("googleURL");

    //locators
    public static By googleLogo_image(){
        return By.xpath("//img[@alt='Google']");
    }
    private static By search_textBox(){
        return By.name("q");
    }

    //constructor
    public Home (WebDriver driver){
        this.driver = driver;
    }

    //keywords

    /**
     * Navigates to google home
     * @return self-reference
     */
    public Home navigate(){
        BrowserActions.navigateToURL(driver, url);
        return this;
    }

    /**
     * Searches for a given string and presses enter
     * @param query the string that you want to search for
     * @return self-reference
     */
    public Results searchForQuery(String query){
//        (new ElementActions(driver)).type(search_textBox(), query)
//                .keyPress(search_textBox(), Keys.ENTER);
        ElementActions.type(driver, search_textBox(), query);
        ElementActions.keyPress(driver, search_textBox(), Keys.ENTER);
        return new Results(driver);
    }
}
