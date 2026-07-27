-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old

SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to fetch customer records and their corresponding loans
    CURSOR c_customers IS
        SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
        
    v_age NUMBER;
    v_new_rate NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Processing Loan Discounts for Customers > 60 Years Old ---');
    
    FOR r_cust IN c_customers LOOP
        -- Calculate current age based on Date of Birth (DOB)
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r_cust.DOB) / 12);
        
        -- Apply discount if customer is above 60 years old
        IF v_age > 60 THEN
            v_new_rate := r_cust.InterestRate - 1.00;
            
            -- Update the loan interest rate in the database
            UPDATE Loans
            SET InterestRate = v_new_rate
            WHERE LoanID = r_cust.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Discount Applied: ' || r_cust.Name || 
                                 ' (Age: ' || v_age || ') | Loan ID: ' || r_cust.LoanID || 
                                 ' | Old Rate: ' || r_cust.InterestRate || '% | New Rate: ' || v_new_rate || '%');
        END IF;
    END LOOP;
    
    -- Commit the interest rate updates
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('--- Discount Processing Completed ---');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
