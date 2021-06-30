CREATE TABLE TERM
(term_id NUMBER(6),
term_desc VARCHAR2(20),
status VARCHAR2(20),
CONSTRAINT term_term_id_pk PRIMARY KEY (term_id),
CONSTRAINT term_status_cc CHECK ((status = 'OPEN') OR (status = 'CLOSED')));

CREATE TABLE COURSE
(course_id NUMBER(6),
call_id VARCHAR2(10),
course_name VARCHAR2(25),
credits NUMBER(2),
CONSTRAINT course_course_id_pk PRIMARY KEY(course_id));

CREATE TABLE COURSE_SECTION
(c_sec_id NUMBER(6),
course_id NUMBER(6) CONSTRAINT course_section_courseid_nn NOT NULL,
term_id NUMBER(6) CONSTRAINT course_section_termid_nn NOT NULL,
sec_num NUMBER(2) CONSTRAINT course_section_secnum_nn NOT NULL,
f_id NUMBER(6),
c_sec_day VARCHAR2(10),
c_sec_time DATE,
c_sec_duration INTERVAL DAY TO SECOND,
loc_id NUMBER(6),
max_enrl NUMBER(4) CONSTRAINT course_section_maxenrl_nn NOT NULL,
CONSTRAINT course_section_csec_id_pk PRIMARY KEY (c_sec_id),
CONSTRAINT course_section_cid_fk FOREIGN KEY (course_id) REFERENCES course(course_id), 	
CONSTRAINT course_section_loc_id_fk FOREIGN KEY (loc_id) REFERENCES location(loc_id),
CONSTRAINT course_section_termid_fk FOREIGN KEY (term_id) REFERENCES term(term_id),
CONSTRAINT course_section_fid_fk FOREIGN KEY (f_id) REFERENCES faculty(f_id));

CREATE TABLE ENROLLMENT
(s_id NUMBER(6),
c_sec_id NUMBER(6),
grade CHAR(1),
CONSTRAINT enrollment_pk PRIMARY KEY (s_id, c_sec_id),
CONSTRAINT enrollment_sid_fk FOREIGN KEY (s_id) REFERENCES student(s_id),
CONSTRAINT enrollment_csecid_fk FOREIGN KEY (c_sec_id) REFERENCES course_section (c_sec_id),
CONSTRAINT enrollment_grade_cc
    CHECK ((grade = 'A') OR (grade = 'B') 
    OR (grade = 'C') OR (grade = 'D') OR (grade = 'F')));