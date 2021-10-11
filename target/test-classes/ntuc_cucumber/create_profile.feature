Feature: To create profile in testcafe

  @smokeTest @RegressionTest
  Scenario Outline: create profile
    Given user opened "example" page
    Then Enter user name and feedback
      | name    | os      |  features | interface    | testcafeTried   | rating  | comments   |
      | <name>  | <os>    | <features>| <interface>  | <testcafeTried> |<rating> | <comments> |
    When I am clicking on submit button
    Then I get thank you "<name>"

    Examples:
      | name     | os      | features                  | interface  | testcafeTried | rating | comments|
      |Praveen   |Windows  |remote#re-using#background#CI#analysis|Command Line|tried|5|comment|
      |Praveen   |MacOS  |remote|JavaScript API|tried|8|comment|
      |Praveen   |Linux  |background#CI#analysis|Both|not tried|||

