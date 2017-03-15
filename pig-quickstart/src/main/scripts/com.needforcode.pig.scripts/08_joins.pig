/*
Joins can be done on single/multiple keys.
Triggers reduce phase if not map join.
 */


A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = LOAD 'person_diagnosis.txt' USING PigStorage() AS (id:long,code:chararray,description:chararray);

INNER_JOIN = JOIN A BY id, B BY id;

DUMP INNER_JOIN;

LEFT_OUTER = JOIN A BY id LEFT OUTER, B BY id;

DUMP LEFT_OUTER;

RIGHT_OUTER = JOIN A BY id RIGHT OUTER, B BY id;

DUMP RIGHT_OUTER;

FULL_OUTER = JOIN A BY id FULL OUTER, B BY id;

DUMP FULL_OUTER;

COGRP =  COGROUP A BY id, B BY id;

DUMP COGRP;

-- inner join on cogrp removes empty bags
COGRP_INNER = COGROUP A BY id INNER, B BY id INNER;

DUMP COGRP_INNER;

-- replicated join. the large relation is followed by one or more small relations.

REPLICATED_JOIN = JOIN A BY id, B BY id USING 'replicated';

DUMP REPLICATED_JOIN

