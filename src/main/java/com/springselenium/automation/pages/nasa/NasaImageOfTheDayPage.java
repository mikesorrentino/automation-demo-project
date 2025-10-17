package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.BasePage;
import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class NasaImageOfTheDayPage extends BasePage {

    public NasaImageOfTheDayPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Page Locators
    By rocketImage = By.xpath("//img[@alt='A rocket lifts off into the sky, leaving a bright trail of flame in its wake. White vapor clouds billow out along the ground. There are also various structures in the image, including a gantry and a white structure that looks like a water tower.']");
    By launchHeader = By.xpath("//h1[text()='3-in-1 Launch']");

    //Click on a random featured image or video.
    public void selectImage(){
        WebElement rocket = wait.until(ExpectedConditions.visibilityOfElementLocated(rocketImage));
        rocket.click();
    }

    //Verify that the image/video opens correctly and check for properties like title or alt text.
    public boolean verifyCorrectTitle(){
        WebElement launch = driver.findElement(launchHeader);
        return launch.getText().equalsIgnoreCase("3-in-1 Launch");
    }
}
