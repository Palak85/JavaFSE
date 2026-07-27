-- Scenario 2: Promote customers to VIP status (IsVIP = 'TRUE') if balance is over $10,000

SET SERVEROUTPUT ON;

DECLARE
    -- Cursor to iterate through all customers
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance, IsVIP
        FROM Customers;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Processing VIP Promotions ---');
    
    FOR r_cust IN c_customers LOOP
        -- Check if balance is greater than $10,000
        IF r_cust.Balance > 10000.00 THEN
            -- Update VIP status flag
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_cust.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('VIP Promotion: ' || r_cust.Name || 
                                 ' (ID: ' || r_cust.CustomerID || ') | Balance: $' || r_cust.Balance || 
                                 ' | Status: Promoted to VIP');
        END IF;
    END LOOP;
    
    -- Commit the VIP status updates
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('--- VIP Promotions Completed ---');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
