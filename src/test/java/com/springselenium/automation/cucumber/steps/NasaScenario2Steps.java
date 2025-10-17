package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaHomePage;
import com.springselenium.automation.pages.nasa.NasaTechnologyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario2Steps {

    @Autowired
    NasaHomePage nasaHomePage;

    @Autowired
    NasaTechnologyPage nasaTechnologyPage;

    @When("I navigate to Explore and Technology")
    public void i_NavigateToExploreAndTechnology() {
        //nasaScenario2.navigateToExploreAndTechnology();
        nasaHomePage.navigateToExploreAndTechnology();
    }

    @Then("I should see Technology as the header")
    public void i_ShouldSeeTechnologyAsTheHeader(){
        //Assert.assertTrue(nasaScenario2.verifyCorrectHeader());
        Assert.assertTrue(nasaTechnologyPage.verifyCorrectHeader());
    }

}
