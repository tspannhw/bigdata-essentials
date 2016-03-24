/*
The filter statement allows you to select which records will be retained in your data pipeline.
 */


A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = FILTER A BY salary > 150.0;

C = GROUP B ALL;

D = FOREACH C GENERATE COUNT(B);

DUMP B;

DUMP D;


-- filter by match

B = FILTER A by name matches '.*Jan.*';

DUMP B;

B = FILTER A by not name matches '.*Jan.*';

DUMP B;

-- writing our own custom filter fn

B = FILTER A BY com.sv.pig.filterfn.isGoodPackage(salary);

DUMP B;