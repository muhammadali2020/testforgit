Feature:

  Scenario: Add a product
    Given user in home page
    When he click computer kit
    And he click buy now
    And he click the basket link
    Then the product should add to the basket