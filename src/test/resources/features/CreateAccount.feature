@regression
Feature:Create Account Page

  Background:
    Given Open the application with given URL
    And Verify the windows title "QA TASK"

  @smoke
  Scenario Outline: Valid Data for Owner(AccountHolder)
    Given Enter "<accountHolder>", "<balance>" and select "<currency>"
    Then Click submit button
    When Verify to get expected "<Message>"
    Examples:
      | accountHolder     | balance | currency | Message                                |
      | Nobert Nowak      | 50000   | EURO     | Account has been successfully created. |
      | Fatih Gulen       | 80000   | DOLLAR   | Account has been successfully created. |
      | Jerald Greenawalt | 4568    | EURO     | Account has been successfully created. |
      | Arnoldo Meade     | 8595    | DOLLAR   | Account has been successfully created. |

  Scenario Outline: Invalid data for Owner (AccountHolder)
    When Enter "<accountHolder>", "<balance>" and select "<currency>"
    Then Click submit button
    When Verify to get expected "<Message>"

    Examples:
      | accountHolder | balance | currency | Message                     |
#      | 46456 5643    | 1       | EURO     | Please use valid character. |
      | ?!!. ^:/@%    |         | DOLLAR   | Please fill in balance.     |
      |               |         | DOLLAR   | Please fill in name.        |


#  Scenario Outline: Create an Account MAX data
#    When Enter "<accountHolder>", "<balance>" and select "<currency>"
#    Then Click submit button
#    When Verify to get expected "<Message>"
#
#    Examples:
#      | accountHolder                                    | balance | currency | Message                          |
#      | Hubert Blaine Wolfeschlegelsteinhausenbergerdorf | 47      | EURO     | Please use MAX ???? characters . |


#  Scenario Outline: Create an Account MIN data
#    When Enter "<AccountHolder>", "<Balance>" and select "<Currency>"
#    Then Click submit button
#    When Verify to get expected "<Message>"
#
#    Examples:
#      | AccountHolder | Balance | Currency | Message                          |
#      | H F           | 1       | EURO     | Please use MIN ???? characters . |


  Scenario Outline: Create an Account Without Currency (Dollar/Euro)
    Given Enter "<accountHolder>", "<balance>" and select no currency
    Then Click submit button
    When Verify to get expected "<Message>"

    Examples:
      | accountHolder | balance | Message                  |
      | Nakati Enne   | 59      | Please fill in currency. |


#  Scenario Outline: Verify "$" (Dollar) or "€" (Euro) sign is allowed
#    Given Enter "<Name>", "<Balance>" and select "DOLLAR"
#    Then Click submit button
#    When Verify to get expected "<Message>"
#
#    Examples:
#      | Name             | Balance | Message                                |
#      | Carletta Rashid  | $500    | Account has been successfully created. |
#      | Darlene Blubaugh | 500$    | Account has been successfully created. |
#      | Marlys Brassard  | €500    | Account has been successfully created. |
#      | Flora Stumpf     | 500€    | Account has been successfully created. |


  Scenario Outline: Verify any character is allowed in Balance
    Given Enter "Carlos Mark", "<Balance>" and select "DOLLAR"
    Then Click submit button
    When Verify to get expected "<Message>"

    Examples:
      | Balance | Message                                |
      | E250    | Please fill in balance.                |
      | 100E    | Please fill in balance.                |
      | --100   | Please fill in balance.                |
      | -100    | Account has been successfully created. |


  Scenario Outline: Verify any "O" (Zero) is allowed in Balance in the beginning
    Given Enter "Carlos Mark", "<Balance>" and select "DOLLAR"
    Then Click submit button
    When Verify to get expected "<Message>"

    Examples:
      | Balance | Message                                |
      | 000002  | Account has been successfully created. |
      | 001     | Account has been successfully created. |


  Scenario Outline: Verify any "." (dot) is allowed in Balance
    Given Enter "<Name>", "<Balance>" and select "DOLLAR"
    Then Click submit button
    When Verify to get expected "<Message>"

    Examples:
      | Name            | Balance | Message                                |
      | Marlys Brassard | 0.006   | Account has been successfully created. |
      | Flora Stumpf    | 000.5   | Account has been successfully created. |