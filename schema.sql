-- PayFlow tables, sample data and example queries (PostgreSQL)

-- Tables
CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    owner VARCHAR(50),
    city VARCHAR(50)
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_id INT REFERENCES accounts(id),
    type VARCHAR(20),
    amount BIGINT
);

-- Sample data
INSERT INTO accounts (owner, city) VALUES
    ('Tyler', 'Tokyo'),
    ('Hana', 'Osaka'),
    ('Ken', 'Sapporo');

INSERT INTO transactions (account_id, type, amount) VALUES
    (1, 'deposit', 2000),
    (2, 'declined', 1500),
    (1, 'payment', 2000),
    (2, 'deposit', 2000),
    (1, 'declined', 100000);

-- Example queries

-- Every transaction with the account owner's name and city
SELECT accounts.owner, accounts.city, transactions.type, transactions.amount
FROM transactions
JOIN accounts
ON transactions.account_id = accounts.id;

-- All of Tyler's transactions
SELECT accounts.owner, transactions.type, transactions.amount
FROM transactions
JOIN accounts
ON transactions.account_id = accounts.id
WHERE accounts.owner = 'Tyler';

-- Number of transactions per account, including accounts with none
SELECT accounts.owner, COUNT(transactions.id) AS number_of_transactions
FROM accounts
LEFT JOIN transactions
ON accounts.id = transactions.account_id
GROUP BY accounts.owner;

-- Total deposits per city
SELECT accounts.city, SUM(transactions.amount) AS total_deposits
FROM accounts
JOIN transactions
ON accounts.id = transactions.account_id
WHERE transactions.type = 'deposit'
GROUP BY accounts.city;