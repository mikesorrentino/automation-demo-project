package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@LazyComponent
public class NasaScenario1 {

    @Value("${application.url}")
    private String url;

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Autowired
    public NasaScenario1(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators
    By searchBar = By.id("search-field-en-small--desktop");
    By articlesBox = By.id("content_typearticles");
    By applyButton = By.xpath("//button[.//span[text()='Apply Filters']]");
    By filterLabel = By.xpath("//span[text()='Articles']");



    //nav to nasa homepage
    public void openHome(){
        driver.get(url);
    }

    //search "mars rover"
    public void searchMarsRover(){
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        search.clear();
        search.sendKeys("Mars Rover");
        search.sendKeys(Keys.ENTER);
    }

    //apply filters
    public void appleFilters(){
        boolean articlesCheckbox = true;
        WebElement articles = driver.findElement(articlesBox);

        if (articlesCheckbox) {
            if (!articles.isSelected()) {
                articles.click();
            }
        } else {
            if (articles.isSelected()) {
                articles.click();
            }
        }
    }

    public void clickApplyButton(){
        WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(applyButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", apply);

        try {
            apply.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply);
        }
    }

    public boolean isLoaded(){

        WebElement filter = wait.until(
                ExpectedConditions.visibilityOfElementLocated(filterLabel));

        return filter.getText().equalsIgnoreCase("Articles");
    }


}
