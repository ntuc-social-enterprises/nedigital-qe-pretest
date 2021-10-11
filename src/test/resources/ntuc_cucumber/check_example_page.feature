Feature: check example page
  Checking all the web elements of Example page

@RegressionTest
  Scenario: Eaxmple Page functionality for not tried TestCafe
    Given user opened "example" page
    Then "Name" input box "is" exists
    When user Enters "Praveen" name
    Then I am selecting "remote" feature
    Then I am selecting "re-using" feature
    Then I am selecting "Linux" Operating System
    Then I am selecting "Command Line" interface
    When I have "not tried" TestCafe
    Then I see comments is "disabled"
    When I am clicking on submit button
    Then I get thank you "Praveen"

  Scenario Outline: I have tried TestCafe functionality
    Given user opened "example" page
    Then "Name" input box "is" exists
    When user Enters "Praveen" name
    Then I am selecting "remote" feature
    Then I am selecting "re-using" feature
    Then I am selecting "Windows" Operating System
    Then I am selecting "Command Line" interface
    When I have "tried" TestCafe
    Then I rate TestCafe as "<rating>"
    Then I see comments is "enabled"
    Then I enter comment as "Nice to use TestCafe website"
    When I am clicking on submit button
    Then I get thank you "Praveen"

    Examples:
      | rating |
      | 1      |
      | 10     |


  Scenario: Checking populate button functionality
    Given user opened "example" page
    Then "Name" input box "is" exists
    When user Enters "Praveen" name
    Then I am selecting "remote" feature
    Then I am selecting "re-using" feature
    Then I am selecting "Windows" Operating System
    Then I am selecting "Command Line" interface
    When I click Populate button
    Then I should get alert message
    Then I "Cancel" alert
    When I click Populate button
    Then I should get alert message
    Then I "accept" alert
    When I am clicking on submit button
    Then I get thank you "Peter Parker"