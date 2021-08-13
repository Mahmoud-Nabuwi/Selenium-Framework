Feature: User Registration
I want check the user can register in our e-commerce website
Scenario Outline:
: User Registration
Given the user in the home page
When I click on Register Link
And I entered "<fname>", "<lname>", "<email>", "<pass>"
Then The Registration Page displayed successfully
Examples:
| fname | lname | email | pass |
| ahmed | mohamed | ahmed1@test.com | 5122875|
| said | rami | said1@test.com | 8875522|

