
@tag
Feature: Google Search
  

  @tag1
  Scenario Outline: Passing inputs to Google search
    Given user is on Google Page
    When user inputs data inside search text field <keyword>
    Then validate whether the results contains the <keyword>
    
   Examples:
   |keyword|keyword|
   |"Mobile"|"Mobile"|
   |"laptop"|"laptop"|
   |"TestNG"|"TestNG"|
   |"Selenium"|"Selenium"|
  
  