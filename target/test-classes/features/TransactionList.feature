@regression
Feature: TransactionList Page
  Background:
    Given Open Application with given URL and click TransactionList Button
    And Verify The Windows Title "QA TASK"

  @smoke
  Scenario Outline: Verify Transaction after Transaction in TransactionList Page
    Given Go To CreateTransaction Page For New Transaction
    When Enter "<Amount>", Select "<Sender>", Select "<Receiver>", Submit To Send Money
    Then Verify transaction exist in TransactionList page with "<Sender>", "<Receiver>","<Amount>"

    Examples:
      | Amount | Sender            | Receiver     |
      | 15     | Jerald Greenawalt | Nobert Nowak |
      | 10     | Marlys Brassard   | Flora Stumpf |
