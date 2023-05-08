Feature: Update Customer

Scenario: Update Customer Name Successfully
Given that the administrator is logged in
And there is a customer with id 2
When the admin want to change the name of the customer to "mohammad"
Then the customer's name should be "mohammad"

Scenario: Update Customer Address Successfully
Given that the administrator is logged in
And there is a customer with id 2
When the admin want to change the address of the customer to "nablus"
Then the customer's address should be "nablus"

Scenario: Update Customer phone Successfully
Given that the administrator is logged in
And there is a customer with id 2
When the admin want to change the phone of the customer to 456
Then the customer's phone should be 456

Scenario: Update a non existing customer
Given that the administrator is logged in
And there is a customer with id -2
Then the message that the customer is not exist will be print