Feature: As a user, I want to navigate to contact form, fill it out and confrim on Nasa homepage

  Scenario: I locate contact form, fill in and send form, confirm message
    Given I am on the nasa home page
    When I locate contact form
    When I fill in form and submit it
    Then I verify confirm message




