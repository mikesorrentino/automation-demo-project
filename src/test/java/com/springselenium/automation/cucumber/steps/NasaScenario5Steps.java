package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario5Steps {

    @Autowired
    NasaHomePage nasaHomePage;

    @When("I iterate nav links")
    public void i_IterateNavLinks() {
        nasaHomePage.IterateThroughNavLinks();
    }

    @Then("all pages load successfully")
    public void all_pages_load_successfully() {
        System.out.println("All navigation links loaded successfully");
    }

}
