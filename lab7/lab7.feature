Feature: Divider
  Input Divisor and Dividend to get the result of division

  Scenario Outline: positive double calculate
    Given dividend is <dividend>
    Given divisor is <divisor>
    When I ask what's the answer for divider
    Then I should get the answer <answer> for divider

    Examples:
      | dividend  | divisor | answer  |
      | 6.0         | 2.0       | 3.0       |
      | 200.0       | 200.0     | 1.0       |

  Scenario Outline: Throw exception when divide by zero
    Given dividend is <dividend>
    Given divisor is <divisor>
    When I ask what's the answer for divider
    Then I should get the exception for divider

    Examples:
      | dividend  | divisor |
      | 200.0       | 0.0       |