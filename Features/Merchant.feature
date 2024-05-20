Feature: Add New Merchant

@SL
Scenario: Add New Merchant
Given User launch browser
And User opens URL "http://147.182.252.15:3200/"
When User add Email "admin@hubwallet.com" and password "12345678"
And Login Page tile captured
And Click on the Login button
Then Merchant Page title captured
And Click on Add New Merchant Btn
Then Add New Merchant Page title captured
Then Enter Merchant Information
When Click on save button
Then Verify Merchant Added
And Click on the logout
And Close browser


