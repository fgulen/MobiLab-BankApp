@regression
Feature: AccountsList Page

  Background:
    Given Open Application with given URL and click Transaction Button
    And Verify the Windows Title "QA TASK"

  @smoke
  Scenario Outline: User should see the new account After new account creation
    Given Go To CreateAccountPage for new Account
    When Enter "<accountHolder>", "<balance>" And Select "<currency>"
    Then Go To AccountListPage To Verify New Account with "<accountHolder>", "<balance>", "<currency>" Data

    Examples:
      | accountHolder | balance | currency |
      | Cedric Bella  | 350000  | DOLLAR   |


  Scenario Outline: Compare Owner Balance before and after Transaction only $ to $ /€ to €
    Given "<Sender>" sends "<Money>" to "<Receiver>"
    Then Verify first balance and current balance difference gives the "<Money>"transaction amount
    Examples:
      | Sender            | Money | Receiver     |
      | Jerald Greenawalt | 10    | Nobert Nowak |
      | Fatih Gulen       | 17    | Cedric Bella |
