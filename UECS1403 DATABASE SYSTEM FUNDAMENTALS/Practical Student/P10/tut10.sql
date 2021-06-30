START c:\OraData\Chapter3\3Northwoods.sql
START c:\OraData\Chapter3\3Clearwater.sql
START c:\OraData\Chapter3\3Software.sql

select *
from faculty, location
where location.loc_id=faculty.loc_id

select f_id,loc_id
from faculty
where loc_id in (Select loc_id
		 from location)


select faculty.f_id, location.loc_id, location.bldg_code, location.room, location.capacity
from faculty, location
where location.loc_id=faculty.loc_id

select s.s_id,s.s_last, e.grade,count(grade)
from student s, enrollment e
where s.s_id=e.s_id and grade in ('A','B') and grade is not null
group by s.s_id,s.s_last, e.grade

select s.s_id, s.s_last, c.course_id, c.course_name
from student s, enrollment e, course_section cs, course c
where s.s_id=e.s_id and cs.c_sec_id=e.c_sec_id and c.course_id=cs.course_id

select f_id,f_last, sum(capacity)
from faculty f, location l
where l.loc_id=f.loc_id
group by f_id,f_last

select s_id,s_last
from student
where s_id in (select s_id
               from enrollment
               )


select s_id,s_last
from student s
WHERE EXISTS (SELECT *
FROM enrollment e
where s.s_id=e.s_id
)

SELECT *
FROM location l
WHERE EXISTS (SELECT * 
FROM faculty f 
WHERE l.loc_id=f.loc_id and bldg_code='BUS'); 


select f.f_id, sum(capacity) "total_capacity"
from faculty f, location l
where f.loc_id=l.loc_id
group by f.f_id

select s.s_id,s.s_last,e.grade, count(grade)
from student s,enrollment e
where s.s_id=e.s_id
group by s.s_id,s.s_last,e.grade

select s.s_id,s.s_last, e.grade, c.course_id,c.call_id
from student s, enrollment e, course_section cs, course c
where s.s_id=e.s_id and e.c_sec_id=cs.c_sec_id and 
cs.course_id=c.course_id and e.grade is not null


select s.s_id, s_last, course_name, grade, f.f_id, f_last, term_desc
from student s, enrollment e, course_section cs, term t, course c, faculty f
where s.s_id=e.s_id and e.c_sec_id=cs.c_sec_id and c.course_id=cs.course_id and t.term_id=cs.term_id and f.f_id=cs.f_id



select l.loc_id, f_last,bldg_code 
from location l, faculty f
where l.loc_id=f.loc_id



SELECT s_id, s_last, s_first, student.f_id, f_last
FROM student, faculty
WHERE student.f_id = faculty.f_id;


select s.s_id, grade, c.course_id, course_name, c_sec_day, 
c_sec_time, f.f_id, term_desc
from student s, enrollment e, course_section cs, faculty f, term t, course c
where s.s_id=e.s_id and e.c_sec_id=cs.c_sec_id and cs.term_id=t.term_id and cs.course_id=c.course_id and f.f_id=cs.f_id

SELECT f_last
FROM faculty, course_section, term
WHERE faculty.f_id = course_section.f_id
AND course_section.term_id = term.term_id
AND term_desc = 'Summer 2007';

SELECT call_id, grade
FROM student, enrollment, course_section, course
WHERE student.s_id = enrollment.s_id
AND enrollment.c_sec_id = course_section.c_sec_id
AND course_section.course_id = course.course_id
AND s_last = 'Miller'
AND s_first = 'Sarah';

SELECT s_id, s_last, s_first, student.f_id, f_last
FROM student, faculty;

SELECT inventory.inv_id, inv_size, color, inv_qoh, ship_id, sl_date_received, sl_quantity
FROM inventory, shipment_line
WHERE inventory.inv_id = shipment_line.inv_id;

SELECT inventory.inv_id, inv_size, color, inv_qoh, ship_id, sl_date_received, sl_quantity
FROM inventory, shipment_line
WHERE inventory.inv_id = shipment_line.inv_id(+);


select l.loc_id, bldg_code,room,f_id,f_last
from faculty f,location l
where  l.loc_id(+)=f.loc_id
order by l.loc_id


select l.loc_id,l.bldg_code, f.f_id
from faculty f, location l
where l.loc_id(+)=f.loc_id


select l.loc_id, l.bldg_code,l.room,f.f_id,f.f_last
from location l left outer join faculty f
on l.loc_id=f.loc_id

where location.loc_id=1

SELECT parent_project.project_name "Parent Project", sub_project.project_name "Sub Project"
FROM project parent_project, project sub_project
WHERE sub_project.parent_p_id = parent_project.p_id;



SELECT *
FROM course NATURAL JOIN  course_section


SELECT *
FROM location NATURAL JOIN  faculty


SELECT *
FROM course c, course_section cs
where c.course_id=cs.course_id


SELECT * 
FROM Location INNER JOIN Faculty
on location.loc_id=faculty.loc_id

SELECT * 
FROM Location, Faculty
on location.loc_id=faculty.loc_id


SELECT loc_id, f_id 
FROM Location JOIN Faculty
USING (loc_id)



SELECT loc_id, f_id FROM location  NATURAL LEFT JOIN  Faculty


SELECT s_last, s_first
FROM student
WHERE s_class IN
  (SELECT s_class
   FROM student
   WHERE s_last = 'Mobley'
   AND s_first = 'Amanda');

SELECT DISTINCT s_last, s_first
FROM student, enrollment
WHERE student.s_id = enrollment.s_id
AND c_sec_id IN
 (SELECT c_sec_id
   FROM student, enrollment
   WHERE student.s_id = enrollment.s_id
   AND s_last = 'Mobley'
   AND s_first = 'Amanda');

