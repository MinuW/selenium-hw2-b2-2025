Feature: Login to Sauce Demo Site
  This feature will check successful and
  unsuccessful user login

  Background:
    Given the user is in the login page

  @Smoke
  Scenario: Valid user login
    When the user enter credentials
    Then the user is directed to the inventory page

  @Smoke
  Scenario: Valid user login parameterised
    When the user enter credentials "standard_user", "secret_sauce"
    Then the user is directed to the inventory page

  @Regression
  Example: Login with invalid password
    When the user enter credentials "standard_user", "invalid"
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"

  @Regression
  Scenario Outline: Invalid user login scenarios
    When the user enter credentials <username>, <password>
    Then the user should see an error message <expectedErrorMessage>
    Examples:
      | username        | password  | expectedErrorMessage                                                        |
      | "standard_user" | "invalid" | "Epic sadface: Username and password do not match any user in this service" |
      | ""              | ""        | "Epic sadface: Username is required"                                        |
      | "standard_user" | ""        | "Epic sadface: Password is required"                                        |