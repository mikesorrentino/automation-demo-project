package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaScenario3;
import com.springselenium.automation.pages.nasa.NasaScenario4;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario4Steps {

    @Autowired
    NasaScenario4 nasaScenario4;

    @When("I locate contact form")
    public void i_LocateContactForm() {
        nasaScenario4.locateContactForm();
    }

    @When("I fill in form and submit it")
    public void i_FillInFormAndSubmitIt() {
        nasaScenario4.fillInFieldsAndSubmit();
    }

    @Then("I verify confirm message")
    public void i_verifyConfirmMessage(){
        Assert.assertTrue(nasaScenario4.verifyConfirmMessage());
    }

}
