Feature: Add Product

Scenario: add Product successfully
Given that the administrator is logged in
And there is a product with id 0, name "product",category "cate", width 10, height 20 , description "des" and status "in treatment"
And the customer id is 2
And there is an available worker with id 
Then the product will be saved in the product list with in treatment state
And the worker will be not available


Scenario: add Product and no available worker
Given that the administrator is logged in
And there is a product with id 0, name "product",category "cate", width 10, height 20 , description "des" and status "in treatment"
And the customer id is 2
And there is not an available worker 
Then the product will be saved in the product list with waiting state


Scenario: add Product and no customer id
Given that the administrator is logged in
And there is a product with id 0, name "product",category "cate", width 10, height 20 , description "des" and status "in treatment"
And the customer id is -1
And there is not an available worker 
Then the product will not be saves and error message will appear