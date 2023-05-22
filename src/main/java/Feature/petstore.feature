@Petstore
Feature: Validate petstore 

  Scenario Outline: Login with valid credentials
    Given I open Sign in page
    When I enter username "<username>" and password "<password>"
    And I click on login button
    Then I navigate to welcome page

    Examples: 
      | username  | password |
      | j2ee 			|     j2ee | 
      #| weaver@123|123456789 |			
     
	
	Scenario: Validate submit order - 1
		Given I am on welcome page
		When I choose a particular type of pet 
		| Fish | FI-SW-01 | EST-1 |
		And I click on add to cart
		And I click on proceed to checkout 
		And I confirm the order
		Then I verify the order submission in MyOrder section
		
	Scenario: Validate submit order - 2
		Given I am on welcome page
		When I choose a particular type of pet 
		| Birds| AV-CB-01 | EST-18|
		And I click on add to cart
		And I click on proceed to checkout 
		And I confirm the order
		Then I verify the order submission in MyOrder section
	