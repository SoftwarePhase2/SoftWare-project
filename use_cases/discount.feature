
Feature: Discount for customer

  Scenario: discount for customer 
  	Given that the administrator is logged in
  	And there is a customer with id 1
  	And product with hieght 10, width 20 , catogery "covers"
    And the total money for this customer is above 400
    Then the customer will have a discount by 0.25 for the total price

