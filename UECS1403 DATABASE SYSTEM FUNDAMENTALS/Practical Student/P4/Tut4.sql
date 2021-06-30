CREATE TABLE location
(loc_id NUMBER(6),
bldg_code VARCHAR2(10),
room VARCHAR2(6),
capacity NUMBER(5), 
CONSTRAINT location_loc_id_pk PRIMARY KEY (loc_id));

CREATE TABLE faculty
(f_id NUMBER(6),
f_last VARCHAR2(30),
f_first VARCHAR2(30),
f_mi CHAR(1),
loc_id NUMBER(5),
f_phone VARCHAR2(10),
f_rank VARCHAR2(8),
f_pin NUMBER(4),
f_image BLOB, 
CONSTRAINT faculty_f_id_pk PRIMARY KEY(f_id),
CONSTRAINT faculty_loc_id_fk FOREIGN KEY (loc_id) REFERENCES location(loc_id));

DESCRIBE location;

DESCRIBE faculty;

SELECT table_name
FROM user_tables;


'FROM ALL THE USER TABLES
SELECT table_name
FROM all_tables;

DESCRIBE user_constraints;

SELECT constraint_name, table_name, constraint_type 
FROM user_constraints;

SELECT constraint_name, constraint_type,Last_change
FROM user_constraints
WHERE table_name = 'FACULTY';

DROP TABLE location;

DROP TABLE location 
CASCADE CONSTRAINTS;

ALTER TABLE FACULTY 
ADD CONSTRAINT faculty_loc_id_fk FOREIGN KEY (loc_id) REFERENCES location(loc_id);

ALTER TABLE LOCATION
ADD (item varchar(30),
     pc char(20));


Alter table faculty
drop column f_image;

ALTER TABLE faculty
ADD (start_date DATE);

ALTER TABLE faculty
ADD (gender char(5));

ALTER TABLE LOCATION
MODIFY (item char(5));

ALTER TABLE faculty
MODIFY (sex Varchar2(3),
f_pin number(3));

ALTER TABLE faculty 
MODIFY (f_rank CHAR(4),
f_last Varchar(20));

ALTER TABLE location 
ADD CONSTRAINT RNO NOT NULL (capacity);

ALTER TABLE location 
MODIFY (capacity NUMBER(5) CONSTRAINT my_cons_name NOT NULL); 

ALTER TABLE faculty 
DROP COLUMN START_DATE;

ALTER TABLE faculty 
ADD (f_rank CHAR(4));

ALTER TABLE faculty 
ADD CONSTRAINT faculty_f_pin_uk UNIQUE (f_pin);

ALTER TABLE FACULTY
rename column gender to sex;

ALTER TABLE STUDENT 
ADD CONSTRAINT student_f_id_fk FOREIGN KEY (f_id) REFERENCES FACULTY(f_id);


ALTER TABLE faculty 
DROP CONSTRAINT faculty_f_pin_uk;


'GOTO  5CASE1-INSERT RECORD AND DISABLE CONSTRAINTS
ALTER TABLE faculty
DISABLE CONSTRAINT faculty_LOC_ID_FK;


INSERT INTO faculty (F_ID, F_LAST, F_FIRST, F_MI, LOC_ID)
VALUES (20, 'Cox', 'Kim', 'J', 15);


INSERT INTO location VALUES
(15, 'BUS', '424', 1);


ALTER TABLE faculty
DROP CONSTRAINT faculty_LOC_ID_FK;

ALTER TABLE faculty
ENABLE CONSTRAINT faculty_LOC_ID_FK;



DROP TABLE faculty CASCADE CONSTRAINTS;
DROP TABLE COURSE CASCADE CONSTRAINTS;
DROP TABLE COURSE_SECTION CASCADE CONSTRAINTS;
DROP TABLE ENROLLMENT CASCADE CONSTRAINTS;
DROP TABLE LOCATION CASCADE CONSTRAINTS;
DROP TABLE STUDENT CASCADE CONSTRAINTS;
DROP TABLE TERM CASCADE CONSTRAINTS;












