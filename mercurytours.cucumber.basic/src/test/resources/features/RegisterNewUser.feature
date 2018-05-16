Feature: Register new user
	As a new user to the application, I want to be able to register myself
	so that I can login and use the application further
	
@completed
Scenario: Register new user and login using the newly registered credentials
	Given I am in the login page of the application
	When I register a new user with the following details:
		|	Username		|	autopia							|
		|	Password		|	password-1				|
		|	FirstName		|	vj								|
		|	LastName		|	rams							|
		|	Phone				|	1234567890				|
		|	Email				|	reachus@autopia.com	|
		|	Address			|	90 May Street		|
		|	City				|	Woodbridge						|
		|	State				|	New Jersey				|
		|	PostalCode	|	07095							|
	Then I should get a confirmation on successful registration
	When I click on the sign in link
	And I login using the valid username autopia and the valid password password-1
	Then The application should log me in and navigate to the Flight Finder page