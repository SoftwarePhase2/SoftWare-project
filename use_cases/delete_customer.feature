Feature: Delete Customer

Scenario: Delete a customer successfully
Given that the administrator is logged in
And there is a customer with id 1
Then the customer will be deleted from the customer list

Scenario: Delete a non exist customer
Given that the administrator is logged in
And there is a customer with id -2
Then the message that the customer is not exist will be print