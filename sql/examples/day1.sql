--create user yuvirds IDENTIFIED by yuvirds;
grant connect, resource to yuvirds;
GRANT DBA TO yuvi WITH ADMIN OPTION;

--DDL Data Definition Language
Create table FLASHCARDS(FC_ID Number(10) PRIMARY key,FC_QUESTION VARCHAR (100),
FC_ANSWERS VARCHAR (100) --primary key(fc_id)
);
--select values from a table
select * from Flashcards;
--create another example table 
Create table deltethistable(id NUMBER(10), name VARCHAR(20));
--change the name of table that was already created
alter table deltethistable
rename to deletethistable;
--select all the values from a table
select * from deletethistable;
--delete the table
drop table deletethistable;
select * from Flashcards;
insert into flashcards values (1, 'Is java 100% OOP?', 'No');
insert into flashcards values (2, 'Difference between abstract class and 
interface?', 'Interfaces cant have concrete methods. Abstract classes
can have both concrete and abstract methods');
insert into FLASHCARDS values (3, '3 + 4 ',' 7');
insert into FLASHCARDS values (4, '4 pillars of oop ',' inheritance, 
polymorphism, abstraction, encapsulation');
insert into FLASHCARDS values (5, 'which is synchronized - string buffer 
or builder','buffer');
insert into FLASHCARDS values (6, '2 + 2',' 4');
insert into FLASHCARDS values (7, ' Purpose of junit ',' unit testing');
insert into FLASHCARDS values (8, ' Purpose of maven ',' build automation tool');
insert into FLASHCARDS values (9, ' 7 + 4 ',' 11 ');
insert into FLASHCARDS values (10, ' 7 + 4 ',' 11 ');
insert into FLASHCARDS values (11, 'What is java','OOP');
insert into FLASHCARDS values (12, 'Why is java used','portable, platform independent');
insert into FLASHCARDS values (13, 'Why?','Answer');

select * from flashcards;   --10
select count(*) from flashcards;    --10
select count(distinct(fc_question)) from flashcards;  --9

select * from flashcards where FC_ID = '2'; 
select * from flashcards where FC_ID >= '5'; --<= < > >= <>
select * from flashcards where FC_ID <> '2'; 
--invalid identifier
--select * from flashcards where FC_ID1 = '20'; 

--% means multiple characters _ means single character
select * from flashcards where FC_QUESTION like '_h%' and FC_ANSWERS <> '2 + 2';

select * from flashcards order by fc_id; 

desc flashcards;

select 46 from dual;

select * from dual;

select sysdate from dual;