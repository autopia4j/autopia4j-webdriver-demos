Feature: Login 
	As a user, I want to be able to login to the application
	when I present valid credentials

Background:
	Given I am in the login page of the application

@completed	
Scenario: Login with invalid username and invalid password
	When I login using the invalid username abc and the invalid password xyz
	Then The application should stay on the login page, and not log me in
	
@completed
Scenario: Login with valid username and invalid password
	When I login using the valid username mercury and the invalid password xyz
	Then The application should stay on the login page, and not log me in
	
@completed
Scenario Outline: Login with valid username and valid password
	When I login using the valid username <Username> and the valid password <Password>
	Then The application should log me in and navigate to the Flight Finder page
	
	Examples:
	|Username	|Password	|
	|mercury	|mercury	|
	|test		|test		|