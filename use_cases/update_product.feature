Feature: Update Product

Scenario: Update Product Name Successfully
Given that the administrator is logged in
And there is a product with id 1
When the admin want to change the name of the product to "pro4"
Then the product's name should be "pro4"

Scenario: Update Product Status Successfully
Given that the administrator is logged in
And there is a product with id 1
When the admin want to change the status of the product to "in treatment"
Then the product's Status should be "in treatment"
