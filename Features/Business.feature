Feature: Add New Business

@SL
Scenario: Add New Business
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
And Click on Business Module
Then Business Page Title Capture
When Click on Add New Business Btn
Then Add New Business Page Title Capture
And Enter Business Information
Then Click on Business Save button
Then Verify Business Added
And Click on the logout
And Close browser


