Feature: search the argos product
  Scenario: search the product
    Given open the browser and search the searchbar
    When search the product Nike
    And hit the search button
    Then show the respective product item

