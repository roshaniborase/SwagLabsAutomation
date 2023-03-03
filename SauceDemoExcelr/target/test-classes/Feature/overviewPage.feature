Feature: Overview page testing

  Scenario: Verify cancel button
  	Given user done login And user is on overview page
  	When user click on cancel button
  	Then products page is displayed
  
  Scenario: Verify finish button
  	Given user done login And user is on overview page
  	When user click on finish button
  	Then checkout complete page is displayed
  
  Scenario: Verify back home button
    Given user done login And user is on overview page
    When user click on back home button
    Then products page is displayed
    