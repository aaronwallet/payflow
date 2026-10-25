# PayFlow

A small payment system in Java.
It creates the rules for how accounts receive deposits, make payments and transfer money, including a full transaction history.

## How to run

Open the project in any Java IDE and run `Bank.java`.
It runs a demo of every rule and prints a statement for each account.

## Rules

- Balances can never go negative, and payments and transfers larger than the balance are declined.
- Zero and negative amounts are rejected for payments, deposits and transfers.
- Every transaction is recorded with a running balance, including declined attempts, so the history can be verified later.
- Money is never created or lost through transfers.

## Next steps

- Store accounts and transactions in an SQL database.
- Let an app or website use PayFlow over the internet, using Spring Boot.
- Add automated tests.