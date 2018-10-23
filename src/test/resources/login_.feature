Feature: LogIn

  Scenario: Successful LogIn
    Given I am on the home page
    When I click on signIn button
    Then SignIn page is opened
    When I enter correct email and password into signIn form
    And I click on green signIn button
    Then I'm logged in


  Scenario Outline: UnSuccessful LogIn
    Given I am on the home page
    When I click on signIn button
    Then SignIn page is opened
    When I enter "<email>" and "<password>" into signIn form
    And I click on green signIn button
    Then Error "<message>" is displayed

    Examples:
      |email| password|message|
      |test_a1error@test.com|test_a11111|Authentication failed.|
      |test_a1error@test.com|1|Invalid password.|
      ||123|An email address required.|
      |test_a1error@test.com|| Password is required.|