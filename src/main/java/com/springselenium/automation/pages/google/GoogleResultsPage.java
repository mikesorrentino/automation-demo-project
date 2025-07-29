package com.springselenium.automation.pages.google;

import com.springselenium.automation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class GoogleResultsPage extends AbstractPage {


    private By resultStats = By.id("result-stats");

    public boolean isAt() {
        return wait.until((d) -> driver.findElement(resultStats).isDisplayed());
    }
}
