Feature: login testing with multiple test of data

Scenario Outline:
Given user go to the login page
When Enter the login data<username> and <password>
And press the enter button
Then login successfull with correct data
And user get error with incorrect data

Examples:
|username|password|
|Admin	| admin123|
 |jack	|admin123|
|		|		 |
|Rock	|rocky123|