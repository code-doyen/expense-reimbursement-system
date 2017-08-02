--drop user
--drop user David_Vollmar_project1;
create user David_Vollmar_project1 identified by p4ssw0rd;
grant dba to David_Vollmar_project1 with admin option;

--drop curernt sequences
 drop sequence staff_seq;
 drop sequence reimbursement_seq;
 drop sequence reimbursement_type_seq;
 drop sequence reimbursement_status_seq;

--drop current tables
 drop table reimbursement;
 drop table reimbursement_status;
 drop table reimbursement_type;
 drop table staff;
 drop table staff_rank;

create table reimbursement_status(
    reimbursement_status_id number not null,
    reimbursement_status_desc varchar2(50),
    constraint reimbursement_status_id_pk primary key(reimbursement_status_id)
);

create table reimbursement_type(
    reimbursement_type_id number not null,
    reimbursement_type_description varchar2(100),
    constraint reimbursement_type_id_pk primary key(reimbursement_type_id)
);

create table staff_rank(
    rank_id number not null, --pk
    rank_description varchar2(50) not null,
    constraint rank_id_pk primary key(rank_id)
);
create table staff(
    staff_id number,
    staff_username varchar2(50) unique not null,
    staff_password varchar2(50) not null,
    staff_rank number not null,  --fk ??number
    staff_first_name varchar2(50) not null,
    staff_last_name varchar2(50) not null,
    staff_phone varchar2(50), --can be blank
    staff_email varchar2(50) not null,
    constraint staff_id_pk primary key(staff_id),
    constraint staff_rank_fk foreign key (staff_rank) references staff_rank (rank_id)
);


create table reimbursement(
    reimbursement_id number not null,--pk
    reimbursement_staff_id number not null,
    reimbursement_amount number not null,
    reimbursement_pending number not null, --fk?number
    reimbursement_description varchar2(100) not null,
    reimbursement_date_submitted date not null,
    reimbursement_date_approved date,  --approval date can be blank 
    reimbursement_approve_by number, --fk 
    reimbursement_image blob, --image can be blank
    reimbursement_type number not null, --fk
    constraint reimbursement_id_pk primary key(reimbursement_id),
    constraint reimbursement_id_type_fk foreign key (reimbursement_type) references reimbursement_type (reimbursement_type_id) on delete cascade,
    constraint reimbursement_pending_fk foreign key (reimbursement_pending) references reimbursement_status (reimbursement_status_id) on delete cascade,
    constraint reimbursement_staff_id_fk foreign key (reimbursement_staff_id) references staff (staff_id),
    constraint reimbursement_diffstaff_fk foreign key (reimbursement_approve_by) references staff (staff_id)
);

---hash password for a new staff member
create sequence staff_seq
  start with 1
  increment by 1;
  
create or replace function get_staff_hash(username varchar2, password varchar2) return varchar2
is
extra varchar2(10) := 'salt';
begin
  return to_char(dbms_obfuscation_toolkit.md5(
  input => utl_i18n.string_to_raw(data => username || password || extra)));
end;
/

create or replace trigger staff_b_insert
before insert
on staff
for each row
begin
  /* increase the sequence */
  if :new.staff_id is null then
    select staff_seq.nextval into :new.staff_id from dual;
  end if;
  
  /* save hash instead of password */
  select get_staff_hash(:new.staff_username,:new.staff_password) into :new.staff_password from dual;
end;
/

create or replace procedure insert_staff(
staff_username varchar2, password varchar2, staff_rank number, staff_first_name varchar2, staff_last_name varchar2, staff_phone varchar2, staff_email varchar2, staff_position varchar2)
is
used number;
begin
  select count(*) into used from staff_rank where rank_id = staff_rank;
  --check if staff rank currently exists
  if used = 0 then
    insert into staff_rank values(staff_rank, staff_position);
  end if;
                            
  insert into staff values(null, staff_username, password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email);
  --insert into staff values(null, firstname, lastname, username, password);
  commit;
end;
/

create or replace trigger staff_b_update
before update
on staff
for each row
begin
  /* save hash instead of password */
  select get_staff_hash(:new.staff_username,:new.staff_password) into :new.staff_password from dual;
end;
/

