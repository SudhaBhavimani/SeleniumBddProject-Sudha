Feature: Login page

Background: Common steps 
      Given User launch chrome browser 
      When User open URL "http://admin-demo.nopcommerce.com/login"

@sanity
Scenario: Successful login with valid credentials
And User enter email as "admin@yourstore.com" and password as "admin"
And Click on login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on log out link
Then Page Title should be "Your store. Login"
And Close browser 

@regression
Scenario Outline: login feature with data driven approach
And User enter email as "<email>" and password as "<password>"
And Click on login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on log out link
Then Page Title should be "Your store. Login"
And Close browser 

Examples:
|email | password |
|admin@yourstore.com|admin|
|admin1@yourstore.com|admin11|