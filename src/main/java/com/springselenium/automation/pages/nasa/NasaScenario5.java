package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


@LazyComponent
public class NasaScenario5 {

    @Value("${application.url}")
    private String url;

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Autowired
    public NasaScenario5(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators
    By exploreButton = By.id("global-navigation-trigger");

    //nav to nasa homepage
    public void openHome(){
        driver.get(url);
        System.out.println("Opened: " + driver.getCurrentUrl());
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
