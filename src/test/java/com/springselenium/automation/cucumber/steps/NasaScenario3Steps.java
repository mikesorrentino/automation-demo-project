package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaScenario2;
import com.springselenium.automation.pages.nasa.NasaScenario3;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario3Steps {

    @Autowired
    NasaScenario3 nasaScenario3;


    @When("I navigate to image of day")
    public void i_NavigateToImageOfDay() {
        nasaScenario3.navigagteToImgOfDay();
    }

    @When("I select image")
    public void i_SelectImage() {
        nasaScenario3.selectImage();
    }

    @Then("I should see image title")
    public void i_ShouldSeeImageTitle(){
        Assert.assertTrue(nasaScenario3.verifyCorrectTitle());
    }

}
