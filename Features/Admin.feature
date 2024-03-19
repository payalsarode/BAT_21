Feature: Admin
 
  @smoke
  Scenario: Login with valid credential
    Given user launch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and password as "admin"
    And User click on Login button
    Then User verify page title should be "Dashboard / nopCommerce administration"
    And Close browser

    @sanity
    Scenario Outline: Login Data Driven
    Given user launch Chrome Browser
    When User open url "<url>"
    And User enter Email as "<email>" and password as "<password>"
    And User click on Login button
    Then User verify page title should be "Dashboard / nopCommerce administration"
    And Close browser
    
    Examples:
    |url                                     |email               |password   |
    |https://admin-demo.nopcommerce.com/login|admin@yourstore.com |admin      |
    |https://admin-demo.nopcommerce.com/login|admin123@yourstore.com |admin123      |
    |https://admin-demo.nopcommerce.com/login|admin@yourstore.com |admin      |