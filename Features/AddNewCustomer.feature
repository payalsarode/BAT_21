Feature: Customer
 
 
    Scenario Outline: Login Data Driven
    Given user launch Chrome Browser
    When User open url "<url>"
    And User enter Email as "<email>" and password as "<password>"
    And User click on Login button
    Then User can view Dashboard
    When User click on Customers menu
    And  User click on Customers menu item
    And User click on new add button
    Then User can view new customer page
    When User enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminComment>"
    And user click on save button
    Then user can view confirmation page "The new customer has been added successfully."
    And Close browser
    
    Examples:
    |url|email|password|newEmail|newPass|fname|lname|gender|comName|adminComment|
    |https://admin-demo.nopcommerce.com/login|admin@yourstore.com |admin|sayali12@gmail.com|Sayali12|sayali|goyal|female|Infobase|NiceInfobase|
    |https://admin-demo.nopcommerce.com/login|admin@yourstore.com |admin|rahil12@gmail.com|Rahil12|rahil|raj|male|Infogate|NiceInfogate|
  