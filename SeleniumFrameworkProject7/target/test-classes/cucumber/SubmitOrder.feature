
@tag
Feature: Purchase the order from Eccommerce website
  I want to use this template for my feature file
	
	Background: 
	Given I landed on Ecommerce page 


  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <Password>
    When I add the product <productName> from Cart
    And Checkout <productName> and submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name  										| Password 				| productName	|
      | kamalnath121998@gmail.com | Password1*			| zara coat 3 |
      | kamalnath199812@gmail.com	| Password23$			| ADIDAS ORIGINAL |