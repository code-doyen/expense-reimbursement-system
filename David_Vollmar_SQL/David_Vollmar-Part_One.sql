--2.1 Select 
select * from employee;
select * from employee where lastname = 'King';
select * from employee where firstname ='Andrew' and reportsto is null;

--2.2 Order By
select * from album order by title desc; 
select firstname from customer order by city;

--2.3 Insert into

insert into genre (genreid, name) values (26, 'Code Cash');
insert into genre (genreid, name) values (27, 'J-Pop');

insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate,hiredate, address, city, state, country, postalcode,phone,fax, email)values(9 , 'Vollmar', 'David', 'Software Developer', 5, TO_DATE('1980-11-1 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2017-7-5 00:00:00','yyyy-mm-dd hh24:mi:ss'), '169 Code Smash Ln', 'Tampa', 'FL', 'USA', '33620', '419-494-5566', '419-494-5566', 'david.bradly.vollmar@gmail.com');
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate,hiredate, address, city, state, country, postalcode,phone,fax, email)values(10 , 'Vollmar', 'Leah', 'Model', 6, TO_DATE('1994-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2017-7-5 00:00:00','yyyy-mm-dd hh24:mi:ss'), '169 Code Smash Ln', 'Tampa', 'FL', 'USA', '33620', '419-494-5566', '419-494-5566', 'mybabe@gmail.com');

insert into customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
values(9, 'David', 'Vollmar', 'Revature', 'Code Ave.', 'Tampa', 'FL', 'USA', '34444', '4194945566', '4194945566', 'david.bradley.collmar@gmail.com', 5);
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values(10, 'Elena', 'Vollmar', 'Super Model', 'Bird Lane', 'Tampa', 'FL', 'USA', '12444', '4194945566', '4194945566', 'superbabe@gmail.com', 6);

--2.4 Update 
update customer set firstname='Robert', lastname='Walter' where customerid =32;
update artist set name = 'CCR' where artistid = 76;
select * from customer where customerid = 32;

--2.5 Like
select * from invoice where billingaddress like 'T%';

--2.6 Between
select * from invoice where total between 15 and 50;
select * from employee where hiredate between '01-JUN-03' AND '1-MAR-04';

--2.7 Delete
--alter table invoice add constraint fk_invoicecustomerid foreign key (customerid) references customer (customerid) on delete cascade;
delete from invoiceline where invoiceid = 50;
delete from invoiceline where invoiceid = 61;
delete from invoiceline where invoiceid = 116;
delete from invoiceline where invoiceid = 342;
delete from invoiceline where invoiceid = 245;
delete from invoiceline where invoiceid = 268;
delete from invoiceline where invoiceid = 290;
delete from invoice where customerid =32;
delete from customer where firstname = 'Robert' and lastname ='Walter';
select * from customer;


--3.1 SQL defined functions
select to_char(sysdate, 'HH24:MI:SS') as Current_TIME from dual ;  --to_char(sysdate, 'MM-DD-YYYY HH24:MI:SS')

select length(name) as media_type_length from mediatype;

--3.2 System defined aggregate
create or replace function invoice_avg return number
is
    average number;
begin
    select avg(total) into average from invoice;
    return average;
end;
/
select invoice_avg from dual;

create or replace function invoiceline_maxprice return number
is
    maximum number;
begin
  select max(unitprice) into maximum from invoiceline;
 return maximum;
end;
/
select invoiceline_maxprice from dual;

--3.3 User define functions
create or replace function invoiceline_avg return number
is
    average number;
begin
  select avg(unitprice) into average from invoiceline;
 return average;
end;
/
select invoiceline_avg from dual;

--3.4 User defined table valued functions
create or replace function after_1968 return sys_refcursor
is
    employee_c sys_refcursor;
begin
 open employee_c for select * from employee where birthdate > to_date('01-01-1968', 'DD-MM-YYYY');
 return employee_c;
end;
/
select after_1968 from dual;

--4.1 Basic Stored Procedure
create or replace procedure employee_info(employee_c out sys_refcursor)
as 
begin
    open employee_c for select firstname, lastname from employee;
end;
/

declare employee_c sys_refcursor;
    firstname varchar(100);
    lastname varchar(100);
begin
    employee_info(employee_c);
    loop
        fetch employee_c into firstname, lastname;
        exit when employee_c%notfound;
        dbms_output.put_line(firstname || ', ' || lastname);
    end loop;
end;
/
set serveroutput on;

--4.2 Stored Procedures Input Parameters
create or replace procedure update_employee_address(empid number, newaddress varchar2)
as
begin
    --update 
    update employee set address = newaddress where employeeid = empid;
   -- commit; -- to complete the transaction
end;
/
exec update_employee_address(1, '1200 Updated Ave.');

---------------------------------------
create or replace procedure employees_managers(empid in number, managers_c out sys_refcursor)
as 
begin
    open managers_c for select firstname, lastname from employee where reportsto = empid ;
