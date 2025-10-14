Feature: As a user, I want to iterate nav links and check if link is correct on Nasa homepage

  Scenario: I iterate nav Links and check if link is correct
    Given I am on the nasa home page
    When I iterate nav links
    Then all pages load successfully




