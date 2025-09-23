package com.springselenium.automation.pages.google;

import com.springselenium.automation.annotation.LazyComponent;
import com.springselenium.automation.pages.AbstractPage;
import org.openqa.selenium.By;

@LazyComponent
public class GoogleResultsPage extends AbstractPage {


    private By resultStats = By.id("result-stats");

    public boolean isAt() {
        return wait.until((d) -> driver.findElement(resultStats).isDisplayed());
    }
}
