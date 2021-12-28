Feature: Check purchase
  Scenario: Assert purchase amount as expected
    Given the user opens "https://www.demoblaze.com/index.html"
    When "Sony vaio i5" and "Dell i7 8gb" from category "Laptops" are added to cart
      And "Dell i7 8gb" is deleted from cart
      And I fill web form and purchase with "Jesus", "Spain", "Zaragoza", "1234567", "Junio", "2023"
      And I capture purchase Id and Amount
    Then I Assert purchase amount equals "790 USD"