create or replace procedure update_staff(username varchar2, password varchar2, first_name varchar2, last_name varchar2, phone varchar2, email varchar2)
is
begin                  
  update staff set staff_password = password, staff_first_name = first_name, 
        staff_last_name = last_name, staff_phone = phone, staff_email = email where staff_username = username;
  commit;
end;
/


select * from staff;


update staff set staff_password = '1234', staff_first_name = 'Wow', 
        staff_last_name = 'Cow', staff_phone = 'Cow', staff_email = 'Cow' where staff_username = 'david';

create sequence reimbursement_seq
  start with 1
  increment by 1;
create sequence reimbursement_type_seq
  start with 1
  increment by 1;
create sequence reimbursement_status_seq
  start with 1
  increment by 1;

create or replace trigger reimbursement_type_b_insert
before insert
on reimbursement_type
for each row
begin
  /* increase the sequence */
  if :new.reimbursement_type_id is null then
    select reimbursement_type_seq.nextval into :new.reimbursement_type_id from dual;
  end if; 
end;
/

create or replace trigger reimbursement_status_b_insert
before insert
on reimbursement_status
for each row
begin
  /* increase the sequence */
  if :new.reimbursement_status_id is null then
    select reimbursement_status_seq.nextval into :new.reimbursement_status_id from dual;
  end if; 
end;
/

create or replace trigger reimbursement_b_insert
before insert
on reimbursement
for each row
begin
  /* increase the sequence */
  if :new.reimbursement_id is null then
    select reimbursement_seq.nextval into :new.reimbursement_id from dual;
  end if; 
end;
/

create or replace procedure insert_reimbursement(
reimbursement_staff_id number, reimbursement_amount number, reimbursement_pending number, 
reimbursement_description varchar2, reimbursement_date_submitted date, reimbursement_date_approved date,
reimbursement_approve_by number, reimbursement_image blob, reimbursement_type number,
reimbursement_type_desc varchar2, reimbursement_status_desc varchar2 )
as
begin
                                 --typeid, description
  insert into reimbursement_type values(null, reimbursement_type_desc); 
                                    --statusid, status desc
  insert into reimbursement_status values(null, reimbursement_status_desc);

  insert into reimbursement values(null, reimbursement_staff_id, reimbursement_amount, reimbursement_pending, 
  reimbursement_description, reimbursement_date_submitted, reimbursement_date_approved,
  reimbursement_approve_by, reimbursement_image, reimbursement_type);
  commit;
end;
/




commit;
exit;

