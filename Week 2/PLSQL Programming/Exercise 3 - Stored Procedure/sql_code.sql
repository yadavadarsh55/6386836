--Scenario 1: 
create or replace procedure processmonthlyinterest is
   bal accounts.balance%type;
begin
   for acc in (
      select accountid,
             balance
        from accounts
   ) loop
      bal := acc.balance;
      update accounts
         set
         balance = bal * 1.01
       where accountid = acc.accountid;

      dbms_output.put_line('ACCOUNT ID: '
                           || acc.accountid
                           || ', OLD BALANCE: '
                           || bal
                           || ', NEW BALANCE: '
                           ||(bal * 1.01));
   end loop;
   commit;
end;
/

EXEC PROCESSMONTHLYINTEREST;

--Scenario 2:
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
   bonusPercentage IN NUMBER,
   deptName IN VARCHAR2  
) IS
   bonus employees.salary%TYPE;
   sal   employees.salary%TYPE;
BEGIN
   FOR emp IN (
      SELECT employeeid, salary
      FROM employees
      WHERE department = deptName  
   ) LOOP
      sal := emp.salary;
      bonus := sal * (100 + bonusPercentage) / 100;
 
      UPDATE employees
      SET salary = bonus
      WHERE employeeid = emp.employeeid;
 
      DBMS_OUTPUT.PUT_LINE('Employee ID: ' || emp.employeeid ||
                           ', Old salary: ' || sal ||
                           ', New salary: ' || bonus);
   END LOOP;
 
   COMMIT;
END;
/ 


EXEC UPDATEEMPLOYEEBONUS(5, 'HR');

--Scenario 3: 
CREATE OR REPLACE PROCEDURE transferfunds (
   sender   IN accounts.accountid%TYPE,
   receiver IN accounts.accountid%TYPE,
   amount   IN NUMBER
) IS
   sender_balance   accounts.balance%TYPE;
   receiver_balance accounts.balance%TYPE;

   insufficient_funds EXCEPTION;
   invalid_amount     EXCEPTION;

BEGIN

   SELECT balance INTO sender_balance
     FROM accounts
    WHERE accountid = sender;


   SELECT balance INTO receiver_balance
     FROM accounts
    WHERE accountid = receiver;

   IF amount <= 0 THEN
      RAISE invalid_amount;
   ELSIF sender_balance < amount THEN
      RAISE insufficient_funds;
   END IF;


   UPDATE accounts
      SET balance = balance - amount
    WHERE accountid = sender;

   UPDATE accounts
      SET balance = balance + amount
    WHERE accountid = receiver;

   COMMIT;
   DBMS_OUTPUT.PUT_LINE('Transfer successful.');
   
END;
/