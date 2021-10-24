Feature: Profile
  As a User
  I want a profile form
  So that I can update my profile details

  Background: User Register
    Given User sing up with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User process the create profile request
    Then User Get a 201 response

  Scenario: User updates profile name
    Given User Login to Buggy cars website
    And User Navigates to profile
    When User updates
      | firstName |
      | rafa      |
    And User saves updated details
    Then User can read a "The profile has been saved successful" message

  Scenario: User updates profile lastname
    Given User Login to Buggy cars website
    And User Navigates to profile
    When User updates
      | lastName |
      | Mendoza  |
    And User saves updated details
    Then User can read a "The profile has been saved successful" message