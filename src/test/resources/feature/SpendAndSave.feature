Feature: Spend & Save verification

    Scenario: Spend & Save link verification
    Given user is on Spend & Save link
    Then Verify card "products name"
|Aspiration|
|Aspiration Plus|


  Scenario: Input field for an email address
    Given user is on Spend & Save link
    When click Get Aspiration
    Then input field for an email address

  Scenario: Monthly and yearly plans
    Given user is on Spend & Save link
    When click Get Aspiration Plus
    Then monthly and yearly plans appears
    And verify that yearly radio option is "$71.88" paid once yearly
		And verify that monthly radio option is "$7.99" paid monthly
 