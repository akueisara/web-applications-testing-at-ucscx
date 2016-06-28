Feature: Edit Customer 
  As a valid manager,
  I should be able to edit customer

Scenario: Edit Customer Info
  Given the user has logged in with user id "mngr41899" and password "Ujuveja"
  And the user is on the Edit Customer page
  When he submits "51330" as customer id
  Then ensure the customer name is "Kuei Jung Hu"
  And ensure the customer gender is "female"
  And ensure the customer DoB is "1988-03-09"