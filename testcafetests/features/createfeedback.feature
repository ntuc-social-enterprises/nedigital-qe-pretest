@createfeedback
Feature: Submit feedback on Testcafe
    Scenario Outline: Submit feedback in testcafe and verify it is submitted successfully
        Given Feedback page opened
        When Enter Feedback Details
             | name    | OS      |  features | interface    | testcafe_tried   | rating  | comments   |
             | <name>  | <OS>    | <features>| <interface>  | <testcafe_tried> |<rating> | <comments> |

        And ClickButton "Submit" 
        Then Feedback Submitted Successfully

        Examples:
                | name     | OS      |                    features               | interface      | testcafe_tried | rating | comments         |
                | lavanya  | Windows |remote#jsreuse#backgroundtests#CI#analysis | Command Line   | true           | 5      | auto comments    |
                | lavanya1 | MacOS   |remote#jsreuse                             | JavaScript API | true           | 2      | auto comments123 |
                | lavanya12|         |                                           |                |                |        |                  |
                |          |         |                                           |                |                |        |                  |