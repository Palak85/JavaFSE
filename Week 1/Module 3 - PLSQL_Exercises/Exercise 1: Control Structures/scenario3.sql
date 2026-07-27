-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days

SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch loans due in the next 30 days
    CURSOR c_due_loans IS
        SELECT l.LoanID, l.EndDate, c.Name, c.CustomerID
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_found BOOLEAN := FALSE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Processing Loan Due Reminders (Next 30 Days) ---');
    
    FOR r_loan IN c_due_loans LOOP
        v_found := TRUE;
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || r_loan.Name || ' (CustomerID: ' || r_loan.CustomerID || '), ' ||
                             'your Loan (ID: ' || r_loan.LoanID || ') is due on ' || 
                             TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD') || '. Please ensure timely repayment.');
    END LOOP;
    
    IF NOT v_found THEN
        DBMS_OUTPUT.PUT_LINE('No loans are due within the next 30 days.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('--- Reminder Processing Completed ---');
END;
/
