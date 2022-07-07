Feature: Adding, deleting and buying products
  This feature tests the buying, deleting and adding products functionality

  Background:
    Given User is on Demo Blaze
@Buy
  Scenario: User is able to select a Category
    When the user clicks on a category
    Then user can see products
@Buy
  Scenario: Adding products to the cart
    When the user clicks on the product
    Then the product is added to the cart
@Buy
  Scenario: Deleting products
    When the user clicks on delete button
    Then the product is deleted from the cart
@Buy
  Scenario Outline: Buying a product
    When user adds products and click on purchase button
    And user fills form with name "<name>" country "<country>" city "<city>" card "000" expMonth "00" expYear "00"
    Then order is placed
  Examples:
    | name | country   | city    |
    | Jhon | USA       | NY      |
    | Jenny| USA       | Miami   |
    | Jan  | Canada    | Toronto |