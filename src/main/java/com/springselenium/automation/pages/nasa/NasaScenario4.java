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
import org.testng.Assert;


@LazyComponent
public class NasaScenario4 {

    @Value("${application.url}")
    private String url;

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Autowired
    public NasaScenario4(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators
    By contactLink = By.xpath("//a[span[normalize-space(text())='Contact NASA']]");
    By submitQuestionLink = By.cssSelector("a[href='https://www3.nasa.gov/content/submit-a-question-for-nasa']");
    By firstName = By.id("input_18_3_3");
    By lastName = By.id("input_18_3_6");
    By email = By.id("input_18_4");
    By subject = By.id("input_18_5");
    By question = By.id("input_18_6");

    //nav to nasa homepage
    public void openHome(){
        driver.get(url);
        System.out.println("Opened: " + driver.getCurrentUrl());
    }

    //Locate contact form
        public void locateContactForm(){
            WebElement contact = wait.until(ExpectedConditions.presenceOfElementLocated(contactLink));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contact);


            WebElement submitQuestion = wait.until(ExpectedConditions.presenceOfElementLocated(submitQuestionLink));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitQuestion);
    }

    //Fill in some fields (name, email, etc.) with test data.
        public void fillInFieldsAndSubmit(){
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
        }

    //Verify confirm message
    public boolean verifyConfirmMessage(){
        WebElement confirmMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("gform_confirmation_message_18"))
        );
        return confirmMessage.getText().equalsIgnoreCase("Thanks for contacting us! We will get in touch with you shortly.");
    }


}
