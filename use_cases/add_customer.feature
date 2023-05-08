Feature: Add Customer

Scenario: add customer successfully
Given that the administrator is loged in
And there is a customer with id 1,phone 0564, name "ahmad" and address "jenin"
Then the customer will be saved in the list
