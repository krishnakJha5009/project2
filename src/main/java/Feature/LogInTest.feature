Feature: LogIn feature
Background:
Given I an from Nykaa Page Scenarieos




Scenario: LogIn with valid
Given I launch the application
When I entered user name
And I entered password
And I click login button
Then I varified that I logedIn successfully

             