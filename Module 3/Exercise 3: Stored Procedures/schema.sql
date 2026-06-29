-- Schema Setup for Module 3 Exercise 3: Stored Procedures

-- Drop tables if they already exist
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

-- Create Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20) NOT NULL, -- 'Savings' or 'Checking'
    Balance NUMBER(15, 2) NOT NULL,
    LastUpdate DATE DEFAULT SYSDATE
);

-- Create Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(50) NOT NULL,
    Department VARCHAR2(30) NOT NULL,
    Salary NUMBER(15, 2) NOT NULL
);

-- Insert Sample Accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1001, 10, 'Savings', 5000.00, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1002, 10, 'Checking', 2000.00, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1003, 11, 'Savings', 12000.00, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (1004, 11, 'Checking', 1500.00, SYSDATE);


-- Insert Sample Employees
INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (201, 'Alice Johnson', 'IT', 75000.00);

INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (202, 'Bob Smith', 'IT', 65000.00);

INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (203, 'Charlie Brown', 'HR', 55000.00);

INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (204, 'Diana Green', 'Finance', 85000.00);

COMMIT;
/
