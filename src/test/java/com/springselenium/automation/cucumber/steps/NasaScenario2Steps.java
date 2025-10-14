package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaScenario2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario2Steps {

    @Autowired
    NasaScenario2 nasaScenario2;


//    @Given("I am on the nasa home page")
//    public void given_IAmOnTheNasaHomePage() {
//        nasaScenario2.openHome();
//    }

    @When("I navigate to Explore and Technology")
    public void i_NavigateToExploreAndTechnology() {
        nasaScenario2.navigateToExploreAndTechnology();
    }

    @Then("I should see Technology as the header")
    public void i_ShouldSeeTechnologyAsTheHeader(){
        Assert.assertTrue(nasaScenario2.verifyCorrectHeader());
    }

}
