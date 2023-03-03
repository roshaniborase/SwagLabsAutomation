Feature: Your cart page testing

  Scenario: Verify checkout
    Given user done login And user is on your cart page
    When user click on checkout
    Then your information page is displayed

  #Scenario: Verify continue shopping
    #Given user done login And user is on your cart page
    #When user click on continue shopping
    #Then products page is displayed

  Scenario: product details are displayed
    Given user done login And user is on your cart page
    When user click on products
    Then product details page is display

  Scenario: Remove product from cart
    Given user done login And user is on your cart page
    When user click on remove
    Then product remove from cart
    