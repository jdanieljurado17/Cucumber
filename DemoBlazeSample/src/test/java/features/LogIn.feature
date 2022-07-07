
Feature: LogIn, Sign up and Contact Form into the app
  In this feature LogIn Sign up and Contact Form functionalities will be tested

  Background:
    Given User is on Demo Blaze

  @Login
  Scenario: Signing Up
    When user clicks on sign up button and fills the form
    Then Alert indicating sign up successful is displayed

  @Login
  Scenario Outline: Login with registered username and password
    When user login with username "<username>" and password: "<password>"
    Then user is logged in
    Examples:
      | username  | password  |
      | thistest  | thistest1 |
      | thistest1 | thistest1 |

  @Login
  Scenario Outline: User can fill contact form
    When fill contact form with email "<email>" name "<name>" message "<message>"
    Then contact form is submitted
    Examples:
      | email                 | name      | message       |
      | this.test@email.com   | Test1     | a message     |
      | this.test1@email.com  | Test2     | a message     |
      | this.test2@email.com  | Test3     | a message     |











