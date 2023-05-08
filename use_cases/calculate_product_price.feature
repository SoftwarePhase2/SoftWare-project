
Feature: Calculate product price

  Scenario Outline: calculate product price 
  	Given that the administrator is logged in
    And the height of the product <height>
    And the width of the product <width>
    And the catogery of the product <catogery>
    Then the result will be <result>

    Examples: 
      | height  | width | catogery  | result | 
      |   5     |   5   | "carpets" |   50   |
      |   6     |   7   | "covers"  |   42   |
