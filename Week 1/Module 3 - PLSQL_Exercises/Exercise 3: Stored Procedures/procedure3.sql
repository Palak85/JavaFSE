-- Scenario 3: Stored Procedure to transfer funds between accounts with balance checking

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- 1. Input Validation
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;
    
    -- 2. Fetch and check source balance (lock the row for update to prevent race conditions)
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance. Available balance: $' || v_balance || ', requested transfer: $' || p_amount);
    END IF;
    
    -- 3. Verify destination account exists
    DECLARE
        v_dummy NUMBER;
    BEGIN
        SELECT 1 INTO v_dummy FROM Accounts WHERE AccountID = p_to_account;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20003, 'Destination account ID ' || p_to_account || ' does not exist.');
    END;
    
    -- 4. Execute the transfer
    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_from_account;
    
    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_to_account;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Success: Transferred $' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20004, 'Source account ID ' || p_from_account || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/
