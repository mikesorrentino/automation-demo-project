package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.BasePage;
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

@LazyComponent
public class NasaContactPage extends BasePage {

    public NasaContactPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Locators
    By firstName = By.id("input_18_3_3");
    By lastName = By.id("input_18_3_6");
    By email = By.id("input_18_4");
    By subject = By.id("input_18_5");
    By question = By.id("input_18_6");

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
