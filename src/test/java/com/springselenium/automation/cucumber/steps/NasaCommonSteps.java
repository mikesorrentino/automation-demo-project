package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaHomePage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaCommonSteps {
    @Autowired

    private NasaHomePage nasaHomePage;

    @Given("I am on the nasa home page")
    public void given_IAmOnTheNasaHomePage() {
        nasaHomePage.open();
    }
}
