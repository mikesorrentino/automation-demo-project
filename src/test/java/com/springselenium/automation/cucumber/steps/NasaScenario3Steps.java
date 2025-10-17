package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaHomePage;
import com.springselenium.automation.pages.nasa.NasaImageOfTheDayPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario3Steps {

    @Autowired
    NasaHomePage nasaHomePage;

    @Autowired
    NasaImageOfTheDayPage nasaImageOfTheDayPage;

    @When("I navigate to image of day")
    public void i_NavigateToImageOfDay() {
        nasaHomePage.navigagteToImgOfDay();
    }

    @When("I select image")
    public void i_SelectImage() {
        nasaImageOfTheDayPage.selectImage();
    }

    @Then("I should see image title")
    public void i_ShouldSeeImageTitle(){
        Assert.assertTrue(nasaImageOfTheDayPage.verifyCorrectTitle());
    }

}
