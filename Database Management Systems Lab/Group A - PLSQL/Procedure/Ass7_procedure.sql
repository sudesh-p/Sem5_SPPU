CREATE OR REPLACE PROCEDURE proc_Grade(roll NUMBER,name VARCHAR,totmarks NUMBER) IS
BEGIN
    IF(totmarks >= 990 and totmarks <= 1500) THEN
        INSERT INTO Result1 VALUES(roll,name,'DISTINCTION');
        INSERT INTO Stud_marks VALUES(name,totmarks);
    ELSIF(totmarks >= 900 and totmarks <= 989) THEN
        INSERT INTO Result1 VALUES(roll,name,'FIRST CLASS');
        INSERT INTO Stud_marks VALUES(name,totmarks);
    ELSIF(totmarks >= 825 and totmarks <=899) THEN
        INSERT INTO Result1 VALUES(roll,name,'HIGHER SECOND CLASS');
        INSERT INTO Stud_marks VALUES(name,totmarks);
    END IF;
END proc_Grade;
/
