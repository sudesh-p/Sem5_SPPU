create or replace trigger Library_Audittable1
after
update or delete on Library_table1


declare
oper varchar(20);

begin

if updating then 
oper:='update';
insert into Library_Audittable1 values(sysdate,oper); 

elsif deleting then
oper:='delete';
insert into Library_Audittable1 values(sysdate,oper); 

end if;

end;
/
