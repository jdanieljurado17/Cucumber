Feature: DemoBlaze
  This test Suit is to test Demo Blaze app functionality

  Scenario: Signing Up
    Given the website loaded
    When user clicks on Sign Up button
    Then user can type in data to sign up
    And  clicks on Sign Up to complete Signing Up
    And closes the driver

  Scenario: LogIn In
    Given the website loaded
    When the user clicks on LogIn Button
    Then user can fill logIn form
    And click on LogIn to complete Login
    And closes the driver

  Scenario: Contact Form
    Given the website loaded
    When the user clicks on contact button
    Then can fill the contact form
    And click on confirm contact button
    And closes the driver

  Scenario: Category Phone
    Given the website loaded
    When the user clicks on Phone button
    Then Phones category page is loaded
    And closes the driver

  Scenario: Category Laptop
    Given the website loaded
    And the user is on home page
    When the user clicks on Laptop button
    Then Laptops category is loaded
    And closes the driver

  Scenario: Category Monitor
    Given the website loaded
    And the user is on home page
    When the user clicks on monitor category
    Then Monitor category is loaded
    And closes the driver

  Scenario: Adding products to the cart
    Given the website loaded
    And the user navigates to desired category
    And clicks on the product to add to the cart
    When clicks on add to cart
    Then product is added to cart
    And closes the driver

  Scenario: Deleting products
    Given the website loaded
    And the user has added products to the cart
    When the user clicks on delete button
    Then the products are deleted
    And closes the driver

  Scenario: Buying Item
    Given the website loaded
    And the user is on home page
    And navigates to desired category
    When the user adds a product to the cart
    And clicks on the cart button
    And clicks on place order button to fill the form
    Then order is placed
    And can click on confirm button
    And closes the driver
