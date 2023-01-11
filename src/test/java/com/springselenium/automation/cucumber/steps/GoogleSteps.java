package com.springselenium.automation.cucumber.steps;

import com.springselenium.automation.pages.google.GooglePage;
import com.springselenium.automation.pages.google.GoogleResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class GoogleSteps {

    @Autowired
    GooglePage googlePage;

    @Autowired
    GoogleResultsPage googleResultsPage;

    @Given("I am on the google page")
    public void given_IAmOnTheGooglePage() {
        googlePage.goTo();
        Assert.assertTrue(googlePage.isAt());
    }

    @When("I search for {string}")
    public void when_ISearchFor(String search) {
        googlePage.search(search);
    }

    @When("I click the search button")
    public void when_ICLickTheSearchButton() {
        googlePage.clickSearch();
    }

    @Then("I should see the results page")
    public void then_IShouldSeeTheResultsPage() {
        Assert.assertTrue(googleResultsPage.isAt());
    }

}
