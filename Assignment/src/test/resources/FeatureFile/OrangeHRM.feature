Feature: OrangeHRM Employee Management

   Scenario: Add employees and verify them in the employee list
   
    Given User is on OrangeHRM login page
    When User logs in with valid credentials
    And User navigates to PIM module
    And User adds new employees
      | FirstName | LastName | EmpID    |
      | Ram       | B.       | 022112   |
      | Sita      | B.       | 412213   |
      | Laxman    | B.       | 512314   |
    Then User verifies added employees in the employee list
    And User logs out from the application

    