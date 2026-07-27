-- Scenario 1: Stored Procedure to process monthly interest (1%) for all savings accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Update all savings accounts
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastUpdate = SYSDATE
    WHERE AccountType = 'Savings';
    
    -- Commit the updates
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% successfully applied to all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in ProcessMonthlyInterest: ' || SQLERRM);
END;
/
