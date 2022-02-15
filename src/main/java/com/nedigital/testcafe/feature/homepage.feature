Feature: Test Test-Cafe HomePage scenarios

  Scenario Outline: Test Test-Cafe by passing valid set of values
    Given Open chrome browser and navigate to homepage
    When I am on homepage specify following details "<Name>" "<features>" "<OS>" "<triedTc>" "<rateScale>" "<Description>"
    Then Submit should be successful "<Expected>"


    Examples:
      | Name | features | OS      | triedTc | rateScale | Description | Expected        |
      | abc  | remote   | Linux   | true    | 5         | abc         | Thank you, abc! |
      | tom  | re-using | Windows | true    | 10        | description | Thank you, tom! |


  Scenario Outline: Test Test-Cafe when description box is grayed
    Given Open chrome browser and navigate to homepage
    When I am on homepage specify following details "<Name>" "<features>" "<OS>" "<triedTc>"
    Then Description and rate scale should be greyed

    Examples:
      | Name | features | OS      | triedTc |
      | abc  | remote   | Linux   | false   |
      | tom  | re-using | Windows | false   |

