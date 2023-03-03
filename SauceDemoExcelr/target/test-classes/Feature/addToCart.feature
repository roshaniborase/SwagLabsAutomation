Feature: Verify Add to Cart

  Background: 
    Given browser is open And user done login
    When user clicks on add to cart

  Scenario: Add products to the cart
    Then products add to the cart

  Scenario: Remove products from cart
    And user clicks on remove
    Then products remove from cart

  Scenario: Checking count of cart when prducts are added
    Then count of cart incresed
    
  Scenario: Checking count of cart when prducts are removed  
    When user clicks on remove
    Then count of cart decreased
    
  Scenario: Checking add to cart button
    Then user is on your cart page
