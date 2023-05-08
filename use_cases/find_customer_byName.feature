Feature: Find Customer By Name

Scenario: Find Customer By Name successfully
Given that the administrator is logged in
When search about the customer with name "ahmad"
Then display all information about customers found