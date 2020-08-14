@Buy
Feature: Buy

  Background: Go to the main page
    Given I am signed in using the credentials email "alejandrojeancarlo@gmail.com" and password "control123456"
      And I go to the main page

  Scenario: Buy two products
    Given I navigate to Best Sellers section
    When add "Printed Chiffon Dress" item to Cart
      And add "Blouse" item to Cart
      And go to checkout
    Then the "Printed Chiffon Dress" item it's available
      And the "Blouse" item it's available
      And the total amount to pay is "$45.40"
    When proceed with the checkout
      And proceed with the checkout
      And I try to continue to checkout without accept Shipping Terms of Services
    Then this message "You must agree to the terms of service before continuing." is displayed about to accept Shipping Terms of Service
    When accept Shipping Terms of Services
      And proceed with the checkout
    Then the total amount to pay is "$45.40"
    When I choose pay By check
      And I confirm my order
    Then this message is displayed "Your order on My Store is complete." about the order was completed
     

