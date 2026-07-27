# PL/SQL Stored Procedures (Module 3 Exercise 3)

This project contains database tables and three stored procedures for bank management operations (interest posting, employee bonuses, and safe transfer of funds).

## Directory Structure
- **schema.sql**: DDL and sample inserts to create the `Accounts` and `Employees` tables.
- **procedure1.sql**: Stored procedure `ProcessMonthlyInterest`.
- **procedure2.sql**: Stored procedure `UpdateEmployeeBonus`.
- **procedure3.sql**: Stored procedure `TransferFunds` with balance verification.
- **README.md**: Documentation of configurations and execution logs.

---

## 1. Schema Design (`schema.sql`)
Sets up:
- **Accounts**: Tracks AccountID, CustomerID, type (e.g. 'Savings'), and Balance.
- **Employees**: Tracks EmployeeID, Name, Department, and Salary.

---

## 2. Scenario 1: Savings Interest (`ProcessMonthlyInterest`)
- **Objective**: Applies a monthly interest rate of 1% to the balance of all savings accounts (`Balance = Balance * 1.01`).
- **PL/SQL Implementation**:
  - Updates only records matching `AccountType = 'Savings'`.

### Execution:
```sql
EXEC ProcessMonthlyInterest;
```
### Expected Console Output:
```
Monthly interest of 1% successfully applied to all savings accounts.
```

---

## 3. Scenario 2: Employee Performance Bonus (`UpdateEmployeeBonus`)
- **Objective**: Adds a bonus percentage to the salary of all employees in a given department.
- **PL/SQL Parameters**:
  - `p_department` (VARCHAR2)
  - `p_bonus_percentage` (NUMBER)
- **PL/SQL Implementation**:
  - Multiplies `Salary` by `(1 + bonus/100)` for the specified department.

### Execution:
```sql
EXEC UpdateEmployeeBonus('IT', 10);
```
### Expected Console Output:
```
Updated salary with 10% bonus for all employees in department: IT
```

---

## 4. Scenario 3: Fund Transfer (`TransferFunds`)
- **Objective**: Transfers a specified amount from a source account to a destination account, verifying that the source has sufficient balance.
- **PL/SQL Parameters**:
  - `p_from_account` (NUMBER)
  - `p_to_account` (NUMBER)
  - `p_amount` (NUMBER)
- **PL/SQL Implementation**:
  - Uses `FOR UPDATE` cursor locking to protect against concurrent updates.
  - Throws exceptions via `RAISE_APPLICATION_ERROR` if accounts are invalid, amount is negative, or balance is insufficient.

### Execution:
```sql
-- Valid Transfer
EXEC TransferFunds(1001, 1002, 500.00);

-- Invalid Transfer (Insufficient Balance)
EXEC TransferFunds(1001, 1002, 100000.00);
```
### Expected Console Output (Valid):
```
Success: Transferred $500 from Account 1001 to Account 1002
```
### Expected Console Output (Invalid):
```
Error at line 1:
ORA-20002: Insufficient balance. Available balance: $4500, requested transfer: $100000
```

---

## How to Execute in Oracle SQL*Plus
1. Create tables and mock records:
   ```sql
   @schema.sql
   ```
2. Compile Stored Procedures:
   ```sql
   @procedure1.sql
   @procedure2.sql
   @procedure3.sql
   ```
3. Run the procedures as documented above.
