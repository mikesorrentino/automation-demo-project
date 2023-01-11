Feature: As a user, I want to search for Ronaldo on Google

  Scenario: I search for Ronaldo and land on the results page

    Given I am on the google page
    When I search for "Ronaldo"
    And I click the search button
    Then I should see the results page