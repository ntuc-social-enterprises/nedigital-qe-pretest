# Pretest

### To Run:
    mvn test

Output:
    Verify in target\cucumber-reports\cucumber-pretty.html
For reporting, I just went the cucumber html report.

I placed the reference test report in the main folder.
### to run selected tests
mvn test -Dcucumber.filter.tags="@smokeTest and @RegressionTest"

#### To Answer the questions mentioned
1. Tell us what kind of test should be conduct (plan and why) to make sure the page is ok.
Test plan:
   1. Identify the platform, OS and browser where we need to run the applications.
   2. Perform functionality test for the new features.
   3. After the development of the page, perform smoke, new feature and regression tests.

2. Tell us what kind of testcase you want to execute.
Web GUI testing
Test cases:
1. Perform feedback form by entering all the details to the element.
2. Verify by entering name, select features, OS, interface then click on submit, submit the feedback
3. Verify tried testcafe checkbox is checked then scale and comments is enabled.
4. Verify by entering all the details to the fields and then check tried testcafe. Then select
scale and add comments, then submit will subtmit the form.
5. Enter name and click on populate will populate the user details with the entered feedback.
6. Click on populate button popup alert to notify user about the form reset.
7. Verify that after clicking on the populate button displays alert and click on cancel should not clear the form.
8. Verify that scale and comment fields are disabled when tried testcafe is unchecked.
9. Verify that scale and comment fields are enabled when tried testcafe is checked.
10. Submit button is disabled untill the user enters name.

Security, database and api testing if the application supports.

3. We all know automation can help, show us your test-automation code to test it with BDD Style and Please Impress us by not using Katalon. <BR>
   Please put in your README.md how to run this locally, so we can try it.
   Nice to have if you can integrate it with the CircleCI or Bitbucket Pipelines , and capture the result.

Create the PR and the result is provided in the main folder.


4. Every new employee at NTUC will have a buddy help him/her to tune in with environment. Every employee have their supervisor and team. Let's say that we have a table of employee where all the information mention earlier is store. The table specification is looks like this:<BR>
   | employee_id | employee_name | buddy_id | supervisor_id | team_name |<BR>
   your task is to create a query to show:<BR>
   | employee_id | employee_name | buddy_name | supervisor_name | team_name |

select e1.employee_id,
e1.employee_name,
e2.employee_name as buddy_name,
e3.employee_name as supervisor_name,
e1.team_name team_name
from employee e1
LEFT JOIN employee e2 ON e2.employee_id = e1.buddy_id
LEFT JOIN employee e3 ON e3.employee_id = e1.supervisor_id