--insertion order
--staff_username varchar2, password varchar2, staff_rank number, staff_first_name varchar2, staff_last_name varchar2, staff_phone varchar2, staff_email varchar2, staff_position varchar2)
exec insert_staff('david', 'vollmar', 1, 'david', 'vollmar', null, 'vollmad@bgsu.edu', 'Pro');
exec insert_staff('username', 'password', 2, 'elena', 'vollmar', null, 'elena@bgsu.edu', 'Manager');
--reimbursement_staff_id number, reimbursement_amount number, reimbursement_pending number, 
--reimbursement_description varchar2, reimbursement_date_submitted date, reimbursement_date_approved date,
--reimbursement_approve_by number, reimbursement_image blob, reimbursement_type number,
--reimbursement_type_desc varchar2, reimbursement_status_desc varchar2 
exec insert_reimbursement(1,  212, 1, 'test', TO_DATE('2009-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), null, null, null, 1, 'type desc', 'PENDING');
exec insert_reimbursement(1,  212, 2, 'test', TO_DATE('2009-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), null, null, null, 1, 'type desc', 'RESOLVED');
exec insert_reimbursement(2,  212, 1, 'test', TO_DATE('2009-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), null, null, null, 1, 'type desc', 'PENDING');
exec insert_reimbursement(2,  212, 2, 'test', TO_DATE('2009-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), null, null, null, 1, 'type desc', 'RESOLVED');
-- table views
 select * from reimbursement_type;
 select * from reimbursement_status;
 select * from reimbursement;
 
 --select all reimbursments
 select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
        reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
        reimbursement_type_description as reimbursement_type from reimbursement 
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join reimbursement_type on reimbursement_type = reimbursement_type_id;
-- staff select all reimbursments
select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
        reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
        reimbursement_type_description as reimbursement_type from reimbursement 
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join reimbursement_type on reimbursement_type = reimbursement_type_id where reimbursement_staff_id = 1;
-- staff select all RESOLVED reimbursments
select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
        reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
        reimbursement_type_description as reimbursement_type from reimbursement 
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join reimbursement_type on reimbursement_type = reimbursement_type_id where reimbursement_status_desc = 'RESOLVED' and reimbursement_staff_id = 1; 
    
-- staff select all PENDING reimbursments
select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
        reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
        reimbursement_type_description as reimbursement_type from reimbursement 
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join reimbursement_type on reimbursement_type = reimbursement_type_id where reimbursement_status_desc = 'PENDING' and reimbursement_staff_id = 1;
-- a staff member can view their information    
select staff_username, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description as staff_position from staff left join staff_rank on staff_rank = rank_id where staff_username = 'david';

--a staff member can update their profile
    --update_staff(username, password, first_name, last_name, phone, email)
    update_staff('david', '1234', 'Wow', 'Cow', '90', 'w@cat.com');

-- manager approve/deny pending reimbursement requests
select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
    reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
    reimbursement_type_description as reimbursement_type from reimbursement 
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join reimbursement_type on reimbursement_type = reimbursement_type_id where reimbursement_status_desc = 'PENDING' and reimbursement_staff_id = 1;

--A Manager can view all resolved requests from all employees and see which manager resolved it
select reimbursement_id, (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee, reimbursement_amount, reimbursement_description,
    reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
    reimbursement_type_description as reimbursement_type 
    from 
    (select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
    reimbursement_date_submitted, reimbursement_date_approved, (staff_first_name || ' ' || staff_last_name) as reimbursement_approve_by, reimbursement_status_desc, 
    reimbursement_type_description from reimbursement
    left join reimbursement_type on reimbursement_type = reimbursement_type_id   
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join staff on staff_id = reimbursement_approve_by where reimbursement_status_desc = 'RESOLVED')
    left join staff on staff_id = reimbursement_staff_id where reimbursement_status_desc = 'RESOLVED'; -- and reimbursement_approve_by <> null;
--A Manager can view all pending requests from all employees
select reimbursement_id, (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee, reimbursement_amount, reimbursement_description,
    reimbursement_date_submitted, reimbursement_date_approved, reimbursement_approve_by, reimbursement_status_desc as reimbursement_status, 
    reimbursement_type_description as reimbursement_type 
    from 
    (select reimbursement_id, reimbursement_staff_id, reimbursement_amount, reimbursement_description,
    reimbursement_date_submitted, reimbursement_date_approved, (staff_first_name || ' ' || staff_last_name) as reimbursement_approve_by, reimbursement_status_desc, 
    reimbursement_type_description from reimbursement
    left join reimbursement_type on reimbursement_type = reimbursement_type_id   
    left join reimbursement_status on reimbursement_pending = reimbursement_status_id
    left join staff on staff_id = reimbursement_approve_by where reimbursement_staff_id = 1)
    left join staff on staff_id = reimbursement_staff_id where reimbursement_staff_id = 1; -- and reimbursement_approve_by <> null;
   
--A Manager can view all Employees   
   
   
   
update REIMBURSEMENT set REIMBURSEMENT_APPROVE_BY = 2 where REIMBURSEMENT_ID =2;
update REIMBURSEMENT set REIMBURSEMENT_APPROVE_BY = 1 where REIMBURSEMENT_ID =4;
select * from  REIMBURSEMENT;
select (staff_first_name || ' ' || staff_last_name) as reimbursement_staff_requestee from staff;
select * from staff;
--get all staff info
select staff_id, staff_username, staff_password, staff_rank, staff_first_name, staff_last_name, staff_phone, staff_email, rank_description as staff_position from staff left join staff_rank on staff_rank = rank_id;
--value removal sequence
 delete from reimbursement_type where reimbursement_type_id=1;
 delete from staff where staff_id=1;
 delete from staff_rank where rank_id=1;
 delete from reimbursement_status where reimbursement_status_id=1;
 delete from reimbursement where reimbursement_id=1;
    