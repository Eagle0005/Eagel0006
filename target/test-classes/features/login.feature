      # Each feature file starts with Feature keywork and name for feature file
      Feature: Login to Retail Website
      
      # Each Scenario starts with Scenario keyword and : then name of scenario
      # Scenario runs oce with provided data
      # we can write same step N times as long as they are teh same (case sensitive , and no extra space)
      # but in ste Defination we shulc have only one step associated with this step
      # The Backgroun Keyword will host any step or steps that are repeatd at the beginning of each scenario in feature file
      # each Background steps can be used only on one feature file
      
      Background:
      Given user is on retail website
      When user click on Myaccount
      
      @smokeTest @Regression  @endtoendTesting
      Scenario: Retail website login test
      
      # Givne is used for precondition
      # (Because of Backgroun commented) Given user is on retail website
      
      # When is used fo ran action
      # (Because of Backgroun commented) When user click on Myaccount
      
      #And is used for actions step following when keyword
      And user click on login opiton
      And user enter userName 'eagles@tekschool.us' and password 'eagles'
      
      # Then is used for expected result and writting assertions.
      Then user shoul be logged in to Myaccount dashboard
      
      # Scenario outline will run same scenario with multiple set of data 
      # and we use examples and keywords to store the data under it
      @endtoendTesting   @smokeTest
      Scenario Outline: Retail website login test with multiple accounts
     #(Because of Backgroun commented) Given user is on retail website
     #(Because of Backgroun commented) When user click on Myaccount
      And user click on login opiton
      And user enter userName '<userName>' and password '<password>'
      And user click on Login Button
      Then user shoul be logged in to Myaccount dashboard
      
     
      Examples: 
      
      |userName|password|
      |eagles@tekschool.us|eagles|
      |hawks@tekschool.us|hawks|
      |falcons@tekschool.us|falcons| 
      
      
Scenario: Retail website logout test

			Then user click on logOut Option