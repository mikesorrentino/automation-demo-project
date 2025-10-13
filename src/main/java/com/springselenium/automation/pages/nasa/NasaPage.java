package com.springselenium.automation.pages.nasa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class NasaPage {

    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "https://www.nasa.gov";

    //map links
    By exploreButton = By.id("global-navigation-trigger");
    By technologyButton = By.xpath("//a[span[text()='Technology']]");
    By searchBar = By.id("search-field-en-small--desktop");
    By articlesBox = By.id("content_typearticles");
    By applyButton = By.xpath("//button[.//span[text()='Apply Filters']]");
    By filterLabel = By.xpath("//span[text()='Articles']");
    By techHeader = By.xpath("//h3[text()='Technology']");
    By multimediaLink = By.xpath(".//button[span[text()='Multimedia']]");
    By imageOfDayLink = By.xpath("//a[span[text()='Image of the Day']]");
    By contactLink = By.xpath("//a[span[normalize-space(text())='Contact NASA']]");
    By submitQuestionLink = By.cssSelector("a[href='https://www3.nasa.gov/content/submit-a-question-for-nasa']");
    By rocketImage = By.xpath("//img[@alt='A rocket lifts off into the sky, leaving a bright trail of flame in its wake. White vapor clouds billow out along the ground. There are also various structures in the image, including a gantry and a white structure that looks like a water tower.']");
    By launchHeader = By.xpath("//h1[text()='3-in-1 Launch']");
    By firstName = By.id("input_18_3_3");
    By lastName = By.id("input_18_3_6");
    By email = By.id("input_18_4");
    By subject = By.id("input_18_5");
    By question = By.id("input_18_6");

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        DriverFactory.quitDriver();
    }

    // Scenario 1
    @Test
    public void ScenarioOne() throws InterruptedException {
        boolean articlesCheckbox = true;

        //Go to NASA.gov homepage.
        driver.get(baseURL);

        //Use the search function with the keyword “Mars Rover”.
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBar));

        search.sendKeys("Mars Rover\n");

        //Apply a filter if available (e.g., by date or content type).
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


        WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(applyButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", apply);

        try {
            apply.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply);
        }

        //Verify that the results match the search text and the filter criteria.
        WebElement filter = wait.until(
                ExpectedConditions.visibilityOfElementLocated(filterLabel));

        Assert.assertEquals(filter.getText(), "Articles");
    }

    // Scenario 2
    @Test
    public void ScenarioTwo() {
        driver.get(baseURL);

        //In the top navigation bar, select “Explore” → “Technology”.
        WebElement explore = driver.findElement(exploreButton);
        explore.click();

        WebElement technology = driver.findElement(technologyButton);
        technology.click();


        //Verify that the Technology page loads with the correct header and at least one article visible.
        WebElement techH = driver.findElement(techHeader);

        Assert.assertTrue(techH.getText().contains("Technology"));
    }

    @Test
    public void ScenarioThree() {

        driver.get(baseURL);


        // Go to the  “Multimedia” -> “Image of the Day” section.
        WebElement multimedia = driver.findElement(multimediaLink);
        WebElement imageOfDay = driver.findElement(imageOfDayLink);

        multimedia.click();
        imageOfDay.click();


        //Click on a random featured image or video.
        WebElement rocket = wait.until(ExpectedConditions.visibilityOfElementLocated(rocketImage));
        rocket.click();

        //Verify that the image/video opens correctly and check for properties like title or alt text.
        WebElement launch = driver.findElement(launchHeader);

        Assert.assertTrue(launch.getText().contains("3-in-1 Launch"));
    }

    @Test
    public void ScenarioFour() throws InterruptedException {

        driver.get(baseURL);

        //Locate contact form
        WebElement contact = wait.until(ExpectedConditions.presenceOfElementLocated(contactLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contact);


        WebElement submitQuestion = wait.until(ExpectedConditions.presenceOfElementLocated(submitQuestionLink));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitQuestion);


        //Fill in some fields (name, email, etc.) with test data.
        WebElement first = wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        WebElement last = wait.until(ExpectedConditions.presenceOfElementLocated(lastName));
        WebElement emailWE = wait.until(ExpectedConditions.presenceOfElementLocated(email));
        WebElement subjectWE = wait.until(ExpectedConditions.presenceOfElementLocated(subject));
        WebElement questionWE = wait.until(ExpectedConditions.presenceOfElementLocated(question));

        first.sendKeys("Michael");
        last.sendKeys("test");
        emailWE.sendKeys("mr.mike@gmail.com");

        Select oSelect = new Select(subjectWE);
        oSelect.selectByIndex(1);

        questionWE.sendKeys("test for questions");

        //Submit the form and verify that a confirmation message appears or the submission is accepted.
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("gform_submit_button_18")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebElement confirmMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("gform_confirmation_message_18"))
        );

        Assert.assertTrue(confirmMessage.getText().contains("Thanks for contacting us! We will get in touch with you shortly."));
    }

    @Test
    public void ScenarioFive() throws InterruptedException {


        driver.get("https://www.nasa.gov");

        //Iterate through the main navigation menu links (or a subset, e.g., the first 5).
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
            driver.get("https://www.nasa.gov");
        }
    }


}
