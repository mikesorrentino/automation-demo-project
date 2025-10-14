package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaScenario1;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaCommonSteps {
    @Autowired

    private NasaScenario1 nasaScenario1;

    @Given("I am on the nasa home page")
    public void given_IAmOnTheNasaHomePage() {
        nasaScenario1.openHome();
    }
}
