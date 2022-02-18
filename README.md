# QE NE Digital Pretest

  You can answer it as creative as you can, you can even show off what you know, use all the tools that you like, and send us your PR.
Once upon a time there is a web page (https://devexpress.github.io/testcafe/example/) that need to assess how cool is the quality of the page. And here it comes your first task begin:


1. Tell us what kind of test should be conduct (plan and why) to make sure the page is ok.
TestPlan:

For the given requirement,its good to perform the below test procedures.SmokeTesting and Functional testing are of highest priority.
**For this test,only 1 and 2 points are considered in scope.**

1.Smoke testing - Firstly, perform a basic smoke test to ensure the page is loading fine without any issues.
2.Functional testing - To verify that all the  functionalities in the given page are working without any issues/bugs.
3.Browser Compatibility testing - To verify that page loads on different browsers and all the ui fields alignment is proper 
4.Mobile testing - If page is loading on mobile browser and is responsive,if in scope  
5.Performance Testing - Load Test to verify n number of concurrent users can use the same page and submit at a time
7.Regression Testing - Identify the main flows and add into Existing Regression Suite 

Automation Tools Required:Selenium,Cucumber 
Testing Framework : BDD Framework
Programming language :Java
Build Tool : Maven

2. Tell us what kind of testcase you want to execute.

1. Verify that example page is loaded without any erros,verify the title.
2. verify Thankyou page is displayed with username on selecting different features,os,interface,tried testcafe,rating,comments and submit.
3. Verify Thankyou page display without selecting tried testcafe and submit.
4. Verify slider and comments box is disabled when tried testcafe is not selected
5. verify populate button behaviour 
6. verify reset information popup display 


3. We all know automation can help, show us your test-automation code to test it with BDD Style and Please Impress us by not using Katalon. <BR>
   Please put in your README.md how to run this locally, so we can try it.
   Nice to have if you can integrate it with the CircleCI or Bitbucket Pipelines , and capture the result.
  
Automation code is pushed to repository.Used Cucumber with BDD Framework.Execution report index.html gets generates in  target\cucumber-report\cucumber.html
Steps to execute in local:
From commandprompt:  
mvn clean install
mvn test
Also,can run directly from IDE from TestRunner file src\test\java\runner\TestRunner**

4. Every new employee at NTUC will have a buddy help him/her to tune in with environment. Every employee have their supervisor and team. Let's say that we have a table of employee where all the information mention earlier is store. The table specification is looks like this:<BR>
| employee_id | employee_name | buddy_id | supervisor_id | team_name |<BR>
your task is to create a query to show:<BR>
| employee_id | employee_name | buddy_name | supervisor_name | team_name |

**Solution:**
select e1.employee_id,e1.employee_name,e2.employee_name as buddy_name,e3.employee_name as supervisor_name,e1.team_name 
from employee e1
LEFT JOIN employee e2 ON e2.employee_id = e1.buddy_id
LEFT JOIN employee e3 ON e3.employee_id = e1.supervisor_id
