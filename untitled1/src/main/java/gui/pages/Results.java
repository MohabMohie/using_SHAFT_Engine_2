package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    private WebDriver driver;

    public static By resultStats_label(){
        return By.id("result-stats");
    }

    public Results (WebDriver driver){
        this.driver = driver;
    }
}
