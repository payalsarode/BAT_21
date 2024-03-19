Feature:Vendor
 

    Scenario Outline: Login Data Driven
    Given user launch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com"
    And User enter Email as "<email>" and password as "<password>"
    And User click on Login button
    And User click on vendor item
    Then User can view vendor page
    When User enter Vendor name as "<Vendorname>" and password as "<Vendoremail>"
    And User click on Search button
    And Close browser
    
    Examples:
    |email|password|Vendorname|Vendoremail|
    |admin@yourstore.com|admin|Vendor1|Vendor1@gmail.com|
    |admin@yourstore.com|admin|Vendor2|Vendor2@gmail.com|