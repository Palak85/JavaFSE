-- Schema Setup for Module 3 Exercise 1: Control Structures

-- Drop tables if they already exist (in reverse order of foreign keys)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

-- Create Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50) NOT NULL,
    DOB DATE NOT NULL,
    Balance NUMBER(15, 2) NOT NULL,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

-- Create Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER(15, 2) NOT NULL,
    InterestRate NUMBER(5, 2) NOT NULL, -- e.g. 7.50 represents 7.5%
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL, -- Loan Due Date
    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Insert Sample Data

-- Customer 1: Above 60, has loan, balance < 10000 (Scenario 1 target)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (1, 'Robert Smith', TO_DATE('1958-04-15', 'YYYY-MM-DD'), 4500.00, 'FALSE');

-- Customer 2: Below 60, has loan, balance > 10000 (Scenario 2 target)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (2, 'Jane Doe', TO_DATE('1985-08-20', 'YYYY-MM-DD'), 12500.00, 'FALSE');

-- Customer 3: Above 60, has loan due in 15 days, balance > 10000 (Scenario 1, 2, 3 target)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (3, 'Alice Johnson', TO_DATE('1955-11-10', 'YYYY-MM-DD'), 15000.00, 'FALSE');

-- Customer 4: Below 60, has loan due in 45 days, balance < 10000 (No target)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (4, 'Bob Brown', TO_DATE('1992-03-05', 'YYYY-MM-DD'), 2500.00, 'FALSE');

-- Customer 5: Below 60, has loan due in 10 days, balance < 10000 (Scenario 3 target)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (5, 'Charlie Green', TO_DATE('1989-12-12', 'YYYY-MM-DD'), 1500.00, 'FALSE');


-- Insert Loans for each customer
-- Loan 1: Robert Smith, interest rate 7.5%, due in 6 months
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (101, 1, 50000.00, 7.50, SYSDATE - 180, SYSDATE + 180);

-- Loan 2: Jane Doe, interest rate 6.0%, due in 1 year
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (102, 2, 80000.00, 6.00, SYSDATE - 90, SYSDATE + 270);

-- Loan 3: Alice Johnson, interest rate 8.5%, due in 15 days (Due within next 30 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (103, 3, 30000.00, 8.50, SYSDATE - 350, SYSDATE + 15);

-- Loan 4: Bob Brown, interest rate 5.5%, due in 45 days (Not due in next 30 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (104, 4, 15000.00, 5.50, SYSDATE - 320, SYSDATE + 45);

-- Loan 5: Charlie Green, interest rate 9.0%, due in 10 days (Due within next 30 days)
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (105, 5, 10000.00, 9.00, SYSDATE - 350, SYSDATE + 10);

COMMIT;
/
