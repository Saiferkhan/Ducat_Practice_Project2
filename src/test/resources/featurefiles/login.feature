Feature: demo
Background:

Given User is on to login page
When User enter the username and password
| usernam |password  |
| Admin   |  admin123|
And Click on the login button

Scenario: Login functionality

Then Login successfull
And User should see homepage

Scenario:
Then login unsuccessful
And error message displayed