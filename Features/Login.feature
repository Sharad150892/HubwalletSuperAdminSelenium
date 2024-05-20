Feature: Login
@SL
Scenario: Successfull login with valid Credentials
Given User launch browser
And User opens URL "http://147.182.252.15:5100/"
When User add Email "superadmin@booknpay.com" and password "12345678"
And Login Page tile captured
And Click on the Login button
Then Merchant page title captured
And Click on the logout
And Close browser



Scenario Outline: Successfull login with Data Driven
Given User launch browser
And User opens URL "http://147.182.252.15:3200/"
When User add Email as "<email>" and Password as "<password>" 
And Login Page tile captured
And Click on the Login button
Then Merchant page title captured
And Click on the logout
And Close browser
	Examples:
		|email | password |
		| admin@hubwallet.com | 12345678 |
    | narmsync.test@gmail.com | 112233 |
    | narmsync.test@gmail.com | 1222333455 |

