package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@LazyComponent
public class NasaScenario2 {

    @Value("${application.url}")
    private String url;

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Autowired
    public NasaScenario2(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators
    By exploreButton = By.id("global-navigation-trigger");
    By technologyButton = By.xpath("//a[span[text()='Technology']]");
    By techHeader = By.xpath("//h3[text()='Technology']");

    //nav to nasa homepage
    public void openHome(){
        driver.get(url);
        System.out.println("Opened: " + driver.getCurrentUrl());
    }

    //In the top navigation bar, select “Explore” → “Technology”.
    public void navigateToExploreAndTechnology(){
        WebElement explore = driver.findElement(exploreButton);
        explore.click();

        WebElement technology = driver.findElement(technologyButton);
        technology.click();
    }

    //Verify that the Technology page loads with the correct header and at least one article visible.
    public boolean verifyCorrectHeader(){
        WebElement techH = driver.findElement(techHeader);
        return techH.getText().equalsIgnoreCase("Technology");
    }


}
