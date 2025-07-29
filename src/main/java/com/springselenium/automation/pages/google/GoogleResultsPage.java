package com.springselenium.automation.pages.google;

import com.springselenium.automation.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class GoogleResultsPage extends AbstractPage {

    @FindBy(id = "result-stats")
    private WebElement resultStats;

    public boolean isAt() {
        return wait.until((d) -> resultStats.isDisplayed());
    }
}
