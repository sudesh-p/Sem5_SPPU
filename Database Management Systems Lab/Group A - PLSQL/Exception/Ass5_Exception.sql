DECLARE
	amt number;
	no_of_days number;
	no_of_rows number;
	Roll_no1 Borrower.Rollno%type;
	Bookname1 Borrower.Book_Name%type;
	neg_amount EXCEPTION;
	invalid_prn EXCEPTION;
	invalid_book_name EXCEPTION;
	doi1 date;
BEGIN
	Roll_no1:=&Roll_no1;
	SELECT count(*) into no_of_rows FROM Borrower WHERE Rollno=Roll_no1;
	IF(no_of_rows =  0) THEN
		RAISE invalid_prn;
	END IF;

	Bookname1:=&Bookname1;
	SELECT count(*) INTO no_of_rows FROM Borrower WHERE Book_Name=Bookname1;

	IF(no_of_rows =  0) THEN
		RAISE invalid_book_name;
	END IF;

	SELECT doi into doi1 from Borrower where Rollno=Roll_no1;
	no_of_days:=trunc(sysdate)-doi1;

	
	dbms_output.put_line('DAYS ' || no_of_days);
	IF(no_of_days > 15 and no_of_days < 30) THEN
		amt:=no_of_days *5;
		dbms_output.put_line('Fine '||amt); 
	ELSIF (no_of_days > 30) THEN
		amt:=no_of_days *50;
		dbms_output.put_line('Fine '||amt); 
	END IF;
	
	IF(amt =  0) THEN
		dbms_output.put_line('No fine. Book returned before due date');
	ELSE
		INSERT INTO Fine VALUES (Roll_no1 ,sysdate ,amt);
	END IF;

	UPDATE Borrower set Status='R' where Rollno=Roll_no1;
EXCEPTION
	WHEN neg_amount THEN
		dbms_output.put_line('Invalid Book Amount!');
	WHEN invalid_prn THEN
		dbms_output.put_line('Entered Roll No does not exist.');
	WHEN invalid_book_name THEN
		dbms_output.put_line('Entered Book Name does not exsist.');
END;
/
