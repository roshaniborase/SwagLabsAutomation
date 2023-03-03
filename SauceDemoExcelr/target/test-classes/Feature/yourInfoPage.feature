Feature: Your information page testing

  Scenario Outline: Continue process with valid values
    Given user done login And user is on your information page
    When user enters <firstName> and <lastName> and <zipcode>
    And click on continue button
    Then next page is displayed

    Examples: 
      | firstName | lastName | zipcode |
      | roshani   | borase   |  123456 |

  Scenario Outline: FirstName, LastName contains only alphabets and Zipcode contains only numbers
    Given user done login And user is on your information page
    When user enters <firstName> and <lastName> and <zipcode> as alphanumeric values
    And click on continue button
    Then message is display "Please enter valid details"

    Examples: 
      | firstName | lastName | zipcode |
      | rosh123   | bor757   | fgsd123 |

  Scenario: Values not pass to the mandatory feild
    Given user done login And user is on your information page
    And user did not enter values
    And click on continue button
    Then display message "feild is reqired"
