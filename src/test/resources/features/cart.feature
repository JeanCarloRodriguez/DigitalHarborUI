@Cart
Feature: Cart

  Background: Go to the main page
      Given I go to the main page

  Scenario: Verify Add and Remove operations on Cart
    Given I navigate to Best Sellers section
      When add "Printed Chiffon Dress" item to Cart
      And add "Blouse" item to Cart
      And go to checkout
      Then the "Printed Chiffon Dress" item it's available
      And the "Blouse" item it's available
      When I remove "Blouse" item from shopping cart
      Then "Blouse" item should  be deleted from shopping cart
      And the total amount to pay is "$18.40"
