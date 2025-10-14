Feature: As a user, I want to navigate to explore and then technology on Nasa homepage

  Scenario: I select explore and technology and check header
    Given I am on the nasa home page
    When I navigate to Explore and Technology
    Then I should see Technology as the header



