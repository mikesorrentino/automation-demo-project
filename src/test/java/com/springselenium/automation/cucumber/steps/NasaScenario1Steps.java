package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaScenario1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario1Steps {

    @Autowired
    NasaScenario1 nasaScenario1;

//    @Given("I am on the nasa home page")
//    public void given_IAmOnTheNasaHomePage() {
//        nasaScenario1.openHome();
//    }

    @When("I search for Mars Rover")
    public void i_SearchForMarsRover() {
        nasaScenario1.searchMarsRover();
    }

    @When("I filter for articles")
    public void i_filter_for_articles(){
        nasaScenario1.appleFilters();
        nasaScenario1.clickApplyButton();
    }

    @Then("I should see the articles header on results page")
    public void then_IShouldSeeArticlesHeaderOnResultsPage()
    {
        Assert.assertTrue(nasaScenario1.isLoaded());
    }
}
