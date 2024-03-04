Feature: ClickCounterTest Functionality
  As a user of the click counter page
  I want to be able click me button 100 times
  So that i can verify whether the text matches with the iteration count

  Scenario: Correct Counter Display
  Scenario: Test the click me button 100 times
    Given I am on the click counter page with initial count as 0
    When I click on click me button 100 iterations
    Then  I can verify whether the text matches with the iteration count
