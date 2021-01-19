@regression
Feature: Create Transaction Page

  Background:
    Given Open the Application with given URL and click Transaction Button
    And Verify the windows Title "QA TASK"

  @smoke
  Scenario Outline: Valid Data for Transaction
    Given Enter "<Amount>",  select "<Sender>" and select "<Receiver>"
    Then Click Submit Button
    When Verify to get Expected "<Message>"
    Examples:
      | Amount     | Sender            | Receiver          | Message                                       |
      | 1          | Nobert Nowak      | Fatih Gulen       | Transaction has been successfully created.    |
      | 45         | Fatih Gulen       | Jerald Greenawalt | Transaction has been successfully created.    |
      | 45         | Jerald Greenawalt | Arnoldo Meade     | Transaction has been successfully created.    |
      | 8000000000 | Arnoldo Meade     | Fatih Gulen       | Source balance should be greater than amount. |

#  Scenario Outline: Invalid data in Amount
#    Given Enter "<amount>",  select "<Sender>" and select "<Receiver>"
#    Then Click Submit Button
#    When Verify to get Expected "<Message>"
#    Examples:
#      | amount | Sender       | Receiver    | Message       |
#      | A      | Nobert Nowak | Fatih Gulen | Invalid Data. |



