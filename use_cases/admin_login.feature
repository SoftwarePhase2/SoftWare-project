Feature: admin login

Scenario: Successful log in
Given that the administrator is not logged in
And the username is "ahmad"
And the password is "true Pass"
Then the administrator login succeeds

Scenario: Administrator entered a wrong username
Given that the administrator is not logged in
And the username is "not exist"
And the password is "truePass"
Then the administrator will not login
And show the reason why he can't logged in

Scenario: Administrator entered a wrong password
Given that the administrator is not logged in
And the username is "ahmad"
And the password is "not true"
Then the administrator will not login
And show the reason why he can't logged in