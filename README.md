# QE NE Digital Pretest

  You can answer it as creative as you can, you can even show off what you know, use all the tools that you like, and send us your PR.
Once upon a time there is a web page (https://devexpress.github.io/testcafe/example/) that need to assess how cool is the quality of the page. And here it comes your first task begin:


1. Tell us what kind of test should be conduct (plan and why) to make sure the page is ok.

**Smoke testing** - First we conduct a basic smoke test to make sure the page is loading fine
**Functional testing** - to ensure the page functionality is working fine
**Cross browser testing** - to ensure page is loaded on different browsers (for different OS as well)
**Mobile testing** - If page is loading on mobile browser and is responsive (Assuming the requirement is also for mobile)
**Localization testing** - To see the page accepts data in locale language
**Performance Testing** - Stress and load test
**Security testing** - To make sure no sql injection attack, not using expired certificates
**Regression Testing** - identify common flows in the page and run all those tests as part of release to ensure existing things do not break


2. Tell us what kind of testcase you want to execute.

**GUI and Usability testcases**
   Include testing of various components on the page like setting input  
   text, selecting radio button,checkboxes,slider are aligned correctly 
   and page navigation dont have any issues
   
**Functional Testcases** - Related to the business flows
 - **Positive TestCases**
         Testdata includes english and locale languge and special 
         characters
	   **Eg:**
          1.Verify the feedback form submitted with name and default 
   	         fields 
          2.Verify the feedback form submitted with name and all other 
          optional fields values selected
          3.Verify rating slider and comments textbox can be selected only 
          when checkbox "testcafe tried" enabled and the form is 
          submitted with all the fields 
          4.Submit feedback with same user again and submission is 
          successful
 - **Negative testcases-**
	   **Eg:**
        1.Verify Submit button disabled if required fields are not 
        populated
        2.Check the maximum string length allowed in the comments 
        textarea and name field

**API Tests**
	Test the apis for the operations it supports and error scenarios 
	handled properly 
   
**DataBase Testcases**
    **Eg:**
      1.Once the form is submitted, the data is entered correctly in the 
      DB
      2.Check values for columns that do not accept null values
      3.check if radiobutton and dropdown list options are saved 
      correctly in the database.
      4.If same User is submitting the feedback again, then DB row for 
      the same user should be updated, instead of creating new data
   
**Non Functional Testcases**
 
 - **Performace Testing Scenarios**
       **Eg:**
        1.Page is loaded within accepted response time as per SLA
        2.Stress test the page to know the point it breaks
        3.Load test to see it supports multiple users   

 - **Security Testing Scenarios**
	**Eg:**
    1.If user enters url with http, it should redirect to https
    2.SQL injection attack


3. We all know automation can help, show us your test-automation code to test it with BDD Style and Please Impress us by not using Katalon. <BR>
   Please put in your README.md how to run this locally, so we can try it.
   Nice to have if you can integrate it with the CircleCI or Bitbucket Pipelines , and capture the result.

   **Automation Setup** 
===============
Cucumber + Playwright with chai framework

**Prereq**
======
Install Node froom - https://nodejs.org/en/download/

**Steps to Execute Tests Locally**
=============================
 1. From command line Clone the repo
 2. run "npm install"
 3. To run a feature, run below command,default runs on chrome.Once tests are run, results are stored in 
     folder e2etestresults

      make debug-browser-test-class AGAINST=https://devexpress.github.io/testcafe/example/ TAG=@createfeedback

 4. For generating html report,after test execution completed run command "node reporter.js" from project directory

 5. To view the report open index.html from folder e2etestresults.For failed scenarios exception and screenshot will be logged in the report.

**Integration with CI/CD**
======================
Bitbucket Repo link - https://bitbucket.org/lavanyachappa/nedigital-qe-pretest
I added the project to bitbucket and setup a basic pipeline to execute tests.

**Note -** 
Automation is done for 1 feature only
A basic pipeline is setup and tests are run on headless mode.To run in headless off mode we have to setup runners in bitbucket. We can also configure  yml to run tests only for PRs.
I intentionally failed 1 test to show the exception and screenshot in the report for failed scenario.Results are downloaded to bitbucket artifacts.


4. Every new employee at NTUC will have a buddy help him/her to tune in with environment. Every employee have their supervisor and team. Let's say that we have a table of employee where all the information mention earlier is store. The table specification is looks like this:<BR>
| employee_id | employee_name | buddy_id | supervisor_id | team_name |<BR>
your task is to create a query to show:<BR>
| employee_id | employee_name | buddy_name | supervisor_name | team_name |

**Query**
select e1.employee_id,
	   e1.employee_name,
       e2.employee_name as buddy_name,
	   e3.employee_name as supervisor_name,
	   e1.team_name team_name
from employee e1
LEFT JOIN employee e2 ON e2.employee_id = e1.buddy_id
LEFT JOIN employee e3 ON e3.employee_id = e1.supervisor_id
