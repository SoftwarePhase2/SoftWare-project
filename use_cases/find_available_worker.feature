
Feature: Find available featuer

Scenario: Find the available worker successfully
Given that the administrator is logged in
When search about the customer with name "ahmad"
Then display all information about customers found
