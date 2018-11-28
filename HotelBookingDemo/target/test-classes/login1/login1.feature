Feature: Hotel Login Functionality
  Scenario: Username Password not entered
    Given User is on login1 page
    When username password is blank
    Then Display Error Message: 'Please enter Username'

    Scenario: password is blank
    Given User is on login1 page
    When password is blank
    Then Display Error Message: 'Please Enter Password'
    
    Scenario: Invalid userName and password
    Given User is on login1 page
    When incorrect username or password entered
    Then Display Error Messsage: 'Please Enter Valid username or password' 
    
    Scenario: Valid Username and password is entered
    Given User is on login1 page
    When correct username or password entered
    Then Redirect the user to hotelBooking Page