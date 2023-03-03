Feature: login functionality test

  Scenario Outline: Check login with valid credentials
    Given browser is open
    When user enters valid <username> and <password>
    And clicks on login button
    Then user is navigated to the home page
    
   Examples:
   |username        |password     |
   |standard_user   |secret_sauce |
	 |performance_glitch_user |secret_sauce |
	 |problem_user    |secret_sauce |
	
    Scenario Outline: Check login with invalid credentials
    Given browser is open
    When user enters invalid <username> and <password>
    And clicks on login button
    Then user get a message "invalid credentials"
    
   Examples:
   |username |password  |
   |roshani1 |roshani123|
 