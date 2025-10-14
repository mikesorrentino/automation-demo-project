package com.springselenium.automation.pages.nasa;

import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@LazyComponent
public class NasaScenario3 {

    @Value("${application.url}")
    private String url;

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Autowired
    public NasaScenario3(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Locators
    By multimediaLink = By.xpath(".//button[span[text()='Multimedia']]");
    By imageOfDayLink = By.xpath("//a[span[text()='Image of the Day']]");
    By rocketImage = By.xpath("//img[@alt='A rocket lifts off into the sky, leaving a bright trail of flame in its wake. White vapor clouds billow out along the ground. There are also various structures in the image, including a gantry and a white structure that looks like a water tower.']");
    By launchHeader = By.xpath("//h1[text()='3-in-1 Launch']");

    //nav to nasa homepage
    public void openHome(){
        driver.get(url);
        System.out.println("Opened: " + driver.getCurrentUrl());
    }

    // Go to the  “Multimedia” -> “Image of the Day” section.
        public void navigagteToImgOfDay(){
            WebElement multimedia = driver.findElement(multimediaLink);
            WebElement imageOfDay = driver.findElement(imageOfDayLink);

            multimedia.click();
            imageOfDay.click();
    }

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
