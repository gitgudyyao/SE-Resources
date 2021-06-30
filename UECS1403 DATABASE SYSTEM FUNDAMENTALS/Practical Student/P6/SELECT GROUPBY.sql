START c:\OraData\Chapter3\3Northwoods.sql;
START c:\OraData\chapter3\3Clearwater.sql;

SELECT s_first, s_mi, s_last
FROM student;

SELECT *
FROM location;

SELECT f_rank
FROM faculty;

SELECT DISTINCT f_rank
FROM faculty;

SELECT f_first, f_mi, f_last, f_rank
FROM faculty
WHERE f_rank = 'ASSO';

SELECT room
FROM location
WHERE bldg_code = 'BUS'
AND capacity >= 40;

SELECT * FROM enrollment
WHERE grade IS NULL;

SELECT * FROM enrollment
WHERE grade IS NOT NULL;

SELECT *
FROM enrollment
WHERE grade IN ('A', 'B');

SELECT * 
FROM enrollment
WHERE grade NOT IN ('A', 'B');

SELECT *
FROM term
WHERE term_desc LIKE '%2006';

SELECT * 
FROM term
WHERE term_desc LIKE 'Fall%';

SELECT call_id
FROM course
WHERE call_id LIKE '%1__';

SELECT bldg_code, room, capacity
FROM location
WHERE capacity >= 40
ORDER BY capacity;

SELECT bldg_code, room, capacity
FROM location
WHERE capacity >= 40
ORDER BY capacity DESC;

SELECT bldg_code, room, capacity
FROM location
WHERE capacity >= 40
ORDER BY bldg_code, room;

SELECT inv_id, color, inv_price, inv_qoh, inv_price*inv_qoh
FROM inventory
WHERE item_id = 2;

SELECT s_id, s_last, SYSDATE - s_dob
FROM student;

SELECT s_id, s_last, (SYSDATE - s_dob)/365.25
FROM student;

SELECT s_id, s_last, SYSDATE - time_enrolled 
FROM STUDENT;

SELECT s_id, s_last, TRUNC((SYSDATE - s_dob)/365.25)
FROM student;


SELECT s_id, s_last, ROUND((SYSDATE - s_dob)/365.25)
FROM student;

SELECT CONCAT(bldg_code, room)
FROM location
WHERE bldg_code = 'CR';

SELECT term_id, term_desc, INITCAP(status)
FROM term;

SELECT ADD_MONTHS(ship_date_expected, 2) 
FROM shipment 
WHERE ship_id = 1;

SELECT MONTHS_BETWEEN(ship_date_expected, SYSDATE) 
FROM shipment 
WHERE ship_id = 1;

SELECT SUM(max_enrl), AVG(max_enrl), MAX(max_enrl), MIN(max_enrl)
FROM course_section
WHERE term_id = 6;

SELECT COUNT(*)
FROM enrollment
WHERE s_id = 5;

SELECT COUNT(grade)
FROM enrollment
WHERE s_id = 5;

SELECT bldg_code, SUM(capacity)
FROM location
GROUP BY bldg_code;

SELECT bldg_code, SUM(capacity)
FROM location;

SELECT bldg_code, SUM(capacity)
FROM location
HAVING SUM(capacity) >= 100
GROUP BY bldg_code;

SELECT bldg_code "Building", SUM(capacity) "Capacity"
FROM location
GROUP BY bldg_code;

SELECT bldg_code "Building", SUM(capacity) AS capacity
FROM location
GROUP BY bldg_code
ORDER BY capacity;

SELECT s_id, s_first, s_last, s_dob
FROM student;

SELECT c_sec_id, sec_num, c_sec_day, c_sec_time
FROM course_section;

SELECT c_sec_id, sec_num, c_sec_day, TO_CHAR(c_sec_time, 'HH:MI AM')
FROM course_section;

SELECT inv_id, TO_CHAR(inv_price, '$99,999.99')
FROM inventory
WHERE item_id = 1;