select (select count(*) from student) "Total Students",
       (select count(*) from course) "Total Course",
       (select count(*) from course_section) "Total Classes"
from dual



select course_name 
from course
where course_id in
    (select distinct course_id 
     from course_section)
     

select count(*) "Total Students"
from student

select sum(capacity) "Total Capacity"
from location

select count(*) "Total Courses"
from course


select (select count(*) from student) "Total Students", 
       (select sum(capacity) from location) "Total Capacity"
,      (select count(*) from course) "Total Courses"
from dual


SELECT DISTINCT s_last, s_first
FROM student, enrollment
WHERE student.s_id = enrollment.s_id
AND s_class =
  (SELECT s_class
   FROM student
   WHERE s_last = 'Mobley'
   AND s_first = 'Amanda')
AND c_sec_id IN
 (SELECT c_sec_id
   FROM student, enrollment
   WHERE student.s_id = enrollment.s_id
   AND s_last = 'Mobley'
   AND s_first = 'Amanda');

SELECT DISTINCT s_last, s_first
FROM student, enrollment
WHERE student.s_id = enrollment.s_id
AND c_sec_id IN
 (SELECT course_section.c_sec_id
   FROM student, enrollment, course_section
   WHERE student.s_id = enrollment.s_id
   AND enrollment.c_sec_id = course_section.c_sec_id
   AND s_last = 'Mobley'
   AND s_first = 'Amanda'
   AND course_section.c_sec_id IN
     (SELECT c_sec_id
      FROM course_section, location
      WHERE course_section.loc_id = location.loc_id
      and bldg_code = 'CR'));


SELECT s_last, s_first, s_phone
FROM student
UNION
SELECT f_last, f_first, f_phone
FROM faculty;


SELECT loc_id
FROM location
UNION ALL
SELECT f_id
FROM faculty;


SELECT c_last
FROM consultant, project_consultant
WHERE consultant.c_id = project_consultant.c_id
AND p_id = 5
UNION
SELECT c_last
FROM consultant, consultant_skill
WHERE consultant.c_id = consultant_skill.c_id
AND skill_id = 1;

SELECT c_last
FROM consultant, project_consultant
WHERE consultant.c_id = project_consultant.c_id
AND p_id = 5
UNION ALL
SELECT c_last
FROM consultant, consultant_skill
WHERE consultant.c_id = consultant_skill.c_id
AND skill_id = 1;

SELECT c_last
FROM consultant, project_consultant
WHERE consultant.c_id = project_consultant.c_id
AND p_id = 5
INTERSECT
SELECT c_last
FROM consultant, consultant_skill
WHERE consultant.c_id = consultant_skill.c_id
AND skill_id = 1;

SELECT f_first, f_last
FROM faculty, location, course_section
WHERE faculty.f_id = course_section.f_id
AND location.loc_id = course_section.loc_id
AND bldg_code = 'BUS'
INTERSECT
SELECT f_first, f_last
FROM faculty, location
WHERE faculty.loc_id = location.loc_id
AND bldg_code = 'BUS';



CREATE VIEW faculty_view AS
SELECT f_id, f_last, f_first, f_mi, loc_id, f_phone, f_rank
FROM faculty;



INSERT INTO faculty_view VALUES
(6, 'May', 'Lisa', 'I', 11, '7155552508', 'INST');



CREATE VIEW location_view AS
SELECT loc_id,ROOM,CAPACITY       
FROM location;

CREATE VIEW location_view2 AS
SELECT bldg_code,ROOM,CAPACITY       
FROM location;

CREATE VIEW location_grp AS
(SELECT BLDG_CODE,sum(capacity) "SS"    
FROM location
group by bldg_code);


INSERT INTO location_view VALUES
('BUS','A101',23);


CREATE OR REPLACE VIEW location_faculty_view AS
select l.loc_id,bldg_code,capacity,f_id,f_last
from location l, faculty f
where l.loc_id=f.loc_id

select *
from location_faculty_view;


INSERT INTO location_faculty_view(loc_id,bldg_code,capacity) VALUES
(11,'A101',23);

update location_faculty_view
set f_last='test'
where f_id=1;


SELECT f_last, f_first, bldg_code, room
FROM faculty_view, location
WHERE faculty_view.loc_id = location.loc_id;

SELECT item_desc, SUM(value)
FROM inventory_view
GROUP BY item_desc;

DROP VIEW faculty_view; 


select loc_id from location E
WHERE EXISTS (SELECT 1
FROM location
WHERE bldg_code = E.bldg_code
AND capacity>30)


SELECT *
FROM location l
WHERE EXISTS (SELECT * 
FROM faculty f 
WHERE l.loc_id=f.loc_id and bldg_code='BUS'); 

select location.loc_id,bldg_code,room, capacity
from location, faculty
where location.loc_id=faculty.loc_id


SELECT *
FROM location l
WHERE NOT EXISTS (SELECT * 
FROM faculty f 
WHERE l.loc_id=f.loc_id); 


select *
from location
where capacity > some (35,85,25,18,20,21);

select *
from location
where capacity> all
    (select capacity 
     from location
     where bldg_code='LIB');

select *
from location
where capacity > any(35,85);

select *
from location
where capacity > all(35,85);


INSERT INTO location(loc_id,bldg_code,room,capacity)
VALUES (55, 'B03', NULL, 120);

INSERT INTO location(loc_id,bldg_code,room,capacity)
VALUES (66, 'B03', NULL, 120);

commit;

Rollback to save_location2;

SAVEPOINT save_location2;
