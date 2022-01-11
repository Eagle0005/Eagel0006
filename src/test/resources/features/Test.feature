     
      Feature: Test feature for lab
      
     # for below scenarios we don't need the Backgroun becasue each one of them has diffrent test cases and diffrent websites--
      @test
      Scenario: Test case
      
     
      Given user is on retail website
      When user searche for 'iphone'
      Then iphone should be displayed
      
     
    Scenario: Testcase number 2
    Given user is on amazon
    When user click on myaccount
    Then user should see account information
    
    
    Scenario: Testcase number 3
    Given user is on facebook
    When user login
    Then user should be logged in
     

      
