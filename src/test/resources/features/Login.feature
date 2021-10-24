Feature: Login
  As a User
  I want a login component
  So that I can access my profile details

  Background: User Register
    Given User sing up with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User process the create profile request
    Then User Get a 201 response

  Scenario: User can login to buggy cars website
    When User Login to Buggy cars website
    Then User is able to see his name on the top nav bar


  Scenario: User can not login to buggy cars website with wrong password
    When User Login to Buggy cars website with wrong
      | password      |
      | wrongPassword |
    Then User is presented with error message "Invalid username/password"

  Scenario: User can not login to buggy cars website with wrong username
    When User Login to Buggy cars website with wrong
      | username      |
      | wrongUserName |
    Then User is presented with error message "Invalid username/password"