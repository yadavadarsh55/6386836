--Scenario 1: 
DECLARE
  v_updated_count NUMBER := 0;
BEGIN
  FOR res IN (
    SELECT c.name, c.customerID, l.loanId, l.interestRate
    FROM loans l
    JOIN customers c ON l.customerID = c.customerID
    WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.dob)/12) > 60
  ) LOOP
    UPDATE loans
    SET interestRate = res.interestRate - 1
    WHERE loanId = res.loanID;
    
    v_updated_count := v_updated_count + 1;
    
    DBMS_OUTPUT.PUT_LINE('Updated loan ' || res.loanId || 
                        ' for customer ' || res.name || 
                        ' (ID: ' || res.customerID || 
                        '). New rate: ' || (res.interestRate - 1) || '%');
  END LOOP;
  
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Total loans updated: ' || v_updated_count);
END;
/

--Scenario 2: 
ALTER TABLE CUSTOMERS ADD ISVIP VARCHAR2(5);

DECLARE 
    vip_count NUMBER := 0;
BEGIN
    FOR account IN (
        SELECT customerid, accountid, balance FROM ACCOUNTS
    ) LOOP 
        IF account.balance >= 10000 THEN
            UPDATE CUSTOMERS
            SET isvip = 'TRUE'
            WHERE customerid = account.customerid;
            vip_count := vip_count + 1;
        ELSE
            UPDATE CUSTOMERS
            SET isvip = 'FALSE'
            WHERE customerid = account.customerid;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Total ' || vip_count || ' VIPs found.');
END;
/

--Scenario 3
DECLARE
  loan_count NUMBER := 0;
BEGIN
  FOR res IN (
    SELECT c.name, c.customerID, l.loanID, l.enddate
    FROM loans l
    JOIN customers c ON l.customerID = c.customerID
    WHERE l.enddate BETWEEN SYSDATE AND SYSDATE + 30
    ORDER BY l.enddate
  ) LOOP  
    loan_count := loan_count + 1;
    DBMS_OUTPUT.PUT_LINE(res.name || ', your loan ' || res.loanID || 
                        ' is due on ' || TO_CHAR(res.enddate, 'DD-MON-YYYY'));
  END LOOP;
  
  IF loan_count = 0 THEN
    DBMS_OUTPUT.PUT_LINE('No loans are due in the next 30 days');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Total loans due in next 30 days: ' || loan_count);
  END IF;
END;
/