end;
/

declare managers_c sys_refcursor;
    firstname varchar(100);
    lastname varchar(100);
begin
    employees_managers(1, managers_c);
    loop
        fetch managers_c into firstname, lastname;
        exit when managers_c%notfound;
        dbms_output.put_line(firstname || ', ' || lastname);
    end loop;
end;
/
--set serveroutput on;

--4.3 Store Procedure Output Parameters
create or replace procedure employees_company(custid in number, employee_company_relation out sys_refcursor)
as 
begin
    open employee_company_relation for select firstname, lastname, company from customer where customerid = custid ;
end;
/

declare employee_company_relation sys_refcursor;
    firstname varchar(100);
    lastname varchar(100);
    company varchar(100);
begin
    employees_company(5, employee_company_relation);
    loop
        fetch employee_company_relation into firstname, lastname, company;
        exit when employee_company_relation%notfound;
        dbms_output.put_line(firstname || ' ' || lastname || ' <represents> ' || company);
    end loop;
end;
/


--5.0 Transactions
create or replace procedure delete_invoice(invid number)
as
begin
    --deleting all invoice lines
    delete from invoiceline where invoiceid = invid;
    
    --deleting actual invoice
    delete from invoice where invoiceid = invid;
    
    -- to complete the transaction
    commit;
end;
/
--deletes invoive with id 4
exec delete_invoice(4); 


create or replace procedure add_customer(customerid number, firstname varchar2, lastname varchar2, company varchar2, address varchar2, city varchar2, state varchar2, country varchar2, postalcode varchar2, phone varchar2, fax varchar2, email varchar2, supportrepid number)
as
begin
    --adding new customer
    insert into customer values(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid);
    
    --to complete the transaction
    commit;
end;
/
--adds new customer
exec add_customer(11,'Leah', 'Vollmar', 'Model', 'Some Place Ave.', 'Tampa', 'Fl', 'USA', '33504', '419-494-5566', '419-494-5566', 'david.bradley.vollmar@gmail.com', 2);

select * from customer;
--desc customer;


--6.1 Triggers After/For
--drop sequence employee_seq;
create sequence employee_seq
  start with 1
  increment by 1;
create or replace trigger employee_insert_trigger
before insert on employee
for each row --required if you want to see/manipulate the row's data
begin
  /* INCREASE THE SEQUENCE */
  if :NEW.employeeid is null then
    select employee_seq.nextval into :NEW.employeeid from DUAL;
  END IF;
END;
/
insert into employee values(null,'Vollmar', 'Leah', 'Model', 6, TO_DATE('1994-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2017-7-5 00:00:00','yyyy-mm-dd hh24:mi:ss'), '169 Code Smash Ln', 'Tampa', 'FL', 'USA', '33620', '419-494-5566', '419-494-5566', 'mybabe@gmail.com');
--select * from employee;
--delete employee where employeeid = 9;


create or replace trigger album_update_trigger
before update on album

for each row --required if you want to see/manipulate the row's data
when(new.title != null)
begin
 dbms_output.put_line('Old title: ' || :OLD.title || 'update to  New title: ' || :NEW.title);
END;
/
update album set title ='Update Awared' where albumid = 1;


create or replace trigger customer_delete_trigger
before delete on customer
for each row --required if you want to see/manipulate the row's data

begin
 dbms_output.put_line('Old title: ' || :OLD.customerid);
END;
/
--delete invoice where customerid = 1;
--delete customer where customerid = 1;
select * from customer;


--7.1 Inner Join
select customer.firstname, customer.lastname, invoice.invoiceid from customer 
inner join invoice on invoice.customerid = customer.customerid order by invoice.invoiceid;

--7.2 Outer Join
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from customer 
full outer join invoice on invoice.customerid = customer.customerid order by customer.customerid;

--7.3 Right Join
select artist.name, album.title from album 
right join artist on artist.artistid = album.albumid;

--7.4 Left Join
select artist.name from album cross join artist order by name asc;

--7.5 Self Join
select (reports.firstname || ' ' || reports.lastname) as Employee, (emp.firstname || ' ' || emp.lastname) as Reports_To 
from employee emp
inner join employee reports
on emp.employeeid = reports.reportsto;

--7.6 Complicated Join
select * from invoiceline inner join invoice on invoiceline.invoiceid = invoice.invoiceid
inner join customer on invoice.customerid = customer.customerid 
inner join employee on customer.supportrepid = employee.employeeid
inner join track on invoiceline.trackid = track.trackid 
inner join genre on track.genreid = genre.genreid
inner join mediatype on track.mediatypeid = mediatype.mediatypeid
inner join playlisttrack on track.trackid = playlisttrack.trackid 
inner join playlist on playlisttrack.playlistid = playlist.playlistid
inner join album on track.albumid = album.albumid
inner join artist on album.artistid = artist.artistid;
