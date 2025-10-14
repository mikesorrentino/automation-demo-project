Feature: As a user, I want to search for a topic and apply filters on Nasa homepage

  Scenario: I search for Mars Rover and land on the results page and filter results
    Given I am on the nasa home page
    When I search for Mars Rover
    And I filter for articles
    Then I should see the articles header on results page