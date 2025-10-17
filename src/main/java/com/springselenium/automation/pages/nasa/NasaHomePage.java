package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.BasePage;
import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@LazyComponent
public class NasaHomePage extends BasePage {

    public NasaHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //HomePage Locators
    By searchBar = By.id("search-field-en-small--desktop");
    By articlesBox = By.id("content_typearticles");
    By applyButton = By.xpath("//button[.//span[text()='Apply Filters']]");
    By filterLabel = By.xpath("//span[text()='Articles']");
    By exploreButton = By.id("global-navigation-trigger");
    By technologyButton = By.xpath("//a[span[text()='Technology']]");
    By multimediaLink = By.xpath(".//button[span[text()='Multimedia']]");
    By imageOfDayLink = By.xpath("//a[span[text()='Image of the Day']]");
    By contactLink = By.xpath("//a[span[normalize-space(text())='Contact NASA']]");
    By submitQuestionLink = By.cssSelector("a[href='https://www3.nasa.gov/content/submit-a-question-for-nasa']");


    //open NASA homepage
    public void open() {
        driver.get(url);
    }

    //Search for keyword
    public NasaHomePage search(String keyword){
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    //select the article to filter
    public NasaHomePage selectArticlesFilter(boolean select){
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(articlesBox));
        if (select && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!select && checkbox.isSelected()){
            checkbox.click();
        }
        return this;
    }

    //click apply filter button
    public NasaHomePage clickApplyFilters(){
        WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(applyButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", apply);

        try {
            apply.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply);
        }
        return this;
    }

    //verification of filters
    public boolean isArticlesFilterApplied(String filterName){
        WebElement filter = wait.until(ExpectedConditions.visibilityOfElementLocated(filterLabel));
        return filter.getText().equalsIgnoreCase(filterName);
    }

    //In the top navigation bar, select “Explore” → “Technology”.
    public void navigateToExploreAndTechnology(){
        WebElement explore = driver.findElement(exploreButton);
        explore.click();

        WebElement technology = driver.findElement(technologyButton);
        technology.click();
    }

    //navigate to image of day
    public void navigagteToImgOfDay(){
        WebElement multimedia = driver.findElement(multimediaLink);
        WebElement imageOfDay = driver.findElement(imageOfDayLink);

        multimedia.click();
        imageOfDay.click();
    }

    //Locate contact form
    public void locateContactForm(){
        WebElement contact = wait.until(ExpectedConditions.presenceOfElementLocated(contactLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contact);


        WebElement submitQuestion = wait.until(ExpectedConditions.presenceOfElementLocated(submitQuestionLink));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitQuestion);
    }

    //Iterate through the main navigation menu links (or a subset, e.g., the first 5).
    public void IterateThroughNavLinks() {
        for (int i = 0; i < 5; i++) {

            WebElement explore = driver.findElement(exploreButton);
            explore.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#global-navigation .global-nav__primary-list > .usa-nav__submenu-item > a")));

            List<WebElement> mainNavigation = driver.findElements(By.cssSelector("#global-navigation .global-nav__primary-list > .usa-nav__submenu-item > a"));

            WebElement link = mainNavigation.get(i);
            String href = link.getAttribute("href");

            // Click each link and verify that the page loads without errors (e.g., no “404” pages).
            driver.get(href);

            if (driver.getTitle().contains("404")) {
                System.out.println("link not working");
            } else {
                System.out.println("success");
            }

            //Return to the homepage before continuing to the next link.
            driver.get(url);
        }

    }
}
