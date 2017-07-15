Create table employee 
      (
      emp_id number(10) primary key,
      emp_name varchar2(200),
      emp_title varchar2 (200),
      emp_email varchar2(200),
      emp_start_date date,
      emp_contact_number number (20)
      );
--DDL create, alter, drop --can't rollback
--DML insert, update, delete, select
--DCL grant, revoke
--TCL commit, rollback savepoint

desc employee;
select * from EMPLOYEE;

alter table employee drop column emp_email;

create Table emp_info
      (emp_info_id number (10) PRIMARY KEY,
      emp_address VARCHAR2 (200),
      emp_id number (10),
      CONSTRAINT fk_emp_id
      FOREIGN KEY (emp_id)
      REFERENCES employee(emp_id)
);

insert into EMP_INFO values(1,'yuvi@yuvi.com',1);

create table department
(
  dept_id number(10) primary key,
  dept_name varchar(50), 
  dept_emp_id number (10),
  CONSTRAINT fk_dept_emp_id
  FOREIGN KEY (dept_emp_id)
  REFERENCES employee(emp_id)
);


create table TableA(id number(10),value varchar2(100));
create table TableB(id number(10),value varchar2(100));


insert into employee (EMP_ID, EMP_START_DATE, EMP_CONTACT_NUMBER) values (45,SYSDATE,5672348);
insert into employee values (46,NULL,NULL,SYSDATE,6735);

COMMIT;

DESCRIBE EMPLOYEE;

SELECT * FROM EMPLOYEE WHERE EMP_ID = 46;

UPDATE EMPLOYEE SET EMP_NAME = 'PETER', EMP_TITLE = 'BOSS' WHERE EMP_ID = 46;

COMMIT;

DELETE EMPLOYEE WHERE EMP_ID = 46;

SELECT * FROM EMPLOYEE;

ROLLBACK;

DESCRIBE DEPARTMENT;

INSERT INTO DEPARTMENT VALUES(1,'THE BOSS DEPARTMENT',46);

COMMIT;

SELECT * FROM 
EMPLOYEE EMP INNER JOIN DEPARTMENT DPT
ON EMP.EMP_ID = DPT.DEPT_EMP_ID
/*INNER JOIN THE OTHER TABLE
ON THE OTHER CONDITION
INNER JOIN THE OTHER TABLE*/

SELECT * FROM EMPLOYEE EMP, DEPARTMENT DPT
WHERE EMP.EMP_ID = DPT.DEPT_EMP_ID;


