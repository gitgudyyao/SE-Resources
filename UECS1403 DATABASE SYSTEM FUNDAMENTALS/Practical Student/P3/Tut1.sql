
CREATE TABLE LOCATION
(loc_id NUMBER(6),
bldg_code VARCHAR2(10),
room VARCHAR2(6) CONSTRAINT RNO NOT NULL,
capacity NUMBER(5), 
CONSTRAINT location_loc_id_pk PRIMARY KEY (loc_id));

DESCRIBE LOCATION;

SELECT CONSTRAINT_NAME,CONSTRAINT_TYPE 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME='LOCATION';

SELECT CONSTRAINT_NAME,COLUMN_NAME 
FROM USER_CONS_COLUMNS;

CREATE TABLE faculty
(f_id NUMBER(6),
f_last VARCHAR2(30),
f_first VARCHAR2(30),
f_mi CHAR(1),
loc_id NUMBER(6),
f_phone VARCHAR2(10),
f_rank VARCHAR2(8),
f_pin NUMBER(4),
f_image BLOB, 
CONSTRAINT faculty_f_id_pk PRIMARY KEY(f_id),
CONSTRAINT faculty_loc_id_fk FOREIGN KEY (loc_id) REFERENCES location(loc_id));

CREATE TABLE student
(s_id NUMBER(6),
s_last VARCHAR2(30),
s_first VARCHAR2(30),
s_mi CHAR(1),
s_add VARCHAR2(25),
s_city VARCHAR2(20),
s_state CHAR(2),
s_zip VARCHAR2(9),
s_phone VARCHAR2(10),
s_class CHAR(2) CONSTRAINT student_s_class_cc CHECK ((s_class = 'FR')
OR (s_class = 'SO') OR (s_class = 'JR') OR (s_class = 'SR')),
s_dob DATE,
s_pin NUMBER(4),
f_id NUMBER(6),
time_enrolled INTERVAL YEAR TO MONTH,
CONSTRAINT student_s_id_pk PRIMARY KEY (s_id),
CONSTRAINT student_f_id_fk FOREIGN KEY (f_id) REFERENCES faculty(f_id));

SELECT TABLE_NAME FROM USER_TABLES;