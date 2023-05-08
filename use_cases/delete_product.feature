Feature: Delete Product

Scenario: Delete a product successfully
Given that the administrator is logged in
And there is a product with id 1
Then the product will be deleted from the product list

Scenario: Delete a non exist product
Given that the administrator is logged in
And there is a product with id -2
Then the message that the product is not exist will be print