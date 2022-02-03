@regression
Feature: James launch the TestCafe tutorials application

Background:
	Given James opens the TestCafe application

 	@TC_01
  Scenario Outline: To verify James can launch the TestCafe tutorials application and perform sequence of actions for different OS
    Then James verify the title and text on the screen is displayed as "Example"
   	When James enter the name in the testcafe webpage "<name>"
  	And James select all features
    And James select primary operating system as "<os>"
 		And James select the Interface as "<interface>"
 		And James select tried Testcafe
 		And James select the rating scale of testcafe as <rating>
 		And James enter his comments on the tutorials page "<message>"
 		And James click on the submit button
 		Then James verify the page redirects with text displayed as "Thank you, <name>!"

    Examples:
    |name  |os     |interface     |rating|message																	  |
    |Steve |Windows|Both          |3     |Needs to develop few features on this page|
    |John  |MacOS  |JavaScript API|10    |This page is good                         |
    |Russel|Linux  |Command Line  |5     |Needs to correct few errors               |
   	
  @TC_02
  Scenario: To verify submit button behaviour
    Then James verify the title and text on the screen is displayed as "Example"
   	And James verify submit is disabled when name is not entered

	@TC_03
  Scenario: To verify populate button behaviour for accepting the popup
    Then James verify the title and text on the screen is displayed as "Example"
    When James click on Populate button next to name
   	Then James verify the popup message with ok button
   	
   