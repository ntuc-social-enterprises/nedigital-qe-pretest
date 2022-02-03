Introduction:  
=============
Commonly, Test automation involves automating a manual process already in place that uses a formalized testing process.

Project name: nedigital-bdd-automation

This project is for web automation testing of TestCafe tutorials using Serenity BDD framework

Tools and Technologies:
=======================

Automation tool : Serenity, Selenium
Programming language : Java
Build Tool : Maven
Testing Framework : Cucumber BDD
Report : Serenity HTML report
Logger : Slf4J

Project folder Structure:
=========================
src/main/java:
==============

pageobjects:
HomePage - This class file contains the Object repository/Element locators

stepdefinitions:
HomePageStepdefinations - This class file contains the glue code with respect to the Home Page

tasks:
HomePageAction - This class file contains the methods for UI actions and validations

==============
src/test/java:
==============
acceptancetests: Contains Test runner file which helps to start the execution through Junit
features: Contains cucumber feature file written in Gherkin language/keywords

===================
src/main/resources:
===================
drivers – Contains the chrome driver for Windows
log4j – Log file will be created under target folder

==================
src/test/resources:
==================
serenity.conf - Contains all the configurations for the Serenity framework such as browser, driver location and environments

=====================
Test Execution Steps:
=====================
Right click on the below file and run as Junit Test
src/test/java -> acceptancetests -> CucumberTestSuite.java

(OR)

Run as mvn clean verify

=========
Reports :
=========
Serenity HTML Reports:
        target\site\serenity\index.html
        target\site\serenity\serenity-summary.html
        target\HtmlReports

=======================================================================================================================================================
4. Every new employee at NTUC will have a buddy help him/her to tune in with environment. Every employee have their supervisor and team. Let's say that we have a table of employee where all the information mention earlier is store. The table specification is looks like this:<BR>
| employee_id | employee_name | buddy_id | supervisor_id | team_name |<BR>
your task is to create a query to show:<BR>
| employee_id | employee_name | buddy_name | supervisor_name | team_name |


Answer:

==========================================================================================================================
To fetch the | employee_id | employee_name | buddy_name | supervisor_name | team_name | from Employees table:

We can use either of the below queries:

1)
SELECT a.employee_id Employee_ID,a.employee_name Employee_Name, b.employee_name as Buddy_Name, c.employee_name as Supervisor_Name, a.team_name from Employees a
left join Employees b on a.employee_id = b.buddy_id
left join Employees c on a.employee_id = c.supervisor_id

2)
Select employee_id, employee_name, (Select employee_name from Employees where buddy_id=employee_id) AS buddy_name, (Select employee_name from Employees where supervisor_id=employee_id) AS supervisor_name, team_name from Employees


3)
Select employee_id, employee_name, buddy_name, supervisor_name, team_name from Employees where buddy_name IN (Select employee_name from Employees where c=employee_id) AND supervisor_name IN (Select employee_name from Employees where supervisor_id=employee_id)

4)
SELECT a.employee_id Employee_ID,a.employee_name Employee_Name,(Select employee_name from Employees where employee_id= a.buddy_id)) Buddy_Name, (Select employee_name from Employees where employee_id= a.supervisor_id)) Supervisor_Name, team_name from Employees a, Employees b
where a.employee_id = b.employee_id order by a.employee_id asc;
==========================================================================================================================

