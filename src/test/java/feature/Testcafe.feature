Feature: Verify Example Page Functionalities

 Scenario Outline: Verify form submission by selecting tried testcafe ,feature,os,interface.
  Given Launch the Application
  Then Title of the page  is displayed as Example
  When User enters the name as "<name>"
  And  selects inputs as "<feature>","<os>","<interface>"
  And  selects tried Testcafe,"<rating>" ,enter comments as "<comment>"and submit
  Then Thankyou page is  displayed with text  "Thank you, <name>!"

  Examples:
   |name     |feature   |os     |interface      |rating|comment|
   |Sri      |remote    |windows|Command Line   |5     |Used windows with cmd line|
   |lakshmi  |re-using  |macos  |JavaScript API |6     |Used mac with api|
   |koppolu  |background|linux  |Both           |8     |Used linux|

 Scenario Outline: Verify form submission without selecting tried testcafe
  Given Launch the Application
  When User enters the name as "<name>"
  And  selects inputs as "<feature>","<os>","<interface>"
  And  Don't select tried Testcafe and submit
  Then Thankyou page is  displayed with text  "Thank you, <name>!"

  Examples:
   |name    |feature |os     |interface    |
   |Sri     |remote  |windows|Command Line |

 Scenario Outline: Verify rating and comments are not enabled without selecting tried testcafe
  Given Launch the Application
  When User enters the name as "<name>"
  And  selects inputs as "<feature>","<os>","<interface>"
  And  tried Testcafe checkbox is not selected
  Then Ratingslider and Comments are not enabled

  Examples:
   |name    |feature |os     |interface    |
   |Sri     |remote  |windows|Command Line |

 Scenario Outline: Verify populate button functionality
  Given Launch the Application
  When User enters the name as "<name>"
  And  click on populate
  Then Reset Information Popup is displayed

  Examples:
   |name    |
   |Sri     |