package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario1Steps {

    @Autowired
    //NasaScenario1 nasaScenario1;
    NasaHomePage nasaHomePage;

    @When("I search for Mars Rover")
    public void i_SearchForMarsRover() {
        nasaHomePage.search("Mars Rover");
      //  nasaScenario1.searchMarsRover();
    }

    @When("I filter for articles")
    public void i_filter_for_articles(){
        nasaHomePage.selectArticlesFilter(true);
        nasaHomePage.clickApplyFilters();
        //nasaScenario1.appleFilters();
        //nasaScenario1.clickApplyButton();
    }

    @Then("I should see the articles header on results page")
    public void then_IShouldSeeArticlesHeaderOnResultsPage()
    {
        Assert.assertTrue(nasaHomePage.isArticlesFilterApplied("Articles"));
        //Assert.assertTrue(nasaScenario1.isLoaded());
    }
}
