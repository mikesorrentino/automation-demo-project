package com.springselenium.automation;

import com.springselenium.automation.annotation.LazyComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public abstract class BasePage {

    @Value("${application.url}")
    protected String url;

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @Autowired
    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
}
