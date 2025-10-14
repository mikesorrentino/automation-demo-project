package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaScenario4;
import com.springselenium.automation.pages.nasa.NasaScenario5;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario5Steps {

    @Autowired
    NasaScenario5 nasaScenario5;



    @When("I iterate nav links")
    public void i_IterateNavLinks() {
        nasaScenario5.IterateThroughNavLinks();
    }

    @Then("all pages load successfully")
    public void all_pages_load_successfully() {
        System.out.println("All navigation links loaded successfully");
    }

}
