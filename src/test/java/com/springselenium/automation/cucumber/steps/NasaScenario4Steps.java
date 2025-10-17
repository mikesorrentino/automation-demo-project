package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.nasa.NasaContactPage;
import com.springselenium.automation.pages.nasa.NasaHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NasaScenario4Steps {

    @Autowired
    NasaHomePage nasaHomePage;

    @Autowired
    NasaContactPage nasaContactPage;

    @When("I locate contact form")
    public void i_LocateContactForm() {
        nasaHomePage.locateContactForm();
    }

    @When("I fill in form and submit it")
    public void i_FillInFormAndSubmitIt() {
        nasaContactPage.fillInFieldsAndSubmit();
    }

    @Then("I verify confirm message")
    public void i_verifyConfirmMessage(){
        Assert.assertTrue(nasaContactPage.verifyConfirmMessage());
    }

}
