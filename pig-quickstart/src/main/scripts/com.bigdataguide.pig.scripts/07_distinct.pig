/*
Distinct removes duplicate records.
It forces a reduce phase.
 */


A = LOAD 'person.txt' USING PigStorage() AS (id:long,name:chararray,gender:chararray,city:chararray,country:chararray,salary:double,credit_card:long,ssn:chararray,map_type:map[int],bag_type:bag{t:(name:chararray)},tuple_type:tuple(name1:chararray,name2:chararray));

B = DISTINCT A;

DUMP B;


