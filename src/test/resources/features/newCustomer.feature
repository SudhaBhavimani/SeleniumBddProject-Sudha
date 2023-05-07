 
Feature: Add new customers feature testing

Background: Common steps 
      Given User launch chrome browser 
      When User open URL "http://admin-demo.nopcommerce.com/login"
      And User enter email as "admin@yourstore.com" and password as "admin"
      And Click on login
      Then User can view dashboard
  @sanity    
  Scenario: Add new customer     
      And Click on customer menu
      And Click on New 
      Then User can view and add new custmore page 
      And User enter customer info
      And Click on Save
      Then User can view conformation message "The new customer has added successfully."
      And Close browser
      
   @sanity
   Scenario: Search customer is added successfully
      And Click on customer menu
      Then Enter customer email
      And Cleck on search
      Then User should be abel to find user in search table 
      And Close browser
      
      
    
      
 