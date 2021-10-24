Feature: Registration
  As a User
  I want a Registration Form
  So that I can rate cars in Buggy car website

  Scenario: User can register to Buggy car
    Given User sing up with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User submits form
    Then User can read a "Registration is successful" message

  Scenario: User can not register to Buggy car with a miss-matching password
    Given User sing up with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988%%   |
    When User submits form
    Then User can read a "Passwords do not match" message

  Scenario: User can not register to Buggy car with using an existing user
    Given User sing up with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User submits form
    Then User can read a "Registration is successful" message
    When User submits form
    Then User can read a "UsernameExistsException: User already exists" message