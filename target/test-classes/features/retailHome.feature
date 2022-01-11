Feature: Register new user
@RegisterTest
Scenario: Create new user account in Test Envirnoment
      Given user is on retail website
      When user click on Myaccount
      And user click on Register
      And user fill registration form with belwo information
      |firstName|lastName|email|telephone|password|passwordConfirm|subscribe|
      |alex|conor|alex@gamil.com|2021011122|WrognPass|WrongPass|yes|
      And user agree to privacy and policy
      And user clic on continue button
      Then user should see successful message 'Your Account Has Been Created!'
      