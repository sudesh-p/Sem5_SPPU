DECLARE
  Name1 Stud_marks.Name%type;
  roll1 Result1.RollNo%type;
  totmarks1 Stud_marks.TotalMarks%type;
BEGIN
  roll1:=&roll1;
  Name1:=&Name1;
  totmarks1:=&totmarks1;
  proc_Grade(roll1,Name1,totmarks1);
  END LOOP;
END;
/
