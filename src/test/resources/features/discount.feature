@Discount
Feature: Discount

  Background: Go to the main page
    Given I go to the main page

  Scenario: Verify the discount of 20% on
    Given I navigate to Best Sellers section
    When I hover over the "Printed Chiffon Dress" item
    Then for a old price of "$20.50" is shown a "-20%" discount