-- Scenario 2: Stored Procedure to add a performance bonus percentage to employees of a department

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Input Validation
    IF p_bonus_percentage < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage cannot be negative.');
        RETURN;
    END IF;
    
    -- Update employee salaries for matching department
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE Department = p_department;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Updated salary with ' || p_bonus_percentage || '% bonus for all employees in department: ' || p_department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
END;
/
