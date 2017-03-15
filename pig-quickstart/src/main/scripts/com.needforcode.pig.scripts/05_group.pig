
/*
The group statement collects together records with the same key.
Triggers reduce phase.
 */

A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = GROUP A BY country;

C = FOREACH B GENERATE group, COUNT(A);

DUMP C;

C = FOREACH B GENERATE group, SUM(A.salary);

DUMP C;


-- GROUPING ON MULTIPLE KEYS

B = GROUP A BY (country,gender);

C = FOREACH B GENERATE group,COUNT(A);

DUMP C;

C = FOREACH B GENERATE group.country,group.gender,COUNT(A);

DUMP C;

B = LOAD 'person_diagnosis.txt' USING PigStorage() AS (id:long,code:chararray,description:chararray);

COGRP =  COGROUP A BY id, B BY id;

DUMP COGRP;

-- inner join on cogrp removes empty bags
COGRP_INNER = COGROUP A BY id INNER, B BY id INNER;

DUMP COGRP_INNER;




