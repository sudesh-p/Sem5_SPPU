create or replace trigger Library_Audittable
after
update or delete on Library_table
for each row

declare
oper varchar(20);

begin

if updating then 
oper:='update';

elsif deleting then
oper:='delete';


end if;

insert into Library_Audittable values(:old.Rolno,:old.Name,oper);

end;
/
