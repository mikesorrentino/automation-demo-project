Feature: As a user, I want to navigate to image of day, click on img on Nasa homepage

  Scenario: I select image of day and click on it and check header
    Given I am on the nasa home page
    When I navigate to image of day
    When I select image
    Then I should see image title



