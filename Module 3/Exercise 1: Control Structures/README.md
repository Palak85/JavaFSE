# PL/SQL Control Structures (Module 3 Exercise 1)

This project contains the database setup and PL/SQL blocks for three warehouse banking scenarios involving control structures (loops, cursors, conditional logic).

## Directory Structure
- **schema.sql**: DDL script to create tables (`Customers`, `Loans`) and insert mock data.
- **scenario1.sql**: PL/SQL block applying interest rate discounts.
- **scenario2.sql**: PL/SQL block promoting customers to VIP.
- **scenario3.sql**: PL/SQL block printing due loan reminders.
- **README.md**: Documentation of setup, implementations, and expected execution outputs.

---

## 1. Schema Setup (`schema.sql`)
The schema consists of two tables:
- **Customers**: Stores customer details, DOB (for age validation), balances, and VIP status.
- **Loans**: Stores loan amounts, interest rates, and end dates (due dates).

---

## 2. Scenario 1: Loan Interest Rate Discount (`scenario1.sql`)
- **Objective**: Loops through all customers, checks their age, and if they are above 60 years old, applies a 1% discount to their current loan interest rates.
- **PL/SQL Implementation**:
  - Employs a `CURSOR` joining `Customers` and `Loans`.
  - Calculates age using `TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12)`.
  - Performs an `UPDATE` operation with conditional `IF` logic.

### Expected Console Output:
```
--- Processing Loan Discounts for Customers > 60 Years Old ---
Discount Applied: Robert Smith (Age: 68) | Loan ID: 101 | Old Rate: 7.5% | New Rate: 6.5%
Discount Applied: Alice Johnson (Age: 70) | Loan ID: 103 | Old Rate: 8.5% | New Rate: 7.5%
--- Discount Processing Completed ---
```

---

## 3. Scenario 2: VIP Status Promotion (`scenario2.sql`)
- **Objective**: Iterates through all customers and sets the `IsVIP` flag to `'TRUE'` for those with a balance over $10,000.
- **PL/SQL Implementation**:
  - Iterates through the `Customers` table.
  - Updates `IsVIP = 'TRUE'` when `Balance > 10000.00`.

### Expected Console Output:
```
--- Processing VIP Promotions ---
VIP Promotion: Jane Doe (ID: 2) | Balance: $12500 | Status: Promoted to VIP
VIP Promotion: Alice Johnson (ID: 3) | Balance: $15000 | Status: Promoted to VIP
--- VIP Promotions Completed ---
```

---

## 4. Scenario 3: Loan Due Reminders (`scenario3.sql`)
- **Objective**: Fetches all loans due in the next 30 days and prints a reminder message for each customer.
- **PL/SQL Implementation**:
  - Selects loans where `EndDate BETWEEN SYSDATE AND SYSDATE + 30`.
  - Prints custom alert messages to the console.

### Expected Console Output:
```
--- Processing Loan Due Reminders (Next 30 Days) ---
REMINDER: Dear Alice Johnson (CustomerID: 3), your Loan (ID: 103) is due on 2026-07-15. Please ensure timely repayment.
REMINDER: Dear Charlie Green (CustomerID: 5), your Loan (ID: 105) is due on 2026-07-10. Please ensure timely repayment.
--- Reminder Processing Completed ---
```

---

## How to Execute in SQL*Plus or SQL Developer
1. Execute `schema.sql` to initialize the database tables and insert sample records:
   ```sql
   @schema.sql
   ```
2. Run Scenario 1 to apply loan discounts:
   ```sql
   @scenario1.sql
   ```
3. Run Scenario 2 to process VIP upgrades:
   ```sql
   @scenario2.sql
   ```
4. Run Scenario 3 to print loan reminders:
   ```sql
   @scenario3.sql
   ```
