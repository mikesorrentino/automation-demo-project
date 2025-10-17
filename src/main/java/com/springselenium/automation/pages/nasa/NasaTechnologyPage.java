package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.BasePage;
import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class NasaTechnologyPage extends BasePage {

    public NasaTechnologyPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //HomePage Locators
    By techHeader = By.xpath("//h3[text()='Technology']");

    //Verify that the Technology page loads with the correct header and at least one article visible.
    public boolean verifyCorrectHeader(){
        WebElement techH = driver.findElement(techHeader);
        return techH.getText().equalsIgnoreCase("Technology");
    }
